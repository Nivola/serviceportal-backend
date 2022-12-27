/*-
 * ========================LICENSE_START=================================
 * Api CMP
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.integration.rest.api.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import it.csi.nivola.nivolasp.integration.rest.api.invoker.ApiClient;
import it.csi.nivola.nivolasp.integration.rest.model.base.ApiObjecCountResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.CreateSchedulerEntryRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.CreateSchedulerEntryResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.CrudApiJobResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetAllTasksResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetSchedulerEntriesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetSchedulerEntryResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetTaskGraphResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetTasksDefinitionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.ManagerActiveQueuesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.ManagerPingResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.ManagerReportResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.ManagerStatsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.QueryTaskResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.RunJobTestBodyParamRequestSchema;


@Component("it.csi.nivola.nivolasp.integration.rest.api.base.SchedulerApi")
public class SchedulerApi {
    private ApiClient apiClient;

    public SchedulerApi() {
        this(new ApiClient());
    }

    @Autowired
    public SchedulerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List scheduler entries Call this api to list all the scheduler entries
     * 
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
     * @return GetSchedulerEntriesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetSchedulerEntriesResponseSchema v10NesSchedulerEntriesGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/scheduler/entries").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetSchedulerEntriesResponseSchema> returnType = new ParameterizedTypeReference<GetSchedulerEntriesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Delete schedule Delete scheduler schedule by name
     * 
     * <p><b>204</b> - no response
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
     * @param oid id, uuid or name
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NesSchedulerEntriesOidDelete(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NesSchedulerEntriesOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/scheduler/entries/{oid}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
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
     * @param oid id, uuid or name
     * @return GetSchedulerEntryResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetSchedulerEntryResponseSchema v10NesSchedulerEntriesOidGet(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NesSchedulerEntriesOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/scheduler/entries/{oid}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetSchedulerEntryResponseSchema> returnType = new ParameterizedTypeReference<GetSchedulerEntryResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Create schedule Create scheduler schedule
     * 
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
     * @param body The body parameter
     * @return CreateSchedulerEntryResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreateSchedulerEntryResponseSchema v10NesSchedulerEntriesPost(CreateSchedulerEntryRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/scheduler/entries").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<CreateSchedulerEntryResponseSchema> returnType = new ParameterizedTypeReference<CreateSchedulerEntryResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Worker pings Ping all active workers
     * 
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
     * @return ManagerPingResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ManagerPingResponseSchema v10NesWorkerPingGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/ping").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ManagerPingResponseSchema> returnType = new ParameterizedTypeReference<ManagerPingResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Worker Report Get all active workers report
     * 
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
     * @return ManagerActiveQueuesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ManagerActiveQueuesResponseSchema v10NesWorkerQueuesGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/queues").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ManagerActiveQueuesResponseSchema> returnType = new ParameterizedTypeReference<ManagerActiveQueuesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Worker Report Get all active workers report
     * 
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
     * @return ManagerReportResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ManagerReportResponseSchema v10NesWorkerReportGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/report").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ManagerReportResponseSchema> returnType = new ParameterizedTypeReference<ManagerReportResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Worker statistics Get all active workers statistics
     * 
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
     * @return ManagerStatsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ManagerStatsResponseSchema v10NesWorkerStatsGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/stats").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ManagerStatsResponseSchema> returnType = new ParameterizedTypeReference<ManagerStatsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Task count Get count of all tasks
     * 
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
     * @return ApiObjecCountResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjecCountResponseSchema v10NesWorkerTasksCountGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks/count").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjecCountResponseSchema> returnType = new ParameterizedTypeReference<ApiObjecCountResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Get task definitions List all task definitions
     * 
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
     * @return GetTasksDefinitionResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetTasksDefinitionResponseSchema v10NesWorkerTasksDefinitionsGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks/definitions").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetTasksDefinitionResponseSchema> returnType = new ParameterizedTypeReference<GetTasksDefinitionResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Delete all tasks Delete all tasks
     * 
     * <p><b>204</b> - success
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
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NesWorkerTasksDelete() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * List task instances Call this api to list all the task instances
     * 
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
     * @return GetAllTasksResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetAllTasksResponseSchema v10NesWorkerTasksGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetAllTasksResponseSchema> returnType = new ParameterizedTypeReference<GetAllTasksResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Delete task Delete task by id
     * 
     * <p><b>204</b> - success
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
     * @param oid id, uuid or name
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NesWorkerTasksOidDelete(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NesWorkerTasksOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks/{oid}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get task info Query single task by id and return description fields
     * 
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
     * @param oid id, uuid or name
     * @param chain 
     * @return QueryTaskResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public QueryTaskResponseSchema v10NesWorkerTasksOidGet(String oid, Boolean chain) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NesWorkerTasksOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks/{oid}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "chain", chain));

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<QueryTaskResponseSchema> returnType = new ParameterizedTypeReference<QueryTaskResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Get task graph Get list of nodes and link that represents the task childs graph
     * 
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
     * @param oid id, uuid or name
     * @return GetTaskGraphResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetTaskGraphResponseSchema v10NesWorkerTasksOidGraphGet(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NesWorkerTasksOidGraphGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks/{oid}/graph").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetTaskGraphResponseSchema> returnType = new ParameterizedTypeReference<GetTaskGraphResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * 
     * 
     * <p><b>201</b> - success
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
     * @param body The body parameter
     * @return CrudApiJobResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiJobResponseSchema v10NesWorkerTasksTestPost(RunJobTestBodyParamRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/worker/tasks/test").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<CrudApiJobResponseSchema> returnType = new ParameterizedTypeReference<CrudApiJobResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
}
