package dao;

public interface SessionDao {
    void insertSessionData(String session, int userId);
    void deleteSessionData(String session);
    boolean isCurrentSession(String session);
    int getUserIdBySession(String session);
}
