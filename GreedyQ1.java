import java.util.ArrayList;

public class GreedyQ1 {
    public static void main(String[] args) {
        int sart [] = {1,3,0,5,8,5};
        int end [] = {2,4,6,7,9,9};
        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
       ans.add(0);
       int lastend = end[0];
      for(int i=0; i<end.length; i++){
        if (sart[i] >= lastend) {
            maxAct++;
            ans.add(i);
            lastend = end[i];
        }
      }
      System.out.println(maxAct);

    }
}
