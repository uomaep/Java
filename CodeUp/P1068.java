import java.util.Scanner;

public class P1068 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		byte score = in.nextByte();
		
		if(score >= 90) System.out.println("A");
		else if(score >= 70) System.out.println("B");
		else if(score >= 40) System.out.println("C");
		else System.out.println("D");
		
	}

}
