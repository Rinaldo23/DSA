package Arrays.Level_1;

public class FloorAndCeil {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int floor = 0;
        int ceil = 0;
        
        while(lo <= hi){
            // int mid = (lo + hi) / 2;
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid] < target){
                lo = mid + 1;
                floor = nums[mid];
            }else if(nums[mid] > target){
                hi = mid - 1;
                ceil = nums[mid];
            }else{
                floor = nums[mid];
                ceil = nums[mid];
                break;
            }
        }
        return -1;
    }
}
