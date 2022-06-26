package topinterviewquestions;

import java.util.HashMap;

public class Problem_0001_TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		// key 某个之前的数 value 这个数出现的位置
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}

	/**
	 * 数组排序之后，数组的下标索引顺序就乱了
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] _twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		int L = 0;
		int R = nums.length - 1;
		while (L < R) {
			if (nums[L] + nums[R] > target) {
				R--;
			} else if (nums[L] + nums[R] < target) {
				L++;
			} else {
				return new int[] { L, R };
			}
		}
		return new int[] { -1, -1 };
	}

}
