import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,7,1,5,6,4};
        QuickSort(a , 0 , a.length -1);
        System.out.println(Arrays.toString(a));
    }
    public static void QuickSort(int[] arr , int low , int high){
        if(low >= high){
            return;
        }
        int s = low , e = high ;
        int pivot = arr[low];

        while(s <= e){
                //if elements in sorted position it is not swapped
                while(arr[s] < pivot)
                    s++;
                while(arr[e] > pivot)
                    e--;

                if(s<=e){
                    int temp = arr[s];
                    arr[s] = arr[e];
                    arr[e] = temp;
                    s++;
                    e--;
                }
        }
        //pivot is at corect place after the loop
        QuickSort(arr,low , e);
        QuickSort(arr , s , high);
    }
}
