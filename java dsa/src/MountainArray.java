public class MountainArray {
    public static void main(String[] args) {
        int ans = findInMountainArray(1 ,new int[]{0,5,3,1});
        System.out.println(ans);
    }
    public static int findInMountainArray(int target, int[] mountainArr) {
        //1.find the peak element
        //2.from start to peak  do->Binary search to find if target exists in the first half
        //if exist return
        //3.from peak to end  do->Binary search to find if target exists in the second half
        //if exist return

        int peak_index = findPeakIndex(mountainArr);
        int firstHalf = binarySearch(mountainArr , target , 0 , peak_index-1 , true);
        int secondHalf = binarySearch(mountainArr , target , peak_index , mountainArr.length-1 , false);

        return firstHalf == -1 ? secondHalf == -1 ? -1 : secondHalf : firstHalf;
    }

    public static int findPeakIndex (int[] mountainArr){
        int start = 0 , end = mountainArr.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(mountainArr[mid] < mountainArr[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }
    public static int binarySearch( int[] arr , int target , int start , int end ,boolean ascending){

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target)
                return mid;
            if(ascending) {
                if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else{
                if (arr[mid] < target)
                    end = mid - 1;
                else
                    start = mid + 1;

            }
        }

        return -1;
    }
}
