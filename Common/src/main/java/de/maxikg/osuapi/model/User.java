package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Locale;

/**
 * @since 1.0
 * @author maxikg
 */
@Data
public class User {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("count300")
    private int count300;

    @JsonProperty("count100")
    private int count100;

    @JsonProperty("count50")
    private int count50;

    @JsonProperty("playcount")
    private int playCount;

    @JsonProperty("ranked_score")
    private long rankedScore;

    @JsonProperty("total_score")
    private long totalScore;

    @JsonProperty("pp_rank")
    private int ppRank;

    @JsonProperty("level")
    private float level;

    @JsonProperty("pp_raw")
    private int ppRaw;

    @JsonProperty("accuracy")
    private float accuracy;

    @JsonProperty("count_rank_ss")
    private int countRankSs;

    @JsonProperty("count_rank_s")
    private int countRankS;

    @JsonProperty("count_rank_a")
    private int countRankA;

    @JsonProperty("country")
    private Locale country;

    @JsonProperty("events")
    private List<UserEvent> events;
}
