package eu.atsplustom.pureteams.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import eu.atsplustom.pureteams.api.Team;
import eu.atsplustom.pureteams.api.TeamContext;
import eu.atsplustom.pureteams.plugin.PureTeamsPlugin;

public class PureTeam implements Team{
    //All of these have to be protected, so EBean subclass can see them
    protected UUID uuid;
    protected String context, name;
    protected List<String> members;
    protected boolean open;
    
    public PureTeam(String name, String context, boolean open){
        uuid = UUID.randomUUID();
        this.name = name;
        this.context = context;
        members = new ArrayList<String>();
        this.open = open;
    }

    @Override
    public List<MetadataValue> getMetadata(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasMetadata(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeMetadata(String arg0, Plugin arg1) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void setMetadata(String arg0, MetadataValue arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public List<String> getPlayers() {
        return members;
    }

    @Override
    public float getDiplomacy(Team other) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public String getLeader() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addPlayer(String player) {
        // TODO Auto-generated method stub
        members.add(player);
        
    }

    @Override
    public void removePlayer(String player) {
        members.remove(player);
    }

    @Override
    public TeamContext getContext() {
        //TODO can we go with something else than a static thing?
        return PureTeamsPlugin.db.getContext(context);
    }

}
