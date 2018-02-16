package exceptions;

public class NegativeSoliException extends Exception {
    public NegativeSoliException() {
        super();
    }

    public NegativeSoliException(String message) {
        super(message);
    }

    public NegativeSoliException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeSoliException(Throwable cause) {
        super(cause);
    }

    protected NegativeSoliException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
