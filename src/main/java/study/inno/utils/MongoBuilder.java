package study.inno.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import study.inno.dto.Address;
import study.inno.dto.User;

public class MongoBuilder {

    private MongoBuilder() {
    }

    public static DBObject buildUpdate(User user) {
        BasicDBObject result = new BasicDBObject();

        result.put("$set", new BasicDBObject().
                append("name", user.getName()).
                append("password", user.getPassword()).
                append("age", user.getAge()).
                append("address", user.getAddress() == null ? null : user.getAddress().getId()));

        return result;
    }

    public static DBObject buildUpdate(Address address) {
        DBObject result = new BasicDBObject();

        result.put("$set", new BasicDBObject().
                append("city", address.getCity()).
                append("street", address.getStreet()).
                append("house", address.getHouse()));

        return result;
    }

    public static BasicDBObject buildInsert(User user) {
        BasicDBObject result = new BasicDBObject();

        result.append("_id", new ObjectId());
        result.append("name", user.getName());
        result.append("password", user.getPassword());
        result.append("age", user.getAge());
        result.append("address", user.getAddress() == null ? null : user.getAddress().getId());
        return result;
    }

    public static BasicDBObject buildInsert(Address address) {
        BasicDBObject result = new BasicDBObject();

        result.append("_id", new ObjectId());
        result.append("city", address.getCity());
        result.append("street", address.getStreet());
        result.append("house", address.getHouse());

        return result;
    }
}
