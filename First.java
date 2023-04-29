public class First
{
    // It is not somthing of the code it is only Checking if the code works. 
    public static void main(String[] args)
    {
        int[] arr1 = new int[]{5, 4, 5, 8, 12, 9, 9, 3};
        int[] arr2 = new int[]{7, 3, 3, 12, 10, 2, 10, 7}; // The answer is 49
        
        int[] arr3 = new int[]{4, 5, 2, 8};
        int[] arr4 = new int[]{2, 6, 3, 9}; // The answer is 17
        
        int[] arr5 = new int[]{2, 6, 3, 9};
        int[] arr6 = new int[]{2, 6, 3, 9}; // The answer is 20
        
        int[] arr7 = new int[]{2, 2, 2, 2};
        int[] arr8 = new int[]{3, 3, 3, 3}; // The answer is 8
        
        int[] arr9 = new int[]{4, 0, 2, 8};
        int[] arr10 = new int[]{2, 6, 3, 9}; // The answer is 12
        
        int[] arr11 = new int[]{5, 4, 8, 5, 9, 12, 9, 3};
        int[] arr12 = new int[]{2, 9, 4, 1, 8, 2, 1, 2}; // The answer is 27
        
        System.out.println("1. Test arrays at with the same road: " + (shortestRoad(arr1, arr2) == 49));
        System.out.println("2. Test arrays at with the same road: " + (shortestRoad(arr3, arr4) == 17));
        System.out.println("3. Test arrays at with the same road: " + (shortestRoad(arr5, arr6) == 20));
        System.out.println("4. Test arrays at with the same road: " + (shortestRoad(arr7, arr8) == 8));
        System.out.println("5. Test arrays at with the same road: " + (shortestRoad(arr9, arr10) == 12));
        System.out.println("6. Test arrays at with the same road: " + (shortestRoad(arr11, arr12) == 27));
    }
    
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
}
