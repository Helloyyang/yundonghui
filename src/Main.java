import DB.DAO;
import frames.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        System.out.println();

        JFrame loginFrame = new LoginFrame();
        loginFrame.setMinimumSize(new Dimension(400, 300));
        loginFrame.setVisible(true);
//        String time1 = "2020.01.02 08:20";
//        String time2 = "2020.01.02 08:30";
//
//        String time3 = "2020.01.02 08:25";
//        String time4 = "2020.01.02 08:40";
//
//        System.out.println(isConflict(time1,time2,time3,time4));
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
}
