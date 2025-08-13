
public class StringsConcept {

    public static void main(String[] args) {
        String a = "Seelan";
        String b = "Seeln";

        String c = new String("Seelan");
        String d = new String("Seelan");

       // System.out.println(a==b);
      //  System.out.println(c==a);
        String series = "";
        for(int i=0;i<26;i++){
            series += (char)('a'+ i);
        }

        int[] weights = new int[]{1,2,3,1,1};
        int days = 4;
        FindminDays(weights , days);

    }

    public static void FindminDays ( int[] weights, int days){
        int start = 1 , end = 0 , res = 0;

        for(int num : weights){
            end+=num ;
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            int currdays = 1 , currweight = 0;

            for(int weight : weights){
                currweight += weight;

                if(currweight  > mid) {
                    currweight = weight;
                    currdays++;
                }

            }

            if(currdays <= days){
                res = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        System.out.println(res);
    }
}
