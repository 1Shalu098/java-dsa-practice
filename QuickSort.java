public class QuickSort {
    public static void arrprint (int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void Quicksort(int arr[], int si, int ei){
        if (si>=ei) {
            return;
        }
       int pIdx =  partition(arr, si, ei);
        Quicksort(arr, si, pIdx-1);
         Quicksort(arr, pIdx+1, ei);
    }
    public static int partition(int arr[], int si, int ei){
        int pviot = arr[ei];
        int i = si-1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pviot) {
                i++;
            // swap
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            }
        }
        i++;
         int temp = pviot;
           arr[ei] = arr[i];
            arr[i] = temp;
            
          return i;
    }
    public static void main(String[] args) {
        int arr [] = {6, 3, 9, 8, 2, 5, -5};
        Quicksort(arr, 0, arr.length-1);
        arrprint(arr);
    }
}
