package me.ryandw11.ultratitle.listeners;



import me.ryandw11.ultratitle.core.Main;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;



import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class OnJoin implements Listener {
	
	private Main plugin;
	public OnJoin(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		
		if(!plugin.names.contains(p.getUniqueId().toString())){
			plugin.names.set(p.getUniqueId().toString() + ".prefix", "");
			plugin.names.set(p.getUniqueId().toString() + ".suffix", "");
			plugin.saveFile();
		}
		String Prefix = plugin.names.getString(p.getUniqueId().toString() + ".prefix").replace("_", " ");
		String Suffix = plugin.names.getString(p.getUniqueId().toString() + ".suffix").replace("_", " ");
		
		

		if (p.hasPermission("ultratitle.darkblue") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&1" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.green") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&2" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.aqua") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&3" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.red") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&4" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.purple") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&5" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.gold") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&6" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.lightgray") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&7" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.gray") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&8" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.blue") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&9" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.lightgreen") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&a" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.pink") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&d" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.lightblue") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&b" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.lightred") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&c" + event.getPlayer().getName() + Suffix));
		}
		else if (p.hasPermission("ultratitle.yellow") && !(p.isOp())){
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&e" + event.getPlayer().getName() + Suffix));
		}
		else if(p.isOp()){
			if(plugin.getConfig().getString("Op_Tab_Color").equals("null")){
				event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&f" + event.getPlayer().getName() + Suffix));
			}else{
				event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + plugin.getConfig().getString("Op_Tab_Color") + event.getPlayer().getName() + Suffix));
			}
		}
		else{
			event.getPlayer().setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&f" + event.getPlayer().getName() + Suffix));
		}
		//Title Api
				//TitleAPI.sendTabTitle(p, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Tab_Header")), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Tab_Footer")));
		        //End of title api
	}
	
	
}
