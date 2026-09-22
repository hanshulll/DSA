class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];
            int upper = Math.min(bracket[0], income), percent = bracket[1];
            if (i == 0) {
                tax = tax + (1.0 * upper * percent / 100.0);
                income -= upper;
            } else if (i != 0) {
                int taxToBeCalculated = bracket[0] - brackets[i - 1][0];
                upper = Math.min(income, taxToBeCalculated);
                tax = tax + (1.0 * upper * percent / 100.0);
                income -= upper;
            }
        }
        return tax;
    }
}