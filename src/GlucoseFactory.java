import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class takes a file of readings and parses it into
 * ReadingModel.  It stores all the readingModel in
 * the ReadingsController object.
 * Created by ehsan on 4/28/15.
 */
public class GlucoseFactory {
    private ReadingsController readingsController;
    public GlucoseFactory(String patientName){
        ReadingModel readingModel;
        readingsController = new ReadingsController(patientName);
        String fileName = patientName.replaceAll("\\s","");
        File myFile = new File(fileName);
        try {
            Scanner scan = new Scanner(myFile);
            while(scan.hasNextLine()){
                String reading = scan.nextLine();

                readingModel = new ReadingModel(parseValue(reading), parseTime(reading));
                readingsController.addReading(readingModel);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int parseValue(String reading){
        int startIndex = reading.indexOf("bg_value")+11;
        int endIndex = reading.indexOf(',');
        return Integer.parseInt(reading.substring(startIndex, endIndex));
    }

    public String parseTime(String reading){
        int startIndex = reading.lastIndexOf('‘')+1;
        int endIndex = reading.lastIndexOf('’');
        return reading.substring(startIndex, endIndex);
    }

    public ReadingsController getReadingsController(){
        return readingsController;
    }
}
