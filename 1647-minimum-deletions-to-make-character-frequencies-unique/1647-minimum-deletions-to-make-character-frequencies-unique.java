class Solution {
    public int minDeletions(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        reverse(arr);
        // Arrays.sort(arr, (int o1, int o2) -> o2 - o1);
        int count=0;
        System.out.print(Arrays.toString(arr));
        for(int i=0;i<arr.length-1;i++){
            while( (arr[i]!=0||arr[i+1]!=0) && arr[i]<=arr[i+1]){
                count++;
                arr[i+1]--;
            }
        }
        return count;
    }
    public static void reverse(int[] array)
    {
  
        // Length of the array
        int n = array.length;
  
        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {
  
            // Storing the first half elements temporarily
            int temp = array[i];
  
            // Assigning the first half to the last half
            array[i] = array[n - i - 1];
  
            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}