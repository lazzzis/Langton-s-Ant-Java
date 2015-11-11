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
     ControlPanel con_pl = null;

    public App() {
        grid = Grids.getInstance();
        grid.setActionListener(this);

        ant = new Ant(Ant_Util.ANT_START_X, Ant_Util.ANT_START_Y, grid);
        ant_ths = new ArrayList();
        ant_ths.add(ant);
        new Thread(ant).start();

        con_pl = new ControlPanel(grid);

        frame = new JFrame();
        frame.add(grid, BorderLayout.CENTER);
        frame.add(con_pl, BorderLayout.SOUTH);

        frame.setTitle("Langtan's Ant");
        frame.setSize(Ant_Util.Win_Width, Ant_Util.Win_Height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.con_pl.isPuttingAnt()) {
            String str[] = e.getActionCommand().split(" ");
            int x = Integer.valueOf(str[0]);
            int y = Integer.valueOf(str[1]);
            ant = new Ant(x, y, grid);
            ant_ths = new ArrayList();
            ant_ths.add(ant);
            new Thread(ant).start();
        }
    }
}
