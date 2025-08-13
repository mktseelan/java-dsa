import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

        //dice problem
        diceProblem("" , 5);

        int[] nums = {2,2,3,3,3,1,1,1,1};
            int[] count = new int[201];
            for (int num : nums) {
                count[num + 100]++;
            }
            Integer[] numsArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(numsArr, (a, b) -> {
                if (count[a + 100] == count[b + 100]) {
                    return b - a;
                }
                return count[a + 100] - count[b + 100];
            });

    }

    public static void diceProblem(String ans , int target){
        if(target == 0){
            System.out.println(ans);
            return;
        }
        for(int i = 1 ; i<=6 && target - i >=0 ;i++){
            diceProblem(ans + i , target -i);
        }
    }
    
    public static String numToString(char n){
        switch(n){
            case '2' : return "abc";
            case '3' : return "def";
            case '4' : return "ghi";
            case '5' : return "jkl";
            case '6' : return "mno";
            case '7' : return "pqrs";
            case '8' : return "tuv";
            case '9' : return "wxyz";
        };

        return "";
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> res = computeAnswer("" , digits);
        return res;
    }
    public static List<String> computeAnswer(String ans , String str){
        List<String> res = new ArrayList<>();

        if(str.isEmpty()){
            res.add(ans);
            return res;
        }

        String curr = numToString(str.charAt(0));

        for(int i=0;i<curr.length();i++){
            res.addAll(computeAnswer(ans + curr.charAt(i) , str.substring(1)));
        }

        return res;
    }
}
