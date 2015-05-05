package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.User;
import org.apache.http.client.HttpClient;

import java.util.Collection;

/**
 * @author maxikg
 */
public class DefaultGetUserRequestBuilder extends AbstractRequestBuilder implements GetUserRequestBuilder {

    private static final String ENDPOINT = "get_user";
    private static final String PARAM_USER = "u";
    private static final String PARAM_USER_TYPE = "type";
    private static final String PARAM_MODE = "m";
    private static final String PARAM_EVENT_DAYS = "event_days";

    public DefaultGetUserRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, String username) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_USER, Preconditions.checkNotNull(username, "Required parameter username cannot be null."));
        parameters.put(PARAM_USER_TYPE, "string");
    }

    public DefaultGetUserRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, int id) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_USER, id);
        parameters.put(PARAM_USER_TYPE, "id");
    }

    @Override
    public GetUserRequestBuilder mode(GameMode mode) {
        parameters.put(PARAM_MODE, Preconditions.checkNotNull(mode, "mode must be not null. Use unsetMode() to unset mode.").getValue());

        return this;
    }

    @Override
    public GetUserRequestBuilder unsetMode() {
        parameters.remove(PARAM_MODE);

        return this;
    }

    @Override
    public GetUserRequestBuilder daysSinceLastEvent(int days) {
        parameters.put(PARAM_EVENT_DAYS, days);

        return this;
    }

    @Override
    public GetUserRequestBuilder unsetDaysSinceLastEvent() {
        parameters.remove(PARAM_EVENT_DAYS);

        return this;
    }

    @Override
    public Collection<User> query() {
        return execute(ENDPOINT, new TypeReference<Collection<User>>() {
        });
    }
}
