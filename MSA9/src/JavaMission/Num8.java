package JavaMission;
/*
 * 하나의 정수N을 입력받아 다음과 같이 작성하시오.

지그재그로 출력하시오.

N이 5라면 다음과 같이 출력한다.

1 2 3 4 5

10 9 8 7 6

11 12 13 14 15

20 19 18 17 16

21 22 23 24 25
*/

import java.util.Scanner;

public class Num8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];			// 2차원 배열
		int a = 1;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {		//arr[0],arr[2]...[n]행 (1,3..째줄 정방향으로 정렬)

					arr[i][j] = a++;
				}
			} else {
				for (int j = n - 1; j >= 0; j--) {	//2,4... 째 줄 역방향으로 정렬
					arr[i][j] = a++;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");		// 2차원배열 중첩반복문으로 출력
			}
			System.out.println();
		}
		sc.close();
	}

        }