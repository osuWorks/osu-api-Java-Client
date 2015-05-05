package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import de.maxikg.osuapi.model.Mod;

import java.io.IOException;
import java.util.Set;

/**
 * @author maxikg
 */
public class OsuModDeserializer extends JsonDeserializer<Set<Mod>> {

    @Override
    public Set<Mod> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return Mod.parseFlagSum(Integer.parseInt(parser.getText()));
    }
}
