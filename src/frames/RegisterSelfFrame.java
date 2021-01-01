/*
 * Created by JFormDesigner on Thu Dec 31 19:44:34 CST 2020
 */

package frames;

import DB.DAO;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author yyy
 */
public class RegisterSelfFrame extends JFrame {
    public RegisterSelfFrame() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException {
        // 用户注册
        String id;
        String name;
        int age;
        String sex = "null";
        String progress;
        String clazz;
        String password;

        //学号
        id = id_text.getText();
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
        //姓名
        name = name_text.getText();
        if (name.length()==0){
            JOptionPane.showMessageDialog(null, "姓名不允许为空！");
            return;
        }
        if (name.length()>20){
            JOptionPane.showMessageDialog(null, "请检查姓名是否填写正确！");
            return;
        }
        //班级
        clazz = class_text.getText();
        if (clazz.length()==0){
            JOptionPane.showMessageDialog(null, "班级不允许为空！");
            return;
        }
        if (clazz.length()!=4){
            JOptionPane.showMessageDialog(null, "班级格式不正确，应为4位数字\n例如：1802");
            return;
        }
        //年龄
        String ageStr = age_text.getText();
        if (ageStr.length()==0){
            JOptionPane.showMessageDialog(null, "年龄不允许为空！");
            return;
        }
        for (int i=0;i<ageStr.length();i++){
            if(ageStr.charAt(i)<'0'||ageStr.charAt(i)>'9'){
                JOptionPane.showMessageDialog(null, "年龄格式不正确，应只包含数字！");
                return;
            }
        }
        age = Integer.valueOf(ageStr);
        if (age<=0||age>150){
            JOptionPane.showMessageDialog(null, "年龄范围不正确，请重新确认！");
            return;
        }
        //性别
        if (radioButton1.isSelected()){
            sex = "男";
        }
        if (radioButton2.isSelected()){
            sex = "女";
        }
        if (!radioButton1.isSelected()&&!radioButton2.isSelected()){
            JOptionPane.showMessageDialog(null, "请选择性别为‘男’或‘女’！");
            return;
        }
        //专业
        progress = pro_text.getText();
        if (progress.length()==0){
            JOptionPane.showMessageDialog(null, "专业不允许为空！");
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


        //查询是否已经注册
        if (DAO.isRegistered(id)){
            JOptionPane.showMessageDialog(null, "该学号已经注册，无需再次注册！");
            return;
        }

        //添加学生信息
        DAO.stuRegister(id,name,age,sex,progress,clazz,password);
        JOptionPane.showMessageDialog
                (null, "学号："+id+"\n密码:"+password+"\n注册成功，现在可以登录报名了！");
        this.dispose();
        return;

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        label1 = new JLabel();
        id_text = new JTextField();
        label2 = new JLabel();
        name_text = new JTextField();
        label3 = new JLabel();
        class_text = new JTextField();
        label4 = new JLabel();
        age_text = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        pro_text = new JTextField();
        button1 = new JButton();
        label7 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        label8 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7");
        contentPane.add(label1);
        label1.setBounds(135, 35, 40, 25);
        contentPane.add(id_text);
        id_text.setBounds(180, 30, 165, 30);

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        contentPane.add(label2);
        label2.setBounds(135, 80, 40, 25);
        contentPane.add(name_text);
        name_text.setBounds(180, 75, 165, 30);

        //---- label3 ----
        label3.setText("\u73ed\u7ea7");
        contentPane.add(label3);
        label3.setBounds(135, 120, 40, 25);
        contentPane.add(class_text);
        class_text.setBounds(180, 115, 165, 30);

        //---- label4 ----
        label4.setText("\u5e74\u9f84");
        contentPane.add(label4);
        label4.setBounds(135, 165, 40, 25);
        contentPane.add(age_text);
        age_text.setBounds(180, 160, 165, 30);

        //---- label5 ----
        label5.setText("\u6027\u522b");
        contentPane.add(label5);
        label5.setBounds(135, 215, 40, 25);

        //---- label6 ----
        label6.setText("\u4e13\u4e1a");
        contentPane.add(label6);
        label6.setBounds(135, 260, 40, 25);
        contentPane.add(pro_text);
        pro_text.setBounds(180, 255, 165, 30);

        //---- button1 ----
        button1.setText("\u7528\u6237\u6ce8\u518c");
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
        button1.setBounds(195, 395, 95, 30);

        //---- label7 ----
        label7.setText("\u8bbe\u7f6e\u5bc6\u7801");
        contentPane.add(label7);
        label7.setBounds(115, 305, 65, 25);

        //---- radioButton1 ----
        radioButton1.setText("\u7537");
        contentPane.add(radioButton1);
        radioButton1.setBounds(185, 220, 55, radioButton1.getPreferredSize().height);

        //---- radioButton2 ----
        radioButton2.setText("\u5973");
        contentPane.add(radioButton2);
        radioButton2.setBounds(255, 220, 55, radioButton2.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(180, 300, 160, 30);
        contentPane.add(passwordField2);
        passwordField2.setBounds(180, 340, 160, 30);

        //---- label8 ----
        label8.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label8);
        label8.setBounds(115, 345, 65, 25);

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

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yyy
    private JLabel label1;
    private JTextField id_text;
    private JLabel label2;
    private JTextField name_text;
    private JLabel label3;
    private JTextField class_text;
    private JLabel label4;
    private JTextField age_text;
    private JLabel label5;
    private JLabel label6;
    private JTextField pro_text;
    private JButton button1;
    private JLabel label7;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
