package Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 놀이공원티켓판매 {

	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }, { { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };
		for (int testcast = 0; testcast < tickets.length; testcast++) {

			System.out.println("-------------------testcast[" + testcast + "]");
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.print("판매한 티켓 수 : "+result);
			System.out.println();

			for (int[] arr : requests[testcast]) {
				System.out.println(Arrays.toString(arr));
			}
		}

	}

	// tickets: 티켓 수
	// requests: 회원 등급, 티켓 구매 수량
	public static int solution(int tickets, int[][] requests) {
        //이부분 구현 
		//등급 우선순위는 priority 변수를 이용한 for문으로 결정
		//같은 등급 내 우선순위는 Arraylist를 이용하여 결정
		int priority=1;
		int totalSell=0;
		ArrayList<Integer> reqArr = new ArrayList<Integer>();
		while(priority<=10){
			for(int i=0;i<requests.length;i++) {
				if(requests[i][0]==priority) {
					reqArr.add(requests[i][1]);
				}
				
				reqArr.sort(Comparator.reverseOrder());
				
				for(int j=0;j<reqArr.size();j++) {
					if(reqArr.get(j)<=tickets) {
						tickets=tickets-reqArr.get(j);
						totalSell+=reqArr.get(j);
					}
				}
				reqArr.clear();
			}
			priority++;
		}
		return totalSell;

	}
}
