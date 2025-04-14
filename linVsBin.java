
/**
 * An interactive comparing the search times for linear and binary search
 * given different list sizes
 *
 * Shane Fairhall
 * 15/04/2025
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class linVsBin
{
    /** Accepts an array of integers and a item to search for
    * performs a linear search on the array.
    * Returns the number of operation needed for the search
    */
    public static int linSearch(int[] nums, int search){
        int count = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==search){
                return(count);
            }
            count++;
        }
        return(-1);
    }
    
    /** Accepts an array of integers and a item to search for
    * performs a binary search on the array.
    * Returns the number of operation needed for the search
    */
    public static int binSearch(int[] nums, int search){
        int low=0;
        int high=(nums.length-1);
        int count = 1;
        
        while(low<=high){
            int mid = ((high-low)/2) + low;
            if(nums[mid] < search){
                low = mid+1;
                count++;
            } else if(nums[mid] > search){
                high = mid-1;
                count++;
            } else {
                return(count);
            }
        }
        return(-1);
    }
    
    /** Allows a user to enter a random list size
    * generates a random list of that size, order it, 
    * and search for an item in it.
    * Prints results of searching for the item
    */
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int max = 9999999;
        Random random = new Random();
        boolean finished = false;
        System.out.println("List size?: ");
        int size = keyboard.nextInt();
        keyboard.nextLine(); //clear the floating newline
        double searches = 0;
        int binTot=0;
        int linTot=0;
        double binAve;
        double linAve;
        
        while(!finished){
            searches++;
            int[] nums = new int[size];
            for(int i = 0; i<size; i++){
                int randomNum = random.nextInt(0, max);
                nums[i]=randomNum;
                // System.out.println(nums[i]); //testing
            }
            Arrays.sort(nums);
            
            int search = nums[random.nextInt(0, size-1)];
            int linOps = linSearch(nums, search);
            int binOps = binSearch(nums, search);
            
            linTot += linOps;
            binTot += binOps;
            
            System.out.println("******************************");
            System.out.println("Linear search operations: " + linOps);
            System.out.println("Binary search operations: " + binOps);
            System.out.println("******************************");
            
            System.out.println("Again? (Y|N): ");
            String response = keyboard.nextLine().toUpperCase();
            if(response.equals("N")){
                finished = true;
            }
        }
        
        System.out.println("\n****************************************");
        System.out.printf("Average Linear search operations: %.1f", linTot/searches);
        System.out.printf("\nAverage Binary search operations: %.1f", binTot/searches);
        System.out.println("\n****************************************");
    }   
}
