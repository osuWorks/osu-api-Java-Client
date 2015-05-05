package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Optional;
import de.maxikg.osuapi.utils.Valuable;
import de.maxikg.osuapi.utils.ValuableUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents the osu! game mode.
 *
 * @since 1.0
 * @author maxikg
 */
@RequiredArgsConstructor
public enum GameMode implements Valuable<Integer> {

    /**
     * It represents the default osu! game mode. See: https://osu.ppy.sh/wiki/Standard
     */
    STANDARD(0),

    /**
     * It represents the game mode on which you must hit the drum. See: https://osu.ppy.sh/wiki/Taiko
     */
    TAIKO(1),

    /**
     * It represents the game mode on which you must catch the falling fruits. See:
     * https://osu.ppy.sh/wiki/Catch_The_Beat
     */
    CTB(2),

    /**
     * It represents the game mode on which you must hit the right beat note in the right moment. See:
     * https://osu.ppy.sh/wiki/Osu!mania
     */
    OSU_MANIA(3);

    @NonNull
    private final Integer value;

    /**
     * {@inheritDoc}
     */
    @JsonValue
    public Integer getValue() {
        return value;
    }

    /**
     * Returns the {@code GameMode} by it's number value.
     *
     * @param value The value.
     * @return An {@link Optional}. Absent if an unknown value was given.
     */
    @JsonCreator
    public static Optional<GameMode> byValue(int value) {
        return ValuableUtils.getByValue(GameMode.class, value);
    }
}
