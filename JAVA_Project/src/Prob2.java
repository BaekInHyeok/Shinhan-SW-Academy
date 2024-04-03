public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}
	
	public static String leftPad2(String str, int size, char fillChar) {
		int fillCharNum = size-str.length();
		try {
			
		}catch(IllegalAccessException e) {
			result=aa.getmessage;
		}
	}

	public static String leftPad(String str, int size, char fillChar) {
		// String[] array = new String[size];
		String result = null;
		char[] array = new char[size];

		int strSize = str.length();
		int index = 0;
		char[] arr = str.toCharArray();
		int index2 = 0;

		if (size >= strSize) {
			for (int i = 0; i < size - strSize; i++) {
				array[i] = fillChar;
				index++;
			}

			for (int j = index; j < size; j++) {
				array[j] = arr[index2];
				index2++;
			}

			result = new String(array);

			return result;
		}
		else {
			return "문자열의 길이보다 size가 큽니다.";
		}

	}

}

//구현하시오.
class IllegalSizeException extends RuntimeException {

	public IllegalSizeException(){
		super();
		String s = "문자여르이 길이보다 size가 큽니다.";
	}

}
