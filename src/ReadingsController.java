import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a glucose readings list
 * Created by ehsan on 4/28/15.
 */
public class ReadingsController implements Serializable{

    private String patientName;
    private String healthCareProfessional;
    private ArrayList<ReadingModel> list;

    /**
     * constructor
     * @param patientName the name of the patient
     */
    public ReadingsController(String patientName){
        list = new ArrayList<>();
        this.patientName = patientName;
    }

    /**
     * add a glucose reading to the list
     * @param reading ReadingObject we are adding to the list
     */
    public void addReading(ReadingModel reading){
        list.add(reading);
    }

    /**
     * @return the glucose reading list
     */
    public ArrayList<ReadingModel> getReadingsList(){
        return list;
    }

    /**
     * prints the glucose reading that were higher than the limit
     */
    public void getHighAlerts(){
        System.out.println("High Glucose Readings:");
        list.stream().filter(ReadingModel::isHighReading).forEach(System.out::println);
    }

    /**
     * prints the glucose reading that were lower than the limit
     */
    public void getLowAlerts(){
        System.out.println("Low Glucose Readings:");
        list.stream().filter(ReadingModel::isLowReading).forEach(System.out::println);
    }

    /**
     * set the name of the health care professional that can view the glucose reading list
     * @param name name of the health care professional
     */
    public void setHealthCareProfessional(String name){
        healthCareProfessional = name;
    }

    /**
     * @return name of the health care professional allowed to view the list
     */
    public String getHealthCareProfessional(){
        return healthCareProfessional;
    }

    /**
     * get the name of the patient associated with the readings.
     * @return
     */
    public String getPatientName(){
        return patientName;
    }
}
