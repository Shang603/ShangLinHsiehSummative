import javax.swing.*;
public class Soldier extends Player {


    ImageIcon Standing = new ImageIcon(getClass().getResource("Test.png"));
//    ImageIcon RWalk = new ImageIcon(getClass().getResource("R_Norm_Wiz_Walk_v1.gif"));
//    ImageIcon RNormWizBlock = new ImageIcon(getClass().getResource("RBlock.gif"));
//    ImageIcon RNormWizJump = new ImageIcon(getClass().getResource("R_Norm_Wiz_Jump_v2.gif"));
//    ImageIcon RNormWizPunch = new ImageIcon(getClass().getResource("R_Norm_Wiz_Punch_v3.gif"));
//    ImageIcon RNormWizSpin = new ImageIcon(getClass().getResource("R_Norm_Wiz_SPin_v1.gif"));
//    ImageIcon RNormWizLight = new ImageIcon(getClass().getResource("R_Norm_Wiz_Lightning_v4.gif"));

    public Soldier(){
    }
    public Soldier(JComponent rootPane){
        super();
        setPlayerKey(rootPane);
        Standing = imgRescaler(Standing, 50,50);
        setIcon(Standing);
        setBounds(0,100,50,50);
    }

}
