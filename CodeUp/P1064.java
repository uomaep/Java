import java.util.Scanner;

public class P1064 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		System.out.println((a < b) ? ( (a < c) ? a : c) : ( (b < c) ? b : c));
		
	}

}
