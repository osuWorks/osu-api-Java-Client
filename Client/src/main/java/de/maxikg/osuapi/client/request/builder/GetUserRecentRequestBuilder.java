package de.maxikg.osuapi.client.request.builder;

import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.UserGame;

import java.util.Collection;

/**
 * @author maxikg
 */
public interface GetUserRecentRequestBuilder extends RequestBuilder<Collection<UserGame>> {

    GetUserRecentRequestBuilder mode(GameMode mode);

    GetUserRecentRequestBuilder unsetMode();

    GetUserRecentRequestBuilder limit(int limit);

    GetUserRecentRequestBuilder unsetLimit();
}
