package exceptions;

public class NegativeValueAwardException extends Exception {

    public NegativeValueAwardException(String message) {
        super(message);
    }

    public NegativeValueAwardException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeValueAwardException(Throwable cause) {
        super(cause);
    }

    public NegativeValueAwardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
