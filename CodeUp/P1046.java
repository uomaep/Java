import java.util.Scanner;

public class P1046 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int sum = 0;
		
		for(int i=0; i<3; i++) {
			sum += in.nextInt();
		}
		
		System.out.println(sum);
		System.out.printf("%.1f", sum / 3.0);
		
		

	}

}
