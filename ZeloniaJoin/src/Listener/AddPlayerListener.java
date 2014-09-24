package Listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Main.Main;

public class AddPlayerListener implements Listener{
	
	File pregi = new File("plugins/ZeloniaJoin","PlayerRegi");
	public FileConfiguration pregicfg = YamlConfiguration.loadConfiguration(pregi);
	
	private Main plugin;
	public AddPlayerListener (Main instance){
		this.plugin = instance;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public void onAddPlayer (PlayerJoinEvent e){
		Player p = e.getPlayer();
		final String pname = p.getName();
		
		if(p.isOp()){
			pregicfg.set(pname, pname);
			
			try {
				pregicfg.save(pregi);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				
				@Override
				public void run() {
					pregicfg.set(pname, pname);
					
					try {
						pregicfg.save(pregi);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, 20*1);
		}
		
	}
	
}
