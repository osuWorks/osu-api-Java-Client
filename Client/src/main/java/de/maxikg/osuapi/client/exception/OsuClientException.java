package de.maxikg.osuapi.client.exception;

/**
 * @author maxikg
 */
public class OsuClientException extends RuntimeException {

    public OsuClientException() {
        super();
    }

    public OsuClientException(String message) {
        super(message);
    }

    public OsuClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public OsuClientException(Throwable cause) {
        super(cause);
    }
}
