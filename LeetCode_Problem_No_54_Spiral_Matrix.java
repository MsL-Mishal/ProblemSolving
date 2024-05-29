class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int row_size = matrix.length;
        int col_size = matrix[0].length;

        int count = 0;
        List<Integer> result = new ArrayList<>();

        //These four indexes are the key to this problem
        int left = 0;
        int right = col_size - 1;
        int up = 0;
        int down = row_size - 1;

        // We'll be traversing the border elements of each outer matrices in one iteration and in further iterations we'll do the same for each inner matrices
        while( count < ( row_size * col_size ) )
        {
            // traverse from left to right
            for( int col = left; col <= right; col++ )
            {
                result.add(matrix[up][col]);
                count++;
            }    

            // traverse from up to down
            for( int row = up + 1; row <= down; row++ )
            {
                result.add(matrix[row][right]);
                count++;
            }

            if(up != down)  // to avoid duplicates when only a single row is remaining, since they will already be added while traversing from left to right
            {
                // traverse from right to left
                for( int col = right - 1; col >= left; col-- )
                {
                    result.add(matrix[down][col]);
                    count++;
                }
            }

            if(left != right)   // to avoid duplicates when only a single column is remaining, since they will already be added while traversing from up tp down
            {
                // traverse from down to up
                for( int row = down - 1; row >= up + 1; row-- )
                {
                    result.add(matrix[row][left]);
                    count++;
                }
            }

            // Updating the index values to traverse the inner matrices
            left++;
            up++;
            right--;
            down--;
        }
        return result;
    }
}
