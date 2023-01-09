package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {
    private Pane view;
    //private Parent view = FXMLLoader.load(getClass().getResource(EmployeeUi.fxml));

    public Pane getPane(String fileName) {
        try {
            URL fileUrl = Main.class.getResource( "/"+fileName + ".fxml");
            System.out.println("nana");
            /*if (fileUrl == null) {
                throw new FileNotFoundException("Fxml can't be found");
            }*/
            System.out.println("nana0 ");
            view = new FXMLLoader().load(fileUrl);
            //view = FXMLLoader.load(getClass().getResource(fileName));
            System.out.println("nana1");

        }
        catch (Exception e) {
            System.out.println("No page "+fileName+ " Please check fxml loader");

        }
        return view;
    }
}
