import java.util.Arrays;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,1,7,6,5};
        quickSelect(nums , 0 , nums.length -1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSelect(int[] nums, int low , int high){
        if(low >= high){
            return;
        }
        int pivotindex = partition(nums , low , high);
        quickSelect(nums , low , pivotindex - 1);
        quickSelect(nums , pivotindex +1 , high );
    }

    public  static int partition(int[] nums , int low , int high){
        int i = low;
        int pivot = nums[high];

        for(int j = low ; j < high ;j++){
            if(nums[j] < pivot){
                swap(nums , i , j);
                i++;
            }
        }
        swap( nums , i , high);
        return i;

    }
    
    static void  swap(int [] nums , int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }



}
