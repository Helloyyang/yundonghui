package DB;

import javax.swing.plaf.SplitPaneUI;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    public static String StuId;
    JDBC jdbc = new JDBC();
    static ResultSet resultSet;

    //用户个人登录
    public static boolean logStu(String number,String password) throws SQLException {
        String sql = "select * from student " + "where Sid= '"+ number +"' and Spassword = '" + password + "' ;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        if (resultSet.next()){
            return true;
        }
        return false;
    }

    //团队登录
    public static boolean logTeam(String number,String password) throws SQLException {
        String sql = "select * from team_info " + "where Tid = '"+ number +"' and Tpassword = '" + password + "' ;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        if (resultSet.next()){
            return true;
        }
        return false;
    }

    //管理员登录
    public static boolean logMan(String number,String password) throws SQLException {
        String sql = "select * from manager_list " + "where Mid = '"+ number +"' and Mpassword = '" + password + "' ;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        if (resultSet.next()){
            return true;
        }
        return false;
    }

    //得到所有项目信息
    public static ResultSet getAllItemInfo() throws SQLException {
        String sql = "select * from sport_list where Min_sum = 1;";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }

    //根据关键字对项目进行查询
    public static ResultSet getKeyItemInfo(String keyWords) throws SQLException {
        String sql = "select * from sport_list where Min_sum = 1 and Sport_name like '%"+keyWords+"%';";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }

    //查询当前项目已报名人数
    public static ResultSet getSignUpNum(int sportId) throws SQLException {
        String sql = "select * from ssign_up_list  where Sportid = " + sportId+";";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }



    //查询某个学生已经报名的全部项目信息
    public static ResultSet getStuSignUpInfo(String stuId) throws SQLException {
        String sql = "select sport_list.*,Cid from ssign_up_list,sport_list  where sport_list.Sportid=ssign_up_list.Sportid and Sid = '" + stuId+"';";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }


    //添加学生报名信息
    public static boolean addStuSignUpInfo(String stuId,int sportId,int Cid) throws SQLException {
        String sql = "insert into ssign_up_list(Sid,Sportid,Cid) " +
                "values ('"+ stuId +"' ," + sportId +","+Cid+");";
        System.out.println(sql);
        return JDBC.statement.execute(sql);
    }


    //查询看是否有此项目
    public static boolean isHaveItem(int sportId) throws SQLException {
        String sql = " select * from sport_list  where Sportid ="+sportId+";";
        System.out.println(sql);
        return JDBC.statement.executeQuery(sql).next();
    }

    //查询是否已经报名
    public static boolean isSignUp(String stuId,int sportId) throws SQLException {
        String sql = " select * from ssign_up_list  where Sportid ="+sportId+" and Sid ="+ stuId+";";
        System.out.println(sql);
        return JDBC.statement.executeQuery(sql).next();
    }

    //学生取消报名
    public static boolean cancelSignUp(String stuId,int sportId) throws SQLException {
        String sql = " delete from ssign_up_list  where Sportid ="+sportId+" and Sid ="+ stuId+";";
        System.out.println(sql);
        return JDBC.statement.execute(sql);
    }

    //查询项目剩余量
    public static ResultSet searchLeftNum(int sportId) throws SQLException {
        String sql = "select * from sport_list  where Sportid = "+ sportId;
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }

    //修改项目剩余量
    public static void changeLeftItems(int sportId,int leftNum) throws SQLException {
        String sql = "update sport_list set leftNum =" +leftNum+" where Sportid = "+ sportId;
        System.out.println(sql);
        JDBC.statement.execute(sql);
    }

    //查询是否已经注册
    public static boolean isRegistered(String id) throws SQLException {
        String sql = "select * from student  where Sid = "+ id;
        System.out.println(sql);
        return JDBC.statement.executeQuery(sql).next();
    }

    //学生个人注册
    public static boolean stuRegister(String id,String name,int age,String sex,String pro,String clazz,String password) throws SQLException {
        String sql = "insert into student(Sid,Sname,Sage,Ssex,Spro,Sclass,Spassword) " +
                "values('"+id+"','"+name+"',"+age+",'"+sex+"','"+pro+"','"+clazz+"','"+password+"');";
        System.out.println(sql);
        return JDBC.statement.execute(sql);
    }

    //查询学生当队长的数目
    public static ResultSet searchTeamNum(String id) throws SQLException {
        String sql = "select * from student_team_list  where  Sid= "+ id+" and identity ="+ 1+";";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }

    //创建团队
    public static boolean teamRegister(int id,String name,String password) throws SQLException {
        String sql = "insert into team_info(Tid,Tname,Tpassword) " +
                "values(" + id + ",'" + name + "','" + password + "');";
        System.out.println(sql);
        return JDBC.statement.execute(sql);
    }

    //查询团队总数
    public static ResultSet searchTeam(String id) throws SQLException {
        String sql = "select * from team_info";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }
    //查询队名是否重复
    public static ResultSet searchTeamName(String name) throws SQLException {
        String sql = "select * from team_info  where  Tname= '"+ name+"';";
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }

    //判断两个时间的大小关系
    public static boolean bigger(String end_time,String start_time){
        int startMonth = Integer.valueOf(start_time.substring(5,7));
        int endMonth = Integer.valueOf(end_time.substring(5,7));

        int startDay = Integer.valueOf(start_time.substring(8,10));
        int endDay = Integer.valueOf(end_time.substring(8,10));

        int startHour = Integer.valueOf(start_time.substring(11,13));
        int endHour = Integer.valueOf(end_time.substring(11,13));

        int startMin = Integer.valueOf(start_time.substring(14,16));
        int endMin = Integer.valueOf(end_time.substring(14,16));

        if (endMonth>startMonth){
            return true;
        }else if (endMonth==startMonth&&endDay>startDay){
            return true;
        }else if (endMonth==startMonth&&endDay==startDay&&endHour>startHour){
            return true;
        }else if (endMonth==startMonth&&endDay==startDay&&endHour==startHour&&endMin>startMin){
            return true;
        }
        return false;
    }

    //判断两个时间段是否冲突，冲突返回true，不冲突返回false
    public static boolean isConflict(String start_time,String end_time,String newStart_time,String newEnd_time){
        if (bigger(newStart_time,start_time)&&bigger(end_time,newStart_time)){
            return true;
        }
        if (bigger(newEnd_time,start_time)&&bigger(end_time,newEnd_time)){
            return true;
        }
        if (bigger(newStart_time,start_time)&&bigger(newEnd_time,end_time)){
            return true;
        }
        if (bigger(start_time,newStart_time)&&bigger(end_time,newEnd_time)){
            return true;
        }
        return false;
    }

    //根据项目号得到该项目的开始时间和结束时间
    public static ResultSet getStartEndTime(int sportId) throws SQLException {
        String sql = "select * from sport_list  where  Sportid = " + sportId;
        System.out.println(sql);
        resultSet = JDBC.statement.executeQuery(sql);
        return resultSet;
    }
    //

}
