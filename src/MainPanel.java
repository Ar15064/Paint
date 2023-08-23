import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class MainPanel extends JPanel implements MouseMotionListener, MouseListener {
    JLabel showingLocation = new JLabel("");

    int storeX = 751;
    int storeY = 346;
    JLabel brush;

    JButton clear = new JButton("Click to Clear");
    MainPanel() {
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.add(showingLocation);
        ImageIcon brushI = new ImageIcon("C:\\Users\\alekr\\IdeaProjects\\Paint\\src\\rec\\PaintBrush.png");
        brushI.setImage(brushI.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\alekr\\IdeaProjects\\Paint\\src\\rec\\PaintBrush.png");
        Cursor c = toolkit.createCustomCursor(image , new Point(this.getX(),
                this.getY()), "img");
        this.setCursor (c);

    }


        @Override
        public void mouseDragged(MouseEvent e) {
            storeX = e.getX();
            storeY = e.getY();
            Graphics g = this.getGraphics();
            showingLocation.setText(toString(e.getLocationOnScreen()));
            g.fillOval(storeX,storeY,40,40);


        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        public String toString(Point e) {

            String help = String.valueOf(e.getLocation());
            int store1 = 0;
            int store2 = 0;
            for (int i = 0; i < help.length(); i++) {
                if(help.charAt(i) == 'x') {
                    store1 = i;
                }

                else if(help.charAt(i) == ']') {
                    store2 = i;

                    break;
                }
            }

            return help.substring(store1, store2);
        }
        @Override
        public void mouseClicked(MouseEvent e) {

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

            System.out.println("no more");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }




}