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
package it.csi.nivola.nivolasp.util;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

//
// RSA Utils 
//
public class RSAUtils {
	
	//
	// getPublicKey
	// Riceve una stringa 
	// Verifica se la stringa inserita è è una chiave RSA pubblica valida
	// 
    public static PublicKey getPublicKey(String base64PublicKey){
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return publicKey;
    }
    
    public static String filtraChiavePubblica (String daFiltrare) {
    	return daFiltrare.replaceAll("-----BEGIN RSA PRIVATE KEY-----", "").replaceAll("-----BEGIN RSA PUBLIC KEY-----", "").replaceAll("[\n\r]", "").trim();
    	// return daFiltrare.replaceAll("-", "").replaceAll("BEGIN", "").replaceAll("PUBLIC", "").replaceAll("RSA", "").replaceAll("KEY", "").replaceAll("END", "").replaceAll("[\n\r]", "").trim();
    }
    
}
