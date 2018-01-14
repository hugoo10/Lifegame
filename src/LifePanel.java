import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LifePanel extends JPanel implements KeyListener, MouseMotionListener, MouseListener {
    private World world = new World();
    private boolean displayGen = true;
    private boolean addMode = true;
    private boolean displayEmpty = true;


    public LifePanel() {
        super(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WIDTH_PX, Constants.HEIGHT_PX);

        g.setColor(Color.BLACK);
        for (int x = 0; x < world.getLife().length; x++) {
            for (int y = 0; y < world.getLife()[x].length; y++) {
                if (world.getLife()[x][y]) {
                    g.fillRect(x * Constants.ENTITY_SIZE_PX, y * Constants.ENTITY_SIZE_PX, Constants.ENTITY_SIZE_PX, Constants.ENTITY_SIZE_PX);
                } else {
                    if (displayEmpty) {
                        g.drawRect(x * Constants.ENTITY_SIZE_PX, y * Constants.ENTITY_SIZE_PX, Constants.ENTITY_SIZE_PX, Constants.ENTITY_SIZE_PX);
                    }
                }
            }
        }

        if (displayGen) {
            Font f = new Font("Sanserif", Font.BOLD | Font.ITALIC, 14);
            setFont(f);
            g.setColor(Color.RED);
            g.drawString("" + world.getGeneration(), Constants.WIDTH_PX / 2, Constants.HEIGHT_PX / 2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {
            world.computeNextTurn();
            this.repaint();
        }
        if (e.getKeyChar() == 'a') {
            this.displayGen = !displayGen;
            this.repaint();
        }
        if (e.getKeyChar() == 'd') {
            this.addMode = !addMode;
        }
        if (e.getKeyChar() == 'z') {
            this.displayEmpty = !displayEmpty;
            this.repaint();
        }
        if (e.getKeyChar() == 'n') {
            displayGen = true;
            addMode = true;
            world.init();
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        action(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        action(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void action(MouseEvent e) {
        int x = e.getX() / Constants.ENTITY_SIZE_PX;
        int y = e.getY() / Constants.ENTITY_SIZE_PX;
        try {
            this.world.getLife()[x][y] = this.addMode;
            this.repaint();
        }catch (ArrayIndexOutOfBoundsException  ex) {}
    }
}
