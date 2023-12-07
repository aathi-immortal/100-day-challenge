import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Process {
    int arrivalTime;
    int burstTime;

    Process(int arrivalTime, int burstTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

}

public class Solution {
    static List<Process> arrayOfProcess = new ArrayList<>();

    static void loadProcess(int[] arrivalTime, int[] burstTime) {
        for (int i = 0; i < arrivalTime.length; i++) {
            arrayOfProcess.add(new Process(arrivalTime[i], burstTime[i]));
        }
    }

    public static float sjf(int n, int[] arrivalTime, int[] burstTime) {
        int sumOfWaiting = 0;
        // load the process
        loadProcess(arrivalTime, burstTime);
        // sort the process by the arrival time
        Collections.sort(arrayOfProcess, (o1, o2) -> o1.arrivalTime - o2.arrivalTime);
        // display(arrayOfProcess);
        // avg calculation
        return (float) groupByProcessId() / n;

    }

    static void display(List<Process> arrayOfProcess) {
        for (Process process : arrayOfProcess) {
            System.out.println(process.arrivalTime + "  " + process.burstTime);
        }
    }

    public static int groupByProcessId() {
        int sumOfWaiting = 0;
        int size = arrayOfProcess.size();
        List<Process> arrayOfProcessWithSameId = new ArrayList<>();
        int start = 1;
        Process previous = arrayOfProcess.get(0);
        Process current = arrayOfProcess.get(start);
        arrayOfProcessWithSameId.add(arrayOfProcess.get(0));
        // load untill we reach different process arrival time
        while (start < size) {
            current = arrayOfProcess.get(start);
            if (current.arrivalTime == previous.arrivalTime) {

                arrayOfProcessWithSameId.add(current);

            }
            // if we found difference process with different arrival time
            // sort the arrayOfProcessWithSameId withrespect to its burst Time
            // passToCalculateThe waiting time function it will return the sum of waiting
            // time
            else {
                Collections.sort(arrayOfProcessWithSameId, (o1, o2) -> o1.burstTime - o2.burstTime);
                System.out.println("sorted");
                display(arrayOfProcessWithSameId);
                System.out.println("-----------------------------------------------");
                sumOfWaiting += calculateWaintingTime(arrayOfProcessWithSameId);
                // empty the arrayList
                arrayOfProcessWithSameId = new ArrayList<>();
                arrayOfProcessWithSameId.add(current);

            }
            previous = arrayOfProcess.get(start);
            start++;
        }
        Collections.sort(arrayOfProcessWithSameId, (o1, o2) -> o1.burstTime - o2.burstTime);
        System.out.println("sorted last");
        display(arrayOfProcessWithSameId);
        System.out.println("---------------------------------------------");
        sumOfWaiting += calculateWaintingTime(arrayOfProcessWithSameId);
        return sumOfWaiting;
    }

    static int calculateWaintingTime(List<Process> array) {
        int waiting = 0;
        for (int i = 0; i < array.size() - 1; i++) {

            waiting += array.get(i).burstTime;
        }
        return waiting;
    }

    public static void main(String[] args) {

        int[] arrivalTime = { 12, 29, 25, 22, 4, 24, 29, 10, 11 };
        int[] burstTime = { 26, 11, 14, 3, 21, 6, 28, 29, 7 };
        float value = Solution.sjf(9, arrivalTime, burstTime);
        System.out.println(value);
    }

}
