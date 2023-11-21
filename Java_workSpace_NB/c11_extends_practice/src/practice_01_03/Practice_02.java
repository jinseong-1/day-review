package practice_01_03;


public class Practice_02 {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		
		// 코드 수정 및 작성
		int number = (int) (Math.random() * 45 + 1); // 난수가 발생하는 줄
		
		for(int i = 0; i< lotto.length; i++) {
			lotto[i]=(int)(Math.random()*45+1);
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		/*		선생님 풀이
		lotto[0]=number;
		
		for(int i =1;i<lotto.length;i++){
			lotto[i]=(int)(Math.random()*45+1);
			for(int j =0; j<i; j ++){
				if(lotto[i] == lotto[j]){
					i --;
					break;
				}
				
				if(lotto[i]<lotto[j]){
					number = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = number;
				}
			}
		}
		
		*/
		
		
		
		int temp = 0;
		for(int i = 0;i<lotto.length;i++) {
			for(int j =0;j<lotto.length;j++) {
				if(lotto[i]<lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		
		// 결과 출력 코드 수정 x
		System.out.println("[ 결과 ]");
		for (int i : lotto) {
			System.out.print("[" +i+ "]");
		}
	}
}
