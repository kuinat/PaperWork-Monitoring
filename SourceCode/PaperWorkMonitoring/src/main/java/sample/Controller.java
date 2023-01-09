package sample;
//package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dataAccessObjects.ConnectionClass;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import dataAccessObjects.DriverFilesDAO;
import modelClasses.Driver;


public class Controller implements Initializable {
    @FXML
    private TreeView<String> treeView;

    @FXML
    private BorderPane mainPane;

    @FXML
    private AnchorPane homePane;

    @FXML
    FxmlLoader object = new FxmlLoader();

    @FXML
    private ImageView imageView;
    int count;

    @FXML
    private VBox rightMenu;

    @FXML
    private Label appNameLabel;

    @FXML
    private HBox menubarId;







    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


        rightMenu.styleProperty().set("-fx-background-color: #474747");

        appNameLabel.styleProperty().set("-fx-background-color: #474747");

        menubarId.styleProperty().set("-fx-background-color: #474747");

        treeView.setStyle("#68bf0c");


        slideShow();

        // TODO Auto-generated method stub

        mainPane.setCenter(homePane);

        TreeItem<String> ob = new TreeItem<>("All Files");
        TreeItem<String> ob0 = new TreeItem<>("Employment Files");
        TreeItem<String> ob1 = new TreeItem<>("Rent Files");
        TreeItem<String> ob2 = new TreeItem<>("Sales Files");
        TreeItem<String> ob3 = new TreeItem<>("Cars Files");
        TreeItem<String> ob4 = new TreeItem<>("Dismissal Files");
        ob.getChildren().addAll(ob0,ob1, ob2, ob3, ob4);

        TreeItem<String> ob5 = new TreeItem<>("p1");
        TreeItem<String> ob6 = new TreeItem<>("p2");
        TreeItem<String> ob7 = new TreeItem<>("View employment contracts");
        TreeItem<String> ob8 = new TreeItem<>("p3");
        ob2.getChildren().addAll(ob5, ob6);
        ob0.getChildren().addAll(ob7, ob5);
        ob1.getChildren().addAll(ob6, ob8);
        ob3.getChildren().addAll(ob5, ob5);
        treeView.setRoot(ob);
        ob.setExpanded(true);




        treeView.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue.getValue().equals("Employment Files"))
                    {

                        Pane view = object.getPane("EmployeeUi");


                        mainPane.setCenter(view);


                    }

                    else if(newValue.getValue().equals("Rent Files"))
                    {
                        Pane view = object.getPane("RentUi");

                        mainPane.setCenter(view);
                    }

                    else if(newValue.getValue().equals("Sales Files"))
                    {
                        Pane view = object.getPane("SalesUi");

                        mainPane.setCenter(view);
                    }

                    else if(newValue.getValue().equals("Cars Files"))
                    {
                        Pane view = object.getPane("CarsUi");

                        mainPane.setCenter(view);
                    }



                });










    }


    public void slideShow(){
        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image("/images/images (2).jpg"));
        images.add(new Image("/images/images.jpg"));
        images.add(new Image("/images/images (3).jpg"));
        images.add(new Image("/images/images (4).jpeg"));
        images.add(new Image("/images/carInsurance.jpg"));
        images.add(new Image("/images/help.jpeg"));


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            imageView.setImage(images.get(count));
            count++;
            if (count == 6)
                count = 0;
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



    public void handleHomeButtonAction(javafx.event.ActionEvent actionEvent) {
        mainPane.setCenter(homePane);
    }

    public void handleHomeMenuButtonAction(javafx.event.ActionEvent actionEvent) {
        mainPane.setCenter(homePane);}


    public void handleEmploymentFilesButtonAction(javafx.event.ActionEvent actionEvent) {
        mainPane.setCenter(object.getPane("EmployeeUi"));
    }

    public void handleViewAllFilesAction(javafx.event.ActionEvent actionEvent) {
        mainPane.setCenter(object.getPane("AllContractsTableView"));
    }
}
