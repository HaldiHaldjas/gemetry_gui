import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame {
    private GeometryBoard geometryBoard;
    
    public View() {
        super("Geomeetrilised kujundid");
        geometryBoard = new GeometryBoard(); // raami loomine 
        JPanel container = new JPanel(new BorderLayout());
        container.add(geometryBoard, BorderLayout.CENTER);
        this.add(container);
    }

    public void buttonCalculate(ActionListener al) {
        geometryBoard.getBtnCalculate().addActionListener(al);
    }

    public void comboBoxListener(ActionListener al) {
        geometryBoard.getCmbShapes().addActionListener(al);
    }

    public JTextField getUserInputRadius(){
        return geometryBoard.getUserInputRadius();
    }

    public JTextField getUserInputHeight(){
        return geometryBoard.getUserInputHeight();
    }

    public void updateTextArea(String text, boolean clear) {
        // tekstikast puhtaks
        if (clear) {
            geometryBoard.getTextArea().setText(""); 
        }
        geometryBoard.getTextArea().append(text);   
    }

    public GeometryBoard getGeometryBoard() {
        return geometryBoard;
    }

}
