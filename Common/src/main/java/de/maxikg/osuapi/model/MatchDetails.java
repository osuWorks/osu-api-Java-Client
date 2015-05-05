package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.maxikg.osuapi.jackson.OsuDateDeserializer;
import de.maxikg.osuapi.jackson.OsuDateSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @author maxikg
 * @since 1.0
 */
@Data
public class MatchDetails {

    @JsonProperty("match_id")
    private int matchId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("start_time")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date startTime;

    @JsonProperty("end_time")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    @Deprecated
    private Date endTime;
}
