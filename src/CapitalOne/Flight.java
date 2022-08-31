package CapitalOne;

public class Flight {
    public static void main(String[] args) {
        int[] nums1 = {109, 500};
        int[] nums2 = {210, 600};
        Flight f = new Flight();

        System.out.println(f.countTime(nums1, nums2, 2));
    }

    public int countTime(int[] nums1, int[] nums2, int n) {
        int f1 = 0;
        int f2 = 0;
        int arrivedTime = 0;
        int flag = 1;  // 1 - a to b, 2 - b to a

        while (n > 0) {
            if (flag == 1) {
                f1 = this.findEarliest(nums1, f1, arrivedTime);
                arrivedTime = this.travel(nums1[f1], 100);
                flag = 2;
            } else if (flag == 2) {
                f2 = this.findEarliest(nums2, f2, arrivedTime);
                arrivedTime = this.travel(nums2[f2], 100);
                n--;
                flag = 1;
            }
        }

        return arrivedTime;
    }

    private int travel(int startTime, int duration) {
        return startTime + duration;
    }

    private int findEarliest(int[] flight, int index, int arrivedTime) {

        while (index < flight.length && flight[index] < arrivedTime) {
            index++;
        }

        return index;
    }
}
