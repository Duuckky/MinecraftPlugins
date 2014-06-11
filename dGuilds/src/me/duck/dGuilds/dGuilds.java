package me.duck.dGuilds;

import java.util.ArrayList;
import java.util.Set;

import me.duck.dGuilds.API.API;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class dGuilds extends JavaPlugin {
	
	public static ArrayList<String> guilds = new ArrayList<>();
	
	public void loadConfiguration() {
		// See "Creates defaults"
		getConfig().addDefault("guilds", "null");
		getConfig().options().copyDefaults(true);
		
		Set<String> keys = getConfig().getConfigurationSection("guilds").getKeys(false);
		guilds.addAll(keys);
		
		//Save the config
		saveConfig();
	}
	
	public void onEnable() {
		System.out.println("[dGuilds] Loading configuration files...");
		loadConfiguration();
		System.out.println("[dGuilds] Successfully loaded configuration files!");
	}
		
	public void onDisable() {
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		API api = new API(this);
		Player player = (Player) sender;
		
		if(args.length == 1){
			if(label.equalsIgnoreCase("dcreate")) {
				
				api.createGuild(player, args[0]);
				
				for (int i = 0;  i < guilds.size(); i++) {
					player.sendMessage(guilds.get(i));
				}
				return true;
			} else if (label.equalsIgnoreCase("ddelete")) {
				api.deleteGuild(player, args[0]);
			}
		} else if(args.length >= 2) {
			if((label.equalsIgnoreCase("dmessage")) || (label.equalsIgnoreCase("dpm"))) {		
				
				@SuppressWarnings("deprecation")
				Player recipient = Bukkit.getPlayer(args[0]);
				
				if(recipient == null) {
				    player.sendMessage(API.errorMessage("That player is offline, or does not exist!"));
				    return true;
				} else {
					API.privateMessage(player, recipient, API.processMessage(args));
					return true;
				}
			}
		}
		return false;
	}
}
