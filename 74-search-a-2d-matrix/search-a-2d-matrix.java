class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                int start = 0, end = matrix[mid].length - 1;
                while (start <= end) {
                    int middle = start + (end - start) / 2;
                    if (target == matrix[mid][middle]) {
                        return true;
                    } else if (target > matrix[mid][middle]) {
                        start = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                }
                return false;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}