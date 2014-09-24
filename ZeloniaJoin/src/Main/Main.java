package Main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.AddTeleCommand;
import Listener.AddPlayerListener;

public class Main extends JavaPlugin implements Listener{

	private AddTeleCommand myAddTeleCommand;
	
	@Override
	public void onEnable() {
		
		//Commands
		myAddTeleCommand = new AddTeleCommand(this);
		getCommand("addtele").setExecutor(myAddTeleCommand);
		
		//Listener
		new AddPlayerListener(this);
	}
}
