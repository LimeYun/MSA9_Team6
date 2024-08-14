package JavaMission;

import java.util.Scanner;

/*
- do~while 문, switch 문, static 메소드 정의 및 호출을 반드시 사용하시오.
- 정수1~3 입력 시, 해당 메뉴 이름과 주문안내 문구를 출력하시오.
- 정수 0~3 이외의 번호를 입력하면, 0~3 사이의 번호를 입력하도록 요청하는 안내문구를 출력하시오.
- 정수 0 입력 시, 주문한 메뉴 개수와 주문완료 메시지를 출력하시오.


실행결과
다음과 같이, 치킨 메뉴판을 출력하고, 메뉴번호를 입력하면, 다음 <실행결과>와 같이 출력되는
프로그램을 작성하시오.

********** 치킨 메뉴판 **********
1. 황금올리브 반반한 치킨
2. 뿌잉클 치킨
3. 처갓집에서 호식이가 만든 치킨
0. 종료
********** 번호 : 2
‘뿌잉클 치킨’이(/가) 주문되었습니다.

********** 치킨 메뉴판 **********
1. 황금올리브 반반한 치킨
2. 뿌잉클 치킨
3. 처갓집에서 호식이가 만든 치킨
0. 종료
********** 번호 : 5
(0~3) 사이의 번호를 입력해주세요.

********** 치킨 메뉴판 **********
1. 황금올리브 반반한 치킨
2. 뿌잉클 치킨
3. 처갓집에서 호식이가 만든 치킨
0. 종료
********** 번호 : 0
총 5 개의 상품이 주문되었습니다.
 */


public class Num5 {
	
	public static String menu(int a) {
		
		String menuName = " ";

		switch (a) {

		case 1:
			menuName = "황금올리브 반반한 치킨";
			break;
		case 2:
			menuName = "뿌잉클 치킨";
			break;
		case 3:
			menuName = "처갓집에서 호식이가 만든 치킨";
			break;

		default:
			break;
		}

		return menuName;

	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menuNo = 0;

		int count = 0;

		do {
			System.out.println("***** 치킨 메뉴?�� *****");
			System.out.println("1. 황금올리브 반반한 치킨");
			System.out.println("2. 뿌잉클 치킨");
			System.out.println("3. 처갓집에서 호식이가 만든 치킨");
			System.out.println("0. 종료");
			System.out.print("***** 번호 :");
			menuNo = sc.nextInt();
			if (menuNo == 0)
				break;

			if (menuNo >= 0 && menuNo <= 3) {
				System.out.println("\n'" + menu(menuNo) + "'" + "(이/가) 주문되었습니다.\n");
				count++;
			} else {
				System.out.println("\n0~3 사이의 번호를 입력해 주세요.\n");
			}

		} while (menuNo != 0);
		System.out.print("\n총 " + count + " 개의 상품이 주문되었습니다.");

		sc.close();
	}

}
