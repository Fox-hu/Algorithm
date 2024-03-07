//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1747 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        // all in [0, zero] = 0
        // all in (zero, i) = 1
        // all in (two, len - 1] = 2
        if (nums.length == 1) {
            return;
        }
        //三指针 zero代表0区域的起始点 two代表2区域的终点
        //注意 这里是对0，1，2区域进行填充 并不是在对nums数组进行遍历！！！
        int zero = -1, i = 0, two = nums.length - 1;
        while (i <= two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
