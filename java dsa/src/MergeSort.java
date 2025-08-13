import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6,0,4,3,7,8,9};
        arr = MergeSort(arr);
        System.out.println(Arrays.toString(arr));

        //in place merge sort
        int[] b = {5,1,2,3,4};
        MergeSortInPlace(b , 0 , b.length );
        System.out.println(Arrays.toString(b));
    }
    public static int[] MergeSort(int[] arr){
        if(arr.length == 1)
            return arr;

        int mid = arr.length /2;
        int[] left = MergeSort(Arrays.copyOfRange(arr , 0 ,mid));
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return SortedMerge(left , right);

    }
    public static int[] SortedMerge(int[] a , int[] b ){
        int i = 0, j = 0, k = 0;
        int[] result = new int[a.length + b.length];

        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                result[k] = a[i];
                i++;
            }
            else{
                result[k] = b[j];
                j++;
            }
            k++;
        }

        //for the remaining elements in each array after the either size of a or b is exceeded
        while(i < a.length){
            result[k] = a[i];
            i++;
            k++;
        }
        while(j < b.length){
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }

    public static void MergeSortInPlace(int[] arr , int start , int end){
        if(end - start  == 1)
            return ;

        int mid = start + ( end - start) /2;
        MergeSortInPlace(arr , start ,mid);
        MergeSortInPlace(arr , mid ,end);

        SortedMergeInPlace(arr, start , mid , end);

    }
    public static void SortedMergeInPlace(int[] a , int start , int mid , int end ){
        int i = start, j = mid, k = 0;
        int[] result = new int[end - start];

        while(i < mid && j < end){
            if(a[i] < a[j]){
                result[k] = a[i];
                i++;
            }
            else{
                result[k] = a[j];
                j++;
            }
            k++;
        }

        //for the remaining elements in each array after the either size of a or b is exceeded
        while(i < mid){
            result[k] = a[i];
            i++;
            k++;
        }
        while(j < end){
            result[k] = a[j];
            j++;
            k++;
        }

        //copying to original array

        for(int index = 0 ; index < result.length ;index++){
            a[start + index] = result[index];
        }
    }
}
