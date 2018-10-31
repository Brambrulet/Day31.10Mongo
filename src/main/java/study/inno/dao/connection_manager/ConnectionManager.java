package study.inno.dao.connection_manager;

import com.mongodb.DB;

public interface ConnectionManager {
    DB getConnection();
}
