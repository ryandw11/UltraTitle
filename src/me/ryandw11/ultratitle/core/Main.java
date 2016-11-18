package me.ryandw11.ultratitle.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;










import me.ryandw11.ultratitle.commands.TitleCommand;
import me.ryandw11.ultratitle.listeners.OnJoin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	
	
		
		public final Logger logger = Logger.getLogger("Minecraft");
		public Main plugin;
		
		public File namefile = new File(getDataFolder() + "/data.yml");
		public FileConfiguration names = YamlConfiguration.loadConfiguration(namefile);
		
		
		@Override
		public void onEnable(){
			PluginDescriptionFile pdfFile = this.getDescription();
			logger.info("UltraTitle is enabled and running fine! V: 1.0"); // prints into the log
			loadMethoid();
			
			//loadFile();
			registerConfig();
		}
		
		@Override
		public void onDisable(){
			PluginDescriptionFile pdfFile = this.getDescription();
			logger.info("UltraTitle has been disabled correctly!"); // same thing
			//saveFile();
		}
		
		
		
		
		public void saveFile(){
			
			try{
				names.save(namefile);
			}catch(IOException e){
				e.printStackTrace();
				
			}
			
		}
		
		public void loadFile(){
			if(namefile.exists()){
				try {
					names.load(namefile);
				} catch (IOException | InvalidConfigurationException e) {

					e.printStackTrace();
				}
			}
			else{
				try {
					names.save(namefile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		private void registerConfig() {
			saveDefaultConfig();
		}
		
		public void loadMethoid(){
			getCommand("title").setExecutor(new TitleCommand(this));
			Bukkit.getServer().getPluginManager().registerEvents(new OnJoin(this), this);
			
		}

	}

	//Permmisions:

