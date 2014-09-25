package Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import Main.Main;

public class RemoveTeleCommand implements CommandExecutor{

	File teletut = new File("plugins/ZeloniaJoin","teletutorial.yml");
	FileConfiguration teletutcfg = YamlConfiguration.loadConfiguration(teletut);
	
	private Main plugin;
	public RemoveTeleCommand(Main instance){
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("deltele")){
			if(p.hasPermission("zelonia.deltele") && p.isOp()){
				
				if(args.length == 0){
					
					String world = p.getWorld().getName();
					String number = "Number:";
					int number1 = 1;
					
					try {
						teletutcfg.load(teletut);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int number2 = teletutcfg.getInt(world, number1);
					number2--;
					
					teletutcfg.set(number, number2);
					teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.world", null);
					teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.x", null);
					teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.y", null);
					teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.z", null);
					teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.yaw", null);
					teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.pitch", null);
					
					try {
						teletutcfg.save(teletut);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}
}