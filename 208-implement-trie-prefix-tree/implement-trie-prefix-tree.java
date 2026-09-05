class Trie {

    TrieNode head;

    public Trie() {
        head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length(); i++) {
            if (temp.node[word.charAt(i) - 'a'] == null) {
                temp.node[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.node[word.charAt(i) - 'a'];
        }
        temp.isLast = true;
    }

    public boolean search(String word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length(); i++) {
            if (temp.node[word.charAt(i) - 'a'] == null) {
                return false;
            }
            temp=temp.node[word.charAt(i)-'a'];
        }
        return temp.isLast;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = head;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.node[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            temp=temp.node[prefix.charAt(i)-'a'];
        }
        return true;
    }

    class TrieNode {
        TrieNode[] node;
        boolean isLast;

        public TrieNode() {
            node = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */