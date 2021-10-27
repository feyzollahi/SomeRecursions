public class TowersOfHanoi {
    public static void moves(int N, int from, int to, int help){
        if(N == 1)
            return;
        moves(N - 1, from, help, to);
        moves(N - 1, help, to, from);
    }
    public static void main(String[] args){
        int N = 5;
        moves(N, 1, 3, 2);
    }
}
