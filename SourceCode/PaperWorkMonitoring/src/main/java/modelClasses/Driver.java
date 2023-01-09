package modelClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.awt.event.ActionListener;
import java.util.Date;

public class Driver {
    private int ID;
    private String Name;
    private String fileStatus;
    private Date dateOfBirth;
    private String phoneNumber;
    private String licenceNumber;
    private String category;
    private String idCardNumber;



    private ComboBox action;


    public Driver(int ID, String name, String status) {
        this.ID = ID;
        Name = name;
        this.fileStatus = status;


        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Generate Contract file",
                        "Display Contract File",
                        "Dismiss Contract File"
                );
        this.action = new ComboBox(options);
        this.action.setPlaceholder(new Label("Select an action"));



    }


    public Driver(String name,  String phoneNumber, String licenceNumber, String category, String idCardNumber) {
        this.Name = name;
        this.phoneNumber = phoneNumber;
        this.licenceNumber = licenceNumber;
        this.category = category;
        this.idCardNumber = idCardNumber;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ComboBox getAction() {
        return action;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
}