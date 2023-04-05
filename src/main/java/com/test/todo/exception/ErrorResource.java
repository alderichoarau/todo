package com.test.todo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class ErrorResource implements Serializable {

    private static final long serialVersionUID = -2029107332904178110L;

    private String label;
    private String errorMessage;
    private HttpStatus status;

    /**
     * Constructor for {@link ErrorResource}
     *
     * @param label        label
     * @param errorMessage detail message
     * @param status       status
     */
    public ErrorResource(final String label, final String errorMessage, final HttpStatus status) {
        super();
        this.label = label;
        this.errorMessage = errorMessage;
        this.status = status;
    }
}