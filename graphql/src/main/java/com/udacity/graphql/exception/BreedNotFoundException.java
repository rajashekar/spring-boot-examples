package com.udacity.graphql.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Map<String, Object> extensions = new HashMap<>();

    public BreedNotFoundException(String message, String invalidBreed) {
        super(message);
        extensions.put("invalidBreedId", invalidBreed);
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

}