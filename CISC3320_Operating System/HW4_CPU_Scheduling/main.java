import java.util.*;

public class main {

    static int request = 1000;
    static int num = 678;

    static Set<Integer> requests;
    static TreeSet<Integer> partition1 = new TreeSet(Collections.reverseOrder());
    static TreeSet<Integer> partition2 = new TreeSet();

    static Random rand = new Random();


    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        //int num = sc.nextInt();

        int[] req = new int [1000];

        //Put 1000 request into array, each array[i] store one of the address
        for (int i = 0; i < request; i++){
            req[i] = rand.nextInt(4999);
            //System.out.println("ID: " + count +  " Request: " + req[i]);
        }


        //Algo implemented based on above request[address]
        FCFS(num, req);
        SSTF(num, req);
        SCAN(num);
    }

    public static void FCFS (int num, int[] req) {
        if(num < 0 || num >= 5000 ){
            System.out.println("Error!!!");

        } else {

            int numMoves = 0;

            //Loop through 1000 request with their addree
            //Add all the waiting time together
            for(int i=0; i<request; i++){
                req[i] = req[i]-req[i++];
                if(req[i]<0){
                    req[i] = req[i] * -1;
                }
                numMoves = numMoves + req[i];
            }

            int r = req[0] - num;

            if(r < 0){
                r = r * -1;
            }

            numMoves += r;
            System.out.println("FCFS: " + numMoves);
        }
    }

    public static void SSTF(int num, int[]req){
        if(num < 0 || num >= 5000 ){
            System.out.println("Error!!!");

        } else {
            if (req.length == 0)
                return;

            node diff[] = new node[req.length];

            for (int i = 0; i < diff.length; i++)

                diff[i] = new node();

            int seek_count = 0;

            // stores sequence in which disk access is done
            int[] seek = new int[req.length + 1];

            for (int i = 0; i < req.length; i++) {

                seek[i] = num;
                calculateDifference(req, num, diff);

                int index = findMin(diff);

                diff[index].visited = true;

                seek_count += diff[index].distance;
                num = req[index];
            }

            //add head
            seek[seek.length - 1] = num;

            System.out.println("SSTF: " + seek_count);
        }
    }

    public static void SCAN(int num){

        int headMoves;

        if(num < 0 || num >= 5000 ){
            System.out.println("Error!!!");

        } else {
            requests = Requests(4999, request);   //creates a set of 1000 requests. call the method requests which returns set s of requests.
            //System.out.println("requests: "); //prints out the requests that will be serviced.

            for(Integer i : requests){                          //separate requests into 2 tree sets
                if(num >= i.intValue()){   //one is less or equal to the head position.
                    partition1.add(i);
                }
                else{
                    partition2.add(i);                      //the other one is greater than head position.
                }
            }

            headMoves = serviceRequests(partition1,partition2,num); //calls the serviceRequest method to process SCAN algorithm.
            System.out.println("SCAN: " + headMoves); //prints out amount of head movements

        }
    }

//    public static void C_SCAN(int num){
//        if(num < 0 || num >= 5000 ){
//            System.out.println("Error!!!");
//
//        } else {
//
//        }
//    }
//
//    public static void LOOK(int num){
//        if(num < 0 || num >= 5000 ){
//            System.out.println("Error!!!");
//
//        } else {
//
//        }
//    }
//
//    public static void C_LOOK(int num){
//        if(num < 0 || num >= 5000 ){
//            System.out.println("Error!!!");
//
//        } else {
//
//
//        }
//    }

    public static void calculateDifference(int req1[], int num, node diff[])

    {
        for (int i = 0; i < diff.length; i++)
            diff[i].distance = Math.abs(req1[i] - num);
    }

    public static int findMin(node diff[])
    {
        int index = -1, minimum = Integer.MAX_VALUE;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i].visited != true && minimum > diff[i].distance) {

                minimum = diff[i].distance;
                index = i;
            }
        }
        return index;
    }

    public static Set<Integer> Requests(int num, int req){
        Set<Integer> sss = new HashSet();
        while(sss.size()!= req){
            sss.add(rand.nextInt(num));
        }
        return sss;
    }

    public static int serviceRequests (TreeSet<Integer> lessSet, TreeSet<Integer> moreSet, Integer head){
        int count = 0;
        int newHead = head;

        for(Integer i : lessSet) {
            count += newHead - i;
            newHead = i;
        }
        count += newHead;
        count += head;
        newHead = head;

        for(Integer k : moreSet){
            count += k - newHead;
            newHead = k;
        }
        return count;
    }
}

class node {
    int distance = 0;
    boolean visited = false;
}
