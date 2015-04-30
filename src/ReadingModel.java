import java.io.Serializable;

/**
 * This class represents a glucose reading model
 * Created by ehsan on 4/28/15.
 */
public class ReadingModel implements Serializable{

    private int value;
    private String timestamp;
    private boolean highReading;
    private boolean lowReading;

    /**
     * Constructor
     * @param value the glucose reading value
     * @param timestamp the timestamp for the reading
     */
    public ReadingModel(int value, String timestamp){
        this.value = value;
        this.timestamp = timestamp;
        int HIGH_LIMIT = 140;
        int LOW_LIMIT = 60;
        if(value < LOW_LIMIT)
            lowReading = true;
        else if(value > HIGH_LIMIT)
            highReading = true;
    }

    /**
     * @return true if higher than limit
     */
    public boolean isHighReading() {
        return highReading;
    }

    /**
     * return true if lower than limit
     * @return
     */
    public boolean isLowReading() {
        return lowReading;
    }

    @Override
    public String toString(){
        return "Glucose Reading Value: " + value + ", Timestamp: " + timestamp;
    }
}
