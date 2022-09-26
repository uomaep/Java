import java.util.Scanner;

public class P1019 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		in = new Scanner(in.next());
		in.useDelimiter("\\.");
		
		int y = in.nextInt();
		int m = in.nextInt();
		int d = in.nextInt();
		
		System.out.printf("%04d.%02d.%02d", y, m, d);

	}

}
