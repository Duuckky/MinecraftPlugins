package me.duck.dPlugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class dHats extends JavaPlugin {	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(args.length == 1) {
			if(label.equalsIgnoreCase("sethat")) {			
				try {
					ItemStack h = player.getInventory().getHelmet();
					if(h != null) {
						player.getInventory().addItem(h);
					}
				} catch (NullPointerException e) {
					
				}
				player.getInventory().setHelmet(new ItemStack(Material.getMaterial(args[0])));
			}
		}
		return false;
	}
}
