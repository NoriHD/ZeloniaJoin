package Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import Main.Main;

public class AddTeleCommand implements CommandExecutor{

	File teletut = new File("plugins/ZeloniaJoin","teletutorial.yml");
	public FileConfiguration teletutcfg = YamlConfiguration.loadConfiguration(teletut);
	
	@SuppressWarnings("unused")
	private Main plugin;
	public AddTeleCommand (Main instance){
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		
		Player p = (Player)sender;
		int number1 = 1;
		
		if(cmd.getName().equalsIgnoreCase("addtele")){
			if(p.hasPermission("zelonia.addtele") && p.isOp()){
				if(!teletutcfg.isSet(number1 + "." + p.getWorld() + "Location.World")){
					if(args.length == 1){
						
						String world = p.getWorld().getName();
						String number = "Number:";
						double x = p.getLocation().getX();
						double y = p.getLocation().getY();
						double z = p.getLocation().getZ();
						double yaw = p.getLocation().getYaw();
						double pitch = p.getLocation().getPitch();
						
						int number2 = teletutcfg.getInt(world, number1);
						
						teletutcfg.set(number, number2);
						teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.world", world);
						teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.x", Double.valueOf(x));
						teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.y", Double.valueOf(y));
						teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.z", Double.valueOf(z));
						teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.yaw", Double.valueOf(yaw));
						teletutcfg.set(number2 + "." + p.getWorld() + "." + "Location.pitch", Double.valueOf(pitch));
						
						number2++;
						teletutcfg.set(world, number2);
						
						try {
							teletutcfg.save(teletut);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else p.sendMessage("§cDu hast zu viele Argumente angegeben!");
					return false;
				}
			} else p.sendMessage("§cDu hast nicht genug Rechte!");
			return false;
		}
		return true;
	}
}