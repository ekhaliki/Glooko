import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;


/**
 * This class is used by a Health Care Professional to view
 * the glucose readings for the patients that have included
 * them as their Health Care Professional.
 * Created by ehsan on 4/28/15.
 */
public class ProfessionalMain {
    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Health Care Professional Name: ");
        String healthCareProfessional = scan.nextLine();
        System.out.print("Patient Name: ");
        String patientName = scan.nextLine();

        ReadingsController list = deserializeReadingsList(patientName);
        if(list.getHealthCareProfessional().equals(healthCareProfessional)) {
            System.out.println("========================================================");
            list.getHighAlerts();
            System.out.println("========================================================");
            list.getLowAlerts();
            System.out.println("========================================================");
            System.out.println();
        } else {
            System.out.println("You do not have access to " + patientName + "'s glucose readings!");
        }
    }

    /**
     * This method reads an serialized ReadingList object file
     * @param patientName the name of patient
     * @return a ReadingList object which contains the glucose readings
     */
    public static ReadingsController deserializeReadingsList(String patientName){

        ReadingsController readingsController;
        String fileName = patientName.replaceAll("\\s","")+1;
        try{
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            readingsController = (ReadingsController) ois.readObject();
            ois.close();
            return readingsController;
        }catch(Exception ex){
            System.out.println("File was not found!");
            ex.printStackTrace();
            return null;
        }
    }
}
