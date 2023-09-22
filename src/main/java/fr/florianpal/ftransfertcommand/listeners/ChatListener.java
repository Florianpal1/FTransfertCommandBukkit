/*
 * Copyright (C) 2022 Florianpal
 *
 * This program is free software;
 * you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses/>.
 *
 * Last modification : 12/01/2022 17:42
 *
 *  @author Florianpal.
 */

package fr.florianpal.ftransfertcommand.listeners;


import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import fr.florianpal.ftransfertcommand.FTransfertCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class ChatListener implements Listener, PluginMessageListener {

    private final FTransfertCommand plugin;
    public ChatListener(FTransfertCommand plugin) {
        this.plugin = plugin;

    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

        if (channel.equalsIgnoreCase("ftransfert:command")) {

            ByteArrayDataInput in = ByteStreams.newDataInput(message);
            String subchannel = in.readUTF();

            if (subchannel.equalsIgnoreCase("command")) {
                String command = in.readUTF();
                plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
            }
        }
    }
}
