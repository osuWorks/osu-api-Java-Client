package de.maxikg.osuapi.client.request.builder;

import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.UserScore;

import java.util.Collection;

/**
 * @author maxikg
 */
public interface GetUserBestRequestBuilder extends RequestBuilder<Collection<UserScore>> {

    GetUserBestRequestBuilder mode(GameMode mode);

    GetUserBestRequestBuilder unsetMode();

    GetUserBestRequestBuilder limit(int limit);

    GetUserBestRequestBuilder unsetLimit();
}
