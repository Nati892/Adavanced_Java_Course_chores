
import java.util.Scanner;

public class Summarizer {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        runProgram();
    }


    private static void runProgram() {
        System.out.println("Hi, Please enter the array size");
        int arrSize = inputPositiveNum();
        System.out.println("Please enter the number of threads");
        int threadsAmount = inputPositiveNum();

        SummarizeThread[] threadsArr = new SummarizeThread[threadsAmount];
        int[] myArr = new int[arrSize];
        initIntArr(myArr);
        printArray(myArr);
        PoolMonitor monitor = new PoolMonitor(myArr);

        System.out.println("Summing it all up");
        for (int i = 0; i < threadsArr.length; i++) {//initialize threads
            threadsArr[i] = new SummarizeThread(monitor);
        }


        for (int i = 0; i < threadsArr.length; i++) {//start threads
            threadsArr[i].start();
        }

        System.out.println("result: " + monitor.getSum());
    }


    //get an int from the user
    private static int inputPositiveNum() {
        int res = 0;
        boolean good_input = false;
        while (!good_input) {
            try {
                res = Integer.parseInt(scanner.next());
                if (res > 0)
                    good_input = true;
                else
                    System.out.println("The number must be bigger then zero, please re-enter number");
            } catch (Exception e) {
                System.out.println("Please re-enter integer");
            }
        }
        return res;
    }


    private static void initIntArr(int[] arr) {//initializes array with random positive numbers in range 1..100
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
    }


    private static void printArray(int[] arr) {
        if (arr.length > 0)
            System.out.print("\nPrinted array [" + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print("," + arr[i]);
        }
        System.out.println("]");
    }
}
