package leetcode;

public class SumofSquareNumbers {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(0));
        System.out.println(Math.floor(0.0) == 0);
    }
    public boolean judgeSquareSum(int c) {
        for (int i=0;i<c;i++) {
            if (c-i*i >=0) {
                double sqrt = Math.sqrt(c-i*i);
                if (Math.floor(sqrt) == sqrt) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
