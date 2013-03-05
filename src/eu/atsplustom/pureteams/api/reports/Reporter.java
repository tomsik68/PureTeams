package eu.atsplustom.pureteams.api.reports;

import java.util.Queue;

import org.bukkit.entity.Player;

/**
 * Thing that is possible for sending messages to players. If they're offline,
 * the message will be sent once the player logs in. That's the point!
 * 
 * @author Tomsik68
 * 
 */
public interface Reporter {
    /**
     * Adds message to Reporter's send queue
     * 
     * @param playerName
     *            Name of player this message is for
     * @param message
     *            - Message for the player
     */
    public void sendMessage(String playerName, String... message);

    /**
     * Called by Listener when <b>player</b> joins the server
     * 
     * @param player
     *            - {@link Player} who joined
     */
    public void playerJoined(Player player);

    /**
     * 
     * @return {@link Queue} of Reports to be delivered to player known as
     *         <b>playerName</b>
     */
    public Queue<String> getReportQueue(String playerName);
}
