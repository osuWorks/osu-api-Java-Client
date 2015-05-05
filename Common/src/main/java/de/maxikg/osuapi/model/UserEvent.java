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
public class UserEvent {

    @JsonProperty("display_html")
    private String displayHtml;

    @JsonProperty("beatmap_id")
    private int beatmapId;

    @JsonProperty("beatmapset_id")
    private int beatmapSetId;

    @JsonProperty("date")
    @JsonSerialize(using = OsuDateSerializer.class)
    @JsonDeserialize(using = OsuDateDeserializer.class)
    private Date date;

    @JsonProperty("epicfactor")
    private short epicFactor;
}
