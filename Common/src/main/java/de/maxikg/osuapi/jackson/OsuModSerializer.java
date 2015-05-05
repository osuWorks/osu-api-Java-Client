package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.maxikg.osuapi.model.Mod;

import java.io.IOException;
import java.util.Set;

/**
 * @author maxikg
 */
public class OsuModSerializer extends JsonSerializer<Set<Mod>> {

    @Override
    public void serialize(Set<Mod> value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(String.valueOf(Mod.createSum(value)));
    }
}
