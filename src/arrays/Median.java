package arrays;

/*

Problem: Consider two sorted arrays, q and p (they can have different lengths).
Write an application that computes the median value of these two arrays in logarithmic runtime. Median value is middle of the array.

ex:
p = [1, 2] q = [3, 4]
merged array: [1, 2, 3, 4] // even
median: (2+3)/2=2.5
---
p = [1,3], q = [2]
merged array: [1, 2, 3]  // odd
median: 2
---
p = [1,5,17,18,25,28,39,77,88]
q = [2,6,9,10,11,65,67]

using binary search on smaller array (p.len <= q.len) and partition p and q such that
maxLeftP <= minRightQ && maxLeftQ<=minRightP then
    if totalLen is even then
        median = (max(maxLeftP, maxLeftQ) + min(minRightQ, minRightP)) / 2
    if odd then
        median = max(maxLeftP, maxLeftQ);
otherwise keep partitioning the array by using:
if maxLeftP > minRightQ
    high = partitionP -1
else
    low = partitionP + 1


*/
public class Median {
    public static void main(String[] args) {
        int[] p = {1, 3, 8, 9, 15};
        int[] q = {7, 11, 19, 21, 25};
        MedianOfTwoSortedArraysOfDifferentLength s = new MedianOfTwoSortedArraysOfDifferentLength();
        double median = s.getMedianOfTwoSortedArrays(p, q);
        System.out.println(median);
    }
}

class MedianOfTwoSortedArraysOfDifferentLength {
    public double getMedianOfTwoSortedArrays(int[] p, int[] q) {
        if (p.length > q.length) {
            return getMedianOfTwoSortedArrays(q, p);
        }
        int pLen = p.length, qLen = q.length;
        // binary search on smaller len arr
        int low = 0, high = pLen;

        while (low <= high) {
            int partitionP = (low + high) / 2;
            int partitionQ = (pLen + qLen + 1) / 2 - partitionP;

            int maxLeftP = (partitionP == 0) ? Integer.MIN_VALUE : p[partitionP - 1];
            int minRightP = (partitionP == pLen) ? Integer.MAX_VALUE : p[partitionP];

            int maxLeftQ = (partitionQ == 0) ? Integer.MIN_VALUE : q[partitionQ - 1];
            int minRightQ = (partitionQ == qLen) ? Integer.MAX_VALUE : q[partitionQ];

            if (maxLeftP <= minRightQ && maxLeftQ <= minRightP) {
                if ((pLen + qLen) % 2 == 0) {
                    return (double) (Math.max(maxLeftP, maxLeftQ) + Math.min(minRightP, minRightQ)) / 2;
                } else {
                    return (double) Math.max(maxLeftP, maxLeftQ);
                }
            } else if (maxLeftP > minRightQ) {
                high = partitionP - 1;
            } else {
                low = partitionP + 1;
            }
        }
        return -1;
    }
}
