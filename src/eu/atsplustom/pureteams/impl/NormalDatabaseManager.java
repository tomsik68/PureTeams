package eu.atsplustom.pureteams.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;

import com.avaje.ebean.EbeanServer;

import eu.atsplustom.pureteams.api.DiplomaticEntry;
import eu.atsplustom.pureteams.api.Team;
import eu.atsplustom.pureteams.api.TeamContext;
import eu.atsplustom.pureteams.api.database.DatabaseManager;
import eu.atsplustom.pureteams.plugin.PureTeamsPlugin;

public class NormalDatabaseManager implements DatabaseManager{
    private final EbeanServer database;
    public NormalDatabaseManager(EbeanServer ebean){
        database = ebean;
    }
    @Override
    public EbeanServer getEbean() {
        return database;
    }

    @Override
    public void init(PureTeamsPlugin plugin) {
        try{
            plugin.getLogger().info("Checking database...");
            database.find(PureTeam.class).findRowCount();
            plugin.getLogger().info("Database is ok.");
        }catch (Exception e) {
            try{
                plugin.getLogger().info("Installing database...");
                plugin.installDDL();
                plugin.getLogger().info("Database installation complete!");
            }catch(Exception e2){
                plugin.getLogger().severe("Could not install database. Error: ");
                plugin.getLogger().throwing("NormalDatabaseManager", "init", e2);
            }
            
        }
    }

    @Override
    public void save(Object obj) {
        database.save(obj);
    }

    @Override
    public Team getTeamByName(String context, String name) {
        return database.find(PureTeam.class).where().ieq("context", context).ieq("name", name).findUnique();
    }

    @Override
    public TeamContext getContext(String name) {
        return database.find(PureTeamContext.class).where().ieq("name", name).findUnique();
    }

    @Override
    public DiplomaticEntry getDiplomacy(String team, String against, String context) {
        return database.find(BasicDiplomaticEntry.class).where().ieq("team1", team).ieq("team2", against).ieq("context", context).findUnique();
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Class<? extends Object>> getDatabaseClasses(){
        return (ArrayList<Class<? extends Object>>) Arrays.asList(PureTeam.class,BasicDiplomaticEntry.class);
    }
    @Override
    public List<Team> getTeams(String context) {
        List<PureTeam> l = database.find(PureTeam.class).where().ieq("context", context).findList();
        return new ArrayList<Team>(l);
    }
    @Override
    public Team getTeamByPlayer(String context, Player player) {
        return database.find(PureTeam.class).where().ieq("context", context).contains("members", player.getName()).findUnique();
    }
    @Override
    public List<String> getContexts() {
        ArrayList<String> r = new ArrayList<String>();
        List<TeamContext> l = database.find(TeamContext.class).findList();
        for(TeamContext t : l){
            r.add(t.getName());
        }
        return r;
    }
    

}
