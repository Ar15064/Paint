import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;


public class MainPanel extends JPanel implements MouseMotionListener, ActionListener{

    JLabel showingLocation = new JLabel("");

    int storeX = 751;
    int storeY = 346;

    JButton clear = new JButton("Click to Clear");
    MainPanel() {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(this);

        clear.addActionListener(this);
        ImageIcon brushI = new ImageIcon("C:\\Users\\alekr\\IdeaProjects\\Paint\\src\\rec\\PaintBrush.png");
        brushI.setImage(brushI.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("C:\\Users\\alekr\\IdeaProjects\\Paint\\src\\rec\\PaintBrush.png");
        Cursor c = toolkit.createCustomCursor(image , new Point(this.getX(),this.getY()), "img");
        this.setCursor(c);

        addingStuff();
    }


    public void addingStuff() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.weighty = 1;
        constraints.weightx = 2;
        constraints.gridy = 0;
        this.add(showingLocation,constraints);

        constraints.weighty = 30;
        constraints.weightx = 2;
        constraints.gridy = 1;
        this.add(clear,constraints);
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
                if (help.charAt(i) == 'x') {
                    store1 = i;
                } else if (help.charAt(i) == ']') {
                    store2 = i;

                    break;
                }
            }

            return help.substring(store1, store2);
        }
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());

        if(e.getActionCommand().equals(clear.getText())) {
            repaint();
        }

    }
}