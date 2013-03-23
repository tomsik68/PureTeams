package eu.atsplustom.pureteams.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.atsplustom.pureteams.plugin.PureTeamsPlugin;

/**
 * This class serves as a command executer for the plugin, functionality may be
 * found in other classes.
 * @author 
 */
public class PureTeamsCommandExecutor implements CommandExecutor
{
	@SuppressWarnings("unused")
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
		
		PureTeamsCommands ptc = PureTeamsCommands.getEnum(args[0]);
		if(ptc == null) return false;
		
		switch(ptc)
		{
			case CREATE: sender.sendMessage("Create command invoked!"); return true;
			case DELETE: sender.sendMessage("Delete command invoked!"); return true;
			case JOIN: sender.sendMessage("Join command invoked!"); return true;
			//TODO: Is NO_MATCH necessary? How about default? :)
			//		You're right its not really needed :) I replaced it with null and a check.
			
			default: return false;
		}
	}
}
