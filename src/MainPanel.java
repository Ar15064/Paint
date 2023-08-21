import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

public class MainPanel extends JPanel {
    JLabel showingLocation = new JLabel("");
    boolean check = false;
    ImageIcon brushI;
    JLabel brush;


    int storeX = 751;
    int storeY = 346;
    MainPanel() {
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.setLayout(new GridBagLayout());
        mouseListenerInner MLI = new mouseListenerInner();
        this.addMouseMotionListener(MLI);
        this.addMouseListener(MLI);
        this.add(showingLocation);
        ImageIcon brushI = new ImageIcon("C:\\Users\\alekr\\IdeaProjects\\Paint\\src\\rec\\PaintBrush1.jpg");
        brushI.setImage(brushI.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
        brush = new JLabel(brushI);
        this.add(brush);

    }
    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        g.setColor(Color.BLACK);
//        g.fillOval(storeX, storeY, 10, 10);

    }

    private class mouseListenerInner implements MouseMotionListener, MouseListener {
        @Override
        public void mouseDragged(MouseEvent e ) {

            storeX = e.getX();
            storeY = e.getY();
            showingLocation.setText(toString(e.getLocationOnScreen()));

            brush.setLocation(e.getX(),e.getY());


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



}
