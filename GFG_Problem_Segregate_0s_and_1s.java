//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            new Solution().segregate0and1(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution 
{
    void segregate0and1(int[] arr, int n) 
    {
        // code here
        int zeroPtr = 0;
        int onePtr = n - 1;
        int temp;
        
        // S.C : O(1)
        // T.C : O(n)
        while(zeroPtr <= onePtr)
        {
            // If 0s are already in correct place   
            if(arr[zeroPtr] == 0)
            {
                zeroPtr ++;
                
                // If 1s are also in correct place
                if(arr[onePtr] == 1)
                    onePtr --;
            }
            
            // If zeroPtr points to a 1 (means -> not in correct place)
            else
            {
                // If onePtr points to a 0 (means -> not in correct place)
                // Then, we'll swap them
                if(arr[onePtr] == 0)
                {
                    temp = arr[zeroPtr];
                    arr[zeroPtr] = arr[onePtr];
                    arr[onePtr] = temp;
                    
                    zeroPtr ++;
                    onePtr --;
                }
                
                // If onePtr points to a 1 (means -> 1s are already in correct place)
                else
                    onePtr --;
            }
        }
    }

}
