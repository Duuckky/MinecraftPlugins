package me.duck.dGuilds.API;

import me.duck.dGuilds.dGuilds;

import org.bukkit.entity.Player;

public class API {
	
	public dGuilds plugin;
	
	public API(dGuilds plugin) {
		this.plugin = plugin;
	}
	
	public static String successMessage(String message) { return "§2[dGuilds] §f" + message; } // success - green
	public static String warningMessage(String message) { return "§6[dGuilds] §f" + message; } // warning - gold
	public static String primaryMessage(String message) { return "§9[dGuilds] §f" + message; } // primary - blue
	public static String secondaryMessage(String message) { return "§d[dGuilds] §f" + message; } // secondary - pink
	public static String errorMessage(String message) { return "§c[dGuilds] §f" + message; } // error - red
	public static String defaultMessage(String message) { return "§3[dGuilds] §f" + message; } // default - teal

	public static String processMessage(String[] args) {
		StringBuilder msg = new StringBuilder();
		for(int i = 1; i < args.length; i++) {
			if(i > 1) {
				msg.append(" ");
			}
			msg.append(args[i]);
		}
		String msgchecked = msg.toString();
		return msgchecked;
	}
	
	public static void privateMessage(Player sender, Player recipient, String message) {
		recipient.sendMessage(API.primaryMessage("§2[From: " +  sender.getName() + "] §7--> §d[To: " + recipient.getName() + "]§f " + message));
		sender.sendMessage(successMessage("Sent message to §7" + recipient.getName()));
	}

	/*
	public static String chat(String message) {
		return
	}
	public static String getGuilds() {
		return
	}
	
	*/
	
	public void createGuild(Player leader, String guildName) {
		leader.sendMessage(API.primaryMessage("Creating guild " + guildName + "... "));
		// guild creation start
		
		if(!dGuilds.guilds.contains(guildName)) {

			dGuilds.guilds.add(guildName);
			plugin.getConfig().set("guilds." + guildName + ".leader", leader.getName());
			plugin.getConfig().set("guilds." + guildName + ".officer", null);
			plugin.getConfig().set("guilds." + guildName + ".members", null);
			leader.sendMessage(API.successMessage("Guild " + guildName + " successfully created.")); 
			return;
			
		} else {
			leader.sendMessage(API.errorMessage("Guild " + guildName + " failed to be created."));
			leader.sendMessage(API.errorMessage("That guild already exists."));
		}
		plugin.saveConfig();
		
		
		// guild creation end
	}
	
	public void deleteGuild(Player leader, String guildName) {
		leader.sendMessage(API.primaryMessage("Deleting guild " + guildName + "... "));
		// guild deletion start
		
		if(dGuilds.guilds.contains(guildName)) {
			if((plugin.getConfig().getString("guilds." + guildName + ".leader")).equalsIgnoreCase(leader.getName())) {
				dGuilds.guilds.remove(guildName);
				plugin.getConfig().set("guilds." + guildName, null);
			} else {
				leader.sendMessage(API.errorMessage("Guild " + guildName + " failed to be deleted."));
				leader.sendMessage(API.errorMessage("You are not the leader of this guild."));
			}
			
		} else {
			leader.sendMessage(API.errorMessage("Guild " + guildName + " failed to be deleted."));
			leader.sendMessage(API.errorMessage("That guild does not exist."));
		}
		 
		// guild deletion end
	}
	
	public void joinGuild(Player player, String guildName) {
		player.sendMessage(API.primaryMessage("Joining guild " + guildName + "... "));
		if(plugin.getConfig().contains(player.getName())) {
			player.sendMessage(API.errorMessage("Guild " + guildName + " failed to join."));
			player.sendMessage(API.errorMessage("You are already part of a guild."));
			player.sendMessage(API.errorMessage(" Please leave your current guild before joining another."));
		}
		plugin.getConfig().set("guilds." + guildName + ".member", player.getName());
	}
	
	/*
	
	public static void kickFromGuild() {
		
	}
	
	public static void inviteToGuild(Player player) {
		
	}
	*/
}
	
