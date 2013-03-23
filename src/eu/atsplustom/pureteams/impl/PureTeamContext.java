package eu.atsplustom.pureteams.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.bukkit.entity.Player;

import com.avaje.ebean.validation.NotNull;

import eu.atsplustom.pureteams.api.Team;
import eu.atsplustom.pureteams.api.TeamContext;
import eu.atsplustom.pureteams.plugin.PureTeamsPlugin;


public class PureTeamContext implements TeamContext{
    @NotNull
    protected String name;
    
    public PureTeamContext(String name){
        this.name = name;
    }
    protected PureTeamContext(){}
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Team getTeam(String name) {
        return PureTeamsPlugin.db.getTeamByName(this.name, name);
    }

    @Override
    public Team getTeamFor(Player player) {
        return PureTeamsPlugin.db.getTeamByPlayer(name, player);
    }

    @Override
    public List<Team> getTeams() {
        return PureTeamsPlugin.db.getTeams(name);
    }

}
