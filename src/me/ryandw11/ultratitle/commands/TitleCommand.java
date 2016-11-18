package me.ryandw11.ultratitle.commands;




import me.ryandw11.ultratitle.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TitleCommand implements CommandExecutor {

	private Main plugin;
	public TitleCommand(Main plugin){
		this.plugin = plugin;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		if(!(sender instanceof Player)) return true;
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("title")){
			if(args.length == 0){
				p.sendMessage(ChatColor.RED + "-------------------=[" + ChatColor.WHITE + "Utlra Title" + ChatColor.RED + "]=-------------------");
				p.sendMessage("/title prefix {user} {preifx}" + ChatColor.RED + " - Changed a users tab prefix.");
				p.sendMessage("/title suffix {user} {suffix}" + ChatColor.RED + " - Changed a users tab suffix.");
				p.sendMessage(ChatColor.RED + "Plugin made by: " + ChatColor.WHITE + "Ryandw11" + ChatColor.RED + "! Version: " + ChatColor.WHITE + "1.0" + ChatColor.RED + ".");
				p.sendMessage(ChatColor.RED + "---------------------------------------------------");
			}
			
			else if(args.length == 3 && args[0].equalsIgnoreCase("prefix")){
				if(p.hasPermission("ultratitle.prefix")){
					Player getPlayer = Bukkit.getServer().getPlayer(args[1]);
					if(getPlayer instanceof Player){
						p.sendMessage(ChatColor.GREEN + getPlayer.getDisplayName() + ChatColor.YELLOW + " tab prefix has been changed to: " + ChatColor.translateAlternateColorCodes('&', args[2]));
						plugin.names.set(getPlayer.getUniqueId().toString() + ".prefix", args[2]);
						plugin.saveFile();
						
						
						String Prefix = plugin.names.getString(getPlayer.getUniqueId().toString() + ".prefix").replace("_", " ");
						String Suffix = plugin.names.getString(getPlayer.getUniqueId().toString() + ".suffix").replace("_", " ");
						
						
						
						
						if (p.hasPermission("ultratitle.darkblue") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&1" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.green") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&2" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.aqua") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&3" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.red") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&4" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.purple") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&5" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.gold") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&6" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightgray") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&7" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.gray") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&8" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.blue") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&9" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightgreen") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&a" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.pink") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&d" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightblue") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&b" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightred") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&c" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.yellow") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&e" + getPlayer.getName() + Suffix));
						}
						else if(p.isOp()){
							if(plugin.getConfig().getString("Op_Tab_Color").equals("null")){
								getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&f" + getPlayer.getName() + Suffix));
							}else{
								getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + plugin.getConfig().getString("Op_Tab_Color") + getPlayer.getName() + Suffix));
							}
						}
						else{
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&f" + getPlayer.getName() + Suffix));
						}
						
						
					}else{
						p.sendMessage(ChatColor.RED + "That is not a player!");
					}
				}
			}
			else if(args.length == 1 && args[0].equalsIgnoreCase("prefix")){
				if(p.hasPermission("ultratitle.prefix")){
					p.sendMessage(ChatColor.RED + "Invalid Usage. Correct usage: /title prefix {user} {prefix}");
				}
			}
			else if(args.length == 2 && args[0].equalsIgnoreCase("prefix")){
				if(p.hasPermission("ultratitle.prefix")){
					p.sendMessage(ChatColor.RED + "Invalid Usage. Correct usage: /title prefix {user} {prefix}");
				}
			}
			else if(args.length == 3 && args[0].equalsIgnoreCase("suffix")){
				if(p.hasPermission("ultratitle.suffix")){
					Player getPlayer = Bukkit.getServer().getPlayer(args[1]);
					if(getPlayer instanceof Player){
						p.sendMessage(ChatColor.GREEN + getPlayer.getDisplayName() + ChatColor.YELLOW + " tab prefix has been changed to: " + ChatColor.translateAlternateColorCodes('&', args[2]));

						plugin.names.set(getPlayer.getUniqueId().toString() + ".suffix", args[2]);
						plugin.saveFile();
						
						String Prefix = plugin.names.getString(getPlayer.getUniqueId().toString() + ".prefix").replace("_", " ");
						String Suffix = plugin.names.getString(getPlayer.getUniqueId().toString() + ".suffix").replace("_", " ");
						
						if (p.hasPermission("ultratitle.darkblue") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&1" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.green") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&2" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.aqua") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&3" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.red") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&4" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.purple") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&5" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.gold") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&6" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightgray") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&7" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.gray") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&8" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.blue") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&9" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightgreen") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&a" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.pink") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&d" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightblue") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&b" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.lightred") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&c" + getPlayer.getName() + Suffix));
						}
						else if (p.hasPermission("ultratitle.yellow") && !(p.isOp())){
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&e" + getPlayer.getName() + Suffix));
						}
						else if(p.isOp()){
							if(plugin.getConfig().getString("Op_Tab_Color").equals("null")){
								getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&f" + getPlayer.getName() + Suffix));
								
							}else{
								getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + plugin.getConfig().getString("Op_Tab_Color") + getPlayer.getName() + Suffix));
								
							}
						}
						else{
							getPlayer.setPlayerListName(ChatColor.translateAlternateColorCodes('&', Prefix + "&f" + getPlayer.getName() + Suffix));
						}
						
						
					}else{
						p.sendMessage(ChatColor.RED + "That player is not online!");
					}
				}
			}
			else if(args.length == 1 && args[0].equalsIgnoreCase("suffix")){
				if(p.hasPermission("ultratitle.suffix")){
					p.sendMessage(ChatColor.RED + "Invalid Usage. Correct usage: /title suffix {user} {suffix}");
				}
			}
			else if(args.length == 2 && args[0].equalsIgnoreCase("suffix")){
				if(p.hasPermission("ultratitle.suffix")){
					p.sendMessage(ChatColor.RED + "Invalid Usage. Correct usage: /title prefix {user} {suffix}");
				}
			}
			
			
			
			
		}
		return false;
	}

}
