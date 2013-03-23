package eu.atsplustom.pureteams.api.reports;

import java.util.Queue;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Thing that is possible for sending messages to players. If they're offline,
 * the message will be sent once the player logs in. That's the point!
 * There is going to be a default API for reporter + APIs for some major e-mailing/PM plugins which are worth it. :) 
 * 
 */
public interface Reporter extends Listener{
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
     * Called by server when <b>player</b> joins the server
     * 
     * @param event - The event instance that holds information about player who joined(player can be accessed via event.getPlayer) 
     */
    @EventHandler
    public void playerJoined(PlayerJoinEvent event);

    /**
     * 
     * @return {@link Queue} of Reports to be delivered to player known as
     *         <b>playerName</b>
     */
    public Queue<String> getReportQueue(String playerName);
}
