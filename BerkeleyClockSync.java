package berekeley_clock_sync;

import java.util.ArrayList;

public class BerkeleyClockSync {

    private static final int ROUND_TRIP_DELAY = 100; // in milliseconds
    private static final int NUM_ITERATIONS = 3;

    public static void main(String[] args) {
        // Create a list of clock times for each computer
        ArrayList<Long> clockTimes = new ArrayList<>();
        clockTimes.add(10800L); // Computer A
        clockTimes.add(11400L); // Computer B
        clockTimes.add(10200L); // Computer C

        // Run the algorithm
        long offset = runAlgorithm(clockTimes);

        // Print the results
        System.out.println("Clock offset: " + offset + " milliseconds");
    }

    private static long runAlgorithm(ArrayList<Long> clockTimes) {
        // Calculate the average clock time
        long sum = 0;
        for (long clockTime : clockTimes) {
            sum += clockTime;
        }
        long averageTime = sum / clockTimes.size();
        System.out.println(averageTime);

        // Calculate the time offsets
        ArrayList<Long> offsets = new ArrayList<>();
        for (long clockTime : clockTimes) {
            offsets.add(averageTime - clockTime);
        }
        for(int i=0;i<offsets.size();i++) {
        	long curr=offsets.get(i);
        	System.out.println(curr);
        }
        // Repeat the algorithm for a number of iterations
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            // Calculate the new average clock time with the adjusted offsets
            sum = 0;
            for (int j = 0; j < clockTimes.size(); j++) {
                long adjustedTime = clockTimes.get(j) + offsets.get(j);
                sum += adjustedTime;
            }
            long newAverageTime = sum / clockTimes.size();
            System.out.println("New-avg "+newAverageTime);

            // Calculate the new offsets based on the new average time
            offsets.clear();
            for (long clockTime : clockTimes) {
                offsets.add(newAverageTime - clockTime);
            }
//            for(int k=0;k<offsets.size();k++) {
//            	long curr=offsets.get(k);
//            	System.out.println(curr);
//            }
        }

        // Calculate the final clock offset
        long sumOffsets = 0;
        for (long offset : offsets) {
        	System.out.print(offset+" ");
            sumOffsets += offset;
        }
        System.out.println();
        System.out.println(sumOffsets);
        long averageOffset = sumOffsets / offsets.size();
        System.out.println(averageOffset);
        long finalOffset = averageOffset - (ROUND_TRIP_DELAY / 2);
        System.out.println();

        return finalOffset;
    }
}
