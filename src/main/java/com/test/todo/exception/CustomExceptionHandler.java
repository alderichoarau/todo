package com.test.todo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
@ControllerAdvice
public class CustomExceptionHandler {

    private MessageSource messageSource;

    @Autowired
    public CustomExceptionHandler(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public CustomExceptionHandler() {
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseBody
    public ErrorResource handleExceptionNotFound(final Exception e) {
        log.warn("{} handle: {}", e.getClass().getSimpleName(), e.getMessage());
        if (e instanceof CommonException) {
            return new ErrorResource(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ErrorResource(e.getClass().getSimpleName(), e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
}
