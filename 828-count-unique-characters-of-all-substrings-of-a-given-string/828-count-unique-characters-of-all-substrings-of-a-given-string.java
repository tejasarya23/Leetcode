class Solution {
    public int uniqueLetterString(String s) {
        int[] contribution = new int[26];
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        int res = 0;
        for(int i = 0; i<s.length(); i++) {
            int curLetterContribute = i+1;
            //check if seen letter before
            if(lastPos[s.charAt(i) - 'A'] != -1) {
                curLetterContribute -= lastPos[s.charAt(i) - 'A'] + 1;
            }
            //update contribute for that letter
            contribution[s.charAt(i) - 'A'] = curLetterContribute;
            //update its last seen position
            lastPos[s.charAt(i) - 'A'] = i;
            int curUnique = 0;
            //get all new generated strings unqiue values
            for(int contribute : contribution) curUnique += contribute;
            res += curUnique;
        }
        return res;
    }
//      public int uniqueLetterString(String s) {
        
//         int sum = 0, curr = 0, n = s.length();
        
//         int[] last = new int[26];
//         int[] prev = new int[26];
        
//         Arrays.fill(last,-1);
//         Arrays.fill(prev,-1);
        
//         char[] chars = s.toCharArray();
//         for(int i=0;i<n;i++) {
//             char c = chars[i];
//             // curr = curr + q - r + 1 
//             // q = i - lastIndex - 1
//             // r  = lastIndex - previndex
//             curr += (i - last[c-65] - 1) - (last[c-65] - prev[c-65]) + 1;
//             prev[c-65] = last[c-65];
//             last[c-65] = i;
//             sum += curr;
//         }
        
//         return sum;
//     }
}