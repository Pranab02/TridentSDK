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
package net.tridentsdk.command.constraint;

import net.tridentsdk.command.Command;
import net.tridentsdk.command.CommandSource;
import net.tridentsdk.ui.chat.ChatColor;
import net.tridentsdk.ui.chat.ChatComponent;

import javax.annotation.concurrent.Immutable;

/**
 * Maximum args constraint. Any number of args above the
 * constraint results in displaying the help message.
 *
 * <p>Must use an integer constraint.</p>
 *
 * @author TridentSDK
 * @since 0.5-alpha
 */
@Immutable
public class MaxArgsConstraint implements Constraint {
    @Override
    public boolean handle(Command command, String label, CommandSource source, String[] args, Object constraint) {
        if (!(constraint instanceof Integer)) {
            throw new IllegalArgumentException("MaxArgsConstraint does not have the correct constraint arg");
        }

        int i = (int) constraint;

        if (args.length > i) {
            source.sendMessage(ChatComponent.create().setColor(ChatColor.RED).setText("Usage: " + getHelp(command)));
            return false;
        }

        return true;
    }
}