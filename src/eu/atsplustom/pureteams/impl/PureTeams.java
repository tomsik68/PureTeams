package eu.atsplustom.pureteams.impl;

import java.util.List;

import org.bukkit.metadata.MetadataStoreBase;

import eu.atsplustom.pureteams.api.Team;
import eu.atsplustom.pureteams.api.TeamContext;
import eu.atsplustom.pureteams.api.Teams;
import eu.atsplustom.pureteams.api.database.DatabaseManager;
import eu.atsplustom.pureteams.impl.metadata.TeamMetaStore;

public class PureTeams implements Teams{
    private final DatabaseManager db;
    private final MetadataStoreBase<Team> metaStore;
    public PureTeams(DatabaseManager db){
        this.db = db;
        metaStore = new TeamMetaStore();
    }
    @Override
    public TeamContext getOrCreateContext(String name) {
        TeamContext c = db.getContext(name);
        if(c != null)
            return c;
        else{
            c = new PureTeamContext(name);
            db.save(c);
            return c;
        }
    }

    @Override
    public List<String> getContextNames() {
        return db.getContexts();
    }

    @Override
    public MetadataStoreBase<Team> getTeamMetadataStore() {
        return metaStore;
    }

}
