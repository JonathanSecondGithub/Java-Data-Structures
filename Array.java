package Java;

public class Array {
    public static void main(String[] args) {
        // Declaring an array of integers
        int[] arr = new int[5];

        // Initializing the array
        for (int i = 0; i < 5; i++) {
            arr[i] = i + 1;
        }

        // Accessing array elements
        System.out.println("Element at index 0: " + arr[0]);

        // Updating array elements
        arr[0] = 10;
        System.out.println("Element at index 0 after update: " + arr[0]);

        // Traversing the array
        System.out.println("Array elements: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
