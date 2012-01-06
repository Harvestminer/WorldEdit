/*
 * WorldEdit
 * Copyright (C) 2012 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.spout;

import org.bukkit.Bukkit;
import org.getspout.api.command.CommandException;
import org.getspout.api.command.CommandSource;
import org.getspout.api.command.RawCommandExecutor;
import org.getspout.api.util.MiscCompatibilityUtils;

/**
 * @author zml2008
 */
public class SpoutRawCommandExecutor implements RawCommandExecutor {

    private final WorldEditPlugin plugin;

    public SpoutRawCommandExecutor(WorldEditPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSource source, String[] args, int baseIndex, boolean fuzzyLookup) throws CommandException {
        Bukkit.getServer().getCommandAliases();
        args[baseIndex] = "/" + args[baseIndex];
        if (!plugin.getWorldEdit().handleCommand(plugin.wrapCommandSender(source), MiscCompatibilityUtils.arrayCopyOfRange(args, baseIndex, args.length))) {
            throw new CommandException("Unknown command: '" + args[baseIndex] + "'!");
        }
    }
}