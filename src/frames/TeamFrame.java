/*
 * Created by JFormDesigner on Tue Dec 29 13:54:15 CST 2020
 */

package frames;

import DB.DAO;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author yyy
 */
public class TeamFrame extends JFrame {
    public TeamFrame() throws SQLException {
        initComponents();
        welcom_lable2.setText("欢迎用户："+DAO.TeamId);
        // 显示所有项目信息
        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("最少参赛人数");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余队伍名额");

        ResultSet resultSet = DAO.getAllTeamItemInfo();

        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;
        int min_sum;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");
            min_sum = resultSet.getInt("min_sum");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(min_sum);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table2.setModel(tabModel);
        table2.setEnabled(true);
    }


    private void button7MouseClicked(MouseEvent e) throws SQLException {
        // 显示所有项目信息
        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("最少参赛人数");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余队伍名额");

        ResultSet resultSet = DAO.getAllTeamItemInfo();
        
        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;
        int min_sum;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");
            min_sum = resultSet.getInt("min_sum");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(min_sum);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table2.setModel(tabModel);
        table2.setEnabled(true);
    }

    private void button8MouseClicked(MouseEvent e) throws SQLException {
        // 显示团队已经报名的项目信息
        
        ResultSet resultSet = DAO.getTeamSignUpInfo(DAO.TeamId);

        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("参赛编号");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余队伍名额");

        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;
        int min_sum;
        int cid;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");
            cid = resultSet.getInt("Cid");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(cid);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table2.setModel(tabModel);
        table2.setEnabled(true);
    }

    private void button6MouseClicked(MouseEvent e) throws SQLException {
        // 根据关键字查询项目
        // 根据关键字查询符合条件的体育项目
        String keyWords;

        keyWords = textField3.getText();
        if (keyWords.length()==0){
            JOptionPane.showMessageDialog(null, "关键字不能为空！");
            return;
        }
        ResultSet resultSet = DAO.getKeyTeamItemInfo(keyWords);


        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("项目编号");
        columnNames.add("名称");
        columnNames.add("最少参赛人数");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("地点");
        columnNames.add("剩余队伍名额");


        int num;
        String name;
        String address;
        String start_time;
        String end_time;
        int leftNum;
        int min_sum;

        while (resultSet.next()) {
            num = resultSet.getInt("Sportid");
            name = resultSet.getString("Sport_name");
            address = resultSet.getString("Loc");
            start_time = resultSet.getString("start_time");
            end_time = resultSet.getString("end_time");
            leftNum = resultSet.getInt("leftNum");
            min_sum = resultSet.getInt("min_sum");

            row = new Vector<>();
            row.add(num);
            row.add(name);
            row.add(min_sum);
            row.add(start_time);
            row.add(end_time);
            row.add(address);
            row.add(leftNum);

            studate.add(row);
        }

        if (studate.isEmpty()){
            JOptionPane.showMessageDialog(null, "没有此类项目！");
            return;
        }
        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table2.setModel(tabModel);
        table2.setEnabled(true);
    }

    private void button11MouseClicked(MouseEvent e) throws SQLException {
        // 显示队伍所有成员信息
        ResultSet resultSet = DAO.getTeamMatesInfo(DAO.TeamId);

        Vector<Vector<Object>> studate = new Vector<Vector<Object>>();
        Vector<Object> row = null;
        Vector<String> columnNames = new Vector<String>();
        String id;
        String name;
        String progress;
        String clazz;
        String identity;

        columnNames.add("学号");
        columnNames.add("姓名");
        columnNames.add("专业");
        columnNames.add("班级");
        columnNames.add("是否为队长");

        while (resultSet.next()) {
            id = resultSet.getString("Sid");
            name = resultSet.getString("Sname");
            progress = resultSet.getString("Spro");
            clazz = resultSet.getString("Sclass");
            identity = resultSet.getString("iden");

            System.out.println(id+"  "+name);

            row = new Vector<>();
            row.add(id);
            row.add(name);
            row.add(progress);
            row.add(clazz);
            if (identity.equals("1")){
                row.add("是");
            }else {
                row.add("否");
            }
            studate.add(row);
        }
        
        DefaultTableModel tabModel = new DefaultTableModel(studate,columnNames);
        table1.setModel(tabModel);
        table1.setEnabled(true);
    }


    private void button9MouseClicked(MouseEvent e) throws SQLException {
        // 团队报名项目
        String str = textField4.getText();
        if (str.length()==0){
            JOptionPane.showMessageDialog(null, "项目编号不能为空！");
            return;
        }

        for (int i=0;i<str.length();i++){
            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                JOptionPane.showMessageDialog(null, "项目编号格式不正确，应只包含数字！");
                return;
            }
        }

        int sportID = Integer.valueOf(str);

        if (!DAO.isHaveItem(sportID)){
            JOptionPane.showMessageDialog(null, "抱歉，没有此项目！");
            return;
        }

        int cid = 1;
        ResultSet resultSet2 = DAO.getSignUpTeamNum(sportID);
        while (resultSet2.next()){
            cid++;
        }

        ResultSet resultSet = DAO.searchLeftNum(sportID);
        int leftNum = 0;
        if (resultSet.next()){
            leftNum = resultSet.getInt("leftNum");
        }
        if (leftNum<=0){
            JOptionPane.showMessageDialog(null, "该项目报名人数已满，无法报名！");
            return;
        }

        if (DAO.isTeamSignUp(DAO.TeamId,sportID)){
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
        ResultSet resultSet3 = DAO.getTeamSignUpInfo(DAO.TeamId);
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
                JOptionPane.showMessageDialog(null, "此项目与之前报名的编号为 "+sportId+" 的‘"+sportName+"’时间相冲突  \n请重新安排报名！");
                return;
            }
        }


        DAO.addTeamSignUpInfo(DAO.TeamId,sportID,cid);
        DAO.changeLeftItems(sportID,leftNum-1);
        if (DAO.isTeamSignUp(DAO.TeamId,sportID)){
            JOptionPane.showMessageDialog(null, "团队号:"+DAO.TeamId+"\n项目号:"+sportID+"\n报名成功！");
            return;
        }else {
            JOptionPane.showMessageDialog(null, "报名失败！");
            return;
        }
    }

    private void cancleSignUpMouseClicked(MouseEvent e) throws SQLException {
        // 团队取消项目报名

        String str = textField4.getText();
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

        int sportID = Integer.valueOf(textField4.getText());

        if (!DAO.isTeamSignUp(DAO.TeamId,sportID)){
            JOptionPane.showMessageDialog(null, "没有报名该项目，无需取消报名！");
            return;
        }

        int leftNum = 0;
        ResultSet resultSet = DAO.searchLeftNum(sportID);
        if (resultSet.next()){
            leftNum = resultSet.getInt("leftNum");
        }

        DAO.cancelTeamSignUp(DAO.TeamId,sportID);
        DAO.changeLeftItems(sportID,leftNum+1);
        if (!DAO.isSignUp(DAO.StuId,sportID)){
            JOptionPane.showMessageDialog(null, "取消报名成功！");
            return;
        }
    }

    private void addTeamMatesMouseClicked(MouseEvent e) throws SQLException {
        // 添加队员
        String id;
        id = textField5.getText();
        if (id.length()==0){
            JOptionPane.showMessageDialog(null, "学号不允许为空！");
            return;
        }
        if (id.length()!=12){
            JOptionPane.showMessageDialog(null, "学号位数不正确，请重新确认！");
            return;
        }

        for (int i=0;i<id.length();i++){
            if(id.charAt(i)<'0'||id.charAt(i)>'9'){
                JOptionPane.showMessageDialog(null, "学号格式不正确，应只包含数字！");
                return;
            }
        }

        //判断该学生是否已经在队伍中、判断该学生是否已经注册
        if (DAO.isInTeam(id,DAO.TeamId)){
            JOptionPane.showMessageDialog(null, "学生已经在队伍中，无需重复加入！");
            return;
        }

        if (!DAO.isRegistered(id)){
            JOptionPane.showMessageDialog(null, "学号为‘"+id+"’的学生尚未注册，注册后才能加入队伍！");
            return;
        }

        DAO.addTeamMatesInfo(id,DAO.TeamId);
        JOptionPane.showMessageDialog(null, "添加队员成功，请刷新查看！");
        return;
    }

    private void button13MouseClicked(MouseEvent e) throws SQLException {
        //删除队员信息

        String id;
        id = textField5.getText();
        if (id.length()==0){
            JOptionPane.showMessageDialog(null, "学号不允许为空！");
            return;
        }
        if (id.length()!=12){
            JOptionPane.showMessageDialog(null, "学号位数不正确，请重新确认！");
            return;
        }

        //不在队伍中
        if (!DAO.isInTeam(id,DAO.TeamId)){
            JOptionPane.showMessageDialog(null, "该学生不在队伍中，无法删除！");
            return;
        }
        DAO.delTeamMatesInfo(id,DAO.TeamId);
        JOptionPane.showMessageDialog(null, "删除队员成功，请刷新查看！");
        return;

    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button12MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button6 = new JButton();
        label6 = new JLabel();
        textField3 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        textField4 = new JTextField();
        button9 = new JButton();
        label10 = new JLabel();
        button10 = new JButton();
        welcom_lable2 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label11 = new JLabel();
        textField5 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(10, 50, 655, 145);

        //---- button6 ----
        button6.setText("\u786e\u5b9a\u67e5\u8be2");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button6MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button6);
        button6.setBounds(730, 115, 95, 30);

        //---- label6 ----
        label6.setText("\u8bf7\u8f93\u5165\u9879\u76ee\u540d\u79f0\u5173\u952e\u5b57\u8fdb\u884c\u67e5\u8be2\uff1a");
        contentPane.add(label6);
        label6.setBounds(695, 15, 195, 45);
        contentPane.add(textField3);
        textField3.setBounds(700, 65, 175, 40);

        //---- button7 ----
        button7.setText("\u663e\u793a\u6240\u6709\u9879\u76ee\u4fe1\u606f");
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button7MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button7);
        button7.setBounds(75, 210, 135, 40);

        //---- button8 ----
        button8.setText("\u663e\u793a\u5df2\u62a5\u540d\u9879\u76ee\u4fe1\u606f");
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button8MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button8);
        button8.setBounds(275, 210, 150, 40);

        //---- label7 ----
        label7.setText("-----------------------------------------");
        contentPane.add(label7);
        label7.setBounds(705, 210, 205, 17);

        //---- label8 ----
        label8.setText("\u9879\u76ee\u62a5\u540d\u7ba1\u7406\u533a\u57df");
        contentPane.add(label8);
        label8.setBounds(730, 180, 130, 32);

        //---- label9 ----
        label9.setText("\u9879\u76ee\u7f16\u53f7");
        contentPane.add(label9);
        label9.setBounds(695, 240, 65, 35);
        contentPane.add(textField4);
        textField4.setBounds(765, 235, 120, 40);

        //---- button9 ----
        button9.setText("\u786e\u8ba4\u62a5\u540d");
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button9MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button9);
        button9.setBounds(695, 285, 90, 35);

        //---- label10 ----
        label10.setText("-----------------------------------------");
        contentPane.add(label10);
        label10.setBounds(705, 160, 200, 17);

        //---- button10 ----
        button10.setText("\u53d6\u6d88\u62a5\u540d");
        button10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    cancleSignUpMouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button10);
        button10.setBounds(800, 285, 90, 35);

        //---- welcom_lable2 ----
        welcom_lable2.setBackground(Color.red);
        contentPane.add(welcom_lable2);
        welcom_lable2.setBounds(20, 10, 235, 35);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 265, 650, 140);

        //---- button11 ----
        button11.setText("\u663e\u793a\u6240\u6709\u6210\u5458");
        button11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button11MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button11);
        button11.setBounds(195, 425, 135, 40);

        //---- button12 ----
        button12.setText("\u6dfb\u52a0\u961f\u5458");
        button12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    addTeamMatesMouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button12);
        button12.setBounds(700, 450, 90, 30);

        //---- button13 ----
        button13.setText("\u5220\u9664\u961f\u5458");
        button13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    button13MouseClicked(e);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button13);
        button13.setBounds(805, 450, 95, 30);

        //---- label1 ----
        label1.setText("\u56e2\u961f\u4eba\u5458\u7ba1\u7406\u533a\u57df");
        contentPane.add(label1);
        label1.setBounds(745, 350, 155, 30);

        //---- label2 ----
        label2.setText("------------------------------------------");
        contentPane.add(label2);
        label2.setBounds(700, 330, 215, label2.getPreferredSize().height);

        //---- label11 ----
        label11.setText("\u961f\u5458\u5b66\u53f7");
        contentPane.add(label11);
        label11.setBounds(695, 395, 65, 35);
        contentPane.add(textField5);
        textField5.setBounds(770, 390, 120, 40);

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
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button6;
    private JLabel label6;
    private JTextField textField3;
    private JButton button7;
    private JButton button8;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField textField4;
    private JButton button9;
    private JLabel label10;
    private JButton button10;
    private JLabel welcom_lable2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JLabel label1;
    private JLabel label2;
    private JLabel label11;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
