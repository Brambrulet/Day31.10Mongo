package study.inno.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import study.inno.dao.connection_manager.ConnectionManagerImpl;
import study.inno.dao.iface.AddressDao;
import study.inno.pojo.Address;
import study.inno.utils.AddressPusher;

import java.util.HashSet;
import java.util.Set;

import static study.inno.utils.MongoBuilder.buildInsert;
import static study.inno.utils.MongoBuilder.buildUpdate;

public class AddressDaoImpl implements AddressDao {
    private static final AddressPusher PUSHER = new AddressPusher();
    private static final DBCollection TABLE = ConnectionManagerImpl.getInstance().getCollection("addresses");

    @Override
    public Set<Address> getAllAddresses() {
        Set<Address> result = new HashSet<>();
        for (DBObject obj : TABLE.find()) {
            result.add(PUSHER.push(obj));
        }

        return result;
    }

    @Override
    public Address getById(String id) {
        return PUSHER.push(TABLE.findOne(id));
    }

    @Override
    public void updateById(Address address) {
        TABLE.findAndModify(new BasicDBObject("_id", address.getId()), buildUpdate(address));
    }

    @Override
    public void deleteById(Address address) {
        TABLE.remove(new BasicDBObject("_id", address.getId()));
    }

    @Override
    public void add(Address address) {
        BasicDBObject doc = buildInsert(address);
        TABLE.insert(doc);

        address.setId(doc.get("_id").toString());
    }
}
