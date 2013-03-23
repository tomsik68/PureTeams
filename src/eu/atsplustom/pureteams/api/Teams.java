package eu.atsplustom.pureteams.api;

import java.util.List;

import org.bukkit.metadata.MetadataStoreBase;

/** Something like main class that connects everything
 * 
 *
 */
public interface Teams {
    /** Gets or creates {@link TeamContext} with specified name
     * 
     * @param name - Name of context we want to get
     * @return {@link TeamContext} called <B>name</B>
     */
    public TeamContext getOrCreateContext(String name);
    /**
     * 
     * @return Names of existing contexts
     */
    public List<String> getContextNames();
    /**
     * 
     * @return MetadataStore where Teams can store Metadata
     */
    public MetadataStoreBase<Team> getTeamMetadataStore();
    
}
