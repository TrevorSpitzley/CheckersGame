import javax.swing.*;
import java.awt.*;

public class CheckersGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkers Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CheckersPanel panel = new CheckersPanel();
        frame.getContentPane().add(panel);

        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.pack();
        frame.setVisible(true);
    }
}
