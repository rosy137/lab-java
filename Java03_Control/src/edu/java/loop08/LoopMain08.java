package edu.java.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		// 구구단 2단은 2x2까지, 3단은 3x3까지, 4단은 ..., 9단까지 
		
		System.out.println("\n-----for-----\n");
		
		for (int x = 2 ; x <= 9 ; x ++) {
			System.out.printf("---%d단---\n", x);
			for (int y = 1 ; y <= x ; y ++) {
				System.out.printf("%d x %d = %d\n", x, y, x*y);
			}
		}
		
		System.out.println("\n-----while-----\n");
		
		int x1 = 2;
		int y1 = 1;
		while ( x1 <= 9 ){
			y1 = 1;
			System.out.printf("---%d단---\n", x1);
			while ( x1 >= y1 ) {
				System.out.printf("%d x %d = %d\n", x1, y1, x1*y1);
			y1 ++;
			} 
			x1 ++;
		} 
		
		x1 = 2;
		while (x1 < 10) {
			System.out.printf("---%d단---\n", x1);
			
			y1 = 1;
			while ( y1 < 10 ) {
				System.out.printf("%d x %d = %d\n", x1, y1, x1 * y1);
				if ( x1 == y1) {
					break;
				}
				y1 ++;
			}
			x1 ++;
		}
		
		System.out.println("\n-----for+if+break-----\n");
		
		for (int x2 = 2 ; x2 <= 9 ; x2++) {
			System.out.printf("---%d단---\n", x2);
			for (int y2 = 1; y2 <= 9 ; y2++) {
				System.out.printf("%d x %d = %d\n", x2, y2, x2*y2);
				if (x2 == y2) {
					break;
				} // end if
			} // end for (y2)
		} // end for (x2)
		
		
		

		
	}

}
