package study.inno.utils;

import com.mongodb.DBObject;
import study.inno.pojo.User;

import static study.inno.utils.Caster.obj2Str;
import static study.inno.utils.Caster.str2IntDef;

public class UserPusher {

    private UserPusher() {
    }

    public static User push(DBObject src) {
        if (src != null) {
            return new User(obj2Str(src.get("_id")),
                    obj2Str(src.get("name")),
                    obj2Str(src.get("password")),
                    str2IntDef(src.get("age"), -1),
                    AddressPusher.push((DBObject) src.get("address")));
        }
        return null;
    }
}
