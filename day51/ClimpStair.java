import java.util.*;
import java.io.*;

public class ClimpStair {
    static int count;

    public static int countDistinctWayToClimbStair(long nStairs) {
        // distance , destination
        count = 0;
        jump(0, nStairs);
        return count;
    }

    static void jump(long distance, long destination) {
        if (distance == destination) {
            count++;
            return;
        } else if (distance > destination)
            return;

        // one jump
        jump(distance + 1, destination);
        // two jump
        jump(distance + 2, destination);
    }
}