package com.udacity.graphql.exception;

import java.util.HashMap;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class DogNotFoundException extends RuntimeException implements GraphQLError {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException(String message, Long invalidDogId) {
        super(message);
        extensions.put("invalidDogId", invalidDogId);
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public java.util.List<SourceLocation> getLocations() {
        return null;
    }
}