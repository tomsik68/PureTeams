package eu.atsplustom.pureteams.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.bukkit.metadata.Metadatable;
/** Represents a team. Group of people.
 *  Team is {@link Metadatable}, so that we can attach some data.
 *
 */
@Entity
@Table(name="teams")
public interface Team extends Metadatable{
    /**
     * 
     * @return name of this {@link Team}
     */
    public String getName();
    /**
     * 
     * @param name - New name of this team
     */
    public void setName(String name);
    /**
     * 
     * @return {@link List} of {@link Player}s in this {@link Team}
     */
    public List<String> getPlayers();
    /**
     * @param other - Team we want to find the diplomacy for
     * 
     * @return Returns float that tells the current state of this team to the other team <BR>
     * -1 = enemies <BR>
     *  0 = neutral <BR>
     *  1 = allies <BR><BR>
     *  float <U>only</U> guarantees flexibility. Say we want to change it soon ;)
     */
    public float getDiplomacy(Team other);
    /**
     * 
     * @return Name of leader of this team
     */
    public String getLeader();
    /** Adds a player to this team.
     * 
     * @param player - Player we want to add to this {@link Team}
     */
    public void addPlayer(String player);
    /** Removes a player from this team.
     * 
     * @param player - Player we don't want in this {@link Team} anymore
     */
    public void removePlayer(String player);
    /**
     * 
     * @return Context this team belongs to
     */
    public TeamContext getContext();
    /**
     * 
     * @return Name of context this team belongs to. Used by save structure :)
     */
    public String getContextName();
    /** Lets you set 16 booleans for each team.
     *  Examples of what can be flag: pvp/creative,open/closed. 
     *  In fact, we're replacing array of booleans by short.
     *  I'm sure we'll come up with more flags after the plugin release :P
     *  Use {@link TeamFlags} to access flag constants
     * @param flag
     * @return value of specified flag
     */
    public boolean getFlag(short flag);
    /** 
     * 
     * @param flag
     * @param value
     */
    public void setFlag(short flag, boolean b);
    
}
