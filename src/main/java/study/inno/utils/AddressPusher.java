package study.inno.utils;

import com.mongodb.DBObject;
import study.inno.dto.Address;

import static study.inno.utils.Customizer.Obj2Str;
import static study.inno.utils.Customizer.Str2IntDef;

public class AddressPusher {
    public Address push(DBObject src) {
        if (src != null) {
            return new Address(Obj2Str(src.get("_id")),
                    Obj2Str(src.get("city")),
                    Obj2Str(src.get("street")),
                    Str2IntDef(src.get("house"), -1));
        }

        return null;
    }
}
