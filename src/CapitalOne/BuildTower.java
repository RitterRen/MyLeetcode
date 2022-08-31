package CapitalOne;

import java.util.Arrays;

public class BuildTower {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 8};
        int[] nums2 = {3, 10, 9, 9, 4};
        BuildTower bt = new BuildTower();

        System.out.println(bt.countBricks(nums1));
        System.out.println(bt.countBricks(nums2));
    }

    public int countBricks(int[] buildings) {
        if (buildings.length <= 1) return 0;
        Arrays.sort(buildings);
        int numberOfBricks = 0;

        for (int i = buildings.length - 2; i >= 0; i--) {
            int target = buildings[i + 1] - 1;
            numberOfBricks += target - buildings[i];
            buildings[i] = target;
        }

        return numberOfBricks;
    }
}
