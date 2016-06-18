package net.devintia.db;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public interface DbHandler {

    boolean init();

    boolean cleanUp();

    ConfigurationSerializable get( Object key );

    boolean save( Object key, ConfigurationSerializable object );

    boolean update( Object key, ConfigurationSerializable object );

    boolean delete( Object key );
}
