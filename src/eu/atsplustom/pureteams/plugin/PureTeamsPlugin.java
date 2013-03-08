package eu.atsplustom.pureteams.plugin;

//import org.bukkit.ChatColor;
//import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import eu.atsplustom.pureteams.api.database.DatabaseManager;

/**
 * The main class for the plugin, so to speak.
 * @author 
 */
public class PureTeamsPlugin extends JavaPlugin
{
    //private PluginDescriptionFile desc = this.getDescription();
    
	/*
	 * Logger messages are only there while developing,
	 * planning to replace them with:
	 * 
	 * ConsoleCommandSender console = this.getServer().getConsoleSender();
	 * console.sendMessage();
	 * 
	 * This will give the option to color code the messages using ChatColor.RED etc.
	 */
    
    //TODO actually implement DatabaseManager :P
    public static DatabaseManager db;
    
	@Override
    public void onEnable()
    {
		super.onEnable();
		try
		{
			this.getCommand("teams").setExecutor(new PureTeamsCommandExecutor(this));
			this.getLogger().info("has registered its commands!");
		}
		catch(NullPointerException npexc)
		{
			this.getLogger().info("failed to registered its commands!");
			this.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		db.init(this);
		
		this.getLogger().info("Sucessfully Loaded!");
    }
	
	@Override
	public void onDisable()
	{
		this.getLogger().info("Gracefully Stopped!");
	}
	//We need to make this public, so that it can be used in DatabaseManager
	@Override
	public void installDDL() {
	    super.installDDL();
	}
}