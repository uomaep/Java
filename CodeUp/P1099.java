import java.util.Scanner;

public class P1099 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int box[][] = new int[10][10];
		boolean stop = false;
		
		for(int i=0; i<box.length; i++) {
			for(int j=0; j<box[i].length; j++) {
				box[i][j] = in.nextInt();
			}
		}
		
		for(int i=1; i<=box.length-2; i++) {
			for(int j=1; i<=box[i].length-2; j++) {
				if(box[i][j] == 0) box[i][j] = 9;
				else if(box[i][j] == 1) {
					j-=2;
					i++;
					continue;
				}
				else if(box[i][j] == 2) {
					box[i][j] = 9;
					stop = true;
					break;
				}
			}
			if(stop) break;
		}
		
		for(int i=0; i<box.length; i++) {
			for(int j=0; j<box[i].length; j++) {
				System.out.print(box[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}
