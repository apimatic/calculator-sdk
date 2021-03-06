/*
 * APIMATICCalculatorLib
 *
 * This file was automatically generated by APIMATIC v3.0 ( https://www.apimatic.io ).
 */

package com.example.sdk;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.example.sdk.exceptions.ApiException;
import com.example.sdk.http.request.HttpRequest;

/**
 * Interface for defining the behavior of Authentication Classes.
 */
public interface AuthManager {

    /**
     * Adds authentication to the given HttpRequest.
     * @param httpRequest   HttpRequest object for authentication
     * @return Returns the object of HttpRequest
     * @throws ApiException   Represents error response from the server.
     * @throws IOException   Signals that an I/O exception of some sort has occurred.
     */
    HttpRequest apply(HttpRequest httpRequest) throws ApiException, IOException;

    /**
     * Asynchronously adds authentication to the given HttpRequest.
     * @param httpRequest   HttpRequest object for authentication
     * @return Returns the completable future of HttpRequest
     */
    CompletableFuture<HttpRequest> applyAsync(HttpRequest httpRequest);
}
