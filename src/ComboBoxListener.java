import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxListener implements ActionListener {

    private GeometryBoard geometryBoard;

    public ComboBoxListener(GeometryBoard geometryBoard) {
        this.geometryBoard = geometryBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedShape = (String) geometryBoard.getCmbShapes().getSelectedItem();
        if (selectedShape.equals("Sphere")) {
            geometryBoard.getUserInputHeight().setVisible(false);
            geometryBoard.getLblHeight().setVisible(false);
            geometryBoard.getUserInputRadius().setVisible(true);
            geometryBoard.getLblRadius().setVisible(true);
        } else if (selectedShape.equals("Cylinder")) {
            geometryBoard.getUserInputRadius().setVisible(true);
            geometryBoard.getLblRadius().setVisible(true);
            geometryBoard.getUserInputHeight().setVisible(true);
            geometryBoard.getLblHeight().setVisible(true);
        }
    }
}
