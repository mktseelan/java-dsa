import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        List<String> res = new ArrayList<>();
        Permutation( "", str , res);
        System.out.println(res);
    }
    public static void Permutation(String ans , String str , List<String> res ){
        if(str.isEmpty()){
            res.add(ans);
            return;
        }

        for(int i=0 ; i<= ans.length() ;i++ ){
            char ch = str.charAt(0);
            Permutation(ans.substring(0,i) + ch + ans.substring(i,ans.length()) , str.substring(1) ,res );
        }
    }
}
