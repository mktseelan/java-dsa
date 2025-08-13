import java.util.ArrayList;
import java.util.Arrays;

public class StringRecursion {
    public static void main(String[] args) {
        String str = "akmaahaar";
        //remove all a in the string;
        str = removeAllChar(str , 'a');
        System.out.println(str);

        //skip an string itseld
        String s = "is it containing apple ?";
        s = removeAllSring(s , "apple");
        System.out.println(s);

        //print all subsequence of the string;
        subset( "" ,"abc");

        System.out.println(subsetArrayList("", "xyz"));

        //itration
        subsetIteration(new int[] {1,2,3});
        //subset interation having duplicate values
        subsetIterationDuplicates(new int[] { 2,1,2 ,2});

    }
    public static void subsetIteration(int[] arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int num : arr){
            int n = res.size();
            for( int i = 0; i< n ;i++ ){
                ArrayList<Integer> internal  = new ArrayList<>(res.get(i));
                internal.add(num);
                res.add(internal);
            }
        }

        System.out.println(res);
    }

    public static void subsetIterationDuplicates(int[] arr){
        Arrays.sort(arr);
        int start = 0 , end = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int i = 0; i<  arr.length ;i++){
            start = 0;
            if(i>0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = res.size()-1;
            int n = res.size();
            for( int j = start; j< n ;j++ ){
                ArrayList<Integer> internal  = new ArrayList<>(res.get(j));
                internal.add(arr[i]);
                res.add(internal);
            }
        }

        System.out.println(res);
    }

    public static void subset(String str , String s){
        if(s.isEmpty()){
            System.out.println(str);
            return;
        }
        char c = s.charAt(0);

        subset(str + c , s.substring(1) );
        subset(str , s.substring(1));

    }
    public static ArrayList<String> subsetArrayList(String ans , String str){
        ArrayList<String> res = new ArrayList<>();
        if(str.isEmpty()){
            res.add(ans);
            return res;
        }
        char c = str.charAt(0);

        res.addAll(subsetArrayList(ans + c , str.substring(1) ));
        res.addAll(subsetArrayList(ans , str.substring(1)));

        return res;

    }

    public static String removeAllSring(String str , String unwanted){
        if(str.isEmpty())
            return "";

        if(str.startsWith(unwanted))
            return removeAllSring(str.substring(unwanted.length()) , unwanted);

        else
            return str.charAt(0) + removeAllSring(str.substring(1) , unwanted);
    }

    public static String removeAllChar(String str, char c ){
        if(str.isEmpty())
            return "";

        if(str.charAt(0) == c){
            return  removeAllChar(str.substring(1), c);
        }
        else
            return   str.charAt(0) + removeAllChar(str.substring(1) , c );
    }


}
