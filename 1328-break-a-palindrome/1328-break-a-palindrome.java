class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        char ch[]= palindrome.toCharArray();
        String ans="";boolean modified=false;boolean alla=true;
        for(int i=0;i<ch.length/2;i++){
            int cur=(int)ch[i];
            if(cur!=97)alla=false;
            if(cur>97){
                ch[i]='a';
                modified=true;
                break;
            }
        }
        if(alla==true){ch[ch.length-1]='b';ans=String.copyValueOf(ch);}
        if(modified==true)ans=String.copyValueOf(ch);
        return ans;
    }
}