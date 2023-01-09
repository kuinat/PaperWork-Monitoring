package dataAccessObjects;

import modelClasses.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;

import static sample.XmlToPDF.RESOURCES_DIR;
import static sample.XmlToPDF.openFile;

/**
 *
 * @author www.luv2code.com
 *
 */
public class EmploymentFilesDAO {

    public static void saveContract (Driver driver)throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        FileInputStream input = null;
        FileInputStream in = null;

        try {


            String sql = "INSERT INTO employment_contract( driver_id,employment_contract_date,employment_contract_file,qrCode)VALUES(?,Now(),?,?)";
            myStmt = ConnectionClass.getConnection().prepareStatement(sql);



            // 3. Set parameter for resume file name
            File anotherFile = new File("src//main//resources//xsl//qrCode.png");
             in = new FileInputStream(anotherFile);

            File theFile = new File("src//main//resources//output//employee.pdf");
            input = new FileInputStream(theFile);

            myStmt.setInt (1, driver.getID());
            myStmt.setBinaryStream(2, input);
            myStmt.setBinaryStream(3, in);

            System.out.println("Reading input file: " + theFile.getAbsolutePath());

            // 4. Execute statement
            System.out.println("\nStoring employee in database: " + theFile);
            System.out.println(sql);

            myStmt.executeUpdate();

            System.out.println("\nCompleted successfully!");

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

            close(ConnectionClass.getConnection(), myStmt);
        }
    }



    public static void displayContract(Driver driver) throws Exception {


        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        InputStream input = null;
        FileOutputStream output = null;

        try {
            // 1. Get a connection to database


            // 2. Execute statement

            String sql = "SELECT employment_contract_file FROM employment_contract WHERE driver_id = ?";

            myStmt = ConnectionClass.getConnection().prepareStatement(sql);


            myStmt.setInt (1, driver.getID());

            myRs = myStmt.executeQuery();

            // 3. Set up a handle to the file
            File theFile = new File("src//main//resources//output//employee.pdf");
            output = new FileOutputStream(theFile);

            if (myRs.next()) {

                input = myRs.getBinaryStream("employment_contract_file");
                System.out.println("Reading contract file from database...");
                System.out.println(sql);

                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }

                System.out.println("\nSaved to file: " + theFile.getAbsolutePath());

                System.out.println("\nCompleted successfully!");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }

            if (output != null) {
                output.close();
            }

            close(ConnectionClass.getConnection(), myStmt);

            File pdfFile = new File("src//main//resources//output//employee.pdf");
            openFile(pdfFile);
            System.out.println("perfect");

        }
    }


    private static void close(Connection myConn, Statement myStmt)
            throws SQLException {

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

}
