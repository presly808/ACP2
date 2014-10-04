package ua.artcode.dao;

import java.sql.SQLException;

/**
 * Created by bm13 on 04.10.2014.
 */
public interface DBDaoInterface {
    public void initDB(String ip, String port, String schema, String USER, String PASS) throws Exception;
    public void destroyDB();
    public void executeDML(String string);
    public java.sql.ResultSet executeDDL(String string) throws SQLException;
}
