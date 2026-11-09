import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                validInput = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid integer.");
            }
            pipe.nextLine();
        } while (!validInput);
        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0.0;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                validInput = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid decimal number.");
            }
            pipe.nextLine();
        } while (!validInput);
        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean validInput = false;
        String fullPrompt = prompt + " [" + low + " - " + high + "]";
        do {
            System.out.print("\n" + fullPrompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (retInt >= low && retInt <= high) {
                    validInput = true;
                } else {
                    System.out.println("Number out of range. Must be between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid integer.");
            }
            pipe.nextLine();
        } while (!validInput);
        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0.0;
        boolean validInput = false;
        String fullPrompt = prompt + " [" + low + " - " + high + "]";
        do {
            System.out.print("\n" + fullPrompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                if (retDouble >= low && retDouble <= high) {
                    validInput = true;
                } else {
                    System.out.println("Value out of range. Must be between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: \"" + trash + "\". Please enter a valid number.");
            }
            pipe.nextLine();
        } while (!validInput);
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean retVal = false;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                validInput = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                validInput = true;
            } else {
                System.out.println("Invalid response: \"" + response + "\". Please enter Y or N.");
            }
        } while (!validInput);
        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                validInput = true;
            } else {
                System.out.println("Invalid format. Please try again.");
            }
        } while (!validInput);
        return response;
    }
}