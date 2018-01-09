package sb.don_t_panic_1;

import java.util.Collections;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        int[] elevators = new int[nbElevators];
       
        
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevators[elevatorFloor] = elevatorPos;
        }

        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String dir = in.next(); // direction of the leading clone: LEFT or RIGHT
          
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            String decision;
            if(dir.equals("NONE")){
                decision = "WAIT";
            }else {
                int elevatorPos = cloneFloor == exitFloor ? exitPos : elevators[cloneFloor] ;
                if(clonePos > elevatorPos && dir.equals("RIGHT") ||
                clonePos < elevatorPos && !dir.equals("RIGHT") ){
                    decision =   "BLOCK" ;
                }else decision = "WAIT";
            }
            
            System.out.println(decision); // action: WAIT or BLOCK
        }
    }
}