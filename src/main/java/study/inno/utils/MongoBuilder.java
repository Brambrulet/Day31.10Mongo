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
        return user == null ?
                null :
                new BasicDBObject("$set", new BasicDBObject().
                        append("name", user.getName()).
                        append("password", user.getPassword()).
                        append("age", user.getAge()).
                        append("address", buildUpdate(user.getAddress())));
    }

    public static DBObject buildUpdate(Address address) {
        return address == null ?
                null :
                new BasicDBObject("city", address.getCity()).
                        append("street", address.getStreet()).
                        append("house", address.getHouse());
    }

    public static BasicDBObject buildInsert(User user) {
        return user == null ?
                null :
                new BasicDBObject("_id", new ObjectId()).
                        append("name", user.getName()).
                        append("password", user.getPassword()).
                        append("age", user.getAge()).
                        append("address", buildInsert(user.getAddress()));
    }

    public static BasicDBObject buildInsert(Address address) {
        return address == null ?
                null :
                new BasicDBObject("city", address.getCity()).
                        append("street", address.getStreet()).
                        append("house", address.getHouse());
    }
}
