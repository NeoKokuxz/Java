import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        PidManager p1 = new PidManager();
        Boolean condition = true;
        Scanner sc = new Scanner(System.in);
        userInput();
        //Test to run 5000 processes
        testPid(p1);
        //Test to release specific pid position
        testPidRelease(p1,sc);
        //Test to register pid position that just got released
        testPidRegister(p1);
    }

    public static void userInput() {
        System.out.println("Please enter process number to start");
        //User input process name
    }

    //Test function for 5000 processes input
    public static void testPid(PidManager p1) {
        int pid;
        for(int i = 0; i<= 19000; i++) {
            //AllocatePid
            pid = p1.allocate_Pid();
            //-1 means fail to locate open position
            if (pid == -1) {
                //Check id status and release position for new id
                p1.checkPid();
                //Put pid into released position
                pid = p1.allocate_Pid();
//                System.out.println("Process: " + i + " with PID: " + pid);

            }
            //Output
            if(pid==300 || pid==5000) {
                //Print i value corresponding to pid position 300 && 5000
                System.out.println("Process: " + i + " with PID: " + pid);
            } else if(pid >=300 && pid < 320) {
                System.out.println("released: " + i + " with PID: " + pid);
            }
        }
    }

    //Test if position release for next new input pid
    public static void testPidRelease(PidManager p1, Scanner sc) {
        System.out.println("Please enter position that you want to release between 300-5000");
        //int releaseNum = sc.nextInt();
        int releaseNum = 1234;
        if(releaseNum >= 300 && releaseNum <= 5000) {
            p1.releasePid(releaseNum);
            System.out.println("released position: " +releaseNum);
        }
    }

    //Test if there is any open position for pid
    public static void testPidRegister(PidManager p1) {
        System.out.println("Looking for position to register!");
        int pid = p1.allocate_Pid();
        System.out.println("Found position: " + pid);
    }
}
