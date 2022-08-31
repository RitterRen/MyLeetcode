package CapitalOne;

public class BatteryCharge {
    public static void main(String[] args) {
        int[] nums1 = {12, 3, 5, 18};
        int[] nums2 = {8, 1, 4, 9};
        int x = 56;
        BatteryCharge bc = new BatteryCharge();

        System.out.println(bc.useBattery(nums1, nums2, x));
    }

    public int useBattery(int[] battery, int[] chargeTime, int x) {
        int chargedTime = 0;
        int b = 0;
        int c = 0;
        int result = 0;

        while (x > 0) {
            x -= battery[b];
            chargedTime += battery[b];
            b++;
            result++;

            if (b >= battery.length) {
                if (chargedTime >= chargeTime[c]) {
                    chargedTime -= chargeTime[c];
                    c++;
                    b = 0;

                    if (c >= chargeTime.length) {
                        c = 0;
                    }
                } else {
                    break;
                }
            }
        }

        if (x > 0) return -1;

        return result;
    }
}
