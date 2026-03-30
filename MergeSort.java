public class MergeSort {
    public static void printarray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergesort(int arr[], int sidx, int  eidx){
        if (sidx>=eidx) {
            return;
        }
        int mid = sidx+(eidx-sidx)/2;
        mergesort(arr, sidx, mid);
        mergesort(arr, mid+1, eidx);
        merge(arr, sidx,mid, eidx);
    }
    public static void merge(int arr[], int sidx, int mid, int eidx ){
        int temp [] = new int[eidx-sidx+1];
        int i = sidx;// left iterator
        int j = mid+1; // right iterator
        int k = 0; // temp iterator
        while (i<=mid && j<= eidx) {
            if (arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // left part 
        while (i<=mid) {
            temp[k++]= arr[i++];
        }
        //right part
        while (j<=eidx) {
            temp[k++]= arr[j++];
        }
       for (k = 0, i=sidx; k < temp.length; k++,i++) {
        arr[i] = temp[k];
       }
    }
    public static void main(String[] args) {
        int arr [] ={6,3,9,5,2,8};
        mergesort(arr, 0, arr.length-1);
        printarray(arr);
    }
}
