class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int totalElements = n * n;
        int count = 1;

        // These four indexes are the key to this problem
        int left = 0;
        int right = n - 1;
        int top = 0;
        int down = n - 1;

        while( count <= totalElements ) {
            // Traverse from left to right
            for( int col = left; col <= right; col++ ) {
                matrix[top][col] = count;
                count ++;
            }

            // Traverse from top to down
            for( int row = top + 1; row <= down; row++) {
                matrix[row][right] = count;
                count ++;
            }
            
            // To avoid duplicates when only a single row is remaining, since they will already be added while traversing from left to right
            if( top != down ) {
                // Traverse from right to left
                for( int col = right - 1; col >= left; col-- ) {
                    matrix[down][col] = count;
                    count ++;
                }
            }

            // To avoid duplicates when only a single column is remaining, since they will already be added while traversing from top to down
            if( left != right ) {
                // Traverse from down to top
                for( int row = down - 1; row > top; row-- ) {
                    matrix[row][left] = count;
                    count ++;
                }
            }

            // Updating pointers to traverse the inner matrices
            left ++;
            right --;
            top ++;
            down --;
        }
        return matrix;
    }
}
