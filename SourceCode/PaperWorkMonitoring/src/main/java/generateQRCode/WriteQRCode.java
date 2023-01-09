package generateQRCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteQRCode {

    public static void generateQRCode(int idDriver) throws IOException, WriterException {
        String data = String.valueOf(idDriver);
        System.out.println("Voici caaaaaaaaaaaaaa"+data +"lolololololololo"+ idDriver);
        String filePath = "src//main//resources//xsl//qrCode.png";
        String charset = "UTF-8";
        Map <EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset),charset),
                BarcodeFormat.QR_CODE, 100, 100, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.')+1), new File(filePath));


    }


    public static void ReadQRCode(){



    }


}
