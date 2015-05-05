package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Optional;
import de.maxikg.osuapi.utils.Valuable;
import de.maxikg.osuapi.utils.ValuableUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Represents the approved state of a beatmap.
 *
 * @since 1.0
 * @author maxikg
 */
@RequiredArgsConstructor
public enum BeatmapState implements Valuable<Integer> {

    /**
     * The beatmap is qualified and temporary ranked. It waits for it's QAT (quality assurance team) approval.
     */
    QUALIFIED(3),

    /**
     * This beatmap is also ranked but longer than 05:00 minutes.
     */
    APPROVED(2),

    /**
     * The beatmap is now ranked permanently.
     */
    RANKED(1),

    /**
     * The beatmap is completed and awaits it's BAT (beatmap appreciation team) approval.
     */
    PENDING(0),

    /**
     * The beatmap is currently work in progress.
     */
    WORK_IN_PROGRESS(-1),

    /**
     * The beatmap is not ranked and marked as inactive.
     */
    GRAVEYARD(-2);

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
     * Returns the {@code BeatmapState} by it's number value.
     *
     * @param value The value.
     * @return An {@link Optional}. Absent if an unknown value was given.
     */
    @JsonCreator
    public static Optional<BeatmapState> byValue(int value) {
        return ValuableUtils.getByValue(BeatmapState.class, value);
    }
}
