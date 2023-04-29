public class Second
{
    // It is not somthing of the code it is only Checking if the code works. 
    public static void main(String[] args)
    {
        int[] arr1 = new int[]{-2, 4};
        int[] arr2 = new int[]{-2,1, 4, 7, 10, 13, 16, 22, 25};
        int[] arr3 = new int[]{-8,4,10, 16, 22, 28, 34, 40};
        int[] arr4 = new int[]{3, 7, 11, 15, 19, 27};
        System.out.println("Test number 1: " + (missingValue(arr1) == 1));
        System.out.println("Test number 2: " + (missingValue(arr2) == 19));
        System.out.println("Test number 3: " + (missingValue(arr3) == -2));
        System.out.println("Test number 4: " + (missingValue(arr4) == 23));
    }    
    
    public static int missingValue (int [] arr)
    {
        //Finding the missing number in an array of 2
        if(arr.length == 2)
        {
            return ((arr[0] + arr[1]) / 2);
        }
        
        //Finding the difference of the invoice series
        int diff;
        if((arr[1] - arr[0]) < (arr[2] - arr[1]))
        {
            diff = arr[1] - arr[0];
        }
        else
        {
            diff = arr[2] - arr[1];
        }
        
        //Finding the missing number using the Binary Search method
        int min = 0;
        int max = arr.length - 1;
        int temp = (max + min) / 2;
        while(max != min + 1)
        {
            temp = (max + min) / 2;
            if((max - temp) * diff == arr[max] - arr[temp])
            {
                max = temp;
            }
            else
            {
                min = temp;
            }
        }
        return ((arr[min] + arr[max]) / 2);
    }
        
        
        
    
}
