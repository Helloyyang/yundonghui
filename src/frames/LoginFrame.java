/*
 * Created by JFormDesigner on Mon Dec 28 21:40:11 CST 2020
 */

package frames;

import DB.DAO;
import com.sun.tools.javac.Main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author yyy
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
    }

    String name;
    String password;
    private void button1MouseClicked(MouseEvent e) throws SQLException {
        // 用户登录
        name = loginName.getText();
        password = loginPassword.getText();
        if (name.length()==0||password.length()==0){
            JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
            return;
        }

        if (name.length()!=12){
            JOptionPane.showMessageDialog(null, "账号位数不正确，请重新确认！");
            return;
        }

        for (int i=0;i<name.length();i++){
            if(name.charAt(i)<'0'||name.charAt(i)>'9'){
                JOptionPane.showMessageDialog(null, "账号格式不正确，应只包含数字！");
                return;
            }
        }

        if (DAO.logStu(name,password)){
            JFrame stuFrame = new UserFrame();
            stuFrame.setMinimumSize(new Dimension(815, 500));
            this.dispose();
            stuFrame.setVisible(true);
            DAO.StuId = name;
            JOptionPane.showMessageDialog(null, "登录成功！");
        }else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误！");
        }
    }

    private void button4MouseClicked(MouseEvent e) throws SQLException {
        // 用户团队登录
        name = loginName.getText();
        password = loginPassword.getText();
        if (name.length()==0||password.length()==0){
            JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
            return;
        }

        if (DAO.logTeam(name,password)){
            JFrame teamFrame = new TeamFrame();
            teamFrame.setMinimumSize(new Dimension(670, 465));
            this.dispose();
            teamFrame.setVisible(true);
            JOptionPane.showMessageDialog(null, "登录成功！");
        }else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误！");
        }
    }

    private void button2MouseClicked(MouseEvent e) throws SQLException {
        // 管理员登录
        name = loginName.getText();
        password = loginPassword.getText();
        if (name.length()==0||password.length()==0){
            JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
            return;
        }

        if (DAO.logMan(name,password)){
            JFrame manFrame = new ManFrame();
            manFrame.setMinimumSize(new Dimension(670, 465));
            this.dispose();
            manFrame.setVisible(true);
            JOptionPane.showMessageDialog(null, "登录成功！");
        }else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误！");
        }

    }

    private void button3MouseClicked(MouseEvent e) {
        // 用户注册
        JFrame registerFrame = new RegisterFrame();
        registerFrame.setMinimumSize(new Dimension(355, 275));
        registerFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        loginName = new JTextField();
        loginPassword = new JPasswordField();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u7528\u6237\u4e2a\u4eba\u767b\u5f55");
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
        button1.setBounds(75, 150, 115, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u7ba1\u7406\u5458\u767b\u5f55");
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
        button2.setBounds(new Rectangle(new Point(95, 200), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u6ce8\u518c");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(215, 200, 60, 30);

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        contentPane.add(label1);
        label1.setBounds(80, 55, 40, 25);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2);
        label2.setBounds(80, 95, 40, 25);
        contentPane.add(loginName);
        loginName.setBounds(130, 55, 185, 25);
        contentPane.add(loginPassword);
        loginPassword.setBounds(130, 95, 185, 25);

        //---- button4 ----
        button4.setText("\u7528\u6237\u56e2\u961f\u767b\u5f55");
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
        button4.setBounds(210, 150, 115, 30);

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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JLabel label2;
    private JTextField loginName;
    private JPasswordField loginPassword;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
