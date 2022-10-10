class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        int j, k;

        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > (i == len ? Integer.MIN_VALUE : arr[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                sum += (long)arr[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }
        return (int)(sum % (long) (1e9 + 7));
    }
}
