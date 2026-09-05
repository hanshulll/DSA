class Solution {
    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return answer;
    }

    private void dfs(String s, int index, List<String> tempList) {
        if (index == s.length()) {
            answer.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (isPalindrome(sub)) {
                tempList.add(sub);
                dfs(s, i, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;right--;
        }
        return true;
    }
}