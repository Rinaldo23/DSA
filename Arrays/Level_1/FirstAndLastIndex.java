package Arrays.Level_1;

public class FirstAndLastIndex {
    public void firstIndex(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int fi = -1;
        
        while(lo <= hi){
            // int mid = (lo + hi) / 2;
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                fi = mid;
                hi = mid - 1;
            }
        }
        System.out.println(fi);
    }

    public void lastIndex(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int li = -1;
        
        while(lo <= hi){
            // int mid = (lo + hi) / 2;
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] < target){
                lo = mid + 1;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else{
                li = mid;
                lo = mid + 1;
            }
        }
        System.out.println(li);
    }
}
