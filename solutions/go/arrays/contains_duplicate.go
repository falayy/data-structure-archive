func hasDuplicate(nums []int) bool {
	numsMap := make(map[int]int)

	exists := false
	for i := 0; i < len(nums); i++ {
		numsMap[nums[i]] = numsMap[nums[i]] + 1
	}

	for i := 0; i < len(nums); i++ {
		exists = numsMap[nums[i]] > 1
		if exists {
			return exists
		}
	}
	return exists
}