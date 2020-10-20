class Solution {
    class MyComparator implements Comparator<Integer>{
     @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2) { 
             return 1;
        }else if(o1 > o2) {
             return -1;
       }else {
            return 0;
         }
    }     
 }         
    boolean[] v;
    int res;
    int tar;

    public boolean makesquare(int[] nums) {
        Comparator cmp = new MyComparator();
        if (nums.length < 4) return false;
        v = new boolean[nums.length];
        int sum = 0;
        Integer[] a = new Integer [nums.length];
        for (int i = 0; i<nums.length;i++)
        {
            a[i]=nums[i];
            sum += nums[i];       
        }
        if (sum % 4 != 0) return false;
        tar = sum / 4;
        List<Integer> vl = new LinkedList<>();
        
        //倒叙排列
        Arrays.sort(a,cmp);
        sup(0, 0, a, vl);
        return res == 4;
    }

    private void sup(int l, int index, Integer[] nums, List<Integer> vl) {
        if (l == tar) {
            for (int x : vl) {
                if (v[x] == true) {
                    return;
                }
                v[x] = true;
            }
            res++;
        }
        else if (l > tar) return;
        for (int i = index; i < nums.length; i++) {

            if (v[i] == true) continue;
            vl.add(i);

            sup(l + nums[i], i + 1, nums, vl);
            vl.remove(vl.size() - 1);

        }
    }}