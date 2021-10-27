import java.util.HashMap;
import java.util.Map;

/* Java program for Merge Sort */
class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r, int level)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
            Map<String, String> details = new HashMap<>();
            details.put("from index", String.valueOf(l));
            details.put("to index", String.valueOf(r));
            details.put("description", "children of this level will sort from index " + String.valueOf(l) + " to index " + String.valueOf(r));
            Log log = new Log(level, details);
            log.write();
            // Sort first and second halves
            sort(arr, l, m, level + 1);
            sort(arr, m + 1, r, level + 1);

            details.put("description", "children completed. Now! indices from " + l+ " to " + m  + "and + " + m + " to " + r + " are sorted! But not merged yet!");
            log.setDetails(details);
            log.write();
            // Merge the sorted halves
            merge(arr, l, m, r);

            details.put("description", "Merge finished! Now indices from " + l + " to " + r + " are sorted!");
            log.write();

        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);
        Log.levelDefaultAsc = true;
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1, 0);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}