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
        // System.out.println("ActionPerformed called");

        System.out.println("Valitud kujund (ComboBoxListener): " + selectedShape);
        
        // teeb sisestuskastid uueks valikuks tyhjaks
        geometryBoard.getUserInputRadius().setText("");
        geometryBoard.getUserInputHeight().setText("");
        
        if (selectedShape.equals("Kera")) {
            geometryBoard.getUserInputHeight().setVisible(false);
            geometryBoard.getLblHeight().setVisible(false);
            geometryBoard.getUserInputRadius().setVisible(true);
            geometryBoard.getLblRadius().setVisible(true);
            System.out.println("Kera arvutama");
        } else if (selectedShape.equals("Silinder")) {
            geometryBoard.getUserInputRadius().setVisible(true);
            geometryBoard.getLblRadius().setVisible(true);
            geometryBoard.getUserInputHeight().setVisible(true);
            geometryBoard.getLblHeight().setVisible(true);
            System.out.println("Silindrit arvutama");
        }
    }
}
