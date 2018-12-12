package com.sightseekerstudio.wildflyswarmmpdemo.jaxrs.ext;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.Getter;
import lombok.Setter;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        return Response.status(Response.Status.BAD_REQUEST).entity(new ConstraintViolationExceptionModel(exception))
                .build();
    }

    /**
     * {@code ConstraintViolationExceptionMapper} 用のレスポンスEntity
     */
    @Getter
    @Setter
    public static class ConstraintViolationExceptionModel extends Exception {

        private Set<ConstraintViolationModel> constraintViolations = new HashSet<>();

        public ConstraintViolationExceptionModel(ConstraintViolationException exception) {
            super(exception);
            constraintViolations = exception.getConstraintViolations().stream().map(ConstraintViolationModel::new)
                    .collect(Collectors.toSet());
        }

        @Getter
        @Setter
        public static class ConstraintViolationModel implements Serializable {

            private String propertyPath;
            private String message;

            public ConstraintViolationModel(ConstraintViolation violation) {
                this.message = violation.getMessage();
                this.propertyPath = violation.getPropertyPath().toString();
            }

        }
    }
}
