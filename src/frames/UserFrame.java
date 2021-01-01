/*
 * Created by JFormDesigner on Mon Dec 28 21:45:49 CST 2020
 */

package frames;

import DB.DAO;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author yyy
 */
public class UserFrame extends JFrame {
    public UserFrame() throws SQLException {
        initComponents();
        // 显示所有项目信息
        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余名额");

        ResultSet resultSet = DAO.getAllItemInfo();


        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table1.setModel(tabModel);
        table1.setEnabled(true);
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException {
        // 显示所有项目信息
        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余名额");

        ResultSet resultSet = DAO.getAllItemInfo();

        
        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table1.setModel(tabModel);
        table1.setEnabled(true);
    }

    private void button2MouseClicked(MouseEvent e) throws SQLException {
        // 显示学生已经报名的信息
        
        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("选手编号");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");


        ResultSet resultSet = DAO.getStuSignUpInfo(DAO.StuId);


        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int Cid;


        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            Cid = resultSet.getInt("Cid");
            //输出结果
//            System.out.println( bid+ "\t" + name+ "\t" +author+ "\t" +pub+ "\t" +num+ "\t" +type);

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(Cid);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
          

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table1.setModel(tabModel);
        table1.setEnabled(true);
        
    }

    private void button3MouseClicked(MouseEvent e) throws SQLException {
        // 学生报名项目
        String str = textField2.getText();
        if (str.length()==0){
            JOptionPane.showMessageDialog(null, "项目编号不能为空！");
            return;
        }

        for (int i=0;i<str.length();i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                JOptionPane.showMessageDialog(null, "账号格式不正确，应只包含数字！");
                return;
            }
        }

        int sportID = Integer.valueOf(textField2.getText());

        if (!DAO.isHaveItem(sportID)){
            JOptionPane.showMessageDialog(null, "抱歉，没有此项目！");
            return;
        }

        int cid = 1;
        ResultSet resultSet2 = DAO.getSignUpNum(sportID);
        while (resultSet2.next()){
            cid++;
        }

        ResultSet resultSet = DAO.searchLeftNum(sportID);
        int leftNum = 0;
        if (resultSet.next()){
            leftNum = resultSet.getInt("leftNum");
        }
        if (leftNum<=0){
            JOptionPane.showMessageDialog(null, "该项目报名人数已满，无法包报名！");
            return;
        }

        if (DAO.isSignUp(DAO.StuId,sportID)){
            JOptionPane.showMessageDialog(null, "已经报名该项目，无需重复报名！");
            return;
        }

        //判断时间是否冲突
        //先得到新参加项目的开始和结束时间
        String newStart_Time = "";
        String newEnd_time = "";
        ResultSet resultSet1 = DAO.getStartEndTime(sportID);
        if (resultSet1.next()){
            newStart_Time = resultSet1.getString("start_time");
            newEnd_time = resultSet1.getString("end_time");
        }
        System.out.println(newStart_Time);
        System.out.println(newEnd_time);
        //得到之前已经报名的所有项目信息
        ResultSet resultSet3 = DAO.getStuSignUpInfo(DAO.StuId);
        String start_time;
        String end_time;
        String sportName;
        String sportId;
        while(resultSet3.next()){
            start_time = resultSet3.getString("start_time");
            end_time = resultSet3.getString("end_time");
            sportId = resultSet3.getString("Sportid");
            sportName = resultSet3.getString("Sport_name");

            if (DAO.isConflict(start_time,end_time,newStart_Time,newEnd_time)){
                JOptionPane.showMessageDialog(null, "此项目与之前报名的编号为 "+sportId+" 的‘"+sportName+"’相冲突  \n请重新安排报名！");
                return;
            }
        }


        DAO.addStuSignUpInfo(DAO.StuId,sportID,cid);
        DAO.changeLeftItems(sportID,leftNum-1);
        if (DAO.isSignUp(DAO.StuId,sportID)){
            JOptionPane.showMessageDialog(null, "学号:"+DAO.StuId+"\n项目号:"+sportID+"\n报名成功！");
            return;
        }else {
            JOptionPane.showMessageDialog(null, "报名失败！");
            return;
        }
        
    }

    private void button4MouseClicked(MouseEvent e) throws SQLException {
        // 根据关键字查询符合条件的体育项目
        String keyWords;

        keyWords = textField1.getText();
        if (keyWords.length()==0){
            JOptionPane.showMessageDialog(null, "关键字不能为空！");
            return;
        }
        ResultSet resultSet = DAO.getKeyItemInfo(keyWords);
//        if (resultSet){
//            JOptionPane.showMessageDialog(null, "没有该类的比赛项目！");
//            return;
//        }

        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余名额");


        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table1.setModel(tabModel);
        table1.setEnabled(true);
    }

    private void button5MouseClicked(MouseEvent e) throws SQLException {
        // 学生取消项目报名

        String str = textField2.getText();
        if (str.length()==0){
            JOptionPane.showMessageDialog(null, "项目编号不能为空！");
            return;
        }

        for (int i=0;i<str.length();i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                JOptionPane.showMessageDialog(null, "账号格式不正确，应只包含数字！");
                return;
            }
        }

        int sportID = Integer.valueOf(textField2.getText());

        if (!DAO.isSignUp(DAO.StuId,sportID)){
            JOptionPane.showMessageDialog(null, "没有报名该项目，无需取消报名！");
            return;
        }

        int leftNum = 0;
        ResultSet resultSet = DAO.searchLeftNum(sportID);
        if (resultSet.next()){
            leftNum = resultSet.getInt("leftNum");
        }

        DAO.cancelSignUp(DAO.StuId,sportID);
        DAO.changeLeftItems(sportID,leftNum+1);
        if (!DAO.isSignUp(DAO.StuId,sportID)){
            JOptionPane.showMessageDialog(null, "取消报名成功！");
            return;
        }
        
    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button8MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button4 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField2 = new JTextField();
        button3 = new JButton();
        label5 = new JLabel();
        button5 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 10, 565, 345);

        //---- button4 ----
        button4.setText("\u786e\u5b9a\u67e5\u8be2");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button4MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button4);
        button4.setBounds(625, 150, 95, 30);

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u9879\u76ee\u540d\u79f0\u5173\u952e\u5b57\u8fdb\u884c\u67e5\u8be2\uff1a");
        contentPane.add(label1);
        label1.setBounds(595, 30, 195, 45);
        contentPane.add(textField1);
        textField1.setBounds(595, 80, 175, 40);

        //---- button1 ----
        button1.setText("\u663e\u793a\u6240\u6709\u9879\u76ee\u4fe1\u606f");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button1MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button1);
        button1.setBounds(65, 395, 135, 40);

        //---- button2 ----
        button2.setText("\u663e\u793a\u5df2\u62a5\u540d\u9879\u76ee\u4fe1\u606f");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button2MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button2);
        button2.setBounds(300, 395, 150, 40);

        //---- label2 ----
        label2.setText("-----------------------------------------");
        contentPane.add(label2);
        label2.setBounds(585, 260, 225, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u9879\u76ee\u62a5\u540d\u7ba1\u7406\u533a\u57df");
        contentPane.add(label3);
        label3.setBounds(645, 235, 130, 32);

        //---- label4 ----
        label4.setText("\u9879\u76ee\u7f16\u53f7");
        contentPane.add(label4);
        label4.setBounds(585, 290, 65, 35);
        contentPane.add(textField2);
        textField2.setBounds(650, 290, 120, 40);

        //---- button3 ----
        button3.setText("\u786e\u8ba4\u62a5\u540d");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button3MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button3);
        button3.setBounds(600, 355, 90, 35);

        //---- label5 ----
        label5.setText("-----------------------------------------");
        contentPane.add(label5);
        label5.setBounds(585, 220, 225, 17);

        //---- button5 ----
        button5.setText("\u53d6\u6d88\u62a5\u540d");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button5MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button5);
        button5.setBounds(700, 355, 90, 35);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yyy
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button4;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField2;
    private JButton button3;
    private JLabel label5;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
