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
package it.csi.nivola.nivolasp.integration.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import it.csi.nivola.nivolasp.integration.rest.api.invoker.ApiClient;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetPortalDescRoleResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListPortalRolesResponseSchema;


@Component("it.csi.nivola.nivolasp.integration.rest.api.service.PortalApi")
public class PortalApi {
    private ApiClient apiClient;

    public PortalApi() {
        this(new ApiClient());
    }

    @Autowired
    public PortalApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the description of the requested role.
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
     * @param roleName name entity role
     * @return GetPortalDescRoleResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetPortalDescRoleResponseSchema v10NwsRolesDescriptionGet(String roleName) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/roles/description").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role_name", roleName));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetPortalDescRoleResponseSchema> returnType = new ParameterizedTypeReference<GetPortalDescRoleResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Returns a list of the all role description.
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
     * @return ListPortalRolesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListPortalRolesResponseSchema v10NwsRolesListportaldescriptionGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/roles/listportaldescription").build().toUriString();
        
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

        ParameterizedTypeReference<ListPortalRolesResponseSchema> returnType = new ParameterizedTypeReference<ListPortalRolesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Returns a list of the all role description.
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
     * @return ListPortalRolesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListPortalRolesResponseSchema v10NwsRolesListroledescriptionGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/roles/listroledescription").build().toUriString();
        
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

        ParameterizedTypeReference<ListPortalRolesResponseSchema> returnType = new ParameterizedTypeReference<ListPortalRolesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
    /**
     * Returns the description of the requested role.
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
     * @param roleName name entity role
     * @return GetPortalDescRoleResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetPortalDescRoleResponseSchema v10NwsRolesPortaldescGet(String roleName) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/roles/portaldesc").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role_name", roleName));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetPortalDescRoleResponseSchema> returnType = new ParameterizedTypeReference<GetPortalDescRoleResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType).getBody();
    }
}
