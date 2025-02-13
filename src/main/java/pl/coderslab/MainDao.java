package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.sql.SQLException;

public class MainDao {
    public static void main(String[] args) {
//        testAddUser("firstUser", "firstEmail@abc.com", "first");
//        testAddUser("secondUser", "secondEmail@abc.com", "second");
//        testAddUser("thirdUser", "thirdEmail@abc.com", "third");

        testReadUser(1);
        testReadUser(2);

        testUpdateUser(5, "randomUser", "randomUserEmail@abc.com", null);
;
        testDeleteUser(8);

        System.out.println("\nFind all function test");
        testFindAll();
    }

    public static void testAddUser(String userName, String email, String password){
        User user = new User();
        UserDao userDao = new UserDao();

        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(userDao.hashPassword(password));
        userDao.create(user);
    }

    public static void testReadUser(int userId){
        UserDao userDao = new UserDao();

        User user = userDao.read(userId);
        System.out.println(user);
    }

    public static void testUpdateUser(int userId, String newUserName, String newEmail, String newPassword){
        UserDao userDao = new UserDao();
        User user = userDao.read(userId);

        //update user
        System.out.println("User before update");
        System.out.println(user);

        if(newUserName != null)
            user.setUserName(newUserName);
        if(newEmail != null)
            user.setEmail(newEmail);
        if(newPassword != null)
            user.setPassword(userDao.hashPassword("12345"));

        System.out.println("User after update");
        System.out.println(user);

        userDao.update(user);
    }

    public static void testDeleteUser(int userId){
        UserDao userDao = new UserDao();

        testReadUser(userId);
        userDao.delete(userId);
        testReadUser(userId);
    }

    public static void testFindAll(){
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();

        for(User user: users){
            System.out.println(user);
        }
    }
}
