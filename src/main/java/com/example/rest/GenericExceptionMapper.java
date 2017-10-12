package com.example.rest;

import com.example.rest.exception.ExceptionJSONInfo;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        return Response.status(409).entity(new ExceptionJSONInfo(409, exception.getMessage())).build();
    }

}
