package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.maxikg.osuapi.jackson.OsuBooleanDeserializer;
import de.maxikg.osuapi.jackson.OsuBooleanSerializer;
import lombok.Data;

/**
 * @author maxikg
 * @since 1.0
 */
@Data
public class MatchScore {

    @JsonProperty("slot")
    private int slot;

    @JsonProperty("team")
    private Team team;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("score")
    private int score;

    @JsonProperty("maxcombo")
    private int maxCombo;

    @JsonProperty("rank")
    @Deprecated
    private int rank;

    @JsonProperty("count50")
    private int count50;

    @JsonProperty("count100")
    private int count100;

    @JsonProperty("count300")
    private int count300;

    @JsonProperty("countmiss")
    private int countMiss;

    @JsonProperty("countgeki")
    private int countGeki;

    @JsonProperty("countkatu")
    private int countKatu;

    @JsonProperty("perfect")
    @JsonSerialize(using = OsuBooleanSerializer.class)
    @JsonDeserialize(using = OsuBooleanDeserializer.class)
    private boolean perfect;

    @JsonProperty("pass")
    @JsonSerialize(using = OsuBooleanSerializer.class)
    @JsonDeserialize(using = OsuBooleanDeserializer.class)
    private boolean pass;
}
