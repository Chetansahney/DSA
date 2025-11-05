class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int distance = dx * dx + dy * dy;  // squared distance
                
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            
            for (int count : map.values()) {
                result += count * (count - 1);
            }
        }
        
        return result;
    }
}
