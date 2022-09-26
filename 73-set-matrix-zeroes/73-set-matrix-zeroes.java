class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col0=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                col0=true;break;
            }
        }
        // System.out.print(col0);
        boolean row0=false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                row0=true;break;
            }
        }
        // System.out.print(row0);
        for(int i=1;i<matrix.length;i++){
            for( int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }       
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        // System.out.print(Arrays.deepToString(matrix));   
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        if(col0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(row0){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
    }
}