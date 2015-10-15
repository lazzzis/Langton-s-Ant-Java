import java.awt.*;

/**
 * Created by lazzzis on 10/14/15.
 */
public class Ant implements Runnable {

    int x, y, forward;
    private Grids grid = null;
    private boolean alive;

    public Ant(int x, int y, Grids grid) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.alive = true;
        if (grid.getColor(x, y) == Ant_Util.white) {
            this.forward = Ant_Util.RIGHT;
        } else {
            this.forward = Ant_Util.LEFT;
        }
    }

    public void run() {
        // record the original color of grid[x][y]
        Color ori_color = grid.getColor(x, y);
        int old_x, old_y;
        while (this.alive) {
            old_x = x;
            old_y = y;
            // black : turn left
            if (ori_color == Ant_Util.black ) {
                grid.setColor(old_x, old_y, Ant_Util.white);
                this.turn_left();
                ori_color = grid.getColor(x, y);
                grid.setColor(x, y, Ant_Util.red);
            } else { // white : turn right
                grid.setColor(old_x, old_y, Ant_Util.black);
                this.turn_right();
                ori_color = grid.getColor(x, y);
                grid.setColor(x, y, Ant_Util.red);
            }
            stay_idle();
        }
    }

    // stay idle for next step; and this function controls the speed
    private void stay_idle() {
        try {
            Thread.sleep(Ant_Util.ANT_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void terminal() {
        this.alive = false;
    }

    private void turn_left() {
        switch (this.forward) {
            case Ant_Util.UP:
                -- y;
                this.forward = Ant_Util.LEFT;
                break;
            case Ant_Util.DOWN:
                ++ y;
                this.forward = Ant_Util.RIGHT;
                break;
            case Ant_Util.LEFT:
                ++ x;
                this.forward = Ant_Util.DOWN;
                break;
            case Ant_Util.RIGHT:
                -- x;
                this.forward = Ant_Util.UP;
                break;
        }
        check();
    }

    private void turn_right() {
        switch (this.forward) {
            case Ant_Util.UP:
                ++ y;
                this.forward = Ant_Util.RIGHT;
                break;
            case Ant_Util.DOWN:
                -- y;
                this.forward = Ant_Util.LEFT;
                break;
            case Ant_Util.LEFT:
                -- x;
                this.forward = Ant_Util.UP;
                break;
            case Ant_Util.RIGHT:
                ++ x;
                this.forward = Ant_Util.DOWN;
                break;
        }
        check();
    }

    private void check() {
        if (x == Ant_Util.Grid_Height) {
            x = 0;
        } else if (x < 0) {
            x = Ant_Util.Grid_Height - 1;
        }
        if (y == Ant_Util.Grid_Width) {
            y = 0;
        } else if (y < 0) {
            y = Ant_Util.Grid_Width - 1;
        }
    }
}
