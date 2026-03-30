public class Backtraking {
// find the all subset 
public static void findSubset(String str, String ans, int i){
    if (i==str.length()) {
        System.out.println(ans);
        return;
    }
    findSubset(str, ans+str.charAt(i), i+1);
    findSubset(str, ans, i+1);
}
     // find permitation 
     public static void findPermitation(String str, String ans){
        if (str.length()==0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i <str.length(); i++) {
            char current = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);
            findPermitation(newstr, ans+current);
        }
     }
    public static void main(String[] args) {
        String str = "shalu";
       // findSubset(str, "", 0);
       findPermitation(str, "");
    }
}
