public class Recrsion1 {
    // decrising odder
    public static void printdec(int n){
        if (n==1) {
            System.out.println(1);
            return;
        }
        System.out.println(n);
         printdec(n-1);
    }
    // incresing order
    public static void printIc(int n){
        if (n==1) {
            System.out.println(n+" ");
            return;
        }
        printIc(n-1);
        System.out.println(n);
    }
    // fectorial number 
    public static int fac(int n){
        if (n==0) {
            return 1;
        }
      //  int fNm1 = fac(n-1);
        int fectorial = n * fac(n-1);
        return fectorial;
    }
    // print the sume of firs n natural numbers
    public static int sume(int n){
        if (n==1){
            return 1;
        }
       // int Snm = sume(n-1);
        int Sn = n + sume(n-1);
        return Sn;
    }
    // print nth fibonacci number
    public static int fibonacci(int n){
       if (n==0 || n==1) {
         return n;
       }
       int finNM1 = fibonacci(n-1);
       int fibNM2 = fibonacci(n-2);
      // int fib = fibonacci(n-1)+ fibonacci(n-2);
      int fib = finNM1+fibNM2;
       return fib;
    }
    // check array is sorted and not sorted 
    public static boolean issorted( int arr [], int i){
        if (i==arr.length-1) {
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return issorted(arr ,i+1);
    }
    // find the first occurence of an element in array
    // check the given key in index
    public static int firstoccurence(int arr [],int key, int i){
        if (i==arr.length) {
            return -1;
        }
        if (arr[i]==key) {
            return i;
        }
        return firstoccurence(arr, key, i+1);
    }

    // find the last occurence of an element in array

    public static int lastoccurence(int arr [], int key, int i){
        if (i==arr.length) {
            return -1;
        }
        int isFound = lastoccurence(arr, key, i+1);
        if (arr[i]==key && isFound== -1) {
            return i;
        }
        return isFound;
    }
    // print x^n 
    // power of the number
    public static int power(int x, int n){ 
        if (n==1) {
            return x;
        }
        return x* power(x, n-1);
    }
    // optimization of print x^n
     public static int optimizedpower(int x, int n){
        if (n==0) {
            return 1;
        }
        int halfSq = optimizedpower(x, n/2);
        int halfpowerSquare =halfSq*halfSq; 
        // n is odd
        if (n%2 !=0) {
            halfpowerSquare = x * halfpowerSquare;
        }
        return halfpowerSquare;
     }
     // problem no :- 11
     // tiling probleam approach
     public static int titlingProbleam(int n){
        if (n==0||n==1) {
            return 1;
        }
        // verticle
        // int fNM = titlingProbleam(n-1);
        // // horizontal 
        // int fNM2 = titlingProbleam(n-2);
        // int toway = fNM+fNM2;
        // return toway;
       return titlingProbleam(n-1)+titlingProbleam(n-2);
     }
     // problem 12
     // remove duplicates in a String 
     public static void removeDuplicant(String  str , int idx, StringBuilder newstr, boolean map []){
        if (idx==str.length()) {
            System.out.println(newstr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar-'a']==true) {
            removeDuplicant(str, idx+1, newstr, map);
        }else{
            map[currChar-'a']=true;
            removeDuplicant(str, idx+1, newstr.append(currChar), map);
         }
                
           
        }
        // problem 13
        //Friend pairing problem 
        public static int  FriendPairs(int n){
            if (n==1||n==2) {
                return n;
            }
            // // single 
            // int Fnp1 =FriendPairs(n-1);
            // // pair
            // int Fnp2 = FriendPairs(n-2);
            // int pairways = (n-1)*Fnp2;
            // // total
            // int totway = Fnp1+pairways; 
            // return totway;
            return FriendPairs(n-1)+ (n-1)*FriendPairs(n-2);
        }
        // problem 14 
        // binary
        public static void printBinaryString(int n, int lastPlace, String str2){
            if (n==0) {
                System.out.println(str2);
                return;
            }
            printBinaryString(n-1, 0, str2+"0");
            if (lastPlace==0) {
            printBinaryString(n-1, 1, str2+"1");                
            }
        }

    public static void main(String[] args) {
        // printdec(10);
        // printIc(10);
       // System.out.println(fac(5));
       //System.out.println(sume(5));
      // System.out.println(fibonacci(4));
     int arr [] = {1, 2, 3, 4, 5, 6, 7, 5,9, 5,3, 8,};
     //System.out.println(firstoccurence(arr, 05, 0)); 
    // System.out.println(lastoccurence(arr, 5, 0));
      //  System.out.println(power(2, 3));
     // System.out.println(optimizedpower(2, 5));
    // System.out.println(titlingProbleam(4));
      String str = "appnnacollege";
     // removeDuplicant(str, 0, new StringBuilder(""), new boolean[26]);
    // System.out.println(FriendPairs(3));
          printBinaryString(3, 0, "");
    }
}
