package me.duck.dGuilds.API;

import org.bukkit.entity.Player;

public class API {
	
	public static String successMessage(String message) { return "§2[dGuilds] §f" + message; } // success - green
	public static String warningMessage(String message) { return "§6[dGuilds] §f" + message; } // warning - gold
	public static String primaryMessage(String message) { return "§9[dGuilds] §f" + message; } // primary - blue
	public static String secondaryMessage(String message) { return "§d[dGuilds] §f" + message; } // secondary - pink
	public static String errorMessage(String message) { return "§c[dGuilds] §f" + message; } // error - red
	public static String defaultMessage(String message) { return "§3[dGuilds] §f" + message; } // default - teal

	public static void processMessage(Player player, Player recipient, String[] args) {
		StringBuilder msg = new StringBuilder();
		for(int i = 1; i < args.length; i++) {
			if(i > 1) {
				msg.append(" ");
			}
			msg.append(args[i]);
		}
		String msgchecked = msg.toString();
		API.privateMessage(player, recipient, msgchecked);
	}
	
	public static void privateMessage(Player sender, Player recipient, String message) {
		recipient.sendMessage("§8 [From: " +  sender.getName() + "] --> [To: " + recipient.getName() + "]§f " + message);
		sender.sendMessage(successMessage("Sent message to §7" + recipient.getName()));
	}
	
	/*
	public static String mail(String message, String to) {
		return
	}
	
	public static String chat(String message) {
		return
	}
	*/
	
	/*
	public static String getGuilds() {
		return
	}
	
	public static String createGuild() {
		return
	}
	
	public static String deleteGuild() {
		return
	}
	
	public static String joinGuild() {
		return
	}
	
	public static void kickFromGuild() {
		
	}
	
	public static void inviteToGuild(Player player) {
		
	}
	*/
}
