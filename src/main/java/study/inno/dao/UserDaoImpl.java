package study.inno.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import study.inno.dao.connection_manager.ConnectionManagerImpl;
import study.inno.dao.iface.UserDao;
import study.inno.dto.User;
import study.inno.utils.UserPusher;

import java.util.HashSet;
import java.util.Set;

import static study.inno.utils.MongoBuilder.buildInsert;
import static study.inno.utils.MongoBuilder.buildUpdate;

public class UserDaoImpl implements UserDao {
    private static final UserPusher PUSHER = new UserPusher();
    private static final DBCollection TABLE = ConnectionManagerImpl.getInstance().getCollection("users");

    @Override
    public Set<User> getAllUsers() {
        Set<User> result = new HashSet<>();
        for (DBObject obj : TABLE.find()) {
            result.add(PUSHER.push(obj));
        }

        return result;
    }

    @Override
    public User getByName(String name) {
        return PUSHER.push(TABLE.findOne(new BasicDBObject("name", name)));
    }

    @Override
    public void updateByName(User user) {
        //не обновляет объект адреса
        TABLE.findAndModify(new BasicDBObject("name", user.getName()), buildUpdate(user));
    }

    @Override
    public void deleteByName(User user) {
        TABLE.findAndRemove(new BasicDBObject("name", user.getName()));
    }

    @Override
    public void add(User user) {
        BasicDBObject doc = buildInsert(user);
        TABLE.insert(doc);

        user.setId(doc.get("_id").toString());
    }
}
