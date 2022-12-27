/*-
 * ========================LICENSE_START=================================
 * Servizi di accesso dati
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import it.csi.nivola.nivolasp.config.ApplicationProperties;
import it.csi.nivola.nivolasp.service.dto.AmazonS3FileInfo;

@Service("amazonS3ClientServiceBatch")
@Scope(value = "singleton")
public class AmazonS3ClientService {
	
	@Autowired
	public ApplicationProperties proprieta = null;
	
	private AmazonS3 s3client;
	
	@PostConstruct
	public void postConstruct () {
		AWSCredentials credentials = new BasicAWSCredentials(
				proprieta.getBusinessApi().getAmazonClientId(),
				proprieta.getBusinessApi().getAmazonSecretKey()
				
		);
		ClientConfiguration config = new ClientConfiguration();
//		if (proprieta.getDeploy().isDevMode()) {
//			
//			config.setProtocol(Protocol.HTTPS);
//			config.setProxyHost("proxy.csi.it");
//			config.setProxyPort(3128);
//		}
		
		s3client = AmazonS3ClientBuilder
				  .standard()
				  .withClientConfiguration(config)
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.EU_WEST_1)
				  .build();
	}
	
	public void uploadObject (String bucketName, String path, InputStream object, long contentLength) {
		ObjectMetadata metadati = new ObjectMetadata();
		metadati.setContentLength(contentLength);
		s3client.putObject(bucketName, path, object, metadati);
	}
	
	public String getUrl (String bucketName, String path) {
		return ((AmazonS3Client)s3client).getResourceUrl(bucketName, path);
	}
	
	public byte[] getFile (String url) throws IOException {
		AmazonS3URI s3URI = new AmazonS3URI(url);

		S3Object s3Object = s3client.getObject(s3URI.getBucket(), s3URI.getKey());
		return IOUtils.toByteArray(s3Object.getObjectContent());
	}
	public byte[] getFile (String bucketName, String key) throws IOException {
		
		S3Object s3Object = s3client.getObject(bucketName, key);
		System.out.println("CHIAVE DELL?OGGETTO AMAZON " + s3Object.getKey());
		return IOUtils.toByteArray(s3Object.getObjectContent());
	}
	
	public void deleteFile (String bucketName, String key) throws IOException {
		
		s3client.deleteObject(bucketName, key);
		System.out.println("ELIMINATO");
	}
	
	public List<AmazonS3FileInfo> listFiles (String bucketName, String basePath) {
		ObjectListing risposta = s3client.listObjects(bucketName, basePath);
		return risposta.getObjectSummaries().stream().map(os -> convertiFile(os, true)).filter(f -> f != null).collect(Collectors.toList());
	}

	private AmazonS3FileInfo convertiFile(S3ObjectSummary os, boolean filtraFolder) {
		if (filtraFolder && os.getKey().endsWith("/"))
			return null;
		String [] splitted = os.getKey().split("/");
		return new AmazonS3FileInfo(os.getETag(), splitted[splitted.length -1] , os.getSize(), os.getLastModified(), splitted[splitted.length-2]);
	}


}
