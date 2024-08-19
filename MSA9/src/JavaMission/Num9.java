package JavaMission;

/* 
/* 
(1) 화폐는 고액권을 우선으로 지급, 나머지 금액은 그 다음 단위의 화폐 순서로 지급한다.
(2) 화폐 단위는 50000원, 10000원 5000원, 1000원, 500원, 100원, 50원, 10원, 5원, 1원의 10가지 종류가 있다.
(3) 입력데이터는 성명, 간식비 지급액이며, 성명의 입력이 "QUIT" 이면 입력의 끝으로 간주한다.
(4) 출력은 성명, 간식비 지급액, 개인별 각 화폐 매수, 마지막에 전체 화폐 매수를 출력한다.

(입력)
제니 623843
지수 728394
리사 432942
로제 942783

(출력)
성명 출장비 오만원 만원 오천원 천원 오백원 백원 오십원 십원 오원 일원
제니 623843 12 2 0 3 1 3 0 4 0 3
지수 728394 14 2 1 3 0 3 1 4 0 4
리사 432942 8 3 0 2 1 4 0 4 0 2
로제 942783 18 4 0 2 1 2 1 3 0 3
전체 화폐매수 : 52 13 1 10 3 12 2 15 0 12
 */

import java.util.Scanner;

public class Num9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name[] = new String[4];
        int price[] = new int[4];
        int sum[] = new int[10]; //화폐단위 배열

        // 이름과 비용 입력
        for (int i = 0; i < 4; i++) {
            name[i] = sc.next();
            if (name[i].equals("QUIT")) {
            	System.out.println("프로그램 종료");
            	break;
            }
            price[i] = sc.nextInt();
        }
        System.out.println();

        System.out.println("성명\t출장비\t오만원\t만원\t오천원\t천원\t오백원\t백원\t오십원\t십원\t오원\t일원");
        
        for (int i = 0; i < 4; i++) {
            int money = 50000;
            if (name[i].equals("QUIT")) {
            	break;
            }
            System.out.print(name[i] + "\t" + price[i] + "\t");

            for (int j = 0; j < 10; j++) {

                int a = price[i] / money; // 갯수

                int b[] = new int[10]; // 총합 배열
                b[j] = a;

                price[i] = price[i] % money; // 남은 금액

                if (j % 2 == 0) {
                    money = money / 5;
                } else {
                    money = money / 2;
                }
                System.out.print(a + "\t");

                sum[j] += b[j]; // 총합 배열의 화폐단위 배열
            
            }
            System.out.println();
        }
        System.out.print("전체 화폐매수 : ");
        for (int i = 0; i < sum.length; i++) {
            System.out.print("\t"+sum[i]);
        }

        sc.close();
    }

}