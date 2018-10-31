package study.inno.dao.iface;

import study.inno.pojo.Address;

import java.util.Set;

public interface AddressDao {
    public Set<Address> getAllAddresses();

    public Address getById(String id);

    public void updateById(Address address);

    public void deleteById(Address address);

    public void add(Address address);
}
