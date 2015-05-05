package de.maxikg.osuapi.client.exception;

/**
 * @author maxikg
 */
public class OsuClientRequestException extends OsuClientException {

    public OsuClientRequestException() {
        super();
    }

    public OsuClientRequestException(String message) {
        super(message);
    }

    public OsuClientRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public OsuClientRequestException(Throwable cause) {
        super(cause);
    }
}
