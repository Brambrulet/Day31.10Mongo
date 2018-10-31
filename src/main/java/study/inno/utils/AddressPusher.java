package study.inno.utils;

import com.mongodb.DBObject;
import study.inno.pojo.Address;

import static study.inno.utils.Caster.obj2Str;
import static study.inno.utils.Caster.str2IntDef;

public class AddressPusher {
    public Address push(DBObject src) {
        if (src != null) {
            return new Address(obj2Str(src.get("_id")),
                    obj2Str(src.get("city")),
                    obj2Str(src.get("street")),
                    str2IntDef(src.get("house"), -1));
        }

        return null;
    }
}
