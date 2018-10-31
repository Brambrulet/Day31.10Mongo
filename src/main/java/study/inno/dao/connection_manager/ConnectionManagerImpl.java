package study.inno.dao.connection_manager;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.apache.log4j.Logger;

import java.net.UnknownHostException;

public class ConnectionManagerImpl implements ConnectionManager {
    private static DB db;

    private ConnectionManagerImpl() {
    }

    public static DB getInstance() {
        if (db == null) {
            try {
                db = new MongoClient("localhost", 27017).getDB("test");
            } catch (UnknownHostException e) {
                Logger.getLogger(ConnectionManagerImpl.class).error(e.getMessage(), e);
            }
        }
        return db;
    }

    @Override
    public DB getConnection() {
        return getInstance();
    }
}
