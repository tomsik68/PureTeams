package eu.atsplustom.pureteams.api.database;

import com.avaje.ebean.EbeanServer;

import eu.atsplustom.pureteams.api.Team;
import eu.atsplustom.pureteams.api.TeamContext;
import eu.atsplustom.pureteams.plugin.PureTeamsPlugin;

/**
 * Class that is responsible for saving to and retrieving from
 * {@link EbeanServer}
 * 
 * 
 */
public interface DatabaseManager {
    /**
     * 
     * @return The {@link EbeanServer} instance associated with this
     *         {@link DatabaseManager}
     */
    public EbeanServer getEbean();

    /**
     * Initializes the database
     * 
     * @param plugin
     *            - Plugin we're doing this with
     */
    public void init(PureTeamsPlugin plugin);

    /**
     * Saves specified object in database
     * 
     * @param obj
     */
    public void save(Object obj);
    /**
     * 
     * @param context
     * @param name
     * @return Team with specified name from specified context
     */
    public Team getTeamByName(String context, String name);
    /**
     * 
     * @param name
     * @return TeamContext with specified name
     */
    public TeamContext getContext(String name);
}
