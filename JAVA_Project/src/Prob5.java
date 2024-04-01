import java.util.ArrayList;

public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		ArrayList<Integer> arrlist = new ArrayList<>();
		
		for(int i =0;i<counter.length;i++) {
			counter[i]=0;
		}
		
		for(int a:answer) {
			
			for(int i = 0;i<counter.length;i++) {
				if(a ==i+1) {
					counter[i]++;
				}
			}
		}
		
		
		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		for(int i=0;i<counter.length;i++) {
			System.out.println((i+1)+"의 갯수는 "+counter[i]+"개 입니다.");
		}
		
		

	}
}
