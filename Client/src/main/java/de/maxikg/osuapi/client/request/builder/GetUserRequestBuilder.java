package de.maxikg.osuapi.client.request.builder;

import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.User;

import java.util.Collection;

/**
 * @author maxikg
 */
public interface GetUserRequestBuilder extends RequestBuilder<Collection<User>> {

    GetUserRequestBuilder mode(GameMode mode);

    GetUserRequestBuilder unsetMode();

    GetUserRequestBuilder daysSinceLastEvent(int days);

    GetUserRequestBuilder unsetDaysSinceLastEvent();
}
