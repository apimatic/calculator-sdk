/*
 * APIMATICCalculatorLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package com.example.sdk.controllers;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import com.example.sdk.ApiHelper;
import com.example.sdk.AuthManager;
import com.example.sdk.Configuration;
import com.example.sdk.exceptions.ApiException;
import com.example.sdk.http.Headers;
import com.example.sdk.http.client.HttpCallback;
import com.example.sdk.http.client.HttpClient;
import com.example.sdk.http.client.HttpContext;
import com.example.sdk.http.request.HttpRequest;
import com.example.sdk.http.response.HttpResponse;
import com.example.sdk.http.response.HttpStringResponse;
import com.example.sdk.models.GetCalculateInput;

/**
 * This class lists all the endpoints of the groups.
 */
public final class SimpleCalculatorController extends BaseController {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public SimpleCalculatorController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public SimpleCalculatorController(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Calculates the expression using the specified operation.
     * @param  input  GetCalculateInput object containing request parameters
     * @return    Returns the Double response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public Double getCalculate(
            final GetCalculateInput input) throws ApiException, IOException {
        HttpRequest request = buildGetCalculateRequest(input);
        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetCalculateResponse(context);
    }

    /**
     * Calculates the expression using the specified operation.
     * @param  input  GetCalculateInput object containing request parameters
     * @return    Returns the Double response from the API call
     */
    public CompletableFuture<Double> getCalculateAsync(
            final GetCalculateInput input) {
        return makeHttpCallAsync(() -> buildGetCalculateRequest(input),
            request -> getClientInstance().executeAsync(request, false),
            context -> handleGetCalculateResponse(context));
    }

    /**
     * Builds the HttpRequest object for getCalculate.
     */
    private HttpRequest buildGetCalculateRequest(
            final GetCalculateInput input) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/{operation}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("operation",
                new SimpleEntry<Object, Boolean>(((input.getOperation() != null) ? input.getOperation().value() : null), true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("x", input.getX());
        queryParameters.put("y", input.getY());

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("user-agent", BaseController.userAgent);

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for getCalculate.
     * @return An object of type double
     */
    private Double handleGetCalculateResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        double result = Double.parseDouble(responseBody);

        return result;
    }

}