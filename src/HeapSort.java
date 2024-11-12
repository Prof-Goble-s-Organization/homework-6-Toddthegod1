import java.util.Arrays;

public class HeapSort {
    public static void heapSort(Integer[] values) {
        int n = values.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(values,n,i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(values, 0, i);

            heapify(values, i, 0);
        }
       
    }

    private static void heapify(Integer[] array, int heapSize, int rootIndex) {
        int smallest = rootIndex;
        int leftChild =  2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] < array[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] < array[smallest]) {
            smallest = rightChild;
        }
        
        if (smallest != rootIndex) {
            swap(array, rootIndex, smallest);
            heapify(array, heapSize, smallest);
        }
    }

    private static void swap(Integer[] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
    }
}
