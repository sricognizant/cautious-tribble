package org.micronaut.client;

import io.micronaut.http.client.annotation.Client;
import org.micronaut.TriviaResultApi;

@Client("/")
public interface TriviaResultClient extends TriviaResultApi {

}
