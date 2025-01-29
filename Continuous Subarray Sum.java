// Brute force approach with time complexity of O(n^3) and space complexity of O(n) at max.

class Solution {
    public static int findsum(ArrayList<Integer> arr){
        int ans = 0;
        for(int i = 0; i < arr.size(); i++){
            ans = ans + arr.get(i);
        }
        return ans;
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i< n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            for(int j = i+1; j< n; j++){
                temp.add(nums[j]);
                int ans = findsum(temp);
                if(ans % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}

// Hashmap solution with time complexity of O(n).
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> storing = new HashMap<>();
        storing.put(0, -1);
        int subarrsum = 0;
        for(int i =0; i< n; i++){
            subarrsum += nums[i];
            subarrsum = subarrsum % k;
            if(storing.containsKey(subarrsum)){
                if(i - storing.get(subarrsum) >= 2){
                    return true;
                }
            }
            else {
                    storing.put(subarrsum, i);
            }
        
        }
        return false;
    }
}
