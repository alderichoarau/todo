package com.test.todo.exception;

/**
 * Custom Not Found Exception
 */
public class NotFoundException extends CommonException {
    private static final long serialVersionUID = 9115037758722267951L;

    /**
     * NotFoundException constructor
     */
    public NotFoundException() {
        super("Resource not found!");
    }

    /**
     * NotFoundException constructor
     *
     * @param errorCode error code
     * @param args      arguments
     */
    public NotFoundException(final String errorCode, final Object... args) {
        super(errorCode, args);
    }

    /**
     * NotFoundException constructor
     *
     * @param throwable throwable
     * @param errorCode error code
     * @param args      arguments
     */
    public NotFoundException(final Throwable throwable, final String errorCode, final Object... args) {
        super(throwable, errorCode, args);
    }
}
