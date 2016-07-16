import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.Math;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int beforeX = 0;
        int beforeY = 0;
        int curX = 0;
        int curY = 0;
        boolean isAfterPeak = false;
        boolean hasBoost = true;

        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();
            
            // default moving value
            int aimX = nextCheckpointX;
            int aimY = nextCheckpointY;
            String thrust = "100";
            
            // debug
            beforeX = curX;
            beforeY = curY;
            curX = x;
            curY = y;
            double moved = Math.sqrt(Math.pow(curX-beforeX, 2) + Math.pow(curY-beforeY, 2));
            
            nextCheckpointAngle = Math.abs(nextCheckpointAngle);
            

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println("Debug messages : x = " + x + ", y = " + y);
            System.err.println("Debug messages : moved = " + moved);


            // You have to output the target position
            // followed by the power (0 <= thrust <= 100) or "BOOST" or "SHIELD"
            // i.e.: "x y thrust"
            
            // normal moving
            if (nextCheckpointAngle > 90) {
                thrust = "10";
            } else {
                thrust = "100";
            }
            
            // a case to boost
            if (hasBoost && nextCheckpointDist > 5000 && nextCheckpointAngle == 0) {
                thrust = "BOOST";
                hasBoost = false;
            }
            
            // move
            System.out.println(aimX + " " + aimY + " " + " " + thrust);
        }
    }
}
