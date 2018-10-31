package study.inno.dao.connection_manager;

import com.mongodb.DB;
import com.mongodb.MongoClient;

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
                e.printStackTrace();
            }
        }
        return db;
    }

    @Override
    public DB getConnection() {
        return getInstance();
    }
}
