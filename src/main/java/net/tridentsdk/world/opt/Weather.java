/*
 * Trident - A Multithreaded Server Alternative
 * Copyright 2017 The TridentSDK Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.tridentsdk.world.opt;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Allows access to the world's current weather state such
 * as rain, thunder, and sun time.
 *
 * <p>The terminology used in this class may be confusing
 * to some, as it is difficult to understand what happens
 * if clear weather and rain are both toggled. In order to
 * clear up (no pun intended) any confusion, this is how
 * weather in the world will work:</p>
 * <ul>
 *     <li>When a time "resets" it means that the time has
 *     reached {@code 0} and will be set to a random time
 *     (in jurisdiction of the implementation)</li>
 *     <li>Thundering is a special case because it may only
 *     happen if the weather is raining as well. However, if
 *     raining is toggled, then thundering is also toggled
 *     as well, with the effect that {@link #getThunderTime()}
 *     has reached {@code 0} and is reset. Thunder time will
 *     be reset without any weather effect if it is not
 *     raining.</li>
 *     <li>Setting the weather using
 *     {@code #beginXYZ()} has no effect on the toggle
 *     times. It will simply cause the weather state to be
 *     toggled <em>as if</em> the time has reached
 *     {@code 0}, but this time is not reset.</li>
 *     <li>Anytime that {@link #RANDOM_TIME} is passed to
 *     the {@code setXYZTime(int)} methods, the time should
 *     be reset to a random value.</li>
 *     <li>The time until weather state is toggled is never
 *     negative, and a negative value will have the effect
 *     of resetting the time (although it may not always be
 *     the case, unless {@link #RANDOM_TIME} is passed).</li>
 *     <li>Clear weather is defined as the state of the
 *     weather NOT raining AND NOT thundering.</li>
 * </ul>
 *
 * <p>Summary for non-implementation developers: if is clear
 * and {@link #getRainTime()} reaches {@code 0}, nothing
 * happens. It will only rain if clear weather is toggled.
 *
 * If it is raining and clear weather is toggled, then
 * nothing happens. It will only be clear weather once rain
 * is toggled.
 *
 * If thundering is toggled, then it must also be raining in
 * order for it to happen. Otherwise, nothing happens. If it
 * is thundering and it stops raining, then both thundering
 * and raining stops as well.</p>
 *
 * @author TridentSDK
 * @since 0.4-alpha
 */
@ThreadSafe
public interface Weather {
    /**
     * Specifier passed to any method taking time to
     * set the time to a random value. The implementation
     * is free to ignore this if it likes, however it is
     * strongly discouraged.
     */
    int RANDOM_TIME = -1;

    /**
     * Causes the weather to cease raining and thundering.
     */
    void clear();

    /**
     * Begins raining.
     */
    void beginRaining();

    /**
     * Begins thundering, if it is currently raining.
     * Otherwise has no effect.
     */
    void beginThunder();

    /**
     * Ceases thundering.
     */
    void stopThunder();

    /**
     * Whether or not the weather is currently raining in
     * the world
     *
     * @return {@code true} if it is raining, {@code false}
     *         if it is not
     */
    boolean isRaining();

    /**
     * Obtains the amount of ticks until the weather will be
     * toggled to or from raining, and the time will be
     * reset.
     *
     * @return the ticks until raining is toggled
     */
    int getRainTime();

    /**
     * Sets the amount of ticks until raining is toggled in
     * the world.
     *
     * @param ticks the amount of ticks
     */
    void setRainTime(int ticks);

    /**
     * Checks if the world is currently cloudy and
     * thundering.
     *
     * @return {@code true} if it is thundering,
     *         {@code false} otherwise
     */
    boolean isThundering();

    /**
     * Obtains the amount of ticks until the weather will
     * be toggled to or from thundering and this time will
     * be reset.
     *
     * @return the amount of ticks until it is toggled
     */
    int getThunderTime();

    /**
     * Sets the amount of ticks until thundering is toggled
     * in the world.
     *
     * @param ticks the amount of ticks
     */
    void setThunderTime(int ticks);

    /**
     * Obtains if the weather is currently clear.
     *
     * @return {@code true} if the weather is clear,
     *         {@code false} if it isn't
     */
    boolean isClear();

    /**
     * Obtains the amount of ticks until clear weather is
     * toggled to or from clear weather and this time will
     * be reset.
     *
     * @return the amount of ticks until it is toggled
     */
    int getClearTime();

    /**
     * Sets the amount of ticks until clear weather is
     * toggled in the world.
     *
     * @param ticks the amount of ticks
     */
    void setClearTime(int ticks);
}