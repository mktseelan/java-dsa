import java.util.*;

public class ArrayRecursion {
    public static void main(String[] args) {
        //check if an array is sorted using recursion
        int[] a = {2,4,5,6,7,9 ,98};
        System.out.println(Arrays.toString(a) + " Sorted: " + isArraySorted(a,0,a.length));

        //linear search with recursion
        System.out.println(Arrays.toString(a) + "Search : 40 ::" + linearSearch(a , 0,40 ));
        //linear search getIndex
        System.out.println(LinearSearch(a,0,7));

        //return all index (return type = ArrayList)
        int[] arr = {2,3,4,4,5,4};
        ArrayList<Integer> ans = findAllIndex(arr, 0 , 4);
        System.out.println(ans);

        //find in a rotated sorted array.
        int[] b = {7,8,9,10,3,4,5};
        System.out.println(searchRotatedSortedArray(b , 0 , b.length - 1 , 5));

        //printing pattern using recursion
        //****
        //***
        //**
        //*
        printPattern(4,0);
        System.out.println( );

        //bubble sort using recursion;
        int[] sort = {8,5,9,20,36,1,2};
        BubbleSort(sort , sort.length -1, 0 );
        System.out.println(Arrays.toString(sort));

        //SelectionSort using recursion
        int[] s = {8,5,9,20,7,1,2};
        SelectionSort(s, s.length -1 , 0 , 0);
        System.out.println(Arrays.toString(s));

        //Merge two sorted array
        int[] nums1 = {10,12,14,0,0,0};
        int[] nums2 = { 2,5,6 };
        MergeArrays(nums1 ,3,  nums2 , nums2.length);
        System.out.println(Arrays.toString(nums1));

    }
    public static void MergeArrays(int[] a, int m, int[] b, int n) {
        int i = ( m - 1 );
        int j = n -1;
        int k = m + n - 1;

        while(i>=0 && j>= 0){
            if(a[i] >= b[j]){
                a[k--] = a[i--];
            }
            else{
                a[k--] = b[j--];
            }
        }

        while( j >= 0 ){
            a[k--] = b[j--];
        }

    }
    public static void BubbleSort(int[] arr , int length , int index){
        if( length == 0){
            return;
        }
        if(index < length){
            if(arr[index] > arr[index+1])
                swap(arr, index , index + 1);

            BubbleSort(arr,length , index+1);
        }
        else
            BubbleSort(arr,length-1,0);
    }
    public static void SelectionSort(int[] arr , int length , int index , int max_index){
        if( length == 0)
            return;
        if(index <= length){ // untill index<=length find the max_index
            if(arr[max_index] < arr[index])
                    max_index = index;
            SelectionSort(arr, length, index + 1 , max_index);
        }
        else {
            swap(arr , length , max_index);
            SelectionSort(arr, length - 1, 0, 0);
        }
    }
    public static void swap(int[] arr , int pos1 , int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
    public static void printPattern(int row , int col){
        if(row == 0)
            return;
        if(col < row){
            printPattern(row , col+1);
            System.out.print("* ");
        }
        else {
            printPattern(row-1 , 0);
            System.out.println();
        }
    }
    public static int searchRotatedSortedArray(int[] arr , int start , int end , int target){
        if(start > end)
            return -1;

        int mid = start + (end - start)/2;

        if(arr[mid] == target)
            return mid;

        if(arr[start] <= arr[mid]) { // left side sorted
            if (target >= arr[start] && target <= arr[mid]) {
                return searchRotatedSortedArray(arr, start, mid - 1, target);
            }
            else
                return searchRotatedSortedArray(arr, mid + 1 , end ,target);
        }

        if(target >= arr[mid] && target <= arr[end])
            return searchRotatedSortedArray(arr , mid + 1 , end ,target);
        else
            return searchRotatedSortedArray(arr, start , mid - 1 , target);
    }

    public static ArrayList<Integer> findAllIndex (int[] arr , int index , int target){

        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length)
            return list;
        if (arr[index] == target)
            list.add(index);

        ArrayList<Integer> ansFromBelow = findAllIndex(arr , index + 1 ,target);
        list.addAll(ansFromBelow);

        return list;
    }
    public static int LinearSearch(int[] arr , int index ,int target){
        if(index == arr.length ){
            return -1;
        }
        if(arr[index] == target)
            return index;
        else
            return LinearSearch(arr, index + 1,target);
    }

    public static boolean linearSearch(int[] arr ,int index, int target){
        if(index == arr.length -1){
            return arr[index] == target;
        }

        return arr[index] == target || linearSearch(arr , index + 1 , target);
    }
    public static boolean isArraySorted(int[] arr , int index , int length){
        if (length == 1)
            return true;
        if(index == length-1){
            return true;
        }

        return arr[index] <= arr[index +1] && isArraySorted(arr, index + 1 , length);
    }
}
