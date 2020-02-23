import java.util.HashMap;
import java.util.Map;

public class PidManager {

    //Constructor to set up Pid
    public PidManager() {
        allocate_map();
    }

    //Initial Pid input
    private int min = 300;
    private int max = 5000;
    //HashMap to contain id and value
    private HashMap<Integer, Integer> PidMap = new HashMap<>();
    //Release ID Checker
    private int checker = 300;

    //Initial map
    public int allocate_map(){
        int tracker = 0;
        for (int i = min; i <= max; i++) {
            //Set tracker for return value
            if(i==max){
                tracker = i;
            }
            //Initial each pid to value 0
            //0 means not in use, free to use.
            PidMap.put(i, 0);
        }

        //If tracker run loop the run
        if (tracker == max) {
            //Successful initialized all pid
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
                return pid;
            }
        }
        //Every position taken, return -1
        return -1;
    }

    public void checkPid(){
        releasePid(checker);
        if(checker < 5000 && checker >= 300){
            checker++;
        } else {
            //When it went over 5000, reset to min 300;
            System.out.println("Current checker: " + checker);
            checker = 300;
        }

    }

    public void releasePid(int num){
        //Set the input num-position back to 0 - Free to use
        PidMap.put(num, 0);
        //System.out.println("Now Releasing" + num); //Test all released position
    }
}
