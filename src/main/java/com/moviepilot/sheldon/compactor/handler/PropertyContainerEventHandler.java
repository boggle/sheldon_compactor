package com.moviepilot.sheldon.compactor.handler;

import com.lmax.disruptor.EventHandler;
import com.moviepilot.sheldon.compactor.event.PropertyContainerEvent;

/**
 * @author stefanp
 * @since 08.08.12
 */
public interface PropertyContainerEventHandler<E extends PropertyContainerEvent> extends EventHandler<E> {

    public enum Kind {
        NODE, EDGE;

        public String lowercaseName() {
            switch (this) {
                case NODE: return "node";
                case EDGE: return "edge";
            }
            throw new IllegalArgumentException("Unknown kind");
        }
    }

    public Kind getKind();
}
