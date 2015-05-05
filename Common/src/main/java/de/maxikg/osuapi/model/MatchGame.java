package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.maxikg.osuapi.jackson.OsuDateDeserializer;
import de.maxikg.osuapi.jackson.OsuDateSerializer;
import de.maxikg.osuapi.jackson.OsuModDeserializer;
import de.maxikg.osuapi.jackson.OsuModSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author maxikg
 */
@Data
public class MatchGame {

    @JsonProperty("game_id")
    private int gameId;

    @JsonProperty("start_time")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date startTime;

    @JsonProperty("end_time")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date endTime;

    @JsonProperty("beatmap_id")
    private int beatmapId;

    @JsonProperty("play_mode")
    private GameMode playMode;

    @JsonProperty("match_type")
    private int matchType;

    @JsonProperty("scoring_type")
    private WinningCondition scoringType;

    @JsonProperty("team_type")
    private TeamType teamType;

    @JsonProperty("mods")
    @JsonSerialize(using = OsuModSerializer.class)
    @JsonDeserialize(using = OsuModDeserializer.class)
    private Set<Mod> mods;

    @JsonProperty("scores")
    private List<MatchScore> scores;
}
