package BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] regions = new int[N];
        for (int i = 0; i < regions.length; ++i) {
            regions[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken()); // 출력값은 나오므로 다음 줄부터 확인.
            Arrays.sort(regions);
            int start = 0;
            int end = regions[regions.length - 1];
            long sum = 0;
            int mid = 0;
            while (start <= end) {
                sum = 0;
                mid = (start + end) / 2;
                sum = request(regions, mid);
                if (sum < M) {
                    start = mid + 1;
                } else if (sum > M) {
                    end = mid - 1;
                } else {
                    end = mid;
                    break;
                }
            }
            System.out.println(end);
    }
    public static long request(int[] a, int b) {
        long sum = 0;
        for (int i = 0; i < a.length; ++i) {
            if (b < a[i]) {
                sum += b;
            }
            else {
                sum += a[i];
            }

        }
        return sum;
    }
}
