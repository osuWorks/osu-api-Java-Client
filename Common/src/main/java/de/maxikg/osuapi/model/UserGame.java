package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.maxikg.osuapi.jackson.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @since 1.0
 * @author maxikg
 */
@Data
public class UserGame {

    @JsonProperty("beatmap_id")
    private int beatmapId;

    @JsonProperty("score")
    private int score;

    @JsonProperty("maxcombo")
    private int maxCombo;

    @JsonProperty("count300")
    private int count300;

    @JsonProperty("count100")
    private int count100;

    @JsonProperty("count50")
    private int count50;

    @JsonProperty("countmiss")
    private int countMiss;

    @JsonProperty("countkatu")
    private int countKatu;

    @JsonProperty("countgeki")
    private int countGeki;

    @JsonProperty("perfect")
    @JsonSerialize(using = OsuBooleanSerializer.class)
    @JsonDeserialize(using = OsuBooleanDeserializer.class)
    private boolean perfect;

    @JsonProperty("enabled_mods")
    @JsonSerialize(using = OsuModSerializer.class)
    @JsonDeserialize(using = OsuModDeserializer.class)
    private Set<Mod> enabledMods;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("date")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date date;

    @JsonProperty("rank")
    private String rank;
}
