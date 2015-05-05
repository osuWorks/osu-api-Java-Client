package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.maxikg.osuapi.jackson.OsuDateDeserializer;
import de.maxikg.osuapi.jackson.OsuDateSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @since 1.0
 * @author maxikg
 */
@Data
public class Beatmap {

    @JsonProperty("approved")
    private BeatmapState approved;

    @JsonProperty("approved_date")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date approvedDate;

    @JsonProperty("last_update")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date lastUpdate;

    @JsonProperty("artist")
    private String artist;

    @JsonProperty("beatmap_id")
    private int beatmapId;

    @JsonProperty("beatmapset_id")
    private int beatmapSetId;

    @JsonProperty("bpm")
    private float bpm;

    @JsonProperty("creator")
    private String creator;

    @JsonProperty("difficultyrating")
    private float difficultyRating;

    @JsonProperty("diff_size")
    private int difficultySize;

    @JsonProperty("diff_overall")
    private int difficultyOverall;

    @JsonProperty("diff_approach")
    private int difficultyApproach;

    @JsonProperty("diff_drain")
    private int difficultyDrain;

    @JsonProperty("hit_length")
    private int hitLength;

    @JsonProperty("source")
    private String source;

    @JsonProperty("title")
    private String title;

    @JsonProperty("total_length")
    private long totalLength;

    @JsonProperty("version")
    private String version;

    @JsonProperty("mode")
    private GameMode mode;
}
