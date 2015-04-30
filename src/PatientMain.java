import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * The client uses this class to load to a file so that their
 * chosen health professional can also access it.  This class
 * also gives the patient low and high readings.
 * Created by ehsan on 4/28/15.
 */
public class PatientMain {

    /**
     * the patient needs to run this first before a health professional can see
     * the readings
     * @param args no arguments input is coming from console
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GlucoseFactory glucoseParser;
        ReadingsController list;

        System.out.print("Patient Name: ");
        String patientName = scan.nextLine();

        glucoseParser = new GlucoseFactory(patientName);
        list = glucoseParser.getReadingsController();

        //get the alerts for the levels that are above and below the thresholds
        System.out.println("Alerts for " + list.getPatientName());
        System.out.println("=======================================================");
        list.getHighAlerts();
        System.out.println("=======================================================");
        list.getLowAlerts();
        System.out.println("=======================================================");
        System.out.println();

        System.out.print("Name of health care professional to share readings: ");
        list.setHealthCareProfessional(scan.nextLine());

        serializeReadingList(list, patientName);
    }

    /**
     * this method serializes a ReadingsController object into a file
     * @param readingsController the object we are serializing
     * @param patientName the patient name
     */
    public static void serializeReadingList(ReadingsController readingsController, String patientName){
        try{
            String fileName = patientName.replaceAll("\\s","")+1;
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(readingsController);
            oos.close();
            System.out.println("Done");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
