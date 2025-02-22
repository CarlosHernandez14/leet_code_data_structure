package com.charly;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //int[] nums1 = {1,2,3,0,0,0};
        //int[] nums1 = {4,0,0,0,0,0};
        int [] nums1 = {0};
        //int[] nums1 = {7,8,9,0,0,0};

        //int[] nums2 = {2,5,6};
        //int[] nums2 = {1,2,3,5,6};
        int[] nums2 = {1};

        //int m = 1;
        //int m = 3;
        int m = 0;
        //int n = 5;
        int n = 1;

        merge(nums1, m, nums2, n);

        System.out.print("[");
        Arrays.stream(nums1).forEach(num -> System.out.print(num + ","));
        System.out.println("]");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        else if (n == 0) return;


        // Iterate the array backwards
        int i = m - 1;
        int j = n - 1;

        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0) break;

            if (i < 0) {
                nums1[k] = (nums1[k] > nums2[j] || nums1[k] == 0) ? nums2[j--] : nums1[k];
                continue;
            }

            nums1[k] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];

            k = (k == 0 && j >= 0) ? (m + n - 1) : k;
            //System.out.println("dentor del for");
        }

    }

}