
public class Practice06GuGudan {
	public static void main(String[] args) {
		
		for(int j = 9; j>1; j --) {
			for(int i =9; i> 1 ; i--) {
				System.out.print(j + " * " +  i + " = " + (j*i) + "\t");
			}
			System.out.println();
		}
		System.out.println("==============================================");
		for(int i = 2; i<10;i++) {
			for(int j = 2; j<=9; j++){
				System.out.printf("%d * %d = %2d\t", i, j, (i*j));
			}
			System.out.println();
		}
		
		/*
		for(int i = 9; i > 1; i--) {
			for(int j = 9; j >1; j--) {
				System.out.println(i + "*" + j + "=" + (i*j));
			} // for
		*/
		
	} // main
}
