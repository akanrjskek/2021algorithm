package greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 수들의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long S = Integer.parseInt(bf.readLine());
        int N = 0;

        while (S > 0) {
            if (S > N) {
                ++N;
                S -= N;
            } else {
                S = 0;
            }
        }
        System.out.println(N);
    }

}