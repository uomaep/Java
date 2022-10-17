import java.util.Scanner;

public class P1067 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		System.out.println((n > 0) ? "plus" : "minus");
		System.out.println((n%2 == 0) ? "even" : "odd");
		
	}

}
