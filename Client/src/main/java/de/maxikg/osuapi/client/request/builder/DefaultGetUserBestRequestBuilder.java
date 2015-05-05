package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.UserScore;
import org.apache.http.client.HttpClient;

import java.util.Collection;

/**
 * @author maxikg
 */
public class DefaultGetUserBestRequestBuilder extends AbstractRequestBuilder implements GetUserBestRequestBuilder {

    private static final String ENDPOINT = "get_user_best";
    private static final String PARAM_USER = "u";
    private static final String PARAM_USER_TYPE = "type";
    private static final String PARAM_MODE = "m";
    private static final String PARAM_LIMIT = "limit";

    public DefaultGetUserBestRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, int userId) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_USER, userId);
        parameters.put(PARAM_USER_TYPE, "id");
    }

    public DefaultGetUserBestRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, String username) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_USER, Preconditions.checkNotNull(username, "Required parameter username cannot be null."));
        parameters.put(PARAM_USER_TYPE, "string");
    }

    @Override
    public GetUserBestRequestBuilder mode(GameMode mode) {
        parameters.put(PARAM_MODE, Preconditions.checkNotNull(mode, "mode must be not null. Use unsetMode() to unset mode.").getValue());

        return this;
    }

    @Override
    public GetUserBestRequestBuilder unsetMode() {
        parameters.remove(PARAM_MODE);

        return this;
    }

    @Override
    public GetUserBestRequestBuilder limit(int limit) {
        parameters.put(PARAM_LIMIT, limit);

        return this;
    }

    @Override
    public GetUserBestRequestBuilder unsetLimit() {
        parameters.remove(PARAM_LIMIT);

        return this;
    }

    @Override
    public Collection<UserScore> query() {
        return execute(ENDPOINT, new TypeReference<Collection<UserScore>>() {
        });
    }
}
