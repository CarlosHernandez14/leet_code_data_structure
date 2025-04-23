public class Median2SortedArrays {

    public static void main(String[] args) {

        // 1, 2 , 4
        // 3, 5, 6

        // 1, 3
        // 2

        // 1, 4, 5, 7
        // 2, 3, 6 (Result=4)
        int[] nums1 = {1,2};
        int[] nums2 = {-1,3};

        System.out.println("Median = " + findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Nums1 always gonna be the lower length array
        // Use recusevity to save memmory
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        double m = Integer.MIN_VALUE;
        int leftP = 0, rightP = nums1.length;
        int posX = 0, posY = 0;

        int mergedSizeArrays = nums1.length + nums2.length;

        while (leftP <= rightP && m == Integer.MIN_VALUE) {
            posX = (leftP + rightP) / 2;
            posY = ((mergedSizeArrays + 1) / 2) - posX;

            // Compared positions to catch the 4 important possible median numbers
            if (!((posX <= 0 ? Integer.MIN_VALUE : nums1[posX - 1]) <= (posY >= nums2.length ? Integer.MAX_VALUE : nums2[posY]))) {
                rightP = posX - 1;
                continue;
            }
            else if (!((posY <= 0 ? Integer.MIN_VALUE : nums2[posY - 1]) <= (posX >= nums1.length ? Integer.MAX_VALUE : nums1[posX]))) {
                leftP = posX + 1;
                continue;
            }

            leftP = posX;
            // In case it passes the conditions means we found the candidates
            // Check if the summed array length is even or odd
            if (mergedSizeArrays % 2 == 0) {
                m = (double)
                        (
                                Math.max(
                                        leftP <= 0 ? Integer.MIN_VALUE : nums1[leftP - 1],
                                        posY <= 0 ? Integer.MIN_VALUE : nums2[posY - 1]
                                ) + Math.min(
                                        posX >= nums1.length ? Integer.MAX_VALUE : nums1[posX],
                                        posY >= nums2.length ? Integer.MAX_VALUE : nums2[posY]
                                )
                        ) / 2;
                break;
            }

            m = Math.max(
                    posX <= 0 ? Integer.MIN_VALUE : nums1[posX - 1],
                    posY <= 0 ? Integer.MIN_VALUE : nums2[posY - 1]
            );

        }


        return m;
    }

}
