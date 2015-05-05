package de.maxikg.osuapi.client.request.builder;

import de.maxikg.osuapi.model.BeatmapScore;
import de.maxikg.osuapi.model.GameMode;

import java.util.Collection;

/**
 * @author maxikg
 */
public interface GetScoresRequestBuilder extends RequestBuilder<Collection<BeatmapScore>> {

    GetScoresRequestBuilder username(String username);

    GetScoresRequestBuilder userId(int id);

    GetScoresRequestBuilder unsetUser();

    GetScoresRequestBuilder mode(GameMode mode);

    GetScoresRequestBuilder unsetMode();
}
