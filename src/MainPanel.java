import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

public class MainPanel extends JPanel {

    JLabel showingLocation = new JLabel("");
    boolean check = false;
    int storeX = 0;
    int storeY = 0;
    MainPanel() {
        this.setVisible(true);
        this.setBackground(Color.WHITE);

        mouseListenerInner MLI = new mouseListenerInner();

        this.add(showingLocation);

        this.addMouseMotionListener(MLI);

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillOval(storeX, storeY, 10, 10);
        repaint();




    }


    private class mouseListenerInner implements MouseMotionListener, MouseListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            check = true;
            storeX = e.getX();
            storeY = e.getY();
            showingLocation.setText(toString(e.getLocationOnScreen()));


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
            check = false;
            System.out.println("no more");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("no more");

        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("no more");
        }
    }






}
