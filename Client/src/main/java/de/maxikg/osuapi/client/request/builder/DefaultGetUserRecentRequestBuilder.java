package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.UserGame;
import org.apache.http.client.HttpClient;

import java.util.Collection;

/**
 * @author maxikg
 */
public class DefaultGetUserRecentRequestBuilder extends AbstractRequestBuilder implements GetUserRecentRequestBuilder {

    private static final String ENDPOINT = "get_user_recent";
    private static final String PARAM_USER = "u";
    private static final String PARAM_USER_TYPE = "type";
    private static final String PARAM_MODE = "m";
    private static final String PARAM_LIMIT = "limit";

    public DefaultGetUserRecentRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, int userId) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_USER, userId);
        parameters.put(PARAM_USER_TYPE, "id");
    }

    public DefaultGetUserRecentRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, String username) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_USER, Preconditions.checkNotNull(username, "Required parameter username cannot be null."));
        parameters.put(PARAM_USER_TYPE, "string");
    }

    @Override
    public GetUserRecentRequestBuilder mode(GameMode mode) {
        parameters.put(PARAM_MODE, Preconditions.checkNotNull(mode, "mode must be not null. Use unsetMode() to unset mode.").getValue());

        return this;
    }

    @Override
    public GetUserRecentRequestBuilder unsetMode() {
        parameters.remove(PARAM_MODE);

        return this;
    }

    @Override
    public GetUserRecentRequestBuilder limit(int limit) {
        parameters.put(PARAM_LIMIT, limit);

        return this;
    }

    @Override
    public GetUserRecentRequestBuilder unsetLimit() {
        parameters.remove(PARAM_LIMIT);

        return this;
    }

    @Override
    public Collection<UserGame> query() {
        return execute(ENDPOINT, new TypeReference<Collection<UserGame>>() {
        });
    }
}
