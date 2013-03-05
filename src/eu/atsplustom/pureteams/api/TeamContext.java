package eu.atsplustom.pureteams.api;

import java.util.List;

import org.bukkit.entity.Player;

public interface TeamContext {
    /**
     * 
     * @return Name of this context. Doesn't have to be name of plugin which uses this context.
     */
    public String getName();
    /**
     * 
     * @param name - name of the {@link Team} we want to get
     * @return - {@link Team} called <B>name</b>
     */
    public Team getTeam(String name);
    /**
     * 
     * @param player - {@link Player} who is in the team
     * @return - Team which <b>player</b> is member of <B>in this context</B>
     */
    public Team getTeamFor(Player player);
    /**
     * 
     * @return {@link List} of {@link Team}s in this context.
     */
    public List<Team> getTeams();
}
