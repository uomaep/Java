import java.util.Scanner;

public class P1024 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		for(int i=0; i<str.length(); i++) {
			System.out.printf("'%s'\n", str.charAt(i));
		}

	}

}
