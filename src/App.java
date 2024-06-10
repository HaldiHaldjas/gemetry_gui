import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // kontrolleri jaoks peavad need eespool olema
            Model model = new Model();
            View view = new View();
            GeometryBoard geometryBoard = new GeometryBoard();

            // alles kontroller paneb nupud tööle!
            new Controller(model, view, geometryBoard);

            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // või nr 3
            // konstant on suurte tähtedega, seda muuta ei saa.
            view.pack(); // et asjad leiaksid kõik oma õige koha
            view.setLocationRelativeTo(null); // paiguta ekraani keskele
            // teeb akna nähtavaks
            view.setVisible(true);
        });
    }
}
