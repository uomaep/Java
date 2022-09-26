import java.util.Scanner;

public class P1025 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=10000; i>=1; i/=10) {
			System.out.println("[" + i * (n/i) + "]");
			n %= i;
		}

	}

}
