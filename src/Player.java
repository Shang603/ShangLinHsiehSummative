
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Player extends JLabel{
    Timer move, jump;
    int moveSpeed;
    int[][] P1Keys = new int[2][6];
    boolean[][] keyPressed = new boolean[2][6];
    JLabel object = new JLabel();
    int direction = 0;//1 = foward, 2 = left , 3 = bot , 4 = right
    float gravity = 0.05f;

    public Player(JComponent a) {
        defaultConstructorHelper();
        setP1Keys(a);
    }

    void defaultConstructorHelper() {
        //initializes the boolean array with all false
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i < keyPressed.length; i++) {
                keyPressed[i][i2] = false;
            }
        }

    }


//    void gravity(int delay, ActionListener actionlistener) {
//        move = new Timer(delay, e -> {
//            object.setLocation(object.getX(), object.getY() - 5);
//        });
//
//    }

    void setP1Keys(JComponent rootPane) {//add, ImageIcon[][] allPic
        addKeyBinder(rootPane, KeyEvent.VK_ESCAPE, "Exit", e -> {

            System.exit(0);

        });
        addKeyBinder(rootPane, KeyEvent.VK_W, "Fowards", e -> {
            direction = 1;
        });
        addKeyBinder(rootPane, KeyEvent.VK_A, "Left", e -> {
            direction = 2;
        });
        addKeyBinder(rootPane, KeyEvent.VK_S, "Backwards", e -> {
            direction = 3;
        });
        addKeyBinder(rootPane, KeyEvent.VK_D, "Right", e -> {
            direction = 4;
        });
        addKeyBinder(rootPane, KeyEvent.VK_SPACE, "Shoot", e -> {

        });
        addKeyBinder(rootPane, KeyEvent.VK_R, "Reload", e -> {

        });
    }


    // Helper used to set keybindings
    public void addKeyBinder(JComponent component, int keyNum, String keyId, ActionListener actionListener) {
        InputMap IM = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap AM = component.getActionMap();

        IM.put(KeyStroke.getKeyStroke(keyNum, 0, false), "pressed once" + keyId);
        AM.put("pressed once" + keyId, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
    }

    //helper used to set keybindings that u may hold the button
    public void addKeyBinder(JComponent component, int keyNum, String keyId, ActionListener actionListenerPress, ActionListener actionListenerRelease) {
        InputMap IM = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap AM = component.getActionMap();

        IM.put(KeyStroke.getKeyStroke(keyNum, 0, false), "Pressed" + keyId);//false, action done when u press
        IM.put(KeyStroke.getKeyStroke(keyNum, 0, true), "Released" + keyId);//true, action done when u releasew
        AM.put("Pressed " + keyId, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListenerPress.actionPerformed(e);
            }
        });

        AM.put("Released " + keyId, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListenerRelease.actionPerformed(e);
            }
        });

    }

    void movedirection(int delay, int speed) {
        move = new Timer(delay, e-> {
            switch (direction ){
                case 1: object.setLocation(object.getLocation().x , object.getY()+speed);break;
                case 2: object.setLocation(object.getLocation().x-speed , object.getY());break;
                case 3: object.setLocation(object.getLocation().x , object.getY()-speed);break;
                case 4: object.setLocation(object.getLocation().x+speed , object.getY());
            }
        });



    }

    

}
