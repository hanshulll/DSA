class LRUCache {

    Map<Integer,Integer> cache;
    int capacity;
    
    public LRUCache(int capacity) {
        cache=new LinkedHashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        int val = -1;
        if(cache.containsKey(key)) {
            val=cache.get(key);
            cache.remove(key);
            cache.put(key,val);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key,value);
        } else {
            if(cache.size()==capacity) {
                for(Integer e : cache.keySet()) {
                    cache.remove(e);
                    break;
                }
            }
            cache.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * obj.put(key,value);
 * int param_1 = obj.get(key);
 */