import java.util.Scanner;

public class ArrayUtils {

    public void printArray(int [] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int[] inputArray(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        return arr;
    }

    public void sort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    public void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;

        int mid = low + ((high - low)/2);

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr,low,mid,high);
    }

    public void merge(int[] arr, int low, int mid, int high){
        int l1 = mid - low + 1;
        int l2 = high - mid;

        int[] leftArr = new int[l1];
        int[] rightArr = new int[l2];

        for(int i=0; i<l1; i++){
            leftArr[i] = arr[low + i];
        }
        for(int i=0; i<l2; i++){
            rightArr[i] = arr[mid + 1 + i];
        }

        int i=0;
        int j=0;

        int k = low;

        while(i < l1 && j < l2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i<l1) {
            arr[k++] = leftArr[i++];
        }

        while(j<l2){
            arr[k++] = rightArr[j++];
        }
    }

    // test for sort method
    public static void main(String[] args) {
        ArrayUtils obj = new ArrayUtils();
        int arr[] = obj.inputArray();
        obj.sort(arr);
        obj.printArray(arr);
    }
}
