package com.moviepilot.sheldon.compactor.custom;

import com.moviepilot.sheldon.compactor.config.Config;
import com.moviepilot.sheldon.compactor.event.IndexEntry;
import com.moviepilot.sheldon.compactor.event.IndexSwapper;
import com.moviepilot.sheldon.compactor.event.NodeEvent;
import com.moviepilot.sheldon.compactor.handler.NodeIndexer;
import org.neo4j.helpers.collection.MapUtil;
import org.neo4j.unsafe.batchinsert.BatchInserterIndex;

/**
 * @author stefanp
 * @since 09.08.12
 */
@SuppressWarnings("UnusedDeclaration")
public class SheldonNodeIndexer extends SheldonIndexer<NodeEvent> implements NodeIndexer {

    public void setup(final Config config) {
        super.setup(config);
        swapper = new IndexSwapper(config) {
            public BatchInserterIndex makeNew() {
                return config.getTargetIndexProvider().nodeIndex("sheldon_node", MapUtil.stringMap("type", "exact"));
            }
        };
    }

    public final Kind getKind() {
        return Kind.NODE;
    }
}
