import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by lazzzis on 10/15/15.
 */
public class App implements ActionListener {

    JFrame frame = null;
    Grids grid = null;
    Ant ant = null;
    ArrayList<Ant> ant_ths = null;

    public App() {

        grid = new Grids();
        ant = new Ant(Ant_Util.ANT_START_X, Ant_Util.ANT_START_Y, grid);
        ant_ths = new ArrayList();
        ant_ths.add(ant);
        new Thread(ant).start();

        JPanel bottom_pl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton clear_btn = new JButton("Clear ALL");
        clear_btn.addActionListener(this);
        bottom_pl.add(clear_btn);


        frame = new JFrame();
        frame.add(grid, BorderLayout.CENTER);
        frame.add(bottom_pl, BorderLayout.SOUTH);

        frame.setTitle("Langtan's Ant");
        frame.setSize(Ant_Util.Win_Width, Ant_Util.Win_Height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Ant_Util.Grid_Height; ++ i) {
            for (int j = 0; j < Ant_Util.Grid_Width; ++ j) {
                grid.setColor(i, j, Ant_Util.white);
            }
        }
    }
}
