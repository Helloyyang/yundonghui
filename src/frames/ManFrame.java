/*
 * Created by JFormDesigner on Mon Dec 28 21:45:27 CST 2020
 */

package frames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * @author yyy
 */
public class ManFrame extends JFrame {
    public ManFrame() {
        initComponents();
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

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
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
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button10 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u6bd4\u8d5b\u4fe1\u606f");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(505, 35, 95, 30);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 10, 465, 470);

        //---- button3 ----
        button3.setText("\u6dfb\u52a0\u6bd4\u8d5b");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(505, 95, 95, 30);

        //---- button4 ----
        button4.setText("\u67e5\u627e\u6bd4\u8d5b");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
                button4MouseClicked(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(505, 155, 95, 30);

        //---- button5 ----
        button5.setText("\u5220\u9664\u6bd4\u8d5b");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(505, 215, 95, 30);

        //---- button10 ----
        button10.setText("\u4fee\u6539\u6bd4\u8d5b\u4fe1\u606f");
        contentPane.add(button10);
        button10.setBounds(505, 280, 110, 30);

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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
