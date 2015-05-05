package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import de.maxikg.osuapi.model.Beatmap;
import de.maxikg.osuapi.model.GameMode;
import org.apache.http.client.HttpClient;

import java.util.Collection;
import java.util.Date;

/**
 * @author maxikg
 */
public class DefaultGetBeatmapsRequestBuilder extends AbstractRequestBuilder implements GetBeatmapsRequestBuilder {

    private static final String ENDPOINT = "get_beatmaps";
    private static final String PARAM_SINCE = "since";
    private static final String PARAM_BEATMAP_SET_ID = "s";
    private static final String PARAM_BEATMAP_ID = "b";
    private static final String PARAM_USER = "u";
    private static final String PARAM_USER_TYPE = "type";
    private static final String PARAM_MODE = "m";
    private static final String PARAM_INCLUDE_CONVERTED = "a";
    private static final String PARAM_LIMIT = "limit";

    public DefaultGetBeatmapsRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey) {
        super(objectMapper, client, baseUrl, apiKey);
    }

    @Override
    public GetBeatmapsRequestBuilder since(Date date) {
        parameters.put(PARAM_SINCE, Preconditions.checkNotNull(date, "date must be not null. Use unsetSince() to unset since."));

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder unsetSince() {
        parameters.remove(PARAM_SINCE);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder beatmapSetId(int id) {
        parameters.put(PARAM_BEATMAP_SET_ID, id);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder unsetBeatmapSetId() {
        parameters.remove(PARAM_BEATMAP_SET_ID);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder beatmapId(int id) {
        parameters.put(PARAM_BEATMAP_ID, id);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder unsetBeatmapId() {
        parameters.remove(PARAM_BEATMAP_ID);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder username(String username) {
        parameters.put(PARAM_USER, Preconditions.checkNotNull(username, "username must be not null. Use unsetUser() to unset user."));
        parameters.put(PARAM_USER_TYPE, "string");

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder userId(int id) {
        parameters.put(PARAM_USER, id);
        parameters.put(PARAM_USER_TYPE, "id");

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder unsetUser() {
        parameters.remove(PARAM_USER);
        parameters.remove(PARAM_USER_TYPE);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder mode(GameMode mode) {
        parameters.put(PARAM_MODE, Preconditions.checkNotNull(mode, "mode must be not null. Use unsetMode() to unset mode.").getValue());

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder unsetMode() {
        parameters.remove(PARAM_MODE);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder includeConverted() {
        parameters.put(PARAM_INCLUDE_CONVERTED, 1);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder excludeConverted() {
        parameters.remove(PARAM_INCLUDE_CONVERTED);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder limit(int limit) {
        parameters.put(PARAM_LIMIT, limit);

        return this;
    }

    @Override
    public GetBeatmapsRequestBuilder unsetLimit() {
        parameters.remove(PARAM_LIMIT);

        return this;
    }

    @Override
    public Collection<Beatmap> query() {
        return execute(ENDPOINT, new TypeReference<Collection<Beatmap>>() {
        });
    }
}
