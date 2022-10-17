import java.util.Scanner;

public class P1066 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		System.out.println((a%2 == 0) ? "even" : "odd");
		System.out.println((b%2 == 0) ? "even" : "odd");
		System.out.println((c%2 == 0) ? "even" : "odd");
		
	}

}
