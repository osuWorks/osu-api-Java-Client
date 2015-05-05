package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Serializes boolean values in a osu!api compliant way.
 *
 * @author maxikg
 * @since 1.0
 */
public class OsuBooleanSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(String.valueOf(value ? 1 : 0));
    }
}
