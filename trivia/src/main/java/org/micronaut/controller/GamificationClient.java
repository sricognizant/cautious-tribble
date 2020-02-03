package org.micronaut.controller;

import io.micronaut.http.client.annotation.Client;

@Client("http://localhost:5000/results")
public interface GamificationClient extends GamificationApi {



}
