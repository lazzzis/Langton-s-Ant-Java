import javax.swing.*;

/**
 * Created by lazzzis on 10/14/15.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Grids grid = new Grids();
        Ant ant = new Ant(50, 50, grid);
        new Thread(ant).start();

        frame.add(grid);
        frame.setTitle("Langtan's Ant");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
