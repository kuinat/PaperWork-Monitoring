package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import modelClasses.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GenerateXml {
    static ObjectMapper mapper = new XmlMapper();

    public static void generateXml(Driver driver) throws IOException {
        mapper.writeValue(new File("src//main//resources//xml//Driver.xml"), driver);
    }


}
