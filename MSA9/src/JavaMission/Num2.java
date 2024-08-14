package JavaMission;

import java.util.Scanner;

/*
10을 입력받아서,
1번 줄에는 1~N에 대한 홀수의 수식 및 합계,
2번 줄에는 1~N에 대한 짝수의 수식 및 합계,
3번 줄에는 N의 약수를 출력하시오.

(입력)
10 
(출력)
1+3+5+7+9=25
2+4+6+8+10=30
1 2 5 10
*/
public class Num2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum1 = 0;
		int sum2 = 0;
		
		//홀수
		for (int i = 1; i <= N; i++) {
			if (i%2 == 1) {
				System.out.print(i);
				sum1 += i;
			}
			else if (i<N) {
				System.out.print("+");
			}
		}
		System.out.println("="+sum1);
		
		//짝수
		for (int i = 1; i <= N; i++) {
			if (i%2 == 0) {
				System.out.print(i);
				sum2 += i;
			}
			else if (1 < i && i < N) {
				System.out.print("+");
			}
		}
		System.out.println("="+sum2);
		
		//약수
		int divisor = 1;
		
		for (int i = 0; i < N; i++) {
			if ( N%divisor == 0 ) {
				System.out.print(divisor+" ");
			}
			divisor++;
		}
		
		sc.close();
	}
	
}



