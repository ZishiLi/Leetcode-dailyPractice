class Solution {
    public int findTargetSumWays(int[] nums, int S) {
         HashMap<String, Integer> cache = new HashMap<String, Integer>();
        return sup(S, 0, nums,cache);
    }
    public int sup(int S, int index,int[] nums,  HashMap<String, Integer> cache){
        if(index == nums.length) {
            if(S == 0){
                cache.put(index+"-"+S,1);
                return 1;
            }
            else return 0;
        }
        if(cache.containsKey(index+"-"+S)) return cache.get(index+"-"+S);
        int left = sup(S-nums[index],index + 1,nums,cache);
        int right = sup(S+nums[index],index + 1,nums,cache);
        cache.put(index+"-"+S,left + right);
        return(left+right);
    }
    
     
         
}
