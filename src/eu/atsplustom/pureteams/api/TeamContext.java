package eu.atsplustom.pureteams.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.bukkit.entity.Player;
@Entity
@Table(name="teamContexts")
@UniqueConstraint(columnNames = { "name" })
public interface TeamContext {
    /**
     * 
     * @return Name of this context. Doesn't have to be name of plugin which uses this context.
     */
    public String getName();
    /** Gets team with given name, null if none exists
     * 
     * @param name - name of the {@link Team} we want to get
     * @return - {@link Team} called <B>name</b>
     */
    public Team getTeam(String name);
    /** Gets team this player is member of within this context. Null if player is member of no team.
     * 
     * @param player - {@link Player} who is in the team
     * @return - Team which <b>player</b> is member of <B>in this context</B>
     */
    public Team getTeamFor(Player player);
    /** Gets list of teams that belong to this context. Never null.
     * 
     * @return {@link List} of {@link Team}s in this context.
     */
    public List<Team> getTeams();
}
