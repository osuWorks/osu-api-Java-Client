package de.maxikg.osuapi.client.request.builder;

import de.maxikg.osuapi.model.Beatmap;
import de.maxikg.osuapi.model.GameMode;

import java.util.Collection;
import java.util.Date;

/**
 * @author maxikg
 */
public interface GetBeatmapsRequestBuilder extends RequestBuilder<Collection<Beatmap>> {

    GetBeatmapsRequestBuilder since(Date date);

    GetBeatmapsRequestBuilder unsetSince();

    GetBeatmapsRequestBuilder beatmapSetId(int id);

    GetBeatmapsRequestBuilder unsetBeatmapSetId();

    GetBeatmapsRequestBuilder beatmapId(int id);

    GetBeatmapsRequestBuilder unsetBeatmapId();

    GetBeatmapsRequestBuilder username(String username);

    GetBeatmapsRequestBuilder userId(int id);

    GetBeatmapsRequestBuilder unsetUser();

    GetBeatmapsRequestBuilder mode(GameMode mode);

    GetBeatmapsRequestBuilder unsetMode();

    GetBeatmapsRequestBuilder includeConverted();

    GetBeatmapsRequestBuilder excludeConverted();

    GetBeatmapsRequestBuilder limit(int limit);

    GetBeatmapsRequestBuilder unsetLimit();
}
