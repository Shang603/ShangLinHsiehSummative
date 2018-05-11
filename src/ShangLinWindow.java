import javax.swing.*;
import java.awt.Frame;
public class ShangLinWindow extends JFrame{
    String name;
    static int width = 1300;
    static int height = 700;
    Player P1 = new Player(getRootPane());
    public ShangLinWindow(){
        setSize(width, height);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);

    }
}
