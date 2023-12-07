package com.solvd.laba.pooling;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionPool {
    private volatile static ConnectionPool instance;
    private static final int POOL_SIZE = 5;
    private final List<Connection> CONNECTION_POOL = new CopyOnWriteArrayList<>();

    private ConnectionPool(int poolSize) {

    }

    public static ConnectionPool getInstance() {
        if (instance == null)
            synchronized (ConnectionPool.class) {
                if (instance == null)
                    instance = new ConnectionPool(POOL_SIZE);
            }

        return instance;
    }

    private static Connection createConnection() {
        return connection;
    }

    public Connection getConnection() {
        return CONNECTION_POOL.remove(CONNECTION_POOL.size() - 1);
    }

    public void releaseConnection(Connection connection) {
        CONNECTION_POOL.add(connection);
    }
}
