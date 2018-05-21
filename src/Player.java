
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;
public class Player extends JLabel{
    Timer moveTimer, bulletTimer;
    int moveSpeed = 5;
    int[][] P1Keys = new int[2][6];
    boolean[][] keyPressed = new boolean[2][6];
    int direction = -1;//1 = foward, 2 = left , 3 = bot , 4 = right
    float gravity = 0.05f;

    public Player() {
        defaultConstructorHelper();
        actualMoving(10, e-> {

            moveDirection(this,moveSpeed);

        });
        moveTimer.start();
    }

    void defaultConstructorHelper() {
        //initializes the boolean array with all false
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i < keyPressed.length; i++) {
                keyPressed[i][i2] = false;
            }
        }

    }



//   add the player keys
//boolean MRight(){
//    if
//}
    void setPlayerKey(JComponent rootPane){

        P1Keys(rootPane);
    }
    //keys for Player 1
    void P1Keys(JComponent rootPane) {//add, ImageIcon[][] allPic
        addKeyBinder(rootPane, KeyEvent.VK_ESCAPE, "Exit", e -> {

            System.exit(0);

        });
        addKeyBinder(rootPane, KeyEvent.VK_W, "Fowards", e -> {
            direction = 1;

        }, e-> {
            Rmoving(1);
        });
        addKeyBinder(rootPane, KeyEvent.VK_A, "Left", e -> {
            direction = 2;

        }, e-> {
            Rmoving(2);
        });
        addKeyBinder(rootPane, KeyEvent.VK_S, "Backwards", e -> {
            direction = 3;

        }, e-> {
            Rmoving(3);
        });
        addKeyBinder(rootPane, KeyEvent.VK_D, "Right", e -> {
            direction = 4;
        }, e-> {
            Rmoving(4);
        });
        addKeyBinder(rootPane, KeyEvent.VK_SPACE, "Shoot", e -> {

        }, e-> {

        });
        addKeyBinder(rootPane, KeyEvent.VK_R, "Reload", e -> {

        });
    }

    //Check if character is still moving the same direction, if so stop, if not continue to the new direction
    void  Rmoving(int originalDirection){

        if (originalDirection == direction ){
            direction = 0;
        }

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
    void addKeyBinder(JComponent component, int keyNum, String keyId, ActionListener actionListenerPress, ActionListener actionListenerRelease) {
        InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap ap = component.getActionMap();


        im.put(KeyStroke.getKeyStroke(keyNum, 0, false), "Pressed " + keyId);
        im.put(KeyStroke.getKeyStroke(keyNum, 0, true), "Released " + keyId);

        ap.put("Pressed " + keyId, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListenerPress.actionPerformed(e);
            }
        });

        ap.put("Released " + keyId, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListenerRelease.actionPerformed(e);
            }
        });


    }

//    public void addKeyBinder(JComponent component, int keyNum, String keyId, ActionListener actionListenerPress, ActionListener actionListenerRelease) {
//        InputMap IM = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        ActionMap AM = component.getActionMap();
//
//        IM.put(KeyStroke.getKeyStroke(keyNum, 0, false), "Pressed" + keyId);//false, action done when u press
//        IM.put(KeyStroke.getKeyStroke(keyNum, 0, true), "Released" + keyId);//true, action done when u releasew
//
//        AM.put("Pressed " + keyId, new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                actionListenerPress.actionPerformed(e);
//
//            }
//        });
//
//        AM.put("Released " + keyId, new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                actionListenerRelease.actionPerformed(e);
//
//            }
//        });
//
//    }

    void actualMoving(int delay, ActionListener actionListener) {

        moveTimer = new Timer(delay, e-> {
            actionListener.actionPerformed(e);
        });

    }
    void moveDirection(Object object, int speed) {
            switch (direction ){
                case 0: setLocation(getLocation().x , getLocation().y );break;
                case 1: setLocation(getLocation().x , getLocation().y - speed);break;
                case 2: setLocation(getLocation().x -speed , getY());break;
                case 3: setLocation(getLocation().x  , getLocation().y + speed);break;
                case 4: setLocation(getLocation().x +speed , getY());break;
            }

    }
    ImageIcon imgRescaler(ImageIcon img, int w, int h) {

        //complete magic here
        Image tempImg = img.getImage();
        ImageIcon out = new ImageIcon(tempImg.getScaledInstance(w, h, Image.SCALE_DEFAULT));
        return out;

    }


    

}
