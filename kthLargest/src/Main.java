import java.util.PriorityQueue;

public class Main {

    public static
    int prioritySelect(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int elements : arr) {
            queue.offer(elements);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static
    int kthLargest(int[] arr, int k) {
        //base case
        if (k < 1 || arr == null) {
            return 0;
        }
        int quickSelect = quickSelect(arr.length - k, arr, 0, arr.length - 1);
        int kLargest = prioritySelect(arr, 2);
        return quickSelect;

        //Using quickSort algorithm


    }

    public static int quickSelect(int k, int[] arr, int start, int end) {
        int pivot = arr[end];

        int left = start;
        int right = end;

        while (true) {
            while (arr[left] < pivot && left < right) {
                left++;
            }
            while (arr[right] > left && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

            if (k == left + 1) {
                return pivot;
            } else if (k <= left) {
                return quickSelect(k, arr, start, left - 1);
            } else {
                return quickSelect(k, arr, left + 1, end);

            }

    }


    public static void main(String[] args) {
        int [] myArr={1 ,7, 2, 4, 6, 19 };
        int k=4;
        int kthLargest= kthLargest(myArr,k);
    }
}
