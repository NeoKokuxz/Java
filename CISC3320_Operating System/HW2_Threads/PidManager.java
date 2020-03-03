import java.util.HashMap;
import java.util.Map;

public class PidManager {

    //Constructor to initial pid position
    public PidManager() {
        allocate_map();
    }

    //Initial Pid range input
    private int min = 300;
    private int max = 5000;
    //HashMap to contain id and value
    private HashMap<Integer, Integer> PidMap = new HashMap<>();
    //Release ID Checker
    private int checker = 300;

    //Initial map
    public int allocate_map(){
        int tracker = 0;

        //For loop with initial all position in map
        for (int i = min; i <= max; i++) {
            //Set tracker for return value
            if(i==max){
                tracker = i;
            }
            //Initial each pid to value 0
            //0 means not in use, free to use.
            PidMap.put(i, 0);
        }

        //If tracker will check the condition of initial process
        if (tracker == max) {
            //Successful initialized all pid position
            return 1;
        } else {
            //Unsuccessful
            return -1;
        }
    }

    //Check for available Pid
    public int allocate_Pid(){
        //Check value of position
        for (Map.Entry<Integer, Integer> entry : PidMap.entrySet() ){
            //Find the pid is not in use, value 0
            if (entry.getValue() == 0) {
                //Get the pid number from current map position
                int pid = entry.getKey();
                //Set it to 1 means it's in use now
                entry.setValue(1);
                return pid; //return current registered pid position
            }
        }
        //Every position taken, return -1
        return -1;
    }

    //If process more than positions
    //then release and reuse position
    public void checkPid(){
        if (checker >= 5000 || checker < 300) {
            //When released position over 5000, back to position 300
            checker = 300;
        }
        releasePid(checker); //Release
        checker++;
    }

    public void releasePid(int num){
        //Set the input num-position back to 0 - Free to use
        PidMap.put(num, 0);
        //System.out.println("Now Releasing" + num); //Test all released position
    }
}
