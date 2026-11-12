import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // Total windows = n - k + 1
        int[] res = new int[n - k + 1];
        int resIndex = 0; // Result array mein value daalne ke liye pointer

        Deque<Integer> dq = new ArrayDeque<>();

        // ==========================================
        // STEP 1: Pehli window (0 se k-1 tak) ko process karein
        // ==========================================
        for (int i = 0; i < k; i++) {
            // Pichhe se un sabhi indices ko hatao jinki value current element se choti hai
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i); // Current index ko pichhe add karo
        }

        // ==========================================
        // STEP 2: Baaki ki windows (k se n-1 tak) ko slide karein
        // ==========================================
        for (int i = k; i < n; i++) {
            // Pichli window ka maximum answer result mein save karo
            res[resIndex] = nums[dq.peekFirst()];
            resIndex++;

            // Jo elements ab current window se bahar ho gaye hain, unhe aage se hatao
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Pichhe se choti values ko hatao
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Current index ko deque mein daalo
            dq.offerLast(i);
        }

        // ==========================================
        // STEP 3: Aakhiri window ka answer save karein
        // ==========================================
        res[resIndex] = nums[dq.peekFirst()];

        return res;
    }
}
