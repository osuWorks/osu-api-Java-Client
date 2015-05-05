package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Optional;
import de.maxikg.osuapi.utils.Valuable;
import de.maxikg.osuapi.utils.ValuableUtils;
import lombok.RequiredArgsConstructor;

/**
 * @author maxikg
 * @since 1.0
 */
@RequiredArgsConstructor
public enum Team implements Valuable<Integer> {

    UNSUPPORTED(0),
    BLUE(1),
    RED(2);

    private final Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Optional<Team> byValue(int value) {
        return ValuableUtils.getByValue(Team.class, value);
    }
}
