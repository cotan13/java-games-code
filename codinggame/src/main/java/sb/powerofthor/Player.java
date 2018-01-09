package sb.powerofthor;

import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int Y = lightY - initialTY;
            int X = lightX - initialTX;

            String direction = "";
             if (Y < 0) {
                 direction = "N";
                 initialTY --;
             }else if (Y > 0) {
                 direction = "S";
                 initialTY ++;
             }
            if (X < 0) {
                direction = "W";
                initialTX --;
            }else if (X > 0) {
                direction = "E";
                initialTX ++;
            }

            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(direction);
        }
    }
}