package study.inno;

import org.apache.log4j.Logger;
import study.inno.dao.UserDaoImpl;
import study.inno.pojo.User;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();

        LOGGER.info("%n%nFind user with name: tom");
        LOGGER.info(userDao.getByName("tom").toString());

//        LOGGER.info("%n%nAdd user with name: Andrey");
//        userDao.add(new User("Andrey3", "query", 13, null));

        LOGGER.info("%n%nUpd user with name: Andrey3");
        userDao.updateByName(new User("Andrey3", "qwerty", 15, null));

        LOGGER.info("%n%nSelect all users");
        for (User user : userDao.getAllUsers()) {
            LOGGER.info(user.toString());
        }
    }
}
