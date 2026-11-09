import java.util.Random;
import java.util.Scanner;

public class ArrayStuff {
    void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // Step 1: Declare an array of type int named dataPoints with a length of 100
        int[] dataPoints = new int[100];

        // Step 2: Initialize each element to a random value between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Step 3: Display the dataPoints values separated by " | "
        System.out.println("--- DataPoints Array Values ---");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println("\n");

        // Step 4: Calculate the sum and average of the values in dataPoints
        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average + "\n");

        // Step 5 & 6: Prompt user for an int value between 1 and 100, then count occurrences
        int userSearchVal = SafeInput.getRangedInt(in, "Enter an integer to search for", 1, 100);
        int count = 0;
        for (int val : dataPoints) {
            if (val == userSearchVal) {
                count++;
            }
        }
        System.out.println("The value " + userSearchVal + " was found " + count + " time(s) in the dataPoints array.\n");

        // Step 7: Prompt user again, search with short-circuit (break) for the first position
        int userTargetVal = SafeInput.getRangedInt(in, "Enter an integer to find its first position", 1, 100);
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userTargetVal) {
                position = i;
                break; // Short-circuit loop when found
            }
        }

        if (position != -1) {
            System.out.println("The value " + userTargetVal + " was found at array index " + position + ".\n");
        } else {
            System.out.println("The value " + userTargetVal + " was not found in the array.\n");
        }

        // Step 8: Scan for the minimum and maximum values in dataPoints
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum value found in dataPoints is: " + min);
        System.out.println("The maximum value found in dataPoints is: " + max + "\n");

        // Step 9: Test the getAverage method by converting int array to double array
        double[] doubleDataPoints = new double[dataPoints.length];
        for (int i = 0; i < dataPoints.length; i++) {
            doubleDataPoints[i] = dataPoints[i];
        }
        System.out.println("Average of dataPoints is: " + getAverage(doubleDataPoints));
    }

    // Step 9 Required Static Method
    public static double getAverage(double values[]) {
        double total = 0;
        for (double val : values) {
            total += val;
        }
        return total / values.length;
    }
}