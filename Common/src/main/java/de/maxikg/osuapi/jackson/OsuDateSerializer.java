package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.maxikg.osuapi.utils.DateUtils;

import java.io.IOException;
import java.util.Date;

/**
 * @author maxikg
 * @since 1.0
 */
public class OsuDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        if (value != null)
            generator.writeString(DateUtils.formatDate(value));
        else
            generator.writeNull();
    }
}
