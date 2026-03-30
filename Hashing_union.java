import java.util.*;
public class Hashing_union {
    public static void main(String[] args) {
        int arr1 [] = {7,3,9};
        int arr2 [] = {6,3,9,2,9,4};
        HashSet<Integer> hm = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            hm.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hm.add(arr2[i]);
        }
        System.out.println( "size of union "+hm.size());
        System.out.println(hm);
        hm.clear();
        for (int i = 0; i < arr1.length; i++) {
            hm.add(arr1[i]);
        }
        int count =0;
        for (int i = 0; i < arr2.length; i++) {
            if (hm.contains(arr2[i])) {
                count++;
                hm.remove(arr2[i]);
                  System.out.println(hm);
            }
        } 
        System.out.println(count);
    }
}
