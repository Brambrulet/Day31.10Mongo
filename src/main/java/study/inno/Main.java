package study.inno;

import org.apache.log4j.Logger;
import study.inno.dao.UserDaoImpl;
import study.inno.pojo.Address;
import study.inno.pojo.User;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User andrew = new User("Andrew", "query", 13, new Address("Москва", "Новый Арбат", 13));

        LOGGER.info("Find user with name: tom");
        LOGGER.info(userDao.getByName("tom").toString());

        LOGGER.info("Add user");
        userDao.add(andrew);
        LOGGER.info(userDao.getByName(andrew.getName()).toString());

        LOGGER.info("Upd user");
        andrew.setPassword("qwerty");
        andrew.setAge(15);
        andrew.getAddress().setCity("Оренбург");
        andrew.getAddress().setStreet("Терешковой");
        andrew.getAddress().setHouse(121);
        userDao.updateByName(andrew);
        LOGGER.info(userDao.getByName(andrew.getName()).toString());

        LOGGER.info("Select all users");
        for (User user : userDao.getAllUsers()) {
            LOGGER.info(user.toString());
        }

        LOGGER.info("Del user");
        userDao.deleteByName(andrew);

        LOGGER.info("Select all users");
        for (User user : userDao.getAllUsers()) {
            LOGGER.info(user.toString());
        }
    }
}
