package me.duck.dGuilds;

import me.duck.dGuilds.API.API;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class dGuilds extends JavaPlugin {	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(args.length == 2) {
			if(label.equalsIgnoreCase("dmessage")) {			
				API.privateMessage(player.getName(), args[0], args[1]);
			}
		}
		return false;
	}
}
