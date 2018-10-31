package study.inno.utils;

import com.mongodb.DBObject;
import study.inno.dao.AddressDaoImpl;
import study.inno.dao.iface.AddressDao;
import study.inno.dto.User;

import static study.inno.utils.Customizer.Obj2Str;
import static study.inno.utils.Customizer.Str2IntDef;

public class UserPusher {
    private static final AddressDao addressDao = new AddressDaoImpl();

    public User push(DBObject src) {
        if (src != null) {
            return new User(Obj2Str(src.get("_id")),
                    Obj2Str(src.get("name")),
                    Obj2Str(src.get("password")),
                    Str2IntDef(src.get("age"), -1),
                    addressDao.getById(Obj2Str(src.get("address")))
            );
        }
        return null;
    }
}
