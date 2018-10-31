package study.inno.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import study.inno.pojo.Address;
import study.inno.pojo.User;

public class MongoBuilder {

    private MongoBuilder() {
    }

    public static DBObject buildUpdate(User user) {
        return new BasicDBObject("$set", new BasicDBObject().
                append("name", user.getName()).
                append("password", user.getPassword()).
                append("age", user.getAge()).
                append("address", user.getAddress() == null ? null : user.getAddress().getId()));
    }

    public static DBObject buildUpdate(Address address) {
        return new BasicDBObject("$set", new BasicDBObject().
                append("city", address.getCity()).
                append("street", address.getStreet()).
                append("house", address.getHouse()));
    }

    public static BasicDBObject buildInsert(User user) {
        return new BasicDBObject("_id", new ObjectId()).
                append("name", user.getName()).
                append("password", user.getPassword()).
                append("age", user.getAge()).
                append("address", user.getAddress() == null ? null : user.getAddress().getId());
    }

    public static BasicDBObject buildInsert(Address address) {
        return new BasicDBObject("_id", new ObjectId()).
                append("city", address.getCity()).
                append("street", address.getStreet()).
                append("house", address.getHouse());
    }
}
