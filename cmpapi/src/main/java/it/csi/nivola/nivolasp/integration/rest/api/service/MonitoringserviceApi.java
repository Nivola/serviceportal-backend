/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 Regione Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | Regione Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import it.csi.nivola.nivolasp.integration.rest.api.invoker.ApiClient;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFolderApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateFolderApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateMonitoringInstanceApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateMonitoringInstanceApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateMonitoringServiceApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CrudApiObjectResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CrudApiObjectTaskResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteFolderApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteMonitoringInstanceApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteMonitoringServiceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeAccountAttributesSSResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeFoldersResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMonitoringInstancesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DescribeMonitoringServiceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SyncUsersFolderApiRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.SyncUsersFolderApiResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateMonitoringServiceApiRequestSchema;


@Component("it.csi.nivola.nivolasp.integration.rest.api.service.MonitoringserviceApi")
public class MonitoringserviceApi {
    private ApiClient apiClient;

    public MonitoringserviceApi() {
        this(new ApiClient());
    }

    @Autowired
    public MonitoringserviceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Terminate a monitoring service
     * Terminate a monitoring service
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param instanceId Instance uuid or name (required)
     * @return DeleteMonitoringServiceResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeleteMonitoringServiceResponseSchema v10NwsMonitoringservicesDelete(String instanceId) throws RestClientException {
        return v10NwsMonitoringservicesDeleteWithHttpInfo(instanceId).getBody();
    }

    /**
     * Terminate a monitoring service
     * Terminate a monitoring service
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param instanceId Instance uuid or name (required)
     * @return ResponseEntity&lt;DeleteMonitoringServiceResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeleteMonitoringServiceResponseSchema> v10NwsMonitoringservicesDeleteWithHttpInfo(String instanceId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'instanceId' is set
        if (instanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'instanceId' when calling v10NwsMonitoringservicesDelete");
        }
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "instanceId", instanceId));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DeleteMonitoringServiceResponseSchema> returnType = new ParameterizedTypeReference<DeleteMonitoringServiceResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Describes attributes of monitoring service
     * Describes attributes of monitoring service
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerId account ID of the instance owner (required)
     * @return DescribeAccountAttributesSSResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DescribeAccountAttributesSSResponseSchema v10NwsMonitoringservicesDescribeaccountattributesGet(String ownerId) throws RestClientException {
        return v10NwsMonitoringservicesDescribeaccountattributesGetWithHttpInfo(ownerId).getBody();
    }

    /**
     * Describes attributes of monitoring service
     * Describes attributes of monitoring service
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerId account ID of the instance owner (required)
     * @return ResponseEntity&lt;DescribeAccountAttributesSSResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DescribeAccountAttributesSSResponseSchema> v10NwsMonitoringservicesDescribeaccountattributesGetWithHttpInfo(String ownerId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'ownerId' is set
        if (ownerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ownerId' when calling v10NwsMonitoringservicesDescribeaccountattributesGet");
        }
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/describeaccountattributes").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner-id", ownerId));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DescribeAccountAttributesSSResponseSchema> returnType = new ParameterizedTypeReference<DescribeAccountAttributesSSResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create monitoring folder
     * Create monitoring folder
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return CreateFolderApiResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreateFolderApiResponseSchema v10NwsMonitoringservicesFoldersCreatefolderPost(CreateFolderApiRequestSchema body) throws RestClientException {
        return v10NwsMonitoringservicesFoldersCreatefolderPostWithHttpInfo(body).getBody();
    }

    /**
     * Create monitoring folder
     * Create monitoring folder
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return ResponseEntity&lt;CreateFolderApiResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CreateFolderApiResponseSchema> v10NwsMonitoringservicesFoldersCreatefolderPostWithHttpInfo(CreateFolderApiRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/folders/createfolder").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<CreateFolderApiResponseSchema> returnType = new ParameterizedTypeReference<CreateFolderApiResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete monitoring folder
     * Delete monitoring folder
     * <p><b>202</b> - no response
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param folderId folder id (optional)
     * @return DeleteFolderApiResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeleteFolderApiResponseSchema v10NwsMonitoringservicesFoldersDeletefolderDelete(String folderId) throws RestClientException {
        return v10NwsMonitoringservicesFoldersDeletefolderDeleteWithHttpInfo(folderId).getBody();
    }

    /**
     * Delete monitoring folder
     * Delete monitoring folder
     * <p><b>202</b> - no response
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param folderId folder id (optional)
     * @return ResponseEntity&lt;DeleteFolderApiResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeleteFolderApiResponseSchema> v10NwsMonitoringservicesFoldersDeletefolderDeleteWithHttpInfo(String folderId) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/folders/deletefolder").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "FolderId", folderId));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DeleteFolderApiResponseSchema> returnType = new ParameterizedTypeReference<DeleteFolderApiResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Describe monitoring folder
     * Describe monitoring folder
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerIdN account id (optional)
     * @param folderName folder name (optional)
     * @param folderIdN list of folder id (optional)
     * @param maxItems max number elements to return in the response (optional)
     * @param marker pagination token (optional)
     * @return DescribeFoldersResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DescribeFoldersResponseSchema v10NwsMonitoringservicesFoldersDescribefoldersGet(List<String> ownerIdN, String folderName, List<String> folderIdN, Integer maxItems, String marker) throws RestClientException {
        return v10NwsMonitoringservicesFoldersDescribefoldersGetWithHttpInfo(ownerIdN, folderName, folderIdN, maxItems, marker).getBody();
    }

    /**
     * Describe monitoring folder
     * Describe monitoring folder
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerIdN account id (optional)
     * @param folderName folder name (optional)
     * @param folderIdN list of folder id (optional)
     * @param maxItems max number elements to return in the response (optional)
     * @param marker pagination token (optional)
     * @return ResponseEntity&lt;DescribeFoldersResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DescribeFoldersResponseSchema> v10NwsMonitoringservicesFoldersDescribefoldersGetWithHttpInfo(List<String> ownerIdN, String folderName, List<String> folderIdN, Integer maxItems, String marker) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/folders/describefolders").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "owner-id.N", ownerIdN));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "FolderName", folderName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "folder-id.N", folderIdN));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "MaxItems", maxItems));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Marker", marker));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DescribeFoldersResponseSchema> returnType = new ParameterizedTypeReference<DescribeFoldersResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Syncronize users in a grafana folder
     * Syncronize users in a grafana folder
     * <p><b>202</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return SyncUsersFolderApiResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SyncUsersFolderApiResponseSchema v10NwsMonitoringservicesFoldersSyncfolderusersPut(SyncUsersFolderApiRequestSchema body) throws RestClientException {
        return v10NwsMonitoringservicesFoldersSyncfolderusersPutWithHttpInfo(body).getBody();
    }

    /**
     * Syncronize users in a grafana folder
     * Syncronize users in a grafana folder
     * <p><b>202</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return ResponseEntity&lt;SyncUsersFolderApiResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SyncUsersFolderApiResponseSchema> v10NwsMonitoringservicesFoldersSyncfolderusersPutWithHttpInfo(SyncUsersFolderApiRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/folders/syncfolderusers").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<SyncUsersFolderApiResponseSchema> returnType = new ParameterizedTypeReference<SyncUsersFolderApiResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get monitoring service info
     * Get monitoring service info
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerId account ID of the instance owner (required)
     * @return DescribeMonitoringServiceResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DescribeMonitoringServiceResponseSchema v10NwsMonitoringservicesGet(String ownerId) throws RestClientException {
        return v10NwsMonitoringservicesGetWithHttpInfo(ownerId).getBody();
    }

    /**
     * Get monitoring service info
     * Get monitoring service info
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerId account ID of the instance owner (required)
     * @return ResponseEntity&lt;DescribeMonitoringServiceResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DescribeMonitoringServiceResponseSchema> v10NwsMonitoringservicesGetWithHttpInfo(String ownerId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'ownerId' is set
        if (ownerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ownerId' when calling v10NwsMonitoringservicesGet");
        }
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner-id", ownerId));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DescribeMonitoringServiceResponseSchema> returnType = new ParameterizedTypeReference<DescribeMonitoringServiceResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create monitoring instance
     * Create monitoring instance
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return CreateMonitoringInstanceApiResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreateMonitoringInstanceApiResponseSchema v10NwsMonitoringservicesInstanceCreateinstancePost(CreateMonitoringInstanceApiRequestSchema body) throws RestClientException {
        return v10NwsMonitoringservicesInstanceCreateinstancePostWithHttpInfo(body).getBody();
    }

    /**
     * Create monitoring instance
     * Create monitoring instance
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return ResponseEntity&lt;CreateMonitoringInstanceApiResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CreateMonitoringInstanceApiResponseSchema> v10NwsMonitoringservicesInstanceCreateinstancePostWithHttpInfo(CreateMonitoringInstanceApiRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/instance/createinstance").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<CreateMonitoringInstanceApiResponseSchema> returnType = new ParameterizedTypeReference<CreateMonitoringInstanceApiResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete monitoring instance
     * Delete monitoring instance
     * <p><b>202</b> - no response
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param instanceId instance id (required)
     * @return DeleteMonitoringInstanceApiResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeleteMonitoringInstanceApiResponseSchema v10NwsMonitoringservicesInstanceDeleteteinstanceDelete(String instanceId) throws RestClientException {
        return v10NwsMonitoringservicesInstanceDeleteteinstanceDeleteWithHttpInfo(instanceId).getBody();
    }

    /**
     * Delete monitoring instance
     * Delete monitoring instance
     * <p><b>202</b> - no response
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param instanceId instance id (required)
     * @return ResponseEntity&lt;DeleteMonitoringInstanceApiResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeleteMonitoringInstanceApiResponseSchema> v10NwsMonitoringservicesInstanceDeleteteinstanceDeleteWithHttpInfo(String instanceId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'instanceId' is set
        if (instanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'instanceId' when calling v10NwsMonitoringservicesInstanceDeleteteinstanceDelete");
        }
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/instance/deleteteinstance").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "InstanceId", instanceId));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DeleteMonitoringInstanceApiResponseSchema> returnType = new ParameterizedTypeReference<DeleteMonitoringInstanceApiResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Describe monitoring
     * Describe monitoring
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerIdN account id (optional)
     * @param instanceName monitoring instance name (optional)
     * @param instanceIdN list of monitoring instance id (optional)
     * @param maxItems max number elements to return in the response (optional)
     * @param marker pagination token (optional)
     * @return DescribeMonitoringInstancesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DescribeMonitoringInstancesResponseSchema v10NwsMonitoringservicesInstanceDescribeinstancesGet(List<String> ownerIdN, String instanceName, List<String> instanceIdN, Integer maxItems, String marker) throws RestClientException {
        return v10NwsMonitoringservicesInstanceDescribeinstancesGetWithHttpInfo(ownerIdN, instanceName, instanceIdN, maxItems, marker).getBody();
    }

    /**
     * Describe monitoring
     * Describe monitoring
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param ownerIdN account id (optional)
     * @param instanceName monitoring instance name (optional)
     * @param instanceIdN list of monitoring instance id (optional)
     * @param maxItems max number elements to return in the response (optional)
     * @param marker pagination token (optional)
     * @return ResponseEntity&lt;DescribeMonitoringInstancesResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DescribeMonitoringInstancesResponseSchema> v10NwsMonitoringservicesInstanceDescribeinstancesGetWithHttpInfo(List<String> ownerIdN, String instanceName, List<String> instanceIdN, Integer maxItems, String marker) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices/instance/describeinstances").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "owner-id.N", ownerIdN));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "InstanceName", instanceName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "instance-id.N", instanceIdN));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "MaxItems", maxItems));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Marker", marker));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<DescribeMonitoringInstancesResponseSchema> returnType = new ParameterizedTypeReference<DescribeMonitoringInstancesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create monitoring service info
     * Create monitoring service info
     * <p><b>202</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return CrudApiObjectTaskResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectTaskResponseSchema v10NwsMonitoringservicesPost(CreateMonitoringServiceApiRequestSchema body) throws RestClientException {
        return v10NwsMonitoringservicesPostWithHttpInfo(body).getBody();
    }

    /**
     * Create monitoring service info
     * Create monitoring service info
     * <p><b>202</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectTaskResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectTaskResponseSchema> v10NwsMonitoringservicesPostWithHttpInfo(CreateMonitoringServiceApiRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<CrudApiObjectTaskResponseSchema> returnType = new ParameterizedTypeReference<CrudApiObjectTaskResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update monitoring service info
     * Update monitoring service info
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsMonitoringservicesPut(UpdateMonitoringServiceApiRequestSchema body) throws RestClientException {
        return v10NwsMonitoringservicesPutWithHttpInfo(body).getBody();
    }

    /**
     * Update monitoring service info
     * Update monitoring service info
     * <p><b>200</b> - success
     * <p><b>400</b> - The specified resource was not found. Syntax like default.
     * <p><b>401</b> - The operation failed. The operation requires an Authentication header to be set. If this was present in the request, the supplied credentials are not valid or the user is not authorized to perform this operation. Syntax like default.
     * <p><b>403</b> - The operation is forbidden and should not be re-attempted. This does not imply an issue with authentication not authorization, it is an operation that is not allowed. Example. deleting a task that is part of a running process is not allowed and will never be allowed, regardless of the user or process/task state. Syntax like default.
     * <p><b>405</b> - The operation failed. The used method is not allowed for this resource. E.g. trying to update (PUT) a deployment-resource will result in a 405 status. Syntax like default.
     * <p><b>408</b> - Operation timeout. Syntax like default.
     * <p><b>410</b> - Indicates that the resource at this end point is no longer available. Syntax like default.
     * <p><b>415</b> - The operation failed. The request body contains an unsupported media type. Also occurs when the request-body JSON contains an unknown attribute or value that doesn’t have the right format/type to be accepted. Syntax like default.
     * <p><b>422</b> - The request was well-formed but was unable to be followed due to semantic errors. Syntax like default.
     * <p><b>429</b> - The user has sent too many requests in a given amount of time. Syntax like default.
     * <p><b>500</b> - The operation failed. An unexpected exception occurred while executing the operation. The response-body contains details about the error.
     * <p><b>0</b> - Defualt error syntax
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsMonitoringservicesPutWithHttpInfo(UpdateMonitoringServiceApiRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/monitoringservices").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<CrudApiObjectResponseSchema> returnType = new ParameterizedTypeReference<CrudApiObjectResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
