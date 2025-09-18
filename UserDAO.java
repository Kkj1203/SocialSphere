package dao;

import model.User;

public interface UserDAO {
    boolean registerUser(User user);
    User validateUser(String username, String password);
    boolean isUsernameExists(String username);
}