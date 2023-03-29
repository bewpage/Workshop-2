package pl.coderslab.entity;

public class MainDao {
  public static void main(String[] args) {
    UserDao userDao = new UserDao();
    // Check if create user works
    // checkCreateUser(userDao);

    // check if read/find user works
    // checkFindUserById(userDao);

    // check update
    // checkUpdateById(userDao);

    // checkDeleteById(userDao, 1);

    checkFindAll(userDao);
  }

  private static void checkCreateUser(UserDao userDao) {

    User user1 = new User("test_03@gmail.com", "username_03", "password_03");
    User test1 = userDao.create(user1);

    System.out.println(test1.toString());
  }

  private static void checkFindUserById(UserDao userDao, long userId) {
    User user = userDao.read(userId);

    System.out.println(user.toString());
  }

  private static void checkUpdateById(UserDao userDao) {
    User user1 = userDao.read(1);

    user1.setEmail("test_new@gmail.com");
    user1.setUsername("username_new");
    user1.setPassword("test_new");

    userDao.update(user1);

    checkFindUserById(userDao, 1);
  }

  private static void checkDeleteById(UserDao userDao, long userId) {
    userDao.delete(userId);

    checkFindUserById(userDao, userId);
  }

  private static void checkFindAll(UserDao userDao) {
    User[] test = userDao.findAll();

    for (User user : test) {
      System.out.println("check: " + user.toString());
    }
  }
}
