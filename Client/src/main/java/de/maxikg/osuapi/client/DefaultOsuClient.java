package de.maxikg.osuapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import de.maxikg.osuapi.client.request.builder.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author maxikg
 */
@RequiredArgsConstructor
public class DefaultOsuClient implements CloseableOsuClient {

    private static final String DEFAULT_OSU_API_ENDPOINT = "https://osu.ppy.sh/api/";

    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    @NonNull private final String baseUrl;
    @NonNull private final String apiKey;

    public DefaultOsuClient(String apiKey) {
        this(DEFAULT_OSU_API_ENDPOINT, apiKey);
    }

    @Override
    public GetBeatmapsRequestBuilder getBeatmaps() {
        return new DefaultGetBeatmapsRequestBuilder(objectMapper, httpClient, baseUrl, apiKey);
    }

    @Override
    public GetUserRequestBuilder getUserByUsername(String username) {
        return new DefaultGetUserRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, username);
    }

    @Override
    public GetUserRequestBuilder getUserById(int userId) {
        return new DefaultGetUserRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, userId);
    }

    @Override
    public GetScoresRequestBuilder getScores(int beatmapId) {
        return new DefaultGetScoresRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, beatmapId);
    }

    @Override
    public GetUserBestRequestBuilder getUserBestByUsername(String username) {
        return new DefaultGetUserBestRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, username);
    }

    @Override
    public GetUserBestRequestBuilder getUserBestById(int id) {
        return new DefaultGetUserBestRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, id);
    }

    @Override
    public GetUserRecentRequestBuilder getUserRecentByUsername(String username) {
        return new DefaultGetUserRecentRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, username);
    }

    @Override
    public GetUserRecentRequestBuilder getUserRecentById(int id) {
        return new DefaultGetUserRecentRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, id);
    }

    @Override
    public GetMatchRequestBuilder getMatch(int id) {
        return new DefaultGetMatchRequestBuilder(objectMapper, httpClient, baseUrl, apiKey, id);
    }

    @Override
    public void close() {
        try {
            httpClient.close();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
