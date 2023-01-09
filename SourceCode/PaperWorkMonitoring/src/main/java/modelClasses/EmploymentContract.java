package modelClasses;

import javafx.scene.image.Image;

import java.io.File;
import java.util.Date;

public class EmploymentContract {

    public int idEmploymentContract;
    public int driverId;
    public String driverName;
    public File contractFile;
    public Date date;
    public File qrCode;

    public EmploymentContract(int idEmploymentContract, int driverId, String driverName, File contractFile, Date date, File qrCode) {
        this.idEmploymentContract = idEmploymentContract;
        this.driverId = driverId;
        this.driverName = driverName;
        this.contractFile = contractFile;
        this.date = date;
        this.qrCode = qrCode;
    }

    public int getIdEmploymentContract() {
        return idEmploymentContract;
    }

    public void setIdEmploymentContract(int idEmploymentContract) {
        this.idEmploymentContract = idEmploymentContract;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public File getContractFile() {
        return contractFile;
    }

    public void setContractFile(File contractFile) {
        this.contractFile = contractFile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public File getQrCode() {
        return qrCode;
    }

    public void setQrCode(File qrCode) {
        this.qrCode = qrCode;
    }
}
