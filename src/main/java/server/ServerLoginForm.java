package server;

import com.sun.net.httpserver.HttpServer;
import dao.LoginDataDao;
import dao.SessionDao;
import dao.sql.ConnectionPool;
import dao.sql.LoginDataSQL;
import dao.sql.SessionSQL;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerLoginForm {
    private ConnectionPool connectionPool;

    public ServerLoginForm(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        LoginDataDao userDao = new LoginDataSQL(connectionPool);
        SessionDao sessionDao = new SessionSQL(connectionPool);

        server.createContext("/login", new LoginFormHandler(userDao, sessionDao));
        server.setExecutor(null);
        server.start();
    }
}
