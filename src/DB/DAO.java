package DB;

import javax.swing.plaf.SplitPaneUI;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    JDBC jdbc = new JDBC();
    static ResultSet resultSet;
    //用户个人登录
    public static boolean logStu(String name,String password) throws SQLException {
        String sql = "select * from user_stu " + "where user_name = '"+ name +"' and password = '" + password + "' ;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        if (resultSet.next()){
            return true;
        }
        return false;
    }

    //团队登录
    public static boolean logTeam(String name,String password) throws SQLException {
        String sql = "select * from user_team " + "where user_name = '"+ name +"' and password = '" + password + "' ;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        if (resultSet.next()){
            return true;
        }
        return false;
    }

    //管理员登录
    public static boolean logMan(String name,String password) throws SQLException {
        String sql = "select * from user_man " + "where user_name = '"+ name +"' and password = '" + password + "' ;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        if (resultSet.next()){
            return true;
        }
        return false;
    }
}
