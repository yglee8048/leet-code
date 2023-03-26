class P35_Search_Insert_Position {

    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, 0, nums.size - 1, target)
    }

    private fun binarySearch(nums: IntArray, begin: Int, end: Int, target: Int): Int {
        if (begin > end) {
            return end
        }

        val mid = begin + (end - begin) / 2
        return if (nums[mid] == target) {
            mid
        } else if (nums[mid] > target) {
            binarySearch(nums, begin, mid - 1, target)
        } else {
            binarySearch(nums, mid + 1, end, target)
        }
    }
}