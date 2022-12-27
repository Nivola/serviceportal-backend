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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import it.csi.nivola.nivolasp.integration.rest.model.service.AcquireServiceMetricRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.AcquireServiceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ApiObjectPermsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CatalogDefRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CheckServiceInstanceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateCatalogRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateLinkRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceConfigRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceDefinitionRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceMetricRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceMetricTypeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceMetricTypeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServicePriceListRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServicePriceMetricRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceProcessRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceScheduleRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateServiceTypeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CreateTagRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CrudApiObjectResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.CrudApiObjectTaskResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteServiceDefinitionRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteServiceInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteServiceMetricRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.DeleteServiceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GenerateConsumeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GenerateConsumeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetCatalogDefsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetCatalogResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetInstantConsumeServiceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetLinkResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetLinkedServiceInstancesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetPortalDescRoleResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetReportCostResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceConfigResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceDefinitionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceInstanceResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceMetricTypeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServicePriceListResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServicePriceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceProcessResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceScheduleResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetServiceTypeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.GetTagResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ImportInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListCatalogResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListConsumeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListLinksResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListPortalRolesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListReportCostResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceConfigsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceDefinitionResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceInstancesResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceMetricTypeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServicePluginTypeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServicePriceListResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServicePriceMetricResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceProcessResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceScheduleResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListServiceTypeResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.ListTagsResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.PatchServiceInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateCatalogRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateLinkRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceConfigRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceConfigResponseSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceDefinitionRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceInstanceRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceInstanceStatusRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceMetricTypeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServicePriceListRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServicePriceMetricRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceProcessRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceScheduleRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateServiceTypeRequestSchema;
import it.csi.nivola.nivolasp.integration.rest.model.service.UpdateTagRequestSchema;


@Component("it.csi.nivola.nivolasp.integration.rest.api.service.ServiceApi")
public class ServiceApi {
    private ApiClient apiClient;

    public ServiceApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServiceApi(ApiClient apiClient) {
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
     * @param oid id, uuid or name (required)
     * @param rid id, uuid or name (required)
     * @return GetReportCostResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetReportCostResponseSchema v10NwsAccountsOidCostRidGet(String oid, String rid) throws RestClientException {
        return v10NwsAccountsOidCostRidGetWithHttpInfo(oid, rid).getBody();
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
     * @param oid id, uuid or name (required)
     * @param rid id, uuid or name (required)
     * @return ResponseEntity&lt;GetReportCostResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetReportCostResponseSchema> v10NwsAccountsOidCostRidGetWithHttpInfo(String oid, String rid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsAccountsOidCostRidGet");
        }
        
        // verify the required parameter 'rid' is set
        if (rid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'rid' when calling v10NwsAccountsOidCostRidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        uriVariables.put("rid", rid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/accounts/{oid}/cost/{rid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetReportCostResponseSchema> returnType = new ParameterizedTypeReference<GetReportCostResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field enitities list order field. Ex. id, period (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param pluginName  (optional)
     * @param isReported  (optional)
     * @param period  (optional)
     * @param periodStart  (optional)
     * @param periodEnd  (optional)
     * @param jobId  (optional)
     * @return ListReportCostResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListReportCostResponseSchema v10NwsAccountsOidCostsGet(String oid, Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String pluginName, Boolean isReported, String period, String periodStart, String periodEnd, Integer jobId) throws RestClientException {
        return v10NwsAccountsOidCostsGetWithHttpInfo(oid, size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, pluginName, isReported, period, periodStart, periodEnd, jobId).getBody();
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field enitities list order field. Ex. id, period (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param pluginName  (optional)
     * @param isReported  (optional)
     * @param period  (optional)
     * @param periodStart  (optional)
     * @param periodEnd  (optional)
     * @param jobId  (optional)
     * @return ResponseEntity&lt;ListReportCostResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListReportCostResponseSchema> v10NwsAccountsOidCostsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String pluginName, Boolean isReported, String period, String periodStart, String periodEnd, Integer jobId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsAccountsOidCostsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/accounts/{oid}/costs").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "plugin_name", pluginName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "is_reported", isReported));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "period", period));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "period_start", periodStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "period_end", periodEnd));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "job_id", jobId));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListReportCostResponseSchema> returnType = new ParameterizedTypeReference<ListReportCostResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * List service links
     * List service links
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param startService  (optional)
     * @param endService  (optional)
     * @param service  (optional)
     * @param type  (optional)
     * @param tags comma separated tag list (optional)
     * @return ListLinksResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListLinksResponseSchema v10NwsLinksGet(Integer size, Integer page, String order, String field, String startService, String endService, String service, String type, String tags) throws RestClientException {
        return v10NwsLinksGetWithHttpInfo(size, page, order, field, startService, endService, service, type, tags).getBody();
    }

    /**
     * List service links
     * List service links
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param startService  (optional)
     * @param endService  (optional)
     * @param service  (optional)
     * @param type  (optional)
     * @param tags comma separated tag list (optional)
     * @return ResponseEntity&lt;ListLinksResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListLinksResponseSchema> v10NwsLinksGetWithHttpInfo(Integer size, Integer page, String order, String field, String startService, String endService, String service, String type, String tags) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/links").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_service", startService));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "end_service", endService));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service", service));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags", tags));

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListLinksResponseSchema> returnType = new ParameterizedTypeReference<ListLinksResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete service link
     * Delete service link
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsLinksOidDelete(String oid) throws RestClientException {
        v10NwsLinksOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete service link
     * Delete service link
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsLinksOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsLinksOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/links/{oid}").buildAndExpand(uriVariables).toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service link
     * Get service link
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
     * @param oid id, uuid or name (required)
     * @return GetLinkResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetLinkResponseSchema v10NwsLinksOidGet(String oid) throws RestClientException {
        return v10NwsLinksOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get service link
     * Get service link
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetLinkResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetLinkResponseSchema> v10NwsLinksOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsLinksOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/links/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetLinkResponseSchema> returnType = new ParameterizedTypeReference<GetLinkResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service link permissions
     * Get service link permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsLinksOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsLinksOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
    }

    /**
     * Get service link permissions
     * Get service link permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsLinksOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsLinksOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/links/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update service link
     * Update service link
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsLinksOidPut(String oid, UpdateLinkRequestSchema body) throws RestClientException {
        return v10NwsLinksOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update service link
     * Update service link
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsLinksOidPutWithHttpInfo(String oid, UpdateLinkRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsLinksOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/links/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<CrudApiObjectResponseSchema> returnType = new ParameterizedTypeReference<CrudApiObjectResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create service link
     * Create service link
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsLinksPost(CreateLinkRequestSchema body) throws RestClientException {
        return v10NwsLinksPostWithHttpInfo(body).getBody();
    }

    /**
     * Create service link
     * Create service link
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsLinksPostWithHttpInfo(CreateLinkRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/links").build().toUriString();

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

        ParameterizedTypeReference<CrudApiObjectResponseSchema> returnType = new ParameterizedTypeReference<CrudApiObjectResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param flagDefault  (optional)
     * @return ListServicePriceListResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServicePriceListResponseSchema v10NwsPricelistsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, Boolean flagDefault) throws RestClientException {
        return v10NwsPricelistsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, flagDefault).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param flagDefault  (optional)
     * @return ResponseEntity&lt;ListServicePriceListResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServicePriceListResponseSchema> v10NwsPricelistsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, Boolean flagDefault) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/pricelists").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flag_default", flagDefault));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServicePriceListResponseSchema> returnType = new ParameterizedTypeReference<ListServicePriceListResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsPricelistsOidDelete(String oid) throws RestClientException {
        v10NwsPricelistsOidDeleteWithHttpInfo(oid);
    }

    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsPricelistsOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricelistsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/pricelists/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServicePriceListResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServicePriceListResponseSchema v10NwsPricelistsOidGet(String oid) throws RestClientException {
        return v10NwsPricelistsOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServicePriceListResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServicePriceListResponseSchema> v10NwsPricelistsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricelistsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/pricelists/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServicePriceListResponseSchema> returnType = new ParameterizedTypeReference<GetServicePriceListResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsPricelistsOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsPricelistsOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsPricelistsOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricelistsOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/pricelists/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsPricelistsOidPut(String oid, UpdateServicePriceListRequestSchema body) throws RestClientException {
        return v10NwsPricelistsOidPutWithHttpInfo(oid, body).getBody();
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsPricelistsOidPutWithHttpInfo(String oid, UpdateServicePriceListRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricelistsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/pricelists/{oid}").buildAndExpand(uriVariables).toUriString();

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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsPricelistsPost(CreateServicePriceListRequestSchema body) throws RestClientException {
        return v10NwsPricelistsPostWithHttpInfo(body).getBody();
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsPricelistsPostWithHttpInfo(CreateServicePriceListRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/pricelists").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param priceListId  (optional)
     * @param metricTypeId  (optional)
     * @param timeUnit  (optional)
     * @return ListServicePriceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServicePriceMetricResponseSchema v10NwsPricesMetricsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String priceListId, Integer metricTypeId, String timeUnit) throws RestClientException {
        return v10NwsPricesMetricsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, priceListId, metricTypeId, timeUnit).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param priceListId  (optional)
     * @param metricTypeId  (optional)
     * @param timeUnit  (optional)
     * @return ResponseEntity&lt;ListServicePriceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServicePriceMetricResponseSchema> v10NwsPricesMetricsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String priceListId, Integer metricTypeId, String timeUnit) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/prices/metrics").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "price_list_id", priceListId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "metric_type_id", metricTypeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "time_unit", timeUnit));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServicePriceMetricResponseSchema> returnType = new ParameterizedTypeReference<ListServicePriceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsPricesMetricsOidDelete(String oid) throws RestClientException {
        v10NwsPricesMetricsOidDeleteWithHttpInfo(oid);
    }

    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsPricesMetricsOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricesMetricsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/prices/metrics/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServicePriceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServicePriceMetricResponseSchema v10NwsPricesMetricsOidGet(String oid) throws RestClientException {
        return v10NwsPricesMetricsOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServicePriceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServicePriceMetricResponseSchema> v10NwsPricesMetricsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricesMetricsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/prices/metrics/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServicePriceMetricResponseSchema> returnType = new ParameterizedTypeReference<GetServicePriceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsPricesMetricsOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsPricesMetricsOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsPricesMetricsOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricesMetricsOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/prices/metrics/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsPricesMetricsOidPut(String oid, UpdateServicePriceMetricRequestSchema body) throws RestClientException {
        return v10NwsPricesMetricsOidPutWithHttpInfo(oid, body).getBody();
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsPricesMetricsOidPutWithHttpInfo(String oid, UpdateServicePriceMetricRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsPricesMetricsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/prices/metrics/{oid}").buildAndExpand(uriVariables).toUriString();

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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsPricesMetricsPost(CreateServicePriceMetricRequestSchema body) throws RestClientException {
        return v10NwsPricesMetricsPostWithHttpInfo(body).getBody();
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsPricesMetricsPostWithHttpInfo(CreateServicePriceMetricRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/prices/metrics").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param roleName name entity role (optional)
     * @return GetPortalDescRoleResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetPortalDescRoleResponseSchema v10NwsRolesDescriptionGet(String roleName) throws RestClientException {
        return v10NwsRolesDescriptionGetWithHttpInfo(roleName).getBody();
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
     * @param roleName name entity role (optional)
     * @return ResponseEntity&lt;GetPortalDescRoleResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetPortalDescRoleResponseSchema> v10NwsRolesDescriptionGetWithHttpInfo(String roleName) throws RestClientException {
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
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
        return v10NwsRolesListportaldescriptionGetWithHttpInfo().getBody();
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
     * @return ResponseEntity&lt;ListPortalRolesResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListPortalRolesResponseSchema> v10NwsRolesListportaldescriptionGetWithHttpInfo() throws RestClientException {
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
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
        return v10NwsRolesListroledescriptionGetWithHttpInfo().getBody();
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
     * @return ResponseEntity&lt;ListPortalRolesResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListPortalRolesResponseSchema> v10NwsRolesListroledescriptionGetWithHttpInfo() throws RestClientException {
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
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param roleName name entity role (optional)
     * @return GetPortalDescRoleResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetPortalDescRoleResponseSchema v10NwsRolesPortaldescGet(String roleName) throws RestClientException {
        return v10NwsRolesPortaldescGetWithHttpInfo(roleName).getBody();
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
     * @param roleName name entity role (optional)
     * @return ResponseEntity&lt;GetPortalDescRoleResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetPortalDescRoleResponseSchema> v10NwsRolesPortaldescGetWithHttpInfo(String roleName) throws RestClientException {
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
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * List service definition configs
     * List service definition configs
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param serviceDefinitionId  (optional)
     * @param paramsType  (optional)
     * @return ListServiceConfigsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceConfigsResponseSchema v10NwsServicecfgsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String serviceDefinitionId, String paramsType) throws RestClientException {
        return v10NwsServicecfgsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, serviceDefinitionId, paramsType).getBody();
    }

    /**
     * List service definition configs
     * List service definition configs
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param serviceDefinitionId  (optional)
     * @param paramsType  (optional)
     * @return ResponseEntity&lt;ListServiceConfigsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceConfigsResponseSchema> v10NwsServicecfgsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String serviceDefinitionId, String paramsType) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicecfgs").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service_definition_id", serviceDefinitionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "params_type", paramsType));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceConfigsResponseSchema> returnType = new ParameterizedTypeReference<ListServiceConfigsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a service definition config
     * Delete a service definition config
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsServicecfgsOidDelete(String oid) throws RestClientException {
        v10NwsServicecfgsOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete a service definition config
     * Delete a service definition config
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsServicecfgsOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicecfgsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicecfgs/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get a service definition config
     * Get a service definition config
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
     * @param oid id, uuid or name (required)
     * @return GetServiceConfigResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceConfigResponseSchema v10NwsServicecfgsOidGet(String oid) throws RestClientException {
        return v10NwsServicecfgsOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get a service definition config
     * Get a service definition config
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceConfigResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceConfigResponseSchema> v10NwsServicecfgsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicecfgsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicecfgs/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceConfigResponseSchema> returnType = new ParameterizedTypeReference<GetServiceConfigResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service definition config permissions
     * Get service definition config permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsServicecfgsOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsServicecfgsOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
    }

    /**
     * Get service definition config permissions
     * Get service definition config permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsServicecfgsOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicecfgsOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicecfgs/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a service definition config
     * Update a service definition config
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicecfgsOidPut(String oid, UpdateServiceConfigRequestSchema body) throws RestClientException {
        return v10NwsServicecfgsOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update a service definition config
     * Update a service definition config
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicecfgsOidPutWithHttpInfo(String oid, UpdateServiceConfigRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicecfgsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicecfgs/{oid}").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Create a service definition config
     * Create a service definition config
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicecfgsPost(CreateServiceConfigRequestSchema body) throws RestClientException {
        return v10NwsServicecfgsPostWithHttpInfo(body).getBody();
    }

    /**
     * Create a service definition config
     * Create a service definition config
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicecfgsPostWithHttpInfo(CreateServiceConfigRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicecfgs").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * List service definition
     * List service definition
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param status  (optional)
     * @param plugintype  (optional)
     * @param flagContainer  (optional)
     * @return ListServiceDefinitionResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceDefinitionResponseSchema v10NwsServicedefsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String status, String plugintype, Boolean flagContainer) throws RestClientException {
        return v10NwsServicedefsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, status, plugintype, flagContainer).getBody();
    }

    /**
     * List service definition
     * List service definition
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param status  (optional)
     * @param plugintype  (optional)
     * @param flagContainer  (optional)
     * @return ResponseEntity&lt;ListServiceDefinitionResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceDefinitionResponseSchema> v10NwsServicedefsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String status, String plugintype, Boolean flagContainer) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicedefs").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "plugintype", plugintype));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flag_container", flagContainer));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceDefinitionResponseSchema> returnType = new ParameterizedTypeReference<ListServiceDefinitionResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a service definition
     * Delete a service definition
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsServicedefsOidDelete(String oid, DeleteServiceDefinitionRequestSchema body) throws RestClientException {
        v10NwsServicedefsOidDeleteWithHttpInfo(oid, body);
    }

    /**
     * Delete a service definition
     * Delete a service definition
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsServicedefsOidDeleteWithHttpInfo(String oid, DeleteServiceDefinitionRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicedefsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicedefs/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service definition
     * Get service definition
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
     * @param oid id, uuid or name (required)
     * @return GetServiceDefinitionResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceDefinitionResponseSchema v10NwsServicedefsOidGet(String oid) throws RestClientException {
        return v10NwsServicedefsOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get service definition
     * Get service definition
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceDefinitionResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceDefinitionResponseSchema> v10NwsServicedefsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicedefsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicedefs/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceDefinitionResponseSchema> returnType = new ParameterizedTypeReference<GetServiceDefinitionResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service definition permissions
     * Get service definition permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsServicedefsOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsServicedefsOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
    }

    /**
     * Get service definition permissions
     * Get service definition permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsServicedefsOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicedefsOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicedefs/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a service definition
     * Update a service definition
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicedefsOidPut(String oid, UpdateServiceDefinitionRequestSchema body) throws RestClientException {
        return v10NwsServicedefsOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update a service definition
     * Update a service definition
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicedefsOidPutWithHttpInfo(String oid, UpdateServiceDefinitionRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicedefsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicedefs/{oid}").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Create a service definition
     * Create a service definition
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicedefsPost(CreateServiceDefinitionRequestSchema body) throws RestClientException {
        return v10NwsServicedefsPostWithHttpInfo(body).getBody();
    }

    /**
     * Create a service definition
     * Create a service definition
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicedefsPostWithHttpInfo(CreateServiceDefinitionRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicedefs").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param accountId  (optional)
     * @param serviceDefinitionId  (optional)
     * @param status  (optional)
     * @param bpmnProcessId  (optional)
     * @param resourceUuid  (optional)
     * @param parentId  (optional)
     * @param plugintype  (optional)
     * @param tags List of tags. Use comma as separator if tags are in or. Use + separator if tags are in and (optional)
     * @param flagContainer if True show only container instances (optional)
     * @return ListServiceInstancesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceInstancesResponseSchema v10NwsServiceinstsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String accountId, String serviceDefinitionId, String status, Integer bpmnProcessId, String resourceUuid, String parentId, String plugintype, String tags, Boolean flagContainer) throws RestClientException {
        return v10NwsServiceinstsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, accountId, serviceDefinitionId, status, bpmnProcessId, resourceUuid, parentId, plugintype, tags, flagContainer).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param accountId  (optional)
     * @param serviceDefinitionId  (optional)
     * @param status  (optional)
     * @param bpmnProcessId  (optional)
     * @param resourceUuid  (optional)
     * @param parentId  (optional)
     * @param plugintype  (optional)
     * @param tags List of tags. Use comma as separator if tags are in or. Use + separator if tags are in and (optional)
     * @param flagContainer if True show only container instances (optional)
     * @return ResponseEntity&lt;ListServiceInstancesResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceInstancesResponseSchema> v10NwsServiceinstsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String accountId, String serviceDefinitionId, String status, Integer bpmnProcessId, String resourceUuid, String parentId, String plugintype, String tags, Boolean flagContainer) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceinsts").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service_definition_id", serviceDefinitionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bpmn_process_id", bpmnProcessId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "resource_uuid", resourceUuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "parent_id", parentId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "plugintype", plugintype));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flag_container", flagContainer));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceInstancesResponseSchema> returnType = new ParameterizedTypeReference<ListServiceInstancesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServiceInstanceResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceInstanceResponseSchema v10NwsServiceinstsOidGet(String oid) throws RestClientException {
        return v10NwsServiceinstsOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceInstanceResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceInstanceResponseSchema> v10NwsServiceinstsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServiceinstsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceinsts/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceInstanceResponseSchema> returnType = new ParameterizedTypeReference<GetServiceInstanceResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * List service process
     * List service process
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param serviceTypeId  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param methodKey  (optional)
     * @param processKey  (optional)
     * @return ListServiceProcessResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceProcessResponseSchema v10NwsServiceprocessesGet(Integer size, Integer page, String order, String field, String serviceTypeId, String name, String objid, String methodKey, String processKey) throws RestClientException {
        return v10NwsServiceprocessesGetWithHttpInfo(size, page, order, field, serviceTypeId, name, objid, methodKey, processKey).getBody();
    }

    /**
     * List service process
     * List service process
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param serviceTypeId  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param methodKey  (optional)
     * @param processKey  (optional)
     * @return ResponseEntity&lt;ListServiceProcessResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceProcessResponseSchema> v10NwsServiceprocessesGetWithHttpInfo(Integer size, Integer page, String order, String field, String serviceTypeId, String name, String objid, String methodKey, String processKey) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceprocesses").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service_type_id", serviceTypeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "method_key", methodKey));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "process_key", processKey));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceProcessResponseSchema> returnType = new ParameterizedTypeReference<ListServiceProcessResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a service process
     * Delete a service process
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsServiceprocessesOidDelete(String oid) throws RestClientException {
        v10NwsServiceprocessesOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete a service process
     * Delete a service process
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsServiceprocessesOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServiceprocessesOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceprocesses/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service process
     * Get service process
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
     * @param oid id, uuid or name (required)
     * @return GetServiceProcessResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceProcessResponseSchema v10NwsServiceprocessesOidGet(String oid) throws RestClientException {
        return v10NwsServiceprocessesOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get service process
     * Get service process
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceProcessResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceProcessResponseSchema> v10NwsServiceprocessesOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServiceprocessesOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceprocesses/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceProcessResponseSchema> returnType = new ParameterizedTypeReference<GetServiceProcessResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a service process
     * Update a service process
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServiceprocessesOidPut(String oid, UpdateServiceProcessRequestSchema body) throws RestClientException {
        return v10NwsServiceprocessesOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update a service process
     * Update a service process
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServiceprocessesOidPutWithHttpInfo(String oid, UpdateServiceProcessRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServiceprocessesOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceprocesses/{oid}").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Create a service process
     * Create a service process
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServiceprocessesPost(CreateServiceProcessRequestSchema body) throws RestClientException {
        return v10NwsServiceprocessesPostWithHttpInfo(body).getBody();
    }

    /**
     * Create a service process
     * Create a service process
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServiceprocessesPostWithHttpInfo(CreateServiceProcessRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/serviceprocesses").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param body  (optional)
     * @return GenerateConsumeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GenerateConsumeResponseSchema v10NwsServicesConsumesGeneratePost(GenerateConsumeRequestSchema body) throws RestClientException {
        return v10NwsServicesConsumesGeneratePostWithHttpInfo(body).getBody();
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
     * @param body  (optional)
     * @return ResponseEntity&lt;GenerateConsumeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GenerateConsumeResponseSchema> v10NwsServicesConsumesGeneratePostWithHttpInfo(GenerateConsumeRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/consumes/generate").build().toUriString();

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

        ParameterizedTypeReference<GenerateConsumeResponseSchema> returnType = new ParameterizedTypeReference<GenerateConsumeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field enitities list order field. Ex. id, platform_name (optional, default to id)
     * @param id  (optional)
     * @param metricTypeId  (optional)
     * @param instanceOid  (optional)
     * @param instanceOid2  (optional)
     * @param evaluationDateStart  (optional)
     * @param evaluationDateEnd  (optional)
     * @param period  (optional)
     * @param costTypeId  (optional)
     * @param jobId  (optional)
     * @param aggregationType  (optional)
     * @return ListConsumeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListConsumeResponseSchema v10NwsServicesConsumesGet(Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, Integer size, Integer page, String order, String field, Integer id, Integer metricTypeId, Integer instanceOid, Integer instanceOid2, String evaluationDateStart, String evaluationDateEnd, String period, Integer costTypeId, Integer jobId, String aggregationType) throws RestClientException {
        return v10NwsServicesConsumesGetWithHttpInfo(filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, size, page, order, field, id, metricTypeId, instanceOid, instanceOid2, evaluationDateStart, evaluationDateEnd, period, costTypeId, jobId, aggregationType).getBody();
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
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field enitities list order field. Ex. id, platform_name (optional, default to id)
     * @param id  (optional)
     * @param metricTypeId  (optional)
     * @param instanceOid  (optional)
     * @param instanceOid2  (optional)
     * @param evaluationDateStart  (optional)
     * @param evaluationDateEnd  (optional)
     * @param period  (optional)
     * @param costTypeId  (optional)
     * @param jobId  (optional)
     * @param aggregationType  (optional)
     * @return ResponseEntity&lt;ListConsumeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListConsumeResponseSchema> v10NwsServicesConsumesGetWithHttpInfo(Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, Integer size, Integer page, String order, String field, Integer id, Integer metricTypeId, Integer instanceOid, Integer instanceOid2, String evaluationDateStart, String evaluationDateEnd, String period, Integer costTypeId, Integer jobId, String aggregationType) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/consumes").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "metric_type_id", metricTypeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "instance_oid", instanceOid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "instance_oid", instanceOid2));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "evaluation_date_start", evaluationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "evaluation_date_end", evaluationDateEnd));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "period", period));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "cost_type_id", costTypeId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "job_id", jobId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "aggregation_type", aggregationType));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListConsumeResponseSchema> returnType = new ParameterizedTypeReference<ListConsumeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param jobName  (optional)
     * @param scheduleType  (optional)
     * @return ListServiceScheduleResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceScheduleResponseSchema v10NwsServicesJobSchedulesGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String jobName, String scheduleType) throws RestClientException {
        return v10NwsServicesJobSchedulesGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, jobName, scheduleType).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param jobName  (optional)
     * @param scheduleType  (optional)
     * @return ResponseEntity&lt;ListServiceScheduleResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceScheduleResponseSchema> v10NwsServicesJobSchedulesGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String jobName, String scheduleType) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "job_name", jobName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "schedule_type", scheduleType));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceScheduleResponseSchema> returnType = new ParameterizedTypeReference<ListServiceScheduleResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsServicesJobSchedulesOidDelete(String oid) throws RestClientException {
        v10NwsServicesJobSchedulesOidDeleteWithHttpInfo(oid);
    }

    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsServicesJobSchedulesOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesJobSchedulesOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServiceScheduleResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceScheduleResponseSchema v10NwsServicesJobSchedulesOidGet(String oid) throws RestClientException {
        return v10NwsServicesJobSchedulesOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceScheduleResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceScheduleResponseSchema> v10NwsServicesJobSchedulesOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesJobSchedulesOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceScheduleResponseSchema> returnType = new ParameterizedTypeReference<GetServiceScheduleResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsServicesJobSchedulesOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsServicesJobSchedulesOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsServicesJobSchedulesOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesJobSchedulesOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicesJobSchedulesOidPut(String oid, UpdateServiceScheduleRequestSchema body) throws RestClientException {
        return v10NwsServicesJobSchedulesOidPutWithHttpInfo(oid, body).getBody();
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicesJobSchedulesOidPutWithHttpInfo(String oid, UpdateServiceScheduleRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesJobSchedulesOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}").buildAndExpand(uriVariables).toUriString();

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
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicesJobSchedulesOidRestartPut() throws RestClientException {
        return v10NwsServicesJobSchedulesOidRestartPutWithHttpInfo().getBody();
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
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicesJobSchedulesOidRestartPutWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}/restart").build().toUriString();

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
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicesJobSchedulesOidStartPut() throws RestClientException {
        return v10NwsServicesJobSchedulesOidStartPutWithHttpInfo().getBody();
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
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicesJobSchedulesOidStartPutWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}/start").build().toUriString();

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
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicesJobSchedulesOidStopPut() throws RestClientException {
        return v10NwsServicesJobSchedulesOidStopPutWithHttpInfo().getBody();
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
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicesJobSchedulesOidStopPutWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules/{oid}/stop").build().toUriString();

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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicesJobSchedulesPost(CreateServiceScheduleRequestSchema body) throws RestClientException {
        return v10NwsServicesJobSchedulesPostWithHttpInfo(body).getBody();
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicesJobSchedulesPostWithHttpInfo(CreateServiceScheduleRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/job_schedules").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
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
     * @param body  (optional)
     * @return AcquireServiceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AcquireServiceMetricResponseSchema v10NwsServicesMetricsAcquirePost(AcquireServiceMetricRequestSchema body) throws RestClientException {
        return v10NwsServicesMetricsAcquirePostWithHttpInfo(body).getBody();
    }

    /**
     * 
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
     * @param body  (optional)
     * @return ResponseEntity&lt;AcquireServiceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AcquireServiceMetricResponseSchema> v10NwsServicesMetricsAcquirePostWithHttpInfo(AcquireServiceMetricRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metrics/acquire").build().toUriString();

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

        ParameterizedTypeReference<AcquireServiceMetricResponseSchema> returnType = new ParameterizedTypeReference<AcquireServiceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return DeleteServiceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeleteServiceMetricResponseSchema v10NwsServicesMetricsDelete(String oid, DeleteServiceMetricRequestSchema body) throws RestClientException {
        return v10NwsServicesMetricsDeleteWithHttpInfo(oid, body).getBody();
    }

    /**
     * 
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;DeleteServiceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeleteServiceMetricResponseSchema> v10NwsServicesMetricsDeleteWithHttpInfo(String oid, DeleteServiceMetricRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesMetricsDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metrics").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<DeleteServiceMetricResponseSchema> returnType = new ParameterizedTypeReference<DeleteServiceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param metricType  (optional)
     * @param metricNum  (optional)
     * @param serviceInstanceId  (optional)
     * @param jobId  (optional)
     * @param creationDate  (optional)
     * @return ListServiceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceMetricResponseSchema v10NwsServicesMetricsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String metricType, Integer metricNum, Integer serviceInstanceId, Integer jobId, String creationDate) throws RestClientException {
        return v10NwsServicesMetricsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, metricType, metricNum, serviceInstanceId, jobId, creationDate).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param metricType  (optional)
     * @param metricNum  (optional)
     * @param serviceInstanceId  (optional)
     * @param jobId  (optional)
     * @param creationDate  (optional)
     * @return ResponseEntity&lt;ListServiceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceMetricResponseSchema> v10NwsServicesMetricsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String metricType, Integer metricNum, Integer serviceInstanceId, Integer jobId, String creationDate) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metrics").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "metric_type", metricType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "metric_num", metricNum));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service_instance_id", serviceInstanceId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "job_id", jobId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "creation_date", creationDate));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceMetricResponseSchema> returnType = new ParameterizedTypeReference<ListServiceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServiceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceMetricResponseSchema v10NwsServicesMetricsOidGet(String oid) throws RestClientException {
        return v10NwsServicesMetricsOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceMetricResponseSchema> v10NwsServicesMetricsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesMetricsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metrics/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceMetricResponseSchema> returnType = new ParameterizedTypeReference<GetServiceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param extractionDate  (optional)
     * @return GetInstantConsumeServiceResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetInstantConsumeServiceResponseSchema v10NwsServicesMetricsOidInstantconsumeGet(String oid, String extractionDate) throws RestClientException {
        return v10NwsServicesMetricsOidInstantconsumeGetWithHttpInfo(oid, extractionDate).getBody();
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
     * @param oid id, uuid or name (required)
     * @param extractionDate  (optional)
     * @return ResponseEntity&lt;GetInstantConsumeServiceResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetInstantConsumeServiceResponseSchema> v10NwsServicesMetricsOidInstantconsumeGetWithHttpInfo(String oid, String extractionDate) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesMetricsOidInstantconsumeGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metrics/{oid}/instantconsume").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "extraction_date", extractionDate));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetInstantConsumeServiceResponseSchema> returnType = new ParameterizedTypeReference<GetInstantConsumeServiceResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param body  (optional)
     * @return CreateServiceMetricResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreateServiceMetricResponseSchema v10NwsServicesMetricsPost(CreateServiceMetricRequestSchema body) throws RestClientException {
        return v10NwsServicesMetricsPostWithHttpInfo(body).getBody();
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CreateServiceMetricResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CreateServiceMetricResponseSchema> v10NwsServicesMetricsPostWithHttpInfo(CreateServiceMetricRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metrics").build().toUriString();

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

        ParameterizedTypeReference<CreateServiceMetricResponseSchema> returnType = new ParameterizedTypeReference<CreateServiceMetricResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param groupName  (optional)
     * @param metricType  (optional)
     * @param status  (optional)
     * @return ListServiceMetricTypeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceMetricTypeResponseSchema v10NwsServicesMetricstypesGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String groupName, String metricType, String status) throws RestClientException {
        return v10NwsServicesMetricstypesGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, groupName, metricType, status).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param groupName  (optional)
     * @param metricType  (optional)
     * @param status  (optional)
     * @return ResponseEntity&lt;ListServiceMetricTypeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceMetricTypeResponseSchema> v10NwsServicesMetricstypesGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String groupName, String metricType, String status) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metricstypes").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "group_name", groupName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "metric_type", metricType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceMetricTypeResponseSchema> returnType = new ParameterizedTypeReference<ListServiceMetricTypeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete service metric type object Call this api to delete service metric type object.
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsServicesMetricstypesOidDelete(String oid) throws RestClientException {
        v10NwsServicesMetricstypesOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete service metric type object Call this api to delete service metric type object.
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsServicesMetricstypesOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesMetricstypesOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metricstypes/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServiceMetricTypeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceMetricTypeResponseSchema v10NwsServicesMetricstypesOidGet(String oid) throws RestClientException {
        return v10NwsServicesMetricstypesOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceMetricTypeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceMetricTypeResponseSchema> v10NwsServicesMetricstypesOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesMetricstypesOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metricstypes/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceMetricTypeResponseSchema> returnType = new ParameterizedTypeReference<GetServiceMetricTypeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicesMetricstypesOidPut(String oid, UpdateServiceMetricTypeRequestSchema body) throws RestClientException {
        return v10NwsServicesMetricstypesOidPutWithHttpInfo(oid, body).getBody();
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicesMetricstypesOidPutWithHttpInfo(String oid, UpdateServiceMetricTypeRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicesMetricstypesOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metricstypes/{oid}").buildAndExpand(uriVariables).toUriString();

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
     * @param body  (optional)
     * @return CreateServiceMetricTypeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreateServiceMetricTypeResponseSchema v10NwsServicesMetricstypesPost(CreateServiceMetricTypeRequestSchema body) throws RestClientException {
        return v10NwsServicesMetricstypesPostWithHttpInfo(body).getBody();
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CreateServiceMetricTypeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CreateServiceMetricTypeResponseSchema> v10NwsServicesMetricstypesPostWithHttpInfo(CreateServiceMetricTypeRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/services/metricstypes").build().toUriString();

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

        ParameterizedTypeReference<CreateServiceMetricTypeResponseSchema> returnType = new ParameterizedTypeReference<CreateServiceMetricTypeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service types
     * Get service types
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param status  (optional)
     * @param flagContainer  (optional)
     * @param objclass  (optional)
     * @param plugintype  (optional)
     * @return ListServiceTypeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceTypeResponseSchema v10NwsServicetypesGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String status, Boolean flagContainer, String objclass, String plugintype) throws RestClientException {
        return v10NwsServicetypesGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, status, flagContainer, objclass, plugintype).getBody();
    }

    /**
     * Get service types
     * Get service types
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param status  (optional)
     * @param flagContainer  (optional)
     * @param objclass  (optional)
     * @param plugintype  (optional)
     * @return ResponseEntity&lt;ListServiceTypeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceTypeResponseSchema> v10NwsServicetypesGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String status, Boolean flagContainer, String objclass, String plugintype) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flag_container", flagContainer));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objclass", objclass));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "plugintype", plugintype));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceTypeResponseSchema> returnType = new ParameterizedTypeReference<ListServiceTypeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete service type
     * Delete service type
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsServicetypesOidDelete(String oid) throws RestClientException {
        v10NwsServicetypesOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete service type
     * Delete service type
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsServicetypesOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicetypesOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service type
     * Get service type
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
     * @param oid id, uuid or name (required)
     * @return GetServiceTypeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceTypeResponseSchema v10NwsServicetypesOidGet(String oid) throws RestClientException {
        return v10NwsServicetypesOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get service type
     * Get service type
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceTypeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceTypeResponseSchema> v10NwsServicetypesOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicetypesOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceTypeResponseSchema> returnType = new ParameterizedTypeReference<GetServiceTypeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service type permissions
     * Get service type permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsServicetypesOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsServicetypesOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
    }

    /**
     * Get service type permissions
     * Get service type permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsServicetypesOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicetypesOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update service type
     * Update service type
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicetypesOidPut(String oid, UpdateServiceTypeRequestSchema body) throws RestClientException {
        return v10NwsServicetypesOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update service type
     * Update service type
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicetypesOidPutWithHttpInfo(String oid, UpdateServiceTypeRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsServicetypesOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes/{oid}").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Get service plugin type
     * Get service plugin type
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
     * @return ListServicePluginTypeResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServicePluginTypeResponseSchema v10NwsServicetypesPlugintypesGet() throws RestClientException {
        return v10NwsServicetypesPlugintypesGetWithHttpInfo().getBody();
    }

    /**
     * Get service plugin type
     * Get service plugin type
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
     * @return ResponseEntity&lt;ListServicePluginTypeResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServicePluginTypeResponseSchema> v10NwsServicetypesPlugintypesGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes/plugintypes").build().toUriString();

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

        ParameterizedTypeReference<ListServicePluginTypeResponseSchema> returnType = new ParameterizedTypeReference<ListServicePluginTypeResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create service type
     * Create service type
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsServicetypesPost(CreateServiceTypeRequestSchema body) throws RestClientException {
        return v10NwsServicetypesPostWithHttpInfo(body).getBody();
    }

    /**
     * Create service type
     * Create service type
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsServicetypesPostWithHttpInfo(CreateServiceTypeRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/servicetypes").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * List service catalog
     * List service catalog
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @return ListCatalogResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListCatalogResponseSchema v10NwsSrvcatalogsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active) throws RestClientException {
        return v10NwsSrvcatalogsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active).getBody();
    }

    /**
     * List service catalog
     * List service catalog
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @return ResponseEntity&lt;ListCatalogResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListCatalogResponseSchema> v10NwsSrvcatalogsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListCatalogResponseSchema> returnType = new ParameterizedTypeReference<ListCatalogResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Unset service catalog definitions
     * Unset service catalog definitions
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsSrvcatalogsOidDefsDelete(String oid, CatalogDefRequestSchema body) throws RestClientException {
        v10NwsSrvcatalogsOidDefsDeleteWithHttpInfo(oid, body);
    }

    /**
     * Unset service catalog definitions
     * Unset service catalog definitions
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsSrvcatalogsOidDefsDeleteWithHttpInfo(String oid, CatalogDefRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidDefsDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}/defs").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service catalog definitions
     * Get service catalog definitions
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
     * @param oid id, uuid or name. If value is \&quot;all\&quot; select definitions for all thecatalogs you can view (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param plugintype plugin type name (optional)
     * @param flagContainer if True select only definition with type that is a container (optional)
     * @return GetCatalogDefsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetCatalogDefsResponseSchema v10NwsSrvcatalogsOidDefsGet(String oid, Integer size, Integer page, String order, String field, String plugintype, Boolean flagContainer) throws RestClientException {
        return v10NwsSrvcatalogsOidDefsGetWithHttpInfo(oid, size, page, order, field, plugintype, flagContainer).getBody();
    }

    /**
     * Get service catalog definitions
     * Get service catalog definitions
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
     * @param oid id, uuid or name. If value is \&quot;all\&quot; select definitions for all thecatalogs you can view (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param plugintype plugin type name (optional)
     * @param flagContainer if True select only definition with type that is a container (optional)
     * @return ResponseEntity&lt;GetCatalogDefsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetCatalogDefsResponseSchema> v10NwsSrvcatalogsOidDefsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field, String plugintype, Boolean flagContainer) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidDefsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}/defs").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "plugintype", plugintype));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flag_container", flagContainer));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetCatalogDefsResponseSchema> returnType = new ParameterizedTypeReference<GetCatalogDefsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Set service catalog definitions
     * set service catalog definitions
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsSrvcatalogsOidDefsPut(String oid, CatalogDefRequestSchema body) throws RestClientException {
        return v10NwsSrvcatalogsOidDefsPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Set service catalog definitions
     * set service catalog definitions
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsSrvcatalogsOidDefsPutWithHttpInfo(String oid, CatalogDefRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidDefsPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}/defs").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Delete service catalog
     * Delete service catalog
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsSrvcatalogsOidDelete(String oid) throws RestClientException {
        v10NwsSrvcatalogsOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete service catalog
     * Delete service catalog
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsSrvcatalogsOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service catalog
     * Get service catalog
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
     * @param oid id, uuid or name (required)
     * @return GetCatalogResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetCatalogResponseSchema v10NwsSrvcatalogsOidGet(String oid) throws RestClientException {
        return v10NwsSrvcatalogsOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get service catalog
     * Get service catalog
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetCatalogResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetCatalogResponseSchema> v10NwsSrvcatalogsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetCatalogResponseSchema> returnType = new ParameterizedTypeReference<GetCatalogResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service catalog permissions
     * Get service catalog permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsSrvcatalogsOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsSrvcatalogsOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
    }

    /**
     * Get service catalog permissions
     * Get service catalog permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsSrvcatalogsOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update service catalog
     * Update service catalog
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsSrvcatalogsOidPut(String oid, UpdateCatalogRequestSchema body) throws RestClientException {
        return v10NwsSrvcatalogsOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update service catalog
     * Update service catalog
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsSrvcatalogsOidPutWithHttpInfo(String oid, UpdateCatalogRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsSrvcatalogsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs/{oid}").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Create service catalog
     * Create service catalog
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsSrvcatalogsPost(CreateCatalogRequestSchema body) throws RestClientException {
        return v10NwsSrvcatalogsPostWithHttpInfo(body).getBody();
    }

    /**
     * Create service catalog
     * Create service catalog
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsSrvcatalogsPostWithHttpInfo(CreateCatalogRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/srvcatalogs").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service tags
     * Get service tags
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param value  (optional)
     * @param service  (optional)
     * @param link  (optional)
     * @return ListTagsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListTagsResponseSchema v10NwsTagsGet(Integer size, Integer page, String order, String field, String value, String service, String link) throws RestClientException {
        return v10NwsTagsGetWithHttpInfo(size, page, order, field, value, service, link).getBody();
    }

    /**
     * Get service tags
     * Get service tags
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param value  (optional)
     * @param service  (optional)
     * @param link  (optional)
     * @return ResponseEntity&lt;ListTagsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListTagsResponseSchema> v10NwsTagsGetWithHttpInfo(Integer size, Integer page, String order, String field, String value, String service, String link) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/tags").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "value", value));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service", service));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "link", link));

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListTagsResponseSchema> returnType = new ParameterizedTypeReference<ListTagsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a service tag
     * Delete a service tag
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
     * @param oid id, uuid or name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void v10NwsTagsOidDelete(String oid) throws RestClientException {
        v10NwsTagsOidDeleteWithHttpInfo(oid);
    }

    /**
     * Delete a service tag
     * Delete a service tag
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> v10NwsTagsOidDeleteWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsTagsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/tags/{oid}").buildAndExpand(uriVariables).toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get a service tag
     * Get a service tag
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
     * @param oid id, uuid or name (required)
     * @return GetTagResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetTagResponseSchema v10NwsTagsOidGet(String oid) throws RestClientException {
        return v10NwsTagsOidGetWithHttpInfo(oid).getBody();
    }

    /**
     * Get a service tag
     * Get a service tag
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetTagResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetTagResponseSchema> v10NwsTagsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsTagsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/tags/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetTagResponseSchema> returnType = new ParameterizedTypeReference<GetTagResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service tag permissions
     * Get service tag permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ApiObjectPermsResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ApiObjectPermsResponseSchema v10NwsTagsOidPermsGet(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        return v10NwsTagsOidPermsGetWithHttpInfo(oid, size, page, order, field).getBody();
    }

    /**
     * Get service tag permissions
     * Get service tag permissions
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
     * @param oid id, uuid or name (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @return ResponseEntity&lt;ApiObjectPermsResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiObjectPermsResponseSchema> v10NwsTagsOidPermsGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsTagsOidPermsGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/tags/{oid}/perms").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));

        final String[] accepts = { 
            "application/json", "application/xml", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json", "application/xml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ApiObjectPermsResponseSchema> returnType = new ParameterizedTypeReference<ApiObjectPermsResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a service tag
     * Update a service tag
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsTagsOidPut(String oid, UpdateTagRequestSchema body) throws RestClientException {
        return v10NwsTagsOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update a service tag
     * Update a service tag
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsTagsOidPutWithHttpInfo(String oid, UpdateTagRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v10NwsTagsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/tags/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<CrudApiObjectResponseSchema> returnType = new ParameterizedTypeReference<CrudApiObjectResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a service tag
     * Create a service tag
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v10NwsTagsPost(CreateTagRequestSchema body) throws RestClientException {
        return v10NwsTagsPostWithHttpInfo(body).getBody();
    }

    /**
     * Create a service tag
     * Create a service tag
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v10NwsTagsPostWithHttpInfo(CreateTagRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v1.0/nws/tags").build().toUriString();

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

        ParameterizedTypeReference<CrudApiObjectResponseSchema> returnType = new ParameterizedTypeReference<CrudApiObjectResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param accountId  (optional)
     * @param serviceDefinitionId  (optional)
     * @param status  (optional)
     * @param bpmnProcessId  (optional)
     * @param resourceUuid  (optional)
     * @param parentId  (optional)
     * @param plugintype  (optional)
     * @param tags List of tags. Use comma as separator if tags are in or. Use + separator if tags are in and (optional)
     * @param flagContainer if True show only container instances (optional)
     * @return ListServiceInstancesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ListServiceInstancesResponseSchema v20NwsServiceinstsGet(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String accountId, String serviceDefinitionId, String status, Integer bpmnProcessId, String resourceUuid, String parentId, String plugintype, String tags, Boolean flagContainer) throws RestClientException {
        return v20NwsServiceinstsGetWithHttpInfo(size, page, order, field, filterExpired, filterCreationDateStart, filterCreationDateStop, filterModificationDateStart, filterModificationDateStop, filterExpiryDateStart, filterExpiryDateStop, name, objid, version, active, accountId, serviceDefinitionId, status, bpmnProcessId, resourceUuid, parentId, plugintype, tags, flagContainer).getBody();
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
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param filterExpired  (optional)
     * @param filterCreationDateStart  (optional)
     * @param filterCreationDateStop  (optional)
     * @param filterModificationDateStart  (optional)
     * @param filterModificationDateStop  (optional)
     * @param filterExpiryDateStart  (optional)
     * @param filterExpiryDateStop  (optional)
     * @param name  (optional)
     * @param objid  (optional)
     * @param version  (optional)
     * @param active  (optional)
     * @param accountId  (optional)
     * @param serviceDefinitionId  (optional)
     * @param status  (optional)
     * @param bpmnProcessId  (optional)
     * @param resourceUuid  (optional)
     * @param parentId  (optional)
     * @param plugintype  (optional)
     * @param tags List of tags. Use comma as separator if tags are in or. Use + separator if tags are in and (optional)
     * @param flagContainer if True show only container instances (optional)
     * @return ResponseEntity&lt;ListServiceInstancesResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ListServiceInstancesResponseSchema> v20NwsServiceinstsGetWithHttpInfo(Integer size, Integer page, String order, String field, Boolean filterExpired, String filterCreationDateStart, String filterCreationDateStop, String filterModificationDateStart, String filterModificationDateStop, String filterExpiryDateStart, String filterExpiryDateStop, String name, String objid, String version, Boolean active, String accountId, String serviceDefinitionId, String status, Integer bpmnProcessId, String resourceUuid, String parentId, String plugintype, String tags, Boolean flagContainer) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expired", filterExpired));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_start", filterCreationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_creation_date_stop", filterCreationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_start", filterModificationDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_modification_date_stop", filterModificationDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_start", filterExpiryDateStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter_expiry_date_stop", filterExpiryDateStop));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "objid", objid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "active", active));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account_id", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "service_definition_id", serviceDefinitionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "bpmn_process_id", bpmnProcessId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "resource_uuid", resourceUuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "parent_id", parentId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "plugintype", plugintype));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tags", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "flag_container", flagContainer));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<ListServiceInstancesResponseSchema> returnType = new ParameterizedTypeReference<ListServiceInstancesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a service instance using a specific plugintype and an existing resource
     * Create a service instance using a specific plugintype and an existing resource
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
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v20NwsServiceinstsImportPost(ImportInstanceRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsImportPostWithHttpInfo(body).getBody();
    }

    /**
     * Create a service instance using a specific plugintype and an existing resource
     * Create a service instance using a specific plugintype and an existing resource
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v20NwsServiceinstsImportPostWithHttpInfo(ImportInstanceRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/import").build().toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return CheckServiceInstanceResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CheckServiceInstanceResponseSchema v20NwsServiceinstsOidCheckGet(String oid) throws RestClientException {
        return v20NwsServiceinstsOidCheckGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;CheckServiceInstanceResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CheckServiceInstanceResponseSchema> v20NwsServiceinstsOidCheckGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidCheckGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}/check").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<CheckServiceInstanceResponseSchema> returnType = new ParameterizedTypeReference<CheckServiceInstanceResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return UpdateServiceConfigResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UpdateServiceConfigResponseSchema v20NwsServiceinstsOidConfigPut(String oid, UpdateServiceConfigRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsOidConfigPutWithHttpInfo(oid, body).getBody();
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;UpdateServiceConfigResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UpdateServiceConfigResponseSchema> v20NwsServiceinstsOidConfigPutWithHttpInfo(String oid, UpdateServiceConfigRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidConfigPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}/config").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<UpdateServiceConfigResponseSchema> returnType = new ParameterizedTypeReference<UpdateServiceConfigResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a service instance
     * Delete a service instance
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectTaskResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectTaskResponseSchema v20NwsServiceinstsOidDelete(String oid, DeleteServiceInstanceRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsOidDeleteWithHttpInfo(oid, body).getBody();
    }

    /**
     * Delete a service instance
     * Delete a service instance
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectTaskResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectTaskResponseSchema> v20NwsServiceinstsOidDeleteWithHttpInfo(String oid, DeleteServiceInstanceRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}").buildAndExpand(uriVariables).toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
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
     * @param oid id, uuid or name (required)
     * @return GetServiceInstanceResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetServiceInstanceResponseSchema v20NwsServiceinstsOidGet(String oid) throws RestClientException {
        return v20NwsServiceinstsOidGetWithHttpInfo(oid).getBody();
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
     * @param oid id, uuid or name (required)
     * @return ResponseEntity&lt;GetServiceInstanceResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetServiceInstanceResponseSchema> v20NwsServiceinstsOidGetWithHttpInfo(String oid) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GetServiceInstanceResponseSchema> returnType = new ParameterizedTypeReference<GetServiceInstanceResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get service instance linked instances
     * Get service instance linked instances
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
     * @param oid id, uuid (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param type  (optional)
     * @param linkType  (optional)
     * @return GetLinkedServiceInstancesResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GetLinkedServiceInstancesResponseSchema v20NwsServiceinstsOidLinkedGet(String oid, Integer size, Integer page, String order, String field, String type, String linkType) throws RestClientException {
        return v20NwsServiceinstsOidLinkedGetWithHttpInfo(oid, size, page, order, field, type, linkType).getBody();
    }

    /**
     * Get service instance linked instances
     * Get service instance linked instances
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
     * @param oid id, uuid (required)
     * @param size entities list page size. -1 to get all the records (optional, default to 20)
     * @param page entities list page selected (optional)
     * @param order entities list order: ASC or DESC (optional, default to DESC)
     * @param field entities list order field. Ex. id, uuid, name (optional, default to id)
     * @param type  (optional)
     * @param linkType  (optional)
     * @return ResponseEntity&lt;GetLinkedServiceInstancesResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GetLinkedServiceInstancesResponseSchema> v20NwsServiceinstsOidLinkedGetWithHttpInfo(String oid, Integer size, Integer page, String order, String field, String type, String linkType) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidLinkedGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}/linked").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "order", order));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "field", field));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", type));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "link_type", linkType));

        final String[] accepts = { 
            "application/xml", "application/json", "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/xml", "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "ApiKeyAuth", "OAuth2" };

        ParameterizedTypeReference<GetLinkedServiceInstancesResponseSchema> returnType = new ParameterizedTypeReference<GetLinkedServiceInstancesResponseSchema>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Patch a service instance
     * Patch a service instance
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectTaskResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectTaskResponseSchema v20NwsServiceinstsOidPatch(String oid, PatchServiceInstanceRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsOidPatchWithHttpInfo(oid, body).getBody();
    }

    /**
     * Patch a service instance
     * Patch a service instance
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectTaskResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectTaskResponseSchema> v20NwsServiceinstsOidPatchWithHttpInfo(String oid, PatchServiceInstanceRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidPatch");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}").buildAndExpand(uriVariables).toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a service instance
     * Update a service instance
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectTaskResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectTaskResponseSchema v20NwsServiceinstsOidPut(String oid, UpdateServiceInstanceRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsOidPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update a service instance
     * Update a service instance
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectTaskResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectTaskResponseSchema> v20NwsServiceinstsOidPutWithHttpInfo(String oid, UpdateServiceInstanceRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}").buildAndExpand(uriVariables).toUriString();

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
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update service instance status
     * Update service instance status
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return CrudApiObjectResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectResponseSchema v20NwsServiceinstsOidStatusPut(String oid, UpdateServiceInstanceStatusRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsOidStatusPutWithHttpInfo(oid, body).getBody();
    }

    /**
     * Update service instance status
     * Update service instance status
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
     * @param oid id, uuid or name (required)
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectResponseSchema> v20NwsServiceinstsOidStatusPutWithHttpInfo(String oid, UpdateServiceInstanceStatusRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'oid' is set
        if (oid == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'oid' when calling v20NwsServiceinstsOidStatusPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("oid", oid);
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts/{oid}/status").buildAndExpand(uriVariables).toUriString();

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
    /**
     * Create a service instance using a specific plugintype
     * Create a service instance using a specific plugintype
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
     * @param body  (optional)
     * @return CrudApiObjectTaskResponseSchema
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CrudApiObjectTaskResponseSchema v20NwsServiceinstsPost(CreateServiceInstanceRequestSchema body) throws RestClientException {
        return v20NwsServiceinstsPostWithHttpInfo(body).getBody();
    }

    /**
     * Create a service instance using a specific plugintype
     * Create a service instance using a specific plugintype
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
     * @param body  (optional)
     * @return ResponseEntity&lt;CrudApiObjectTaskResponseSchema&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CrudApiObjectTaskResponseSchema> v20NwsServiceinstsPostWithHttpInfo(CreateServiceInstanceRequestSchema body) throws RestClientException {
        Object postBody = body;
        
        String path = UriComponentsBuilder.fromPath("/v2.0/nws/serviceinsts").build().toUriString();

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
}
