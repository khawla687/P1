//Define libraries to be used
import java.util.Arrays;
import java.util.Scanner;

public class Searcher {

    //Attributes - defined as visibility type name;
    private int[] numbers;

    //Constructor - no return value
    public Searcher(int[] values){
        numbers = values;
    }

    //Methods - defined as visibility [type of return value] name (parameters)
    // Each parameter has a type
    public int linearSearch(int toFind){
        for (int i=0; i < numbers.length ; i++ ){
            if(numbers[i] == toFind){
                System.out.println("Found at position "+ i);
                return i;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public int binarySearch(int toFind){
        //First, we need to sort the array
        int[] copy = Arrays.copyOf(numbers, numbers.length); //create a copy
        Arrays.sort(copy);

        //binarySearch
        int lo = 0;
        int hi = copy.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2; //Try to understand why not just (hi -lo)?
            if      (toFind < copy[mid]) hi = mid - 1;
            else if (toFind > copy[mid]) lo = mid + 1;
            else{
                System.out.println("Found at " + mid);
                return mid;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public long timeAlgorithm(int toFind, String search){
        if(search.equals("linear")){
            long start = System.currentTimeMillis();
            int find = linearSearch(toFind);
            long end = System.currentTimeMillis();
            return (end-start);
        }
        else if(search.equals("binary")){
            long start = System.currentTimeMillis();
            int find = binarySearch(toFind);
            long end = System.currentTimeMillis();
            return (end-start);
        }
        return -1;
    }


    public static void main(String[] args) {
        //Get the values first
        System.out.println("Enter 10 values for the array:");
        Scanner scanner = new Scanner(System.in); // To read from the console
        int[] myValues = new int[10];
        for(int i=0; i < 10; i++){
            int userInput = scanner.nextInt();  // Read user input
            myValues[i] = userInput;
        }
        Searcher searcher = new Searcher(myValues);
        System.out.println("Enter number to search:");
        int toFind = scanner.nextInt();
        System.out.println("Which type of search? Enter linear or binary or quit");
        String search = scanner.nextLine();
        search = scanner.nextLine();
        while(!search.equals("quit")){
            long totalTime = searcher.timeAlgorithm(toFind, search);
            System.out.println("The algorithm took" + totalTime + "ms");
            System.out.println("Enter number to search:");
            toFind = scanner.nextInt();
            System.out.println("Which type of search? Enter linear or binary or quit");
            search = scanner.nextLine();
            search = scanner.nextLine();
        }
        System.out.println("Bye!");
    }


}





