import java.util.Scanner;

public class P1027 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		in = new Scanner(in.next());
		in.useDelimiter("\\.");
		
		int y = in.nextInt();
		int m = in.nextInt();
		int d = in.nextInt();
		
		System.out.printf("%02d-%02d-%04d", d, m, y);

	}

}
