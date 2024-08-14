package JavaMission;

/*
  	정수 1부터 100까지 의 수를 출력하면서, 해당 수 가 3 또는 6 또는 9에 해당하는 경우
	 해당 정수 대신에 3, 6, 9가 포함되는 개수만큼 “*” 를 출력하는 프로그램을 작성하시오.
 */

public class Num3 {
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 100; i++) {
			int result = 0; //초기화
			
			int a = i/10;	//10의자리
			int b = i%10;	//1의자리
			
			if (a == 3 || a == 6 || a == 9) {
				result++;
			}
			if (b == 3 || b == 6 || b == 9) {
				result++;
			}
			
			if (result == 1) { 
				
				System.out.println("*");
				
			} else if (result == 2) {
				
				System.out.println("**");
				
			} else {
				
				System.out.println(i);
			}
		}
		
	}

}
