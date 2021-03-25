package Study;
import java.util.Scanner;

public class n1002 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			double distance = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));

			if(x1 == x2 && y1==y2 && r1==r2) {
				System.out.println(-1);
			}
			else if(distance > r1+r2 || x1==x2 &&y1==y2 && r1!=r2 ||distance<Math.abs(r1-r2)) {
				System.out.println(0);
			}
			else if (distance == r1+r2 || Math.abs(r1-r2)==distance) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
		}
		sc.close();
	}

}
