/*
 * Created by JFormDesigner on Mon Dec 28 21:46:12 CST 2020
 */

package frames;

import DB.DAO;

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
        //个人注册
        JFrame registerSelfFrame = new RegisterSelfFrame();
        registerSelfFrame.setMinimumSize(new Dimension(490, 495));
        this.dispose();
        registerSelfFrame.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        // 团队注册
        JFrame registerTeamFrame = new RegisterTeamFrame();
        registerTeamFrame.setMinimumSize(new Dimension(465, 355));
        this.dispose();
        registerTeamFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yyy
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u7528\u6237\u4e2a\u4eba\u6ce8\u518c");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(40, 90, 120, 70);

        //---- button2 ----
        button2.setText("\u56e2\u961f\u6ce8\u518c");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(190, 90, 135, 70);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
