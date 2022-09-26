import java.util.Scanner;

public class P1018 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		in = new Scanner(in.next());
		in.useDelimiter(":");
		
		int h = in.nextInt();
		int m = in.nextInt();
		
		System.out.printf("%d:%d", h, m);

	}

}
