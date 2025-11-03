package keypadCombination;
import java.util.*;

class mapKeys {
    static String charAtDig[] = {".",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void mapDig(String s,int i,String res,List<String> opt){
       // base case
       if(i==s.length()){
            opt.add(res);
            return;
       }
       // logic
        char dig = s.charAt(i);
        String mp = charAtDig[dig-'0'];

        for(int j=0;j<mp.length();j++){
            res+=mp.charAt(j);
            mapDig(s,i+1,res,opt);
            // backtracking logic
            res=res.substring(0,res.length()-1);
        }
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> opt = new ArrayList<>();
        mapDig(str, 0, "",opt);
        System.out.println(opt);}
}