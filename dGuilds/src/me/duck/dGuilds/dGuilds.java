package me.duck.dGuilds;

import me.duck.dGuilds.API.API;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class dGuilds extends JavaPlugin {	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(args.length >= 2) {
			if((label.equalsIgnoreCase("dmessage")) || (label.equalsIgnoreCase("dm"))) {		
				
				@SuppressWarnings("deprecation")
				Player recipient = Bukkit.getPlayer(args[0]);
				
				if (recipient == null) {
				    player.sendMessage(API.errorMessage("That player is offline, or does not exist!"));
				    return true;
				} else {
					API.processMessage(player, recipient, args);
					return true;
				}
			}
		}
		return false;
	}
}
