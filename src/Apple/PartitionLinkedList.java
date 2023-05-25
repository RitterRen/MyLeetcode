package Apple;

public class PartitionLinkedList {
    /**
     * Partition a linked list to left and right let all the value in the right side larger than the left side
     * return length of left linked list
     *
     * requirement : use O(1) space
     */
    public int partitionLinkedList(Node head) {
        Node dummyHeadLeft = new Node();
        Node pointer = head.next;
        Node leftPointer = dummyHeadLeft;
        leftPointer.next = head;
        leftPointer = leftPointer.next;
        int lengthForLeft = 1;
        int maxLeftVal = leftPointer.value;
        leftPointer.next = null;

        while (pointer != null) {
            if (maxLeftVal >= pointer.value) {
                leftPointer.next = pointer;
                pointer = pointer.next;
                leftPointer = leftPointer.next;
                leftPointer.next = null;
                lengthForLeft++;
            }else {
                pointer = pointer.next;
            }

        }

        System.out.println(this.printLinkedList(dummyHeadLeft.next));

        return lengthForLeft;
    }

    private Node createLinkedListFromArr(int[] arr) {
        Node dummyHead = new Node();
        Node p = dummyHead;

        for (int i = 0; i < arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }

        return dummyHead.next;
    }

    private String printLinkedList(Node head) {
        StringBuilder sb = new StringBuilder();

        Node p = head;

        while (p != null) {
            sb.append(p.value).append(" -> ");
            p = p.next;
        }

        return sb.toString();
    }

    // Test
    public static void main(String[] args) {
        PartitionLinkedList solution = new PartitionLinkedList();

        int[] arr1 = {1, 3, -2, 6, -7, -9};
        Node head = solution.createLinkedListFromArr(arr1);

        System.out.println(solution.partitionLinkedList(head));
    }
}
