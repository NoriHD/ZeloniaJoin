package Listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Main.Main;

public class JoinTutListener implements Listener{
	
	File teletut = new File("plugins/ZeloniaJoin","teletutorial.yml");
	FileConfiguration teletutcfg = YamlConfiguration.loadConfiguration(teletut);

	File pregi = new File("plugins/ZeloniaJoin","PlayerRegi.yml");
	public FileConfiguration pregicfg = YamlConfiguration.loadConfiguration(pregi);
	
	private Main plugin;
	public JoinTutListener(Main instance){
		this.plugin = instance;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		
		try {
			pregicfg.load(pregi);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!pregicfg.isSet(p.getName())){
			
		}
	}

}
