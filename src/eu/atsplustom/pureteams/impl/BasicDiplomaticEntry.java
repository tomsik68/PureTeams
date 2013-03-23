package eu.atsplustom.pureteams.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.avaje.ebean.validation.NotNull;

import eu.atsplustom.pureteams.api.DiplomaticEntry;
@Entity
@Table(name="diplomacy")
public class BasicDiplomaticEntry implements DiplomaticEntry{
    @NotNull
    protected String context, team1, team2;
    @NotNull
    protected float dip;
    public BasicDiplomaticEntry(String ownerTeam, String targetTeam, String context, float d){
        this.team1 = ownerTeam;
        this.team2 = targetTeam;
        this.context = context;
        this.dip = d;
    }
    @Override
    public String getContext() {
        return context;
    }

    @Override
    public String getOwnerTeam() {
        return team1;
    }

    @Override
    public String getOtherTeam() {
        return team2;
    }

    @Override
    public float getDiplomacy() {
        return dip;
    }

}
