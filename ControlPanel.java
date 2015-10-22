import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lazzzis on 10/22/15.
 */
public class ControlPanel extends JPanel implements ActionListener {
    private Grids grid = null;
    private CusButton draw_btn = null,
                    put_ant_btn = null,
                    stop_btn = null,
                    clear_btn = null;
    // TODO: the stop and draw operation is temparily unavailable
    public ControlPanel(Grids g) {
        this.grid = g;

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.draw_btn = new CusButton("Paint Black");
        this.draw_btn.addActionListener(this);
//        this.add(draw_btn);

        this.put_ant_btn = new CusButton("Put an ant");
        this.put_ant_btn.addActionListener(this);
        this.add(put_ant_btn);

        this.clear_btn = new CusButton("Clear All");
        this.clear_btn.addActionListener(this);
        this.add(clear_btn);
    }

    public boolean isPuttingAnt() {
        return this.put_ant_btn.isPressed();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clear_btn) {
            for (int i = 0; i < Ant_Util.Grid_Height; ++ i) {
                for (int j = 0; j < Ant_Util.Grid_Width; ++ j) {
                    grid.setColor(i, j, Ant_Util.white);
                }
            }
        } else if (e.getSource() == this.draw_btn) {
            if (this.draw_btn.isPressed()) {
                this.grid.setCursor(Cursor.getDefaultCursor());
            } else {
                this.grid.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                this.draw_btn.changePressed();
            }
        } else if (e.getSource() == this.put_ant_btn) {
            if (this.put_ant_btn.isPressed()) {
                this.grid.setCursor(Cursor.getDefaultCursor());
                this.put_ant_btn.setText("Put an ant");
            } else {
                this.grid.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                this.put_ant_btn.changePressed();
                this.put_ant_btn.setText("Click here to end putting");
            }
        }
    }
}
