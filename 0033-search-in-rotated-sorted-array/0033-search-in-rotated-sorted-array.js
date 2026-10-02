/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {

    let low = 0;
    let high = nums.length - 1;

    while (low <= high) {

        // Find middle index
        let mid = low + Math.floor((high - low) / 2);

        // Check if middle element is target
        if (nums[mid] === target) {
            return mid;
        }

        // Check if LEFT half is sorted
        if (nums[low] <= nums[mid]) {

            // Target LEFT sorted range mein hai
            if (target >= nums[low] && target < nums[mid]) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        // Otherwise RIGHT half is sorted
        else if (nums[mid] <= nums[high]) {

            // Target RIGHT sorted range mein hai
            if (target > nums[mid] && target <= nums[high]) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        else {
            return -1;
        }
    }

    // Target array mein nahi mila
    return -1;
};