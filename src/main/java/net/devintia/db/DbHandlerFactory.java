package net.devintia.db;

import java.io.File;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class DbHandlerFactory {

    public static DbHandler getNewDbHandler( DbType type ) {
        switch ( type ) {
            case YAML:
                return new YamlDbHandler( new File( "dev-database.yml" ) );
        }
        return null;
    }
}
