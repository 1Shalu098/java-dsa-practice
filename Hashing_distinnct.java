import java.util.HashSet;

public class Hashing_distinnct {
    public static void main(String[] args) {
        int arr[] = {4,3,5,2,6,7,3,4,2,1};
        HashSet<Integer> ls = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            ls.add(arr[i]);
        }
        System.out.println(ls.size());
    }
}
