package eu.atsplustom.pureteams.commands;
/*
 * CREATE 		- /teams create <name> <open/closed>				- Command to create a team *1*
 * DELETE 		- /teams delete <name>								- Command to delete a team
 * JOIN			- /teams join <name>								- Command to join a team *2*
 * LEAVE		- /teams leave <name>								- Command to leave a team
 * DIPLOMACY	- /teams dip <name> <another team name> <state>	- Command to change diplomatic status of a team *3*
 * PROPERTIES	- /teams prop <name> <property> <value>			- Command to modify properties of the config file
 * NO_MATCH		- This is not a command, this is a case something goes wrong. Avoids Exceptions!
 * 
 *1* This command could be like so: /teams create <pvp/creative> <open/closed> <name>
 *		pvp - Team will have diplomacy (A player can only be in one pvp team)
 *		creative - Team wont have diplomacy (A player can be in multiple creative teams as well as 1 pvp team)
 *		open - The team is open for anyone to join
 *		closed - Only accepted members can be in this team.
 *		name - Teams name (unique)
 *2* Rules for joining open/closed teams:
 *		Open	: Anyone can join this team as long as it has free slots
 *		Closed	: This team can be only joined if the owner accepts the member
 *---------------------------------------------------------------------------------------------------
 *	Command list still to be discussed
 *---------------------------------------------------------------------------------------------------
 *			/teams li - Lists all the teams you belong to
 *			The list could look like this:
 *			-----------------------------------------------
 *			1. <Team Name> <open/closed> <pvp/creative> <member count> <Owner/Diplomat/Member>
 *			2. ...
 *			-----------------------------------------------
 *
 *			/teams jli <name> - Lists all the join requests for this team
 *			/teams jacc <name> <player> - Accepts a players join request for this team
 *									OR
 *			/teams lock <name> - Locks command view on a specified team
 *			/teams jli - Lists the teams join requests (this command is not available if the team you locked into is closed)
 *			/teams jacc <player> - Accepts a players join request, this results in the player becoming a member
 *				(This command also is available only for closed teams)
 *			The list for join requests could look like this:
 *			-----------------------------------------------
 *			1. <Player> <date>
 *			2. ...
 *			-----------------------------------------------
 *
 *			Property for max teams a player can have
 *			Command: /teams prop maxteams <int>
 *			File: max_teams '5'
 *---------------------------------------------------------------------------------------------------
 *3* PVP Enabled teams only
 *		Neutral - Hostile	: Immediate for both teams
 *		Ally - Hostile 		: Immediate for both teams
 *		Hostile - Neutral	: Only after both teams agree
 *		Ally - Neutral		: Immediate for both teams
 *		Hostile - Ally		: Only after both teams agree
 *		Neutral - Ally		: Only after both teams agree
 */

/**
 * Enums that are used for the commands.
 * @author 
 */
public enum PureTeamsCommands
{
	CREATE ("create"),
	DELETE ("delete"),
	JOIN ("join"),
	LEAVE ("leave"),
	DIPLOMACY ("dip"),
	PROPERTIES ("prop");
	
	private final String command;
	
	private PureTeamsCommands(String command)
	{
		this.command = command;
	}
	/**
	 * Getter for command property.
	 * @return command property.
	 */
	public String getCommand(){ return this.command; }
	/**
	 * A method that tries to match a String to the command property.
	 * @param cmd - a String used to match the command property.
	 * @return Enum that matches the String. In case of mismatch returns null.
	 */
	public static PureTeamsCommands getEnum(String cmd)
	{
		for(PureTeamsCommands c : PureTeamsCommands.values())
			if(c.command.equalsIgnoreCase(cmd)) return c;
		return null;
	}
}
