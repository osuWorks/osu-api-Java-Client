package de.maxikg.osuapi.client;

/**
 * @author maxikg
 */
public interface CloseableOsuClient extends OsuClient {

    void close();
}
