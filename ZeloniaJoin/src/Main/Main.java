package Main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.AddTeleCommand;
import Commands.RemoveTeleCommand;
import Listener.AddPlayerListener;
import Listener.JoinTutListener;

public class Main extends JavaPlugin implements Listener{

	private AddTeleCommand myAddTeleCommand;
	private RemoveTeleCommand myRemoveTeleCommand;
	
	@Override
	public void onEnable() {
		
		//Commands
		myAddTeleCommand = new AddTeleCommand(this);
		getCommand("addtele").setExecutor(myAddTeleCommand);

		myRemoveTeleCommand = new RemoveTeleCommand(this);
		getCommand("deltele").setExecutor(myRemoveTeleCommand);
		
		//Listener
		new AddPlayerListener(this);
		new JoinTutListener(this);
	}
}
