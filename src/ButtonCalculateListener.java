
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.SwingUtilities;


public class ButtonCalculateListener implements ActionListener {
    // private Model model;
    private View view;
    private Controller controller;
    private GeometryBoard geometryBoard;


    public ButtonCalculateListener(View view, Controller controller, GeometryBoard geometryBoard) {
        // this.model = model;
        this.view = view;
        this.controller = controller;
        this.geometryBoard = geometryBoard;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            view.updateTextArea("", true);
        try {
            // kasutaja sisestus + parse string double'iks
            String radiusText = view.getUserInputRadius().getText().trim();
            String heightText = view.getUserInputHeight().getText().trim();
            
            double radius = Double.parseDouble(radiusText);
            double height = Double.parseDouble(heightText);

            // Determine which shape is selected
            String selectedShape = (String) geometryBoard.getCmbShapes().getSelectedItem();
            String shapeInfo = "";
            System.out.println("Selected Shape (from ButtonCalculateListener): " + selectedShape);


            // kera arvutused
            // double sphereSurfaceArea = model.calculateSphereSurfaceArea(radius);
            // double sphereCircumference = model.calculateSphereCircumference(radius);
            // double sphereVolume = model.calculateSphereVolume(radius);

            if (selectedShape.equals("Kera")) { // Sphere
                Sphere sphere = new Sphere(radius);
                double sphereSurfaceArea = sphere.calculateSurfaceArea();
                double sphereCircumference = sphere.calculateCircumference();
                double sphereVolume = sphere.calculateVolume();

                shapeInfo = "Kera pindala (S): " + sphereSurfaceArea + "\n" +
                            "Kera ümbermõõt (P): " + sphereCircumference + "\n" +
                            "Kera ruumala (V): " + sphereVolume + "\n";

            } else if (selectedShape.equals("Silinder")) { // Cylinder
                Cylinder cylinder = new Cylinder(radius, height);
                double cylinderSurfaceArea = cylinder.calculateSurfaceArea();
                double cylinderSideSurfaceArea = cylinder.calculateSideSurfaceArea();
                double cylinderVolume = cylinder.calculateVolume();
    
                shapeInfo = "Silindri kogupindala (S): " + cylinderSurfaceArea + "\n" +
                            "Silindri külgpindala (Sk): " + cylinderSideSurfaceArea + "\n" +
                            "Silindri ruumala (V): " + cylinderVolume + "\n";
            }

            // silindri arvutused
            // double cylinderSurfaceArea = model.calculateCylinderSurfaceArea(radius, height);
            // double cylinderSideSurfaceArea = model.calculateCylinderSideSurface(radius, height);
            // double cylinderVolume = model.calculateCylinderVolume(radius, height);

            // Textarea teksti ettevalmistus
            String outputString = "Raadius: " + radius + "\n" + shapeInfo;
                // "Kõrgus: " + height + "\n\n" +
                // "Kera ümbermõõt (P): " + sphereCircumference + "\n" +
                // "Kera pindala (S): " + sphereSurfaceArea + "\n" +
                // "Kera ruumala (V): " + sphereVolume + "\n\n" +
                // "Silindri kogupindala (S): " + cylinderSurfaceArea + "\n" +
                // "Silindri külgpindala (Sk): " + cylinderSideSurfaceArea + "\n" +
                // "Silindri ruumala (V): " + cylinderVolume;
            
            // tulemuste lisamine viewsse
            // veateade kaob, kui kasutaja parandab sisestust 
            view.updateTextArea(outputString, false);

            writeResultsToFile(outputString);
    
        } catch (NumberFormatException ex) {

            System.out.println("Vale sisestus. Sisesta number!");
            view.updateTextArea("Sisesta number mitte täht! \n", false);
        }
    });
}

private void writeResultsToFile(String outpuString){
    try (FileWriter writer = new FileWriter("JavaKujundid.txt", true)){
        writer.write(outpuString + "\n\n");
        
    } catch (Exception e) {
        view.updateTextArea("Faili kirjutamine ebaõnnestus!\n", false);
    }}
}
