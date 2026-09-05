class LRUCache {

    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            val = node.val;
            this.remove(node);
            this.add(node);
        }
        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = this.cache.get(key);
            this.remove(node);
            node.val = value;
            this.add(node);
        } else {
            if (cache.size() == capacity) {
                Node node = head.prev;
                this.remove(node);
                cache.remove(node.key);
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            this.add(node);
            cache.put(key, node);
        }
    }

    private void add(Node node) {
        Node next = tail.next;
        node.prev = tail;
        tail.next = node;
        node.next = next;
        next.prev = node;
    }

    private void remove(Node node) {
        Node next = node.next, prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */