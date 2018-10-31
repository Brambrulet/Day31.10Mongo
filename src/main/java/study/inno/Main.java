package study.inno;

import com.mongodb.MongoClient;
import study.inno.dao.UserDaoImpl;
import study.inno.dto.User;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = null;

        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        List<String> dbs = mongoClient.getDatabaseNames();
//        for(String db: dbs){
//            System.out.println(db);
//        }

//        DB db = mongoClient.getDB("test");
//        DBCollection table = db.getCollection("users");
//        BasicDBObject dbObject = new BasicDBObject();
//        dbObject.putIfAbsent("name", "tom");
//        dbObject.putIfAbsent("age", 32);
//        table.insert(dbObject);
//        dbObject.putIfAbsent("name", 32);

//        DB db = mongoClient.getDB("test");
//        DBCollection table = db.getCollection("users");
//        DBCursor result = table.find();
//        while(result.hasNext()){
//            DBObject current = result.next();
//            System.out.println(String.format("user id:%s name:%s age:%s", current.get("_id"), current.get("name"), current.get("age")));
//        }
//

        UserDaoImpl userDao = new UserDaoImpl();

        System.out.println("%n%nFind user with name: tom");
        System.out.println(userDao.getByName("tom").toString());

//        System.out.println("%n%nAdd user with name: Andrey");
//        userDao.add(new User("Andrey3", "query", 13, null));

        System.out.println("%n%nUpd user with name: Andrey3");
        userDao.updateByName(new User("Andrey3", "quertyui", 15, null));

        System.out.println("%n%nSelect all users");
        for (User user : userDao.getAllUsers()) {
            System.out.println(user.toString());
        }
    }
}
