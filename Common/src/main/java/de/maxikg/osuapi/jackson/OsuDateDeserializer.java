package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.maxikg.osuapi.utils.DateUtils;

import java.io.IOException;
import java.util.Date;

/**
 * @author maxikg
 * @since 1.0
 */
public class OsuDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getValueAsString();

        return value != null ? DateUtils.parseDate(value) : null;
    }
}
