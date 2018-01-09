package sb.le_cadeau;

import java.util.*;
import java.io.*;
import java.math.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();
        List<Integer> oods = new ArrayList<>(N);
        int total = 0;
        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            oods.add(B);
            total += B;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int c = C;
        if(total < C){
            System.out.println("IMPOSSIBLE");
        }else {
            Collections.sort(oods);
            for(int i = 0; i < N; i++ ){
                int r = Math.min(oods.get(i), c / (N -i));
                c -= r;
                System.out.println(r);
            }
        }
        
    }
}