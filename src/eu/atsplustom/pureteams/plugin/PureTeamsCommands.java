package eu.atsplustom.pureteams.plugin;

/**
 * Enums that are used for the commands.
 * @author 
 */
public enum PureTeamsCommands
{
	CREATE ("create"),
	DELETE ("delete"),
	JOIN ("join"),
	NO_MATCH ("FAIL");
	
	private final String command;

	private PureTeamsCommands(String command)
	{
		this.command = command;
	}
	
	public String getCommand(){ return this.command; }
	public static PureTeamsCommands getEnum(String cmd)
	{
		for(PureTeamsCommands c : PureTeamsCommands.values())
			if(c.command.equalsIgnoreCase(cmd)) return c;
		return NO_MATCH;
	}
}
