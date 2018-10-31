package study.inno.dao.iface;

import study.inno.pojo.Address;

import java.util.Set;

public interface AddressDao {
     Set<Address> getAllAddresses();

     Address getById(String id);

     void updateById(Address address);

     void deleteById(Address address);

     void add(Address address);
}
