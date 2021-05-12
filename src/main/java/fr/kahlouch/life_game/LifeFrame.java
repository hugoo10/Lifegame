package fr.kahlouch.life_game;

import javax.swing.*;
import java.awt.*;

public class LifeFrame extends JFrame {

    public LifeFrame() throws HeadlessException {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, Constants.WIDTH_PX, Constants.HEIGHT_PX);
        //this.setBounds(0, 0, 50, 50);

        LifePanel lifePanel = new LifePanel();
        this.addKeyListener(lifePanel);
        this.addMouseMotionListener(lifePanel);
        this.addMouseListener(lifePanel);
        this.setContentPane(lifePanel);

        this.setVisible(true);

    }
}
