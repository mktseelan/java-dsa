public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = {15,10,19,10,5,18,7};
        System.out.println(findPages(arr,5));
    }

    public static int findPages(int[] arr, int k) {
        if(k > arr.length)
            return -1;

        int start = Integer.MIN_VALUE , end = 0 , res = 0;

        for(int i : arr){
            start = Math.max(start , i);
            end+=i;
        }

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isAllocationPossible(arr, mid , k)){
                res = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return res;

    }

    public static boolean isAllocationPossible(int[] arr ,int mid ,int k){

        int pageCount = 0 , person = 1;

        for(int i = 0 ;i< arr.length ;i++){
            pageCount +=arr[i];
            if(pageCount > mid){
                pageCount-=arr[i];
                person++;
            }
        }
        if(person <= k)
            return true;
        else
            return false;
    }
}
