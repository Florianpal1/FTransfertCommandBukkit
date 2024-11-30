package fr.florianpal.ftransfertcommand;

import fr.florianpal.ftransfertcommand.listeners.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public class FTransfertCommand extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "ftransfert:command", new ChatListener(this));
    }
}
