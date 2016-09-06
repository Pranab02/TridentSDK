package net.tridentsdk.ui.bossbar;

import net.tridentsdk.chat.ChatComponent;

import java.util.UUID;

/**
 * @author TridentSDK
 * @since 0.5-alpha
 */
public interface BossBar {

    /**
     * Gets this boss bar's unique ID.
     *
     * @return The unique ID.
     */
    UUID getUniqueId();

    /**
     * Gets the title of this boss bar.
     *
     * @return The title.
     */
    ChatComponent getTitle();

    /**
     * Sets the title of this boss bar.
     *
     * @param title The new title.
     */
    void setTitle(ChatComponent title);

    /**
     * Gets the boss bar's health.
     *
     * Between 0 and 1.
     *
     * @return The health.
     */
    float getHealth();

    /**
     * Sets this bar's health.
     *
     * Between 0 and 1 is considered normal,
     * values above 1.5 start rendering a second bar.
     *
     * @param health The new health.
     */
    void setHealth(float health);

    /**
     * Gets this boss bar's color.
     *
     * @return The color.
     */
    BossBarColor getColor();

    /**
     * Sets this boss bar's color.
     *
     * @param color The new color.
     */
    void setColor(BossBarColor color);

    /**
     * Gets this boss bar's division style.
     *
     * @return The division style.
     */
    BossBarDivision getDivision();

    /**
     * Sets this boss bar's division style.
     *
     * @param division The new division style.
     */
    void setDivision(BossBarDivision division);

    /**
     * Gets whether or not this boss bar darkens users' sky.
     *
     * @return True iff the sky is darkened.
     */
    boolean isDarkenSky();

    /**
     * Sets whether or not to darken the sky.
     *
     * @param darkenSky True to darken, false to not.
     */
    void setDarkenSky(boolean darkenSky);

    /**
     * Gets whether or not this boss bar is a dragon bar.
     *
     * Used by the client to play End music if true.
     *
     * @return True iff it is a dragon bar.
     */
    boolean isDragonBar();

    /**
     * Sets whether or not this bar is a dragon bar.
     *
     * @param dragonBar True to set as a dragon bar, false to not be.
     */
    void setDragonBar(boolean dragonBar);

    /**
     * Clones this boss bar.
     *
     * @return A cloned copy of this boss bar.
     */
    BossBar clone();

}
