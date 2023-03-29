package pl.coderslab.entity;

import junit.framework.TestCase;
import org.junit.Assert;
import pl.coderslab.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest extends TestCase {

  public void testHashPassword() {
    // ???
  }

  public void testCreate() throws SQLException {
    UserDao userDao = new UserDao();

    User testUser = new User("mock_email@gmail.com", "mock_username", "mock_password");

    try( Connection conn = DbUtil.connectWorkshop()){
      try{
        conn.setAutoCommit(false);

        User createdUser = userDao.create(testUser);

        Assert.assertNotNull(createdUser);
        Assert.assertEquals("mock_email@gmail.com", createdUser.getEmail());
      }catch (SQLException e){
        e.printStackTrace();
      } finally{
        try{
          conn.rollback();
          conn.setAutoCommit(true);
        } catch (SQLException e){
          e.printStackTrace();
        }
      }
    }
  }

  public void testReadThrowsUserNotFoundException() {
    try {
      UserDao userDao = new UserDao();
      long key = 1;
      User user = userDao.read(key);
      fail("Expected a UserNotFoundException to be thrown");
      Assert.fail();
    } catch (UserNotFoundException ex) {
      Assert.assertEquals("USER for given id 1 not found", ex.getMessage());
    }
    assertTrue(true);
  }

  public void testRead() {
    UserDao userDao = new UserDao();
    long key = 3;
    User user = userDao.read(key);

    Assert.assertNotNull(user);
    Assert.assertEquals("username_02", user.getUsername());
  }

  public void testUpdate() {

  }

  public void testDelete() {}

  public void testFindAll() {}
}
