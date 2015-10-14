import javax.swing.*;
import java.awt.*;

/**
 * Created by lazzzis on 10/14/15.
 */
public class Grids extends Container {
    // every button is a grid
    private JButton[][] grid = new JButton[Ant_Util.Height][Ant_Util.Width];

    public Grids() {
        this.setLayout(new GridLayout(Ant_Util.Height, Ant_Util.Width));
        for (int i = 0; i < Ant_Util.Height; ++ i) {
            for (int j  = 0; j < Ant_Util.Width; ++ j) {
                grid[i][j] = new JButton();
                grid[i][j].setBackground(Ant_Util.white);
                this.add(grid[i][j]);
            }
        }
    }

    public Color getColor(int x, int y) {
        return grid[x][y].getBackground();
    }

    public void setColor(int x, int y, Color c) {
        grid[x][y].setBackground(c);
    }
}
