import java.util.ArrayList;
import java.util.List;

public class CountSmallerThanSelf {
    public static void main(String[] args) {
        int[] a = {-1,1};
        List<Integer> res = countSmaller(a);
        System.out.println(res);
    }
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            res.add(CountSmaller(nums,i+1,nums.length -1,nums[i]));
        }

        return res;
    }

    public static int CountSmaller(int[] a , int start , int end ,int target){
        if(start > end)
            return 0;
        if(end - start + 1 == 1){
            if(a[start] < target)
                return 1;
            else
                return 0;
        }
        int mid = start + (end -start)/2;

        return CountSmaller(a, start , mid , target) + CountSmaller(a,mid+1 , end ,target);
    }
}
