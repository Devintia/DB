package net.devintia.db;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.File;
import java.io.IOException;

/**
 * THIS SHOULD ONLY BE USED FOR TESTING!
 *
 * @author MiniDigger
 * @version 1.0
 */
public class YamlDbHandler implements DbHandler {

    private File file;
    private FileConfiguration configuration;

    public YamlDbHandler( File file ) {
        this.file = file;
    }

    @Override
    public boolean init() {
        System.err.println( "STARTING DEBUG DB " +file.getAbsolutePath() + " THIS IS NOT RECOMMENDED" );
        configuration = YamlConfiguration.loadConfiguration( file );
        return true;
    }

    @Override
    public boolean cleanUp() {
        return save();
    }

    public boolean save() {
        try {
            configuration.save( file );
        } catch ( IOException e ) {
            return false;
        }
        return true;
    }

    @Override
    public ConfigurationSerializable get( Object key ) {
        return (ConfigurationSerializable) configuration.get( key.toString() );
    }

    @Override
    public boolean save( Object key, ConfigurationSerializable object ) {
        configuration.set( key.toString(), object );
        return true;
    }

    @Override
    public boolean update( Object key, ConfigurationSerializable object ) {
        configuration.set( key.toString(), object );
        return true;
    }

    @Override
    public boolean delete( Object key ) {
        configuration.set( key.toString(), null );
        return true;
    }
}
