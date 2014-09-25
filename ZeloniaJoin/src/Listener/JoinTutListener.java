package Listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
		
		final Player p = e.getPlayer();
		final String pname = p.getName();
		
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
			if(pregicfg.contains(null)){
				if(teletutcfg.isSet("Number:")){
	
					String number = "Number:";
					long numbercfg = 1;
					final long numberstop = teletutcfg.getLong(number, numbercfg);
					Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
		
						int number1 = 1;
						
						@Override
						public void run() {
							String world = teletutcfg.getString(number1 + "." + p.getWorld() + "." + "Location.world");
							double x = teletutcfg.getDouble(number1 + "." + p.getWorld() + "." + "Location.world");
							double y = teletutcfg.getDouble(number1 + "." + p.getWorld() + "." + "Location.world");
							double z = teletutcfg.getDouble(number1 + "." + p.getWorld() + "." + "Location.world");
							double yaw = teletutcfg.getDouble(number1 + "." + p.getWorld() + "." + "Location.world");
							double pitch = teletutcfg.getDouble(number1 + "." + p.getWorld() + "." + "Location.world");
							
							
							
							Location loc = new Location(Bukkit.getWorld(world), x, y, z);
							loc.setYaw((float)yaw);
							loc.setPitch((float)pitch);
							
							p.teleport(loc);
							
							number1++;
							
							if(number1 == numberstop){
								pregicfg.set(pname, pname);
								
								try {
									pregicfg.save(pregi);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						
					}, 0, numberstop);
				}
			}
		}
	}
}