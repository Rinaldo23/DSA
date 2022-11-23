package Arrays.Level_1;

import java.util.*;

public class SubSetOfAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }

        subSet(arr);
    }

    private static void subSet(int[] arr) {
        int limit = (int)Math.pow(2, arr.length);

        for(int i = 0 ; i < limit ; i++){
            int temp = i;
            String ans = "";
            for(int j = arr.length - 1 ; j >= 0 ; j--){
                int rem = temp % 2;
                temp = temp / 2;

                if(rem == 0){
                    ans = "_\t" + ans;
                }else{
                    ans = arr[j] + "\t" + ans;
                }
            }
            System.out.println(ans);
        }
    }

    // LeetCode
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subSetOfArray(nums, ans);
        return ans;
    }
    
    public void subSetOfArray(int[] arr, List<List<Integer>> ans){
        int limit = (int)Math.pow(2, arr.length);
        
        for(int i = 0 ; i < limit ; i++){
            List<Integer> base = new ArrayList<>();
            int temp = i;
            for(int j = arr.length - 1 ; j >= 0 ; j--){
                int rem = temp % 2;
                temp = temp / 2;
                
                if(rem == 1){
                    base.add(arr[j]);
                }
            }
            ans.add(base);
        }
    }
}
