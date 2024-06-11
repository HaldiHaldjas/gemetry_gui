
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

    public void handleFileOperation(String filePath) {
        geometryBoard.setFilePath(filePath);
    }
}