package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author maxikg
 * @since 1.0
 */
@Data
public class Match {

    @JsonProperty("match")
    private MatchDetails details;

    @JsonProperty("games")
    private List<MatchGame> games;
}
