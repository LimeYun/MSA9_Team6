package JavaMission;

import java.util.Scanner;

/*
정수 하나를 입력 받아, 정수형 변수 N에 초기화시키고, 예시 <출력>과 같이 “*” 기호를 출력하는 프로그램을 작성하시오.

(입력)
5
(출력)
  *
 ***
*****
*******

*/

public class Num4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {

				for (int j = 1; j <= n-i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= 2*i-1; j++) {
					System.out.print("*");
				}
			System.out.println();
		}
		sc.close();
		
	}

}
