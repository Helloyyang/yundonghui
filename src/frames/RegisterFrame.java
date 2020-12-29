/*
 * Created by JFormDesigner on Mon Dec 28 21:46:12 CST 2020
 */

package frames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * @author yyy
 */
public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        label1 = new JLabel();
        id_text = new JTextField();
        label2 = new JLabel();
        name_text = new JTextField();
        label3 = new JLabel();
        author_text = new JTextField();
        label4 = new JLabel();
        pub_text = new JTextField();
        label5 = new JLabel();
        num_text = new JTextField();
        label6 = new JLabel();
        type_text = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u59d3\u540d");
        contentPane.add(label1);
        label1.setBounds(155, 35, 40, 25);
        contentPane.add(id_text);
        id_text.setBounds(200, 30, 165, 30);

        //---- label2 ----
        label2.setText("\u73ed\u7ea7");
        contentPane.add(label2);
        label2.setBounds(155, 80, 40, 25);
        contentPane.add(name_text);
        name_text.setBounds(200, 75, 165, 30);

        //---- label3 ----
        label3.setText("\u5e74\u9f84");
        contentPane.add(label3);
        label3.setBounds(155, 120, 40, 25);
        contentPane.add(author_text);
        author_text.setBounds(200, 115, 165, 30);

        //---- label4 ----
        label4.setText("\u6027\u522b");
        contentPane.add(label4);
        label4.setBounds(155, 165, 40, 25);
        contentPane.add(pub_text);
        pub_text.setBounds(200, 160, 165, 30);

        //---- label5 ----
        label5.setText("\u4e13\u4e1a");
        contentPane.add(label5);
        label5.setBounds(155, 215, 40, 25);
        contentPane.add(num_text);
        num_text.setBounds(200, 210, 165, 30);

        //---- label6 ----
        label6.setText("\u7c7b\u578b");
        contentPane.add(label6);
        label6.setBounds(155, 260, 40, 25);
        contentPane.add(type_text);
        type_text.setBounds(200, 255, 165, 30);

        //---- button1 ----
        button1.setText("\u7528\u6237\u6ce8\u518c");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(240, 330, 75, 30);

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
    private JLabel label1;
    private JTextField id_text;
    private JLabel label2;
    private JTextField name_text;
    private JLabel label3;
    private JTextField author_text;
    private JLabel label4;
    private JTextField pub_text;
    private JLabel label5;
    private JTextField num_text;
    private JLabel label6;
    private JTextField type_text;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
