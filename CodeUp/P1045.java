import java.util.Scanner;

public class P1045 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		System.out.println((long)n + m);
		System.out.println(n - m);
		System.out.println((long) n * m);
		System.out.println(n / m);
		System.out.println(n % m);
		System.out.printf("%.2f", (float)n / m);

	}

}
