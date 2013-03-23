package eu.atsplustom.pureteams.impl;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import eu.atsplustom.pureteams.api.Team;
import eu.atsplustom.pureteams.api.TeamContext;
import eu.atsplustom.pureteams.plugin.PureTeamsPlugin;

public class PureTeam implements Team{
    //All of these have to be protected, so EBean subclass can see them
    protected String context, name, leader;
    protected List<String> members;
    protected short flags = 0;
    
    public PureTeam(){}
    
    public PureTeam(String name, String context, String leader){
        this.name = name;
        this.context = context;
        this.leader = leader;
        members = new ArrayList<String>();
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
    public List<String> getPlayers() {
        return members;
    }

    @Override
    public float getDiplomacy(Team other) {
        if(!other.getContextName().equalsIgnoreCase(getContextName()))
            throw new IllegalArgumentException("Can't compare teams from different contexts.");
        return PureTeamsPlugin.db.getDiplomacy(name, other.getName(), context).getDiplomacy();
    }
    @Override
    public String getLeader() {
        return leader;
    }

    @Override
    public void addPlayer(String player) {
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

    @Override
    public boolean getFlag(short flag) {
        return (flags | flag) == 1;
    }

    @Override
    public void setFlag(short flag, boolean b) {
        if(b)
            flags |= flag;
        else
            flags &= ~flag;
    }

    @Override
    public String getContextName() {
        return context;
    }

}
