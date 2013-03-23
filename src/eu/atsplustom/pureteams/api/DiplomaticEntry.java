package eu.atsplustom.pureteams.api;

public interface DiplomaticEntry {
    /**
     * 
     * @return - Name of context this Entry is valid in
     */
    public String getContext();
    /**
     * 
     * @return - Team which created the entry
     */
    public String getOwnerTeam();
    /**
     * 
     * @return - Team this entry is created against
     */
    public String getOtherTeam();
    /**
     * 
     * @return - Diplomatic state. 1 = friends, 0 = neutral, -1 = enemies
     */
    public float getDiplomacy();
}
