package com.test.todo.exception;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 6124468795632907167L;

    private final String errorCode;
    private final String[] codes;
    private final Object[] arguments;

    /**
     * CommonException constructor
     *
     * @param errorCode error code.
     * @param arguments arguments.
     */
    public CommonException(String errorCode, Object... arguments) {
        this(null, errorCode, null, arguments);
    }

    /**
     * CommonException constructor
     *
     * @param cause
     * @param errorCode
     * @param arguments
     */
    public CommonException(Throwable cause, String errorCode, Object... arguments) {
        this(cause, errorCode, null, arguments);
    }

    /**
     * CommonException constructor
     *
     * @param errorCode
     * @param defaultMessage
     * @param arguments
     */
    public CommonException(String errorCode, String defaultMessage, Object... arguments) {
        this(null, errorCode, defaultMessage, arguments);
    }

    /**
     * CommonException constructor
     *
     * @param cause          cause.
     * @param errorCode      errorCode.
     * @param defaultMessage defaultMessage.
     * @param arguments      arguments.
     */
    public CommonException(Throwable cause, String errorCode, String defaultMessage, Object... arguments) {
        super(defaultMessage == null ? errorCode : defaultMessage, cause);
        this.errorCode = errorCode;
        this.codes = new String[]{errorCode};
        this.arguments = arguments;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String[] getCodes() {
        return this.codes;
    }

    public Object[] getArguments() {
        return this.arguments;
    }
}

