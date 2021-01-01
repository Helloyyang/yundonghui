/*
 * Created by JFormDesigner on Thu Dec 31 19:45:06 CST 2020
 */

package frames;

import DB.DAO;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author yyy
 */
public class RegisterTeamFrame extends JFrame {
    public RegisterTeamFrame() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException {
        // 团队注册
        String id;
        String name;
        String password;
        //队长id
        id = teamid_text.getText();
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

        //队名
        name = teamName_text.getText();
        if (name.length()==0){
            JOptionPane.showMessageDialog(null, "姓名不允许为空！");
            return;
        }
        if (name.length()>30){
            JOptionPane.showMessageDialog(null, "请检查姓名是否填写正确！");
            return;
        }

        if (DAO.searchTeamName(name).next()){
            JOptionPane.showMessageDialog(null, "队名重复了，请换一个！");
            return;
        }
        //密码
        password = passwordField1.getText();
        if (password.length()==0){
            JOptionPane.showMessageDialog(null, "密码！");
            return;
        }
        if (password.length()<6||password.length()>20){
            JOptionPane.showMessageDialog(null, "密码位数不合理，应为6到20位！");
            return;
        }

        //确认密码
        if (!passwordField2.getText().equals(password)){
            JOptionPane.showMessageDialog(null, "两次密码不相同，请重新确认！");
            return;
        }

        //团队注册
        //判断当队长的队伍是否超过10个
        ResultSet resultSet = DAO.searchTeamNum(id);
        if (resultSet.getRow()>10){
            JOptionPane.showMessageDialog(null, "已经创建10个队伍了，不能继续创建了！");
            return;
        }


        int num = 202101;
        ResultSet rs = DAO.searchTeam(id);
        while (rs.next()){
            num++;
        }
        DAO.teamRegister(num,name,password);
        JOptionPane.showMessageDialog(null, "创建队伍成功\n队伍编号为："+num+"密码为："+password+"\n可以登录添加队伍成员了！");
        this.dispose();
        return;

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        label5 = new JLabel();
        teamid_text = new JTextField();
        label6 = new JLabel();
        teamName_text = new JTextField();
        button1 = new JButton();
        label7 = new JLabel();
        passwordField1 = new JPasswordField();
        label8 = new JLabel();
        passwordField2 = new JPasswordField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label5 ----
        label5.setText("\u961f\u957f\u5b66\u53f7");
        contentPane.add(label5);
        label5.setBounds(105, 65, 75, 25);
        contentPane.add(teamid_text);
        teamid_text.setBounds(175, 60, 165, 30);

        //---- label6 ----
        label6.setText("\u56e2\u961f\u540d");
        contentPane.add(label6);
        label6.setBounds(105, 110, 65, 25);
        contentPane.add(teamName_text);
        teamName_text.setBounds(175, 105, 165, 30);

        //---- button1 ----
        button1.setText("\u6ce8\u518c\u56e2\u961f");
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
        button1.setBounds(170, 260, 95, 35);

        //---- label7 ----
        label7.setText("\u8bbe\u7f6e\u5bc6\u7801");
        contentPane.add(label7);
        label7.setBounds(105, 155, 65, 25);
        contentPane.add(passwordField1);
        passwordField1.setBounds(175, 150, 165, 35);

        //---- label8 ----
        label8.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label8);
        label8.setBounds(105, 195, 65, 25);
        contentPane.add(passwordField2);
        passwordField2.setBounds(175, 190, 165, 35);

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
    private JLabel label5;
    private JTextField teamid_text;
    private JLabel label6;
    private JTextField teamName_text;
    private JButton button1;
    private JLabel label7;
    private JPasswordField passwordField1;
    private JLabel label8;
    private JPasswordField passwordField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
