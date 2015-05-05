package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import de.maxikg.osuapi.model.BeatmapScore;
import de.maxikg.osuapi.model.GameMode;
import org.apache.http.client.HttpClient;

import java.util.Collection;

/**
 * @author maxikg
 */
public class DefaultGetScoresRequestBuilder extends AbstractRequestBuilder implements GetScoresRequestBuilder {

    private static final String ENDPOINT = "get_scores";
    private static final String PARAM_BEATMAP_ID = "b";
    private static final String PARAM_USER = "u";
    private static final String PARAM_USER_TYPE = "type";
    private static final String PARAM_MODE = "m";

    public DefaultGetScoresRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, int beatmapId) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_BEATMAP_ID, beatmapId);
    }

    @Override
    public GetScoresRequestBuilder username(String username) {
        parameters.put(PARAM_USER, Preconditions.checkNotNull(username, "username must be not null. Use unsetUser() to unset user."));
        parameters.put(PARAM_USER_TYPE, "string");

        return this;
    }

    @Override
    public GetScoresRequestBuilder userId(int id) {
        parameters.put(PARAM_USER, id);
        parameters.put(PARAM_USER_TYPE, "id");

        return this;
    }

    @Override
    public GetScoresRequestBuilder unsetUser() {
        parameters.remove(PARAM_USER);
        parameters.remove(PARAM_USER_TYPE);

        return this;
    }

    @Override
    public GetScoresRequestBuilder mode(GameMode mode) {
        parameters.put(PARAM_MODE, Preconditions.checkNotNull(mode, "mode must be not null. Use unsetMode() to unset mode.").getValue());

        return this;
    }

    @Override
    public GetScoresRequestBuilder unsetMode() {
        parameters.remove(PARAM_MODE);

        return this;
    }

    @Override
    public Collection<BeatmapScore> query() {
        return execute(ENDPOINT, new TypeReference<Collection<BeatmapScore>>() {
        });
    }
}
