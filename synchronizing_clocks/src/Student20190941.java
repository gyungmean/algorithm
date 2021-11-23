import java.util.*;
public class Student20190941 {
	
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int[][] sw = new int[10][16];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			int swIdx = sc.nextInt();
			int cnt = sc.nextInt();

			for(int j = 0; j < cnt; j++) {
				int idx = sc.nextInt();
				sw[swIdx][idx] = 1;
			}
		}
		
		int[] clocks = new int[16];
		for(int i = 0; i < 16; i++) {
			int time = sc.nextInt();
			if(time == 12) {
				clocks[i] = 0;
			}
			else if (time == 3) {
				clocks[i] = 1;
			}
			else if(time == 6) {
				clocks[i] = 2;
			}
			else {
				clocks[i] = 3;
			}
		}
		
		make12(clocks, sw, 0, 0);
		System.out.println(result);
		
		sc.close();
	}
	
	public static void make12(int clocks[], int sw[][], int swIdx, int cnt) {
		if(check12(clocks)) {
			if(cnt < result) { 
				result = cnt;
			}
			return;
		}
		if(swIdx > 9) {
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			make12(clocks, sw, swIdx + 1, cnt + i);
			for(int j = 0; j < 16; j++) {
				if(sw[swIdx][j] == 1) {
					clocks[j] = (clocks[j] + 1) % 4;
				}
			}
		}
	}
	
	public static boolean check12(int clocks[]) {
		for (int i = 0; i < 16; i++) {
			if(clocks[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
