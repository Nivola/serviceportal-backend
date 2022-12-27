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
import it.csi.nivola.nivolasp.integration.rest.model.base.GetEventEntityDefinitionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetEventResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.GetEventTypesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.base.ListEventsResponseSchema;


@Component("it.csi.nivola.nivolasp.integration.rest.api.base.EventApi")
public class EventApi {
    private ApiClient apiClient;

    public EventApi() {
        this(new ApiClient());
    }

    @Autowired
    public EventApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
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
     * @return GetEventEntityDefinitionResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetEventEntityDefinitionResponseSchema v10NesEventsEntitiesGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/events/entities").build().toUriString();
        
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

        ParameterizedTypeReference<GetEventEntityDefinitionResponseSchema> returnType = new ParameterizedTypeReference<GetEventEntityDefinitionResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * List events Call this api to list all the existing events
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
     * @param objdef 
     * @param field enitities list order field. Ex. id, uuid, name
     * @param dest 
     * @param dateto 
     * @param datefrom 
     * @param order enitities list order: ASC or DESC
     * @param source 
     * @param objid 
     * @param type 
     * @param date 
     * @param objtype 
     * @param data 
     * @param page enitities list page selected
     * @param size enitities list page size
     * @return ListEventsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListEventsResponseSchema v10NesEventsGet(String objdef, String field, String dest, String dateto, String datefrom, String order, String source, String objid, String type, String date, String objtype, String data, Integer page, Integer size) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/events").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objdef", objdef));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dest", dest));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dateto", dateto));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "datefrom", datefrom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "source", source));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "date", date));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objtype", objtype));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "data", data));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListEventsResponseSchema> returnType = new ParameterizedTypeReference<ListEventsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
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
     * @return GetEventResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetEventResponseSchema v10NesEventsOidGet(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NesEventsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/events/{oid}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<GetEventResponseSchema> returnType = new ParameterizedTypeReference<GetEventResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
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
     * @return GetEventTypesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetEventTypesResponseSchema v10NesEventsTypesGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nes/events/types").build().toUriString();
        
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

        ParameterizedTypeReference<GetEventTypesResponseSchema> returnType = new ParameterizedTypeReference<GetEventTypesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
}
