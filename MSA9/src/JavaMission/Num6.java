package JavaMission;

import java.util.Scanner;

public class Num6 {
	/*
	정수 N을 입력받아 N개의 게임의 로또 번호를 출력하시오.
	즉, 6개의 배열요소를 갖는 1차원 배열을 선언하여 1~45 사이의 랜덤한 값을 중복되지 않도록 저장하고 출력하는 과정을
	N번 반복하시오.
	
	몇 게임? 5 
	[1 게임] : 2 9 14 23 41 44
	[2 게임] : 1 8 17 33 37 41
	[3 게임] : 6 12 15 22 23 37
	[4 게임] : 1 8 15 18 28 37
	[5 게임] : 3 11 12 23 31 37

	 */

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		// 로또번호 배열
		int arr[] = new int[6];
		
		// 게임 횟수 입력
		System.out.print("몇 게임? : ");
		int N = sc.nextInt();
		
		// N번 반복
		for (int i = 1; i <= N; i++) { 	
			System.out.print("[" + i + " 게임] : ");
			
			
			for (int j = 0; j < arr.length; j++) {
				int r = (int) (Math.random()*45+1);     // 1~45사이의 번호
				arr[j] = r;
				for ( int k = j-1; k >= 0; k--) {		// 중복 제거
					if ( r == arr[k])
						j--;
				}
			}
			
			for (int k : arr) {
				System.out.print(k+" ");			// 출력
			}
			
			System.out.println();
		}

		sc.close();
	}
}
