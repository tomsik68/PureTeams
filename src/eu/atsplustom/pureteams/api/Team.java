package eu.atsplustom.pureteams.api;

import java.util.List;
import java.util.UUID;

import org.bukkit.metadata.Metadatable;
/** Represents a team. Group of people.
 *  Team is {@link Metadatable}, so that we can attach some data.
 *
 */
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
     * @return - Unique ID for this team
     */
    public UUID getUUID();
    
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
     * @return If this team is open (if anyone can join the team)
     */
    public boolean isOpen();
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
}
