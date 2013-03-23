package eu.atsplustom.pureteams.impl.metadata;

import org.bukkit.metadata.MetadataStoreBase;

import eu.atsplustom.pureteams.api.Team;

public class TeamMetaStore extends MetadataStoreBase<Team>{

    @Override
    protected String disambiguate(Team team, String arg1) {
        //TODO not sure if I'm doing it right...
        //we can relie on §, since it's not typable in minecraft :P
        return team.getContextName()+"§"+team.getName();
    }

}
