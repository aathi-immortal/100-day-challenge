import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

class Train implements Comparable<Train> {
    int arrivalTime;
    int departureTime;

    Train(int arrivalTime, int departureTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public int compareTo(Train o) {
        return (this.arrivalTime > o.arrivalTime) ? 1 : -1;
    }

}

public class TrainPlatForm {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // sort the at abd dt array based on the at array
        // ArrayList<Train> trains = new ArrayList<>();
        // loadArray(trains, at, dt);
        // Collections.sort(trains);
        // display(trains);
        Arrays.sort(at);
        Arrays.sort(dt);
        int arrivalIndex = 1;
        int departureIndex = 0;
        int platformNumber = 1;
        int maxPlatform = 1;

        while (arrivalIndex < n) {
            int arrivalTime = at[arrivalIndex];
            int departureTime = dt[departureIndex];
            // if arrival time is less than departure time
            if (arrivalTime <= departureTime) {
                platformNumber++;
                if (platformNumber > maxPlatform)
                    maxPlatform = platformNumber;
                arrivalIndex++;
            } else {
                // if arrival time is greater than the departure time
                // move the departure time
                departureIndex++;
                platformNumber--;
            }
        }
        return maxPlatform;
    }

    private static void loadArray(ArrayList<Train> trains, int[] at, int[] dt) {
        for (int i = 0; i < dt.length; i++) {
            trains.add(new Train(at[i], dt[i]));
        }
    }

    static void display(ArrayList<Train> datas) {
        for (Train data : datas) {
            System.out.println(data.arrivalTime + " " + data.departureTime);

        }
    }
}