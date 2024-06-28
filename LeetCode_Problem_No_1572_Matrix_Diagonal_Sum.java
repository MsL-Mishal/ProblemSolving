class Solution {
    public int diagonalSum(int[][] mat) 
    {
        int sum = 0;

        int rows = mat.length;  //number of rows
        int cols = mat[0].length;   //number of columns

        //Iterating over the rows only
        for( int rowNo = 0; rowNo < rows; rowNo++ )
        {
            int primaryDiagonal = mat[rowNo][rowNo];    //pattern for primary diagonal elements
            int secondaryDiagonal = mat[rowNo][cols - 1 - rowNo];   //pattern for secondary diagonal elements

            sum += primaryDiagonal; //adding primary diagonal elements directly to sum value
            
            //To avoid adding up of elements common to both diagonals again
            if ( rowNo != (cols - 1 - rowNo) )
                sum += secondaryDiagonal;
        }

        return sum;    
    }
}
