class Solution {
    /**
     * 查找数组中第 k 大的元素（从大到小排序）
     *
     * @param nums 输入的数组
     * @param k    第 k 大的元素
     * @return 返回第 k 大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        return select(nums, nums.length - k);
    }

    /**
     * 使用快速选择算法找到数组中的第 rank 大的元素（从小到大排序）
     *
     * @param nums 输入的数组
     * @param rank 第 rank 大的元素
     * @return 返回第 rank 大的元素
     */
    private int select(int[] nums, int rank) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (rank < j) {
                hi = j - 1;
            } else if (j < rank) {
                lo = j + 1;
            } else {
                return nums[j];
            }
        }
        return nums[lo];
    }

    /**
     * 使用快速排序的划分方法，将数组划分为两部分，左边的元素小于 v，右边的元素大于 v
     *
     * @param nums 输入的数组
     * @param lo   划分的起始位置
     * @param hi   划分的结束位置
     * @return 返回划分后 v 的位置
     */
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param nums 输入的数组
     * @param i    要交换的元素的位置
     * @param j    要交换的元素的位置
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
