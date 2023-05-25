package LeetCode168;

import java.util.Arrays;

public class KClosestPoint973 {
    public static void main(String[] args) {
        int[][] testcase1 = {{1, 2}, {4, 5}, {3, 3}, {2, 6}};
        MaxHeap maxHeap = new MaxHeap(6);

        for (int[] point: testcase1) {
            maxHeap.add(point);
        }

        System.out.println(Arrays.deepToString(maxHeap.data));

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(maxHeap.pop()));
            System.out.println(Arrays.deepToString(maxHeap.data));
        }
    }
}

class MaxHeap {
    int[][] data;
    int size;

    public MaxHeap(int size) {
        this.data = new int[size][2];
        this.size = 0;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return i * 2 + 1;
    }

    private int getRightChild(int i) {
        return i * 2 + 2;
    }

    public void add(int[] point) {
        this.data[this.size++] = point;

        this.heapifyUp();
    }

    public int[] pop() {
        this.swap(0, --this.size);
        this.heapifyDown();
        System.out.println(this.size);
        return this.data[this.size];
    }

    private void heapifyDown() {
        int start = 0;

        while (start < this.size - 1) {
            int targetIndex = 0;
            int leftChildIndex = this.getLeftChild(start);

            if (this.smallerThanPoint(start, leftChildIndex)) targetIndex = leftChildIndex;
            int rightChildIndex = this.getRightChild(start);
            if (this.smallerThanPoint(leftChildIndex, rightChildIndex)) targetIndex = rightChildIndex;

            if (targetIndex != 0) {
                this.swap(start, targetIndex);
                start = targetIndex;
            } else break;
        }
    }

    private boolean smallerThanPoint(int i, int j) {
        return j <= this.size - 1
                && this.getDistance(this.data[i]) < this.getDistance(this.data[j]);
    }

    private void heapifyUp() {
        int start = this.size - 1;

        while (start > 0) {
            int parentIndex = this.getParentIndex(start);

            if (this.getDistance(this.data[start]) > this.getDistance(this.data[parentIndex])) {
                this.swap(start, parentIndex);
                start = parentIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int left, int right) {
        int[] temp = this.data[left];
        this.data[left] = this.data[right];
        this.data[right] = temp;
    }

    private long getDistance(int[] point) {
        return (long) point[0] * point[0] + (long) point[1] * point[1];
    }
}