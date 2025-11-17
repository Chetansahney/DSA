class NumMatrix {
 int prefix[][];
    public NumMatrix(int[][] matrix) 
    {
         int row=matrix.length;
         int col=matrix[0].length;
         prefix=new int[row+1][col+1];
         for(int i=0;i<row;i++)
         { int sum=0;
            for(int j=0;j<col;j++)
            {
                sum+=matrix[i][j];
                prefix[i+1][j+1]=sum+prefix[i][j+1];
            }
         }

    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) 
    {
        r1++;c1++;r2++;c2++;
        return prefix[r2][c2] - prefix[r2][c1-1] - prefix[r1-1][c2] + prefix[r1-1][c1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */