package dao;

import model.User;

public interface LoginDataDao {
    boolean checkIfLoginIsCorrect(String login);
    boolean checkIfPasswordIsCorrect(String login, String password);
    User getUserByLogin(String login);
    String getSaltByLogin(String login);
    User getUserById(int userIdBySession);
}
