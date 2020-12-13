package net.cactusthorn.micro.core;

public class MicroException extends RuntimeException {

    private static final long serialVersionUID = 0L;

    public MicroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MicroException(String message, Throwable cause) {
        super(message, cause);
    }

    public MicroException(String message) {
        super(message);
    }

    public MicroException(Throwable cause) {
        super(cause);
    }
}
