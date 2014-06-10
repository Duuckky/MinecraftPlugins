package me.duck.dGuilds.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class API {
	
	public static String successMessage(String message) { return "§2[dGuilds] §0" + message; } // success - green
	public static String warningMessage(String message) { return "§6[dGuilds] §0" + message; } // warning - gold
	public static String primaryMessage(String message) { return "§9[dGuilds] §0" + message; } // primary - blue
	public static String secondaryMessage(String message) { return "§d[dGuilds] §0" + message; } // secondary - pink
	public static String errorMessage(String message) { return "§c[dGuilds] §0" + message; } // error - red
	public static String defaultMessage(String message) { return "§3[dGuilds] §0" + message; } // default - teal

	@SuppressWarnings("deprecation")
	public static void privateMessage(String sender, String recipient, String message) {
		Player from = Bukkit.getPlayer(sender);
		Player to = Bukkit.getPlayer(recipient);
	
		to.sendMessage(primaryMessage("§8 [From: " +  from.getName() + "] --> [To: " + to.getName() + "]" + message));
		from.sendMessage(primaryMessage("§8 [From: " +  from.getName() + "] --> [To: " + to.getName() + "]" + message));
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
