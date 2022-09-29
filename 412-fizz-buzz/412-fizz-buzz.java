class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res= new ArrayList<>();int i=1;
        while(i<=n){
            if(i%3==0){
                if(i%5==0){
                    res.add("FizzBuzz");
                }else{
                    res.add("Fizz");
                }
              i++;continue;
            }else if(i%5==0){
                res.add("Buzz");i++;continue;
            }else{
                res.add(Integer.toString(i));i++;continue;
            }
        }
        return res;
    }
}