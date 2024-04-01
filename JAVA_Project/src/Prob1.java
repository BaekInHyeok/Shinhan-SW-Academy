public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array){
		// 구현하세요.
		for(String s:array) {
			char[] arr = s.toCharArray();
			char[] scoreArr = new char[2];
			int scarrIndex=0;
			
			for(int i=0;i<arr.length;i++) {
				char a = arr[i];
				if(Character.isDigit(a)) {
					scoreArr[scarrIndex]=a;
					scarrIndex++;
				}else {
					
				}
			}
		}
	}	
}
