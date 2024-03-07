//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2438 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        //从后向前 找到第一个升序的index位置
        //12385764 -> [5,7],pos = 4;
        int pos = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i - 1;
                break;
            }
        }
        //如果是全部逆序 说明是最大值了 重排返回
        if (pos == -1) {
            reverse(nums, 0);
            return;
        }
        //从pos右侧找到第一个大于nums[pos]的值 进行交换
        //12385764 -> 12386754;
        for (int i = nums.length - 1; i > pos; i--) {
            if (nums[pos] < nums[i]){
                swap(nums,pos,i);
                break;
            }
        }
        //将[pos+1,length]翻转
        //因为到这一步时[pos+1,length]一定是降序 翻转后的数组一定是升序
        //12386754 -> 12386457
        reverse(nums,pos+1);
    }

    //从pos位置处逆序一个数组
    private void reverse(int[] nums, int pos) {
        for (int i = pos, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
