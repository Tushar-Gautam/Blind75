class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b)); 
        
        for(int i:map.keySet()){
            int freq = map.get(i);    
            if(pq.size()<k){
                pq.add(i);
            }
            else if(pq.size()==k){
                if(freq> map.get(pq.peek()) ){
                //    System.out.println(pq);
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        return ans;
    }
}