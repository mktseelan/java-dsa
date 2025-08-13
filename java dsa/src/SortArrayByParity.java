import java.util.Arrays;

public class SortArrayByParity {
        public static void main(String[] args) {
            int[] res = sortArrayByParityII(new int[]{888,505,627,846});
            System.out.println(Arrays.toString(res));

            int[] a = sortedSquares(new int[]{-4,-3,0,8,10});
            System.out.println(Arrays.toString(a));
        }

    public static int[] sortedSquares(int[] nums) {
        int k = nums.length - 1 , i = 0 , j = nums.length -1;
        int[] res = new int[nums.length];

        while(i <= j) {
            int a = Math.abs(nums[i]);
            int b = Math.abs(nums[j]);

            if (a >= b) {
                res[k] = a * a;
                k--;
                i++;
            } else {
                res[k] = b * b;
                k--;
                j--;
            }
        }

        return res;
    }
        public static int[] sortArrayByParityII(int[] nums) {
            int i= 0 , j = nums.length -1;

            while( i < nums.length && j >=0){
                if( nums[i] % 2 == 0)
                    i = i+2;
                else {
                    swap(nums, i, j);
                    j = j - 2;
                }
            }

            return nums;
        }

        public static void swap(int[] nums , int pos1, int pos2){
            int temp = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = temp;
        }

}
