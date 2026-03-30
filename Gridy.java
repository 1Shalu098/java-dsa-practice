public class Gridy {
    public static int Gridy (int i, int j, int n, int m){
        if (i==n-1||j==n-1) {
            return 1;
        }else if (i==n|| j==n) {
            return 0;
        }
       int g1 = Gridy(i+1, j, n, m);
      int g2 =  Gridy(i, j+1, n, m);
        return g1+g2;
    }
public static void main(String[] args) {
    int n =3;
    int m= 3;
   int w =  Gridy(0, 0, n, m);
   System.out.println(w);
}
    
}
