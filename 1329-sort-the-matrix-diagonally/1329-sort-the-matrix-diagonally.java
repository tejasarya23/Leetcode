class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int i=0;
        int j=0;
        int n = mat.length;
        int m = mat[0].length;
        int itr=m+n-1;int count=1;

        while(i<n){
            sort1(mat,i,j,n,m);
            i++;
        }
        j=0;
        while(j<m){
            sort2(mat,i,j,n,m);
            j++;
        }

        return mat;
    }
    public int[][] sort1(int[][]mat,int i ,int j , int n ,int m){
        List<Integer> l = new ArrayList<>();
        j=0;int ii=i;
        while(ii<n&&j<m){
            l.add(mat[ii][j]);
            j++;ii++;
        }
        // System.out.print(l);
        Collections.sort(l);
        // System.out.print(l);
        ii=i;j=0;int len=l.size();int a=0;
        while(ii<n&&a<len){
            mat[ii][j]=l.get(a);
            j++;ii++;a++;
        }
        return mat;
    }
    public int[][] sort2(int[][]mat,int i ,int j , int n ,int m){
        List<Integer> l = new ArrayList<>();
        i=0;int jj=j;
        while(jj<m&&i<n){
            l.add(mat[i][jj]);
            i++;jj++;
        }
        // System.out.print(l);
        Collections.sort(l);
        // System.out.print(l);
        jj=j;i=0;int len=l.size();int a=0;
        while(jj<m&&a<len){
            mat[i][jj]=l.get(a);
            i++;jj++;a++;
        }
        return mat;
    }
}