package de.maxikg.osuapi.client.exception;

/**
 * @author maxikg
 */
public class OsuClientConnectionException extends OsuClientException {

    public OsuClientConnectionException() {
        super();
    }

    public OsuClientConnectionException(String message) {
        super(message);
    }

    public OsuClientConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public OsuClientConnectionException(Throwable cause) {
        super(cause);
    }
}
