package dataAccessObjects;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelClasses.Driver;
import sample.Main;

import java.sql.Connection;

import java.sql.*;
import java.util.Objects;

public class DriverFilesDAO {


    public static ObservableList<Driver> getDriver(){

        ObservableList<Driver> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = ConnectionClass.getConnection().prepareStatement("select * from Drivers");
            ResultSet rs = ps.executeQuery();

            String status;
            while (rs.next()){
                if((rs.getString("contract_file_status")).equalsIgnoreCase("1"))
                {
                    status = "generated";
                }
                else{
                     status = "non-generated";
                }
                list.add(new Driver(Integer.parseInt(rs.getString("ID")),rs.getString("Name"),status));

            }



        }catch (Exception e){

        }
        return list;


    }



    public static Driver getDriverForXml(Driver driver){


        Driver driver1 = null;
        try{
            PreparedStatement ps = ConnectionClass.getConnection().prepareStatement("select * from Drivers where ID = ?");
            ps.setInt(1, driver.getID());
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);


                while(rs.next())
                {
                    System.out.println("éééééééééééééééééééééééééééééééééééééééééééééééééééééééééééééééééé");
                    System.out.println(rs.getString("Category"));
                    System.out.println(rs.getString("Licensenumber"));
                    driver1 = new  Driver( rs.getString("Name"),rs.getString("Phonenumber")
                            ,rs.getString("Licensenumber"), rs.getString("Category"), rs.getString("Idcardnumber"));
                    Driver driver3 = new Driver("edddd","dfd","gff","gggg","fdfdf");
                }

                System.out.println(driver1);

            }catch (Exception e){

        }
        return driver1;


    }








    public static void updateDriver(Driver driver)throws Exception {

        try {
            PreparedStatement ps = ConnectionClass.getConnection().prepareStatement("UPDATE Drivers SET contract_file_status = ? WHERE ID = ?");
            System.out.println("Does it work?");
            ps.setInt(1, 1);

            ps.setInt(2, driver.getID());
            ps.executeUpdate();


        } catch (Exception e) {

        }
    }
}






