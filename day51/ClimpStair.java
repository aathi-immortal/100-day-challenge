import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;

public class ClimpStair {
    static int count;
    static int[] map;

    public static int countDistinctWayToClimbStair(long nStairs) {
        // distance , destination
        map = new int[(int) nStairs];
        return (int) dynamicJumpTabulation(nStairs);
    }

    // top down
    static int dynamicJump(long nStair) {
        if (nStair == 0 || nStair == 1) {
            return 1;
        }
        if (nStair < 0)
            return 0;
        int oneJump = dynamicJump(nStair - 1);
        int twoJump = dynamicJump(nStair - 2);

        return oneJump + twoJump;

    }

    // bottom up
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
    // using tabulation to reduce the time complexity

    static int dynamicJumpTabulation(long nStair) {
        if (nStair == 0 || nStair == 1) {
            return 1;
        }
        if (nStair < 0)
            return 0;

        int oneJumpValue, twoJumpValue;
        int oneJumpIndex, twoJumpIndex;
        oneJumpIndex = (int) (nStair - 1);
        twoJumpIndex = (int) (nStair - 2);
        if (map[oneJumpIndex] != 0)
            oneJumpValue = map[oneJumpIndex];
        else {
            oneJumpValue = dynamicJumpTabulation(nStair - 1);
            map[oneJumpIndex] = oneJumpValue;
        }
        if (map[twoJumpIndex] != 0)
            twoJumpValue = map[twoJumpIndex];
        else {
            twoJumpValue = dynamicJumpTabulation(nStair - 2);
            map[twoJumpIndex] = twoJumpValue;
        }

        return (oneJumpValue + twoJumpValue) % ((int) Math.pow(10, 9)) + 7;

    }
}
