package Cisco;

import java.util.HashMap;

public class HotelBirthday {
    /*
        In the hotel, there are birthday celebrations every month. Given N number of days which are
        representing the birthday. Find the number of days where there are an odd number of birthday
        celebrations.
     */

    public static void main(String[] args) {
        int[] birthDayArr = {4, 8, 2, 8, 9};
        int days = 5;
        HotelBirthday hb = new HotelBirthday();

        System.out.println(hb.countBirthDay(days, birthDayArr));
    }

    public int countBirthDay(int n, int[] birthDayArr) {
        HashMap<Integer, Integer> countDayMap = new HashMap();

        for (int day : birthDayArr) {
            countDayMap.put(day, countDayMap.getOrDefault(day, 0) + 1);
        }

        int result = 0;
        for (int key : countDayMap.keySet()) {
            int times = countDayMap.get(key);

            if (times % 2 != 0) result++;
        }

        return result;
    }
}
