/*
 * Trident - A Multithreaded Server Alternative
 * Copyright 2016 The TridentSDK Team
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
package net.tridentsdk.base;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TridentSDK
 * @since 0.5-alpha
 */
public enum HorseType {

    HORSE(0),
    DONKEY(1),
    MULE(2),
    ZOMBIE(3),
    SKELETON(4);

    @Getter
    private final int data;

    HorseType(int data) {
        this.data = data;
    }

    private static final Map<Integer, HorseType> dataToType = new HashMap<>();

    static {
        for (HorseType type : values()) {
            dataToType.put(type.data, type);
        }
    }

    public static HorseType of(int data) {
        HorseType type = dataToType.get(data);
        if (type == null) {
            throw new IllegalArgumentException("no horse type with id = " + data);
        }
        return type;
    }

}
