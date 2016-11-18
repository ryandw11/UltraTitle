package me.ryandw11.ultratitle.commands;

import me.ryandw11.ultratitle.core.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commande implements CommandExecutor {

	private Main plugin;
	public Commande(Main plugin){
		this.plugin = plugin;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		Player p = (Player) sender;
		if(p.getGameMode() == GameMode.SPECTATOR){
			p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Spectator_Color")));
		}
		
		
		return false;

}
}
