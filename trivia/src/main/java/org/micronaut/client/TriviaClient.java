package org.micronaut.client;

import io.micronaut.http.client.annotation.Client;
import org.micronaut.TriviaApi;

@Client("/")
public interface TriviaClient extends TriviaApi {
}
