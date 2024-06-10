import javax.swing.SwingUtilities;

public class Controller {
    private Model model;
    private View view;
    private GeometryBoard geometryBoard;

    public Controller(Model model, View view, GeometryBoard geometryBoard) {
        this.model = model;
        this.view = view;
        this.geometryBoard = geometryBoard;

        view.buttonCalculate(new ButtonCalculateListener(view, this, geometryBoard));
        view.comboBoxListener(new ComboBoxListener(geometryBoard));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            View view = new View();
            GeometryBoard geometryBoard = new GeometryBoard();
            new Controller(model, view, geometryBoard);
        });
    }
}


// public double getUserInputRadius() {
//     String radiusString = view.getUserInputRadius().getText();
//     return Double.parseDouble(radiusString);
// }

// public double getUserInputHeight() {
//     String heightString = view.getUserInputHeight().getText();
//     return Double.parseDouble(heightString);
// }

// public void updateTextArea(String text) {
//     view.getTextArea().append(text);   // Assuming getTextArea exists in View
// }