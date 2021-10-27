public class Factorial {
    public static long fact(int n){
        if(n == 0)
            return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args){
        int n = 10;
        fact(n);
    }
}
