public class Ex11
{
   
    public static int shortestRoad (int [] road1, int [] road2)
    {
        
        // An arrays of the amount of time from each point on each road to its end without crossing the second road.
        int[] arrRoad1ToEnd = new int[road1.length];
        int[] arrRoad2ToEnd = new int[road1.length];
        
        // An arrays of the amount of time from the beginning of one of the road and across to the second road from any point on the first road to the end of the second road.
        int[] arrRoad1WithAcross = new int[road1.length];
        int[] arrRoad2WithAcross = new int[road1.length];
        
        arrRoad1ToEnd = BuildingArrToEnd(road1);
        arrRoad2ToEnd = BuildingArrToEnd(road2);
        
        arrRoad1WithAcross = BuildingArrWithAcross(road1, arrRoad2ToEnd);
        arrRoad2WithAcross = BuildingArrWithAcross(road2, arrRoad1ToEnd);
        
        // An arr of the shortest time to move from one side to the other for each road.
        int[] minOfAllRoads = new int[]{arrRoad1ToEnd[0], arrRoad2ToEnd[0], MinOfArr(arrRoad1WithAcross), MinOfArr(arrRoad2WithAcross)};
        
        // Varible of the shortest time.
        int min = minOfAllRoads[0];
        
        // Loop that finds the shortest time.
        for(int i = 1; i < minOfAllRoads.length; i++)
        {
            if(minOfAllRoads[i] < min)
            {
                min = minOfAllRoads[i];
            }
        }
        
        // The output of the shortest time to move from one side to the other.
        return min;
    }
    
    // Function that builds the arrays of the amount fo time from each point on each road to its end without crossing the second road.
    public static int[] BuildingArrToEnd(int[] road)
    {
        int lenOfArrys = road.length; 
        int [] arr = new int[lenOfArrys];
        int sum = 0;
        for(int i = 0; i< lenOfArrys; i++)
        {
            sum += road[lenOfArrys - i - 1];
            arr[lenOfArrys - 1 - i] = sum;
        }
        return arr;
    }
    
    // Function that builds the arrays of the amount of time from the beginning of one of the road and across to the second road from any point on the first road to the end of the second road.
    public static int[] BuildingArrWithAcross(int[] road1, int[] road2)
    {
        int lenOfArrys = road1.length;
        int [] arr = new int[lenOfArrys];
        int sum = 0;
        for(int i = 0; i< lenOfArrys - 1; i++)
        {
            sum += road1[i]; 
            arr[i] = road2[i + 1] + sum;
        }
        return arr;
    }
    
     // Function that finds the shortest time from arrays
    public static int MinOfArr(int[] arr)
    {
        int lenOfArrys = arr.length;
        int min = arr[0];
        for(int i = 1; i < lenOfArrys - 1; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
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
