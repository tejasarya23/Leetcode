class Solution {
    public boolean isPalindrome(String s) {
        int i=0;int j =s.length()-1;
        while(i<j){
            int left = (int) s.charAt(i);
            int right= (int) s.charAt(j);
            // System.out.print((int)'');
            boolean check = false;
            boolean l=((left>=65&& left<=90) || (left>=97&& left<=122) || (left>=48&& left<=57) );
            boolean r=(right>=65&& right<=90) || (right>=97&& right<=122 || (right>=48&& right<=57));
            if((left>=48&& left<=57) || (right>=48&& right<=57) ) check = true;
            System.out.print(left+" "+right+" || ");
            if( l && r ){
                if(left==right || (check==false&&left+32==right) || (check==false&&left==32+right) ){
                    i++;j--;continue;
                }else{
                    return false;
                }
            }else{
                if(l==false)i++;
                if(r==false)j--;
            }
        }
        return true;
    }
}