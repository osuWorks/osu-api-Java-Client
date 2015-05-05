package de.maxikg.osuapi.utils;

/**
 * Helper class for unique identifiable values.
 *
 * @since 1.0
 * @author maxikg
 */
public interface Valuable<T> {

    /**
     * Returns the representative and unique value.
     *
     * @return The value
     */
    T getValue();
}
