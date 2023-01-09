package sample;

import com.google.zxing.WriterException;
import dataAccessObjects.EmploymentFilesDAO;
import generateQRCode.WriteQRCode;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import dataAccessObjects.DriverFilesDAO;
import dataAccessObjects.ConnectionClass;
import javafx.scene.control.cell.PropertyValueFactory;
import modelClasses.Driver;
import org.apache.fop.apps.FOPException;
import sample.XmlToPDF;

import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class EmployeeUiController implements Initializable {



    @FXML
    private TableView driverTableView;

    @FXML
    private TableColumn driver_id_column;

    @FXML
    private TableColumn driver_name_column;

    @FXML
    private TableColumn action_contract_column;

    @FXML
    private TableColumn id_file_status;

    ObservableList<Driver> listM;

    XmlToPDF  xmlToPDF;

    EmploymentFilesDAO employmentFilesDAO = new EmploymentFilesDAO();

    DriverFilesDAO driverFilesDAO;

    GenerateXml generateXml1;

    WriteQRCode writeQRCode;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        driver_id_column.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("ID"));
        driver_name_column.setCellValueFactory(new PropertyValueFactory<Driver,String>("Name"));
        id_file_status.setCellValueFactory(new PropertyValueFactory<Driver,String>("fileStatus"));
        action_contract_column.setCellValueFactory(new PropertyValueFactory<Driver, Button>("action"));

        // Populate tableview
         driverFilesDAO = new DriverFilesDAO();
         listM = driverFilesDAO.getDriver();

        System.out.println(listM);

        driverTableView.setItems(listM);


        for(int i = 0; i< listM.size() ; i++) {


            int finalI = i;
            int finalI1 = i;
            listM.get(i).getAction().getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue)->{
                if(newValue.toString().equalsIgnoreCase("Generate Contract file")){
                            System.out.println("Great");


                    //Generate QR COde
                    try {
                        writeQRCode.generateQRCode(listM.get(finalI).getID());

                        System.out.println("Yaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+driverFilesDAO.getDriverForXml(listM.get(finalI)).getID());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }


                            //Generate Xml Document
                    try {

                        generateXml1.generateXml(driverFilesDAO.getDriverForXml(listM.get(finalI)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                    //Convert xml document to pdf
                            xmlToPDF = new XmlToPDF();

                    try {
                        xmlToPDF.convertToPDF();

                    } catch (FOPException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (TransformerException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                        //Save contract into employment Contract table
                    try {
                        employmentFilesDAO.saveContract(listM.get(finalI1));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //update the driver contract file status in the database

                    try {
                        driverFilesDAO.updateDriver(listM.get(finalI));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }




                }
                else if(newValue.toString().equalsIgnoreCase("Display Contract File")){
                    System.out.print("Heeeeeeey"+listM.get(finalI).getID());

                    try {
                        employmentFilesDAO.displayContract(listM.get(finalI));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        );

        }





    }






}
