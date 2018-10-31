package study.inno.utils;

import com.mongodb.DBObject;
import study.inno.dao.AddressDaoImpl;
import study.inno.dao.iface.AddressDao;
import study.inno.dto.User;

import static study.inno.utils.Customizer.obj2Str;
import static study.inno.utils.Customizer.str2IntDef;

public class UserPusher {
    private static final AddressDao addressDao = new AddressDaoImpl();

    public User push(DBObject src) {
        if (src != null) {
            return new User(obj2Str(src.get("_id")),
                    obj2Str(src.get("name")),
                    obj2Str(src.get("password")),
                    str2IntDef(src.get("age"), -1),
                    addressDao.getById(obj2Str(src.get("address")))
            );
        }
        return null;
    }
}
