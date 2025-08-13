import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{ 3,4,-1,1 };
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //cyclicSort(arr);
        firstMissingPositive(arr);

        for(int num: arr){
            System.out.println(num);
        }

    }

    public static void firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length];
        int i=0;

        while(i<nums.length){
            if(nums[i] <= 0 || nums[i] > nums.length){
                i++;
                continue;
            }
            int correct = nums[i] - 1;

            if(nums[i] == nums[correct])
                i++;
            else
                swap(arr , correct,i);
        }

        for(int j=0;j<arr.length;j++){
            if(arr[j] != j+1){
                System.out.println(j+1);
            }
        }
    }

    static void insertionSort(int[] arr){
        int n = arr.length;

        for(int i=0;i<=n-2;i++){

            for(int j=i+1;j>0;j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    static void cyclicSort(int[] arr){

        for(int i = 0;i<arr.length ;i++){
            while( arr[i] != i +1){
                swap(arr , arr[i]-1 ,i);
            }
        }

    }

    static void selectionSort(int[] arr){
        int n = arr.length;
        int maxIndex;

        for(int i = 0; i < n;i++){
            maxIndex = i;

            for(int j=0 ;j < n-i ;j++){

                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }

            }
            swap(arr , maxIndex , n-i-1);
        }

    }

    static void bubbleSort(int[] arr){
        boolean swapOccured;
        int n = arr.length;

        for(int i=0 ; i< n ; i++) {
            swapOccured = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapOccured = true;
                }
            }
            if(! swapOccured) // no swaps took place // array is sorted
                break;
        }
    }

    static void swap(int[] arr, int start , int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
