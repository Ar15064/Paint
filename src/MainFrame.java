import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame() {
        this.setVisible(true);
        this.setTitle("Paint");
        this.setSize(1980,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(new MainPanel());

        this.revalidate();
    }
}
