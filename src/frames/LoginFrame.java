/*
 * Created by JFormDesigner on Mon Dec 28 21:40:11 CST 2020
 */

package frames;

import javax.swing.*;
import java.awt.*;

/**
 * @author yyy
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
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

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u7528\u6237\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 160), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u7ba1\u7406\u5458\u767b\u5f55");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(225, 160), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u6ce8\u518c");
        contentPane.add(button3);
        button3.setBounds(175, 230, 60, 30);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
