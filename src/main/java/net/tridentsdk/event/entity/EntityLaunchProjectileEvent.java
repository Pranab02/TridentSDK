/*
 * Trident - A Multithreaded Server Alternative
 * Copyright 2014 The TridentSDK Team
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

package net.tridentsdk.event.entity;

import net.tridentsdk.entity.Entity;
import net.tridentsdk.entity.Projectile;

/**
 * Called when an entity launches a projectile
 *
 * @author The TridentSDK Team
 * @since 0.3-alpha-DP
 */
public class EntityLaunchProjectileEvent extends EntityEvent {
    private final Projectile projectile;
    private final Entity target;
    private boolean cancelled;

    public EntityLaunchProjectileEvent(Entity entity, Projectile projectile, Entity target) {

        super(entity);
        this.projectile = projectile;
        this.target = target;
    }

    public Projectile projectile() {
        return this.projectile;
    }

    @Override
    public boolean isIgnored() {
        return cancelled;
    }

    @Override
    public void cancel(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Gets the Entity the skeleton was targeting when it fired
     */
    public Entity getTarget() {
        return this.target;
    }
}