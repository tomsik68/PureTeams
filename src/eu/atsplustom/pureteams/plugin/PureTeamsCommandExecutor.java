package eu.atsplustom.pureteams.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class serves as a command executer for the plugin, functionality may be
 * found in other classes.
 * @author 
 */
public class PureTeamsCommandExecutor implements CommandExecutor
{
	private PureTeamsPlugin plugin;

	public PureTeamsCommandExecutor(PureTeamsPlugin plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("This command can only be executed by a Player");
			return true;
		}
		if(args.length < 1) return false; //Could be changed to help or something
		
		switch(PureTeamsCommands.getEnum(args[0]))
		{
			case CREATE: sender.sendMessage("Create command invoked!"); return true;
			case DELETE: sender.sendMessage("Delete command invoked!"); return true;
			case JOIN: sender.sendMessage("Join command invoked!"); return true;
			//TODO: Is NO_MATCH necessary? How about default? :)
			case NO_MATCH: sender.sendMessage("This is "+plugin.getDescription().getName()
					+" version "+plugin.getDescription().getVersion()); return false;
			
			default: return false;
		}
	}
}
