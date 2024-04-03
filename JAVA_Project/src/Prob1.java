import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1 {
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);
		printMaxScore2(array);
	}
//	private static void printMaxScore(String[] array){
//		// 구현하세요.
//		for(String s:array) {
//			char[] arr = s.toCharArray();
//			char[] scoreArr = new char[2];
//			int scarrIndex=0;
//			
//			for(int i=0;i<arr.length;i++) {
//				char a = arr[i];
//				if(Character.isDigit(a)) {
//					scoreArr[scarrIndex]=a;
//					scarrIndex++;
//				}else {
//					
//				}
//			}
//		}
//	}	

	private static void printMaxScore2(String[] array) {
		String regExp = "([ㄱ-ㅎ가-힣]+)+([0-9]+)점";
		String maxName="";
		int maxScore = -1;
		for (String data : array) {
			System.out.println(data);
			Pattern pattern = Pattern.compile(regExp);
			Matcher matcher = pattern.matcher(data);

			if (matcher.find()) {
				String name = matcher.group();
				String score = matcher.group();
				int iscore = Integer.parseInt(score);
				if (maxScore < iscore) {
					maxScore = iscore;
					maxName = name;
				}
			}
		}
	}

	private static void printMaxScore(String[] array) {
		String maxName = "";
		int maxScore = -1;
		for (String data : array) {
			char[] arr = data.toCharArray();
			String name = "", score = "";

			for (char ch : arr) {
				if (!Character.isDigit(ch))
					name += ch;
				else
					score += ch;

			}
			if (maxScore < Integer.parseInt(score)) {
				maxScore = Integer.parseInt(score);
				maxName = name.substring(0, name.length() - 1);
			}

		}
	}
}
