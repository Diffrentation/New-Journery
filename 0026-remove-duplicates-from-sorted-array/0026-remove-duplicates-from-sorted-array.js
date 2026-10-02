/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {

    // 'first' unique elements ke last index ko track karega
    let first = 0;

    // Agar array empty hai, to unique elements ki count 0 hai
    if (nums.length === 0) {
        return 0;
    }

    // 'next' poore array ko scan karega
    // first element already unique maana hai, isliye next = 1
    for (let next = 1; next < nums.length; next++) {

        // Agar current element aur last unique element different hain,
        // iska matlab current element unique hai
        if (nums[next] !== nums[first]) {

            // Unique element ke liye next position par jao
            first++;

            // Current unique element ko first position par place karo
            nums[first] = nums[next];
        }
    }

    // first index hai, isliye total unique elements = first + 1
    return first + 1;
};