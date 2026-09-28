class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num: nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int key: mp.keySet()) {
            int val = mp.get(key);

            pq.add(new int[] {val, key});

            if(pq.size() > k) pq.poll();
        }

        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.peek()[1]);
            pq.poll();
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    } 
}
