package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Deserializes boolean values in a osu!api compliant way.
 *
 * @author maxikg
 * @since 1.0
 */
public class OsuBooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        int value = Integer.parseInt(parser.getValueAsString());

        if (value == 0)
            return false;
        else if (value == 1)
            return true;
        else
            throw new JsonParseException("Invalid boolean value", parser.getCurrentLocation());
    }
}
