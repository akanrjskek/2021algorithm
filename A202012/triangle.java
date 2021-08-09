package A202012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class triangle {
	private static int N;
	private static List<Integer> tri[];
	private static ArrayList<Integer> answer[];

	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		tri = new List[N];
		answer = new ArrayList[N];
		int temp;
		StringTokenizer st;
		for(int i = 0; i < N; ++i) {
			tri[i] = new LinkedList<>();
			answer[i] = new ArrayList<>();
			st = new StringTokenizer(bf.readLine());
			while(st.hasMoreTokens()) {
				tri[i].add(Integer.parseInt(st.nextToken()));
				answer[i].add(0);
			}
			if(i == 0) answer[i].set(0, tri[i].get(0));
			for(int j = 0; j < tri[i].size(); ++j) {
				if(i != 0) {
					if(j == tri[i].size() - 1) {
						answer[i].set(j,answer[i-1].get(j-1) + tri[i].get(j));
					}
					else if(j == 0) {
						answer[i].set(j,answer[i-1].get(0) + tri[i].get(0));
					}
					else {
						temp = answer[i-1].get(j-1) > answer[i-1].get(j) ? answer[i-1].get(j-1) : answer[i-1].get(j); 
						answer[i].set(j, temp + tri[i].get(j));
					}
				}
			}
		}
		answer[N-1].sort(null);
		System.out.println(answer[N-1].get(N-1));
	}

}
