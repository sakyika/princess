package com.sakk.princess.core.service.exceptions;

public class PermissionNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6975301468402274579L;

    public PermissionNotFoundException() {
    }

    public PermissionNotFoundException(String message) {
        super(message);
    }

    public PermissionNotFoundException(Throwable cause) {
        super(cause);
    }

    public PermissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionNotFoundException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
