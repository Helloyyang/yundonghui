import frames.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame loginFrame = new LoginFrame();
        loginFrame.setMinimumSize(new Dimension(400, 300));
        loginFrame.setVisible(true);
    }
}
