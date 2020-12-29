import DB.DAO;
import frames.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        System.out.println();

        JFrame loginFrame = new LoginFrame();
        loginFrame.setMinimumSize(new Dimension(400, 300));
        loginFrame.setVisible(true);
    }
}
