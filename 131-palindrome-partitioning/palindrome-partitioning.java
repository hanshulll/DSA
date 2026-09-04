class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        return answer;
    }

    private void dfs(int index, String s, List<String> temp) {
        if(index==s.length()) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index+1; i<=s.length(); i++) {
            if(isPalindrome(s.substring(index,i))) {
                temp.add(s.substring(index,i));
                dfs(i, s, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<=right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;right--;
        }
        return true;
    }
}