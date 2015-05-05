package de.maxikg.osuapi.client;

import de.maxikg.osuapi.client.request.builder.*;

/**
 * @author maxikg
 */
public interface OsuClient {

    GetBeatmapsRequestBuilder getBeatmaps();

    GetUserRequestBuilder getUserByUsername(String username);

    GetUserRequestBuilder getUserById(int id);

    GetScoresRequestBuilder getScores(int beatmapId);

    GetUserBestRequestBuilder getUserBestByUsername(String username);

    GetUserBestRequestBuilder getUserBestById(int id);

    GetUserRecentRequestBuilder getUserRecentByUsername(String username);

    GetUserRecentRequestBuilder getUserRecentById(int id);

    GetMatchRequestBuilder getMatch(int id);
}
