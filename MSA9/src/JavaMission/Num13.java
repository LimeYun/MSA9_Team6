package JavaMission;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Num13 {
	
	/*
	 * - ArrayList 를 이용하시오 
	 * - 싱글톤 패턴을 적용하시오. 
	 * - 발행일은 현재 시간으로 지정하며 추첨일은 토요일 오후 9시를
	 * 기준으로, 이전이면 그 주 토요일 9시로 
	 * 이후이면 차주 토요일 오후 9시로 지정하시오.
	 * - 지급기한은 1년하고 1일을 더한 날짜로 지정하시오.
	 * - 당첨 등수는 당첨번호와 게임당 선택번호가 일치하는 개수로 정한다.
	 * 
	 * 6개 일치하면 1등, 5개 일치하고 보너스 번호가 일치하면 2등, 
	 * 5개만 일치하면 3등, 4개 일치하면 4등, 3개 일치하면 5등
	 * 
	 * 몇 게임? 5 
	 * [1 게임] (1.자동 / 2.수동) : 1 
	 * 4 10 14 17 43 45 
	 * [2 게임] (1.자동 / 2.수동) : 1 
	 * 1 12 34 40 41 42 
	 * [3 게임] (1.자동 / 2.수동) : 1 
	 * 16 18 19 21 26 32 
	 * [4 게임] (1.자동 / 2.수동) : 1 
	 * 7 17 20 30 43 45 
	 * [5 게임] (1.자동 / 2.수동) : 2 
	 * 1 : 10 
	 * 2 : 22 
	 * 3 : 27 
	 * 4 : 33 
	 * 5 : 40 
	 * 6 : 44 
	 * 10 22 27 33 40 44
	 * 
	 * ############ 인생역전 Lottoria ############ 
	 * 발행일 : 2021/06/12일 (토) 05:01:58 
	 * 추첨일 : 2021/06/12일 (토) 21:00:00 
	 * 지급기한 : 2022/06/13일 (월)
	 * ----------------------------------------- 
	 * A 자 동 04 10 14 17 43 45 
	 * B 자 동 01 12 34 40 41 42 
	 * C 자 동 16 18 19 21 26 32 
	 * D 자 동 07 17 20 30 43 45 
	 * E 수 동 10 22 27 33 40 44 
	 * ----------------------------------------- 
	 * 금액 				₩5,000
	 * ######################################### 
	 * 당첨 번호 : 14 19 24 29 36 42 
	 * 보너스 번호 : 45
	 * 
	 * #################### 당첨 결과 #################### 
	 * A 자 동 04 10 14 17 43 45 (낙첨)
	 * B 자 동 01 12 34 40 41 42 (낙첨) 
	 * C 자 동 16 18 19 21 26 32 (낙첨) 
	 * D 자 동 07 17 20 30 43 45 (낙첨) 
	 * E 수 동 10 22 27 33 40 44 (낙첨)
	 * #################################################
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> lotto = new ArrayList(); // 발행번호
		System.out.print("몇 게임? : ");
		int n = sc.nextInt();
		int result[][] = new int[n][6];
		int auto[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("[" + (i+1) + " 게임] 1.(자동) / 2.(수동) : ");
			auto[i] = sc.nextInt();
			
			for (int j = 0; j < 6; j++) {
				
				if (auto[i] == 1) {
					lotto.add(j, (int) (Math.random() * 45 + 1));
				} else if (auto[i] == 2) {
					System.out.print(j+1 + " : ");
					lotto.add(j, sc.nextInt());
				}
				for (int k = j - 1; k >= 0; k--) { // 중복 제거
					if (lotto.get(j) == lotto.get(k)) {
						lotto.remove(lotto.get(j));
						j--;
					}
				}
			}
			
			for (int j = 0; j < 6; j++) {
				System.out.print(lotto.get(j) + " ");
				result[i][j] = lotto.get(j);
			}
			System.out.println();
		}
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		sdf = new SimpleDateFormat("yyyy/M/dd (E) HH:mm:ss");
		
		System.out.println("############ 인생역전 Lottoria ############");
		System.out.println("발행일 : "+sdf.format(now));
		
		// 추첨일
		Calendar lottoCal = Calendar.getInstance();
		
		lottoCal.set(Calendar.HOUR_OF_DAY, 21);
		lottoCal.set(Calendar.MINUTE, 0);
		lottoCal.set(Calendar.SECOND, 0);
		
		// 토요일 21시 이전이면 당일 21시 출력
		if (lottoCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && lottoCal.get(Calendar.HOUR_OF_DAY) < 21) {
			System.out.println("추첨일 : " + sdf.format(lottoCal.getTime()));
		} 
		// 토요일 21시 이후면 하루 넘김
		else if (lottoCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && lottoCal.get(Calendar.HOUR_OF_DAY) > 21) {
			lottoCal.add(lottoCal.DAY_OF_WEEK, 1);
		}
		// 토요일까지 하루씩 늘림
		for (int i = lottoCal.get(Calendar.DAY_OF_WEEK); i < Calendar.SATURDAY; i++) {
			lottoCal.add(lottoCal.DAY_OF_WEEK, 1);
		}
		System.out.println("추첨일 : " + sdf.format(lottoCal.getTime()));
		
		
		
		// 지급 기한
		SimpleDateFormat dday = new SimpleDateFormat("yyyy/M/dd (E)");
		lottoCal.add(Calendar.YEAR, 1);
		lottoCal.add(Calendar.DAY_OF_WEEK, 1);
		System.out.println("지급기한 : " + dday.format(lottoCal.getTime()));
		System.out.println("-----------------------------------------");
		
		DecimalFormat df = new DecimalFormat("00");

		for (int i = 0; i < n; i++) {
			if (auto[i] == 1)
			System.out.print((char)(i+65)+" 자 동 ");
			else if (auto[i] == 2)
				System.out.print((char)(i+65)+" 수 동 ");
			for (int j = 0; j < 6; j++) {
				System.out.print(df.format(result[i][j]) + " ");
			}
			System.out.println();
			
		}
		
		System.out.println("-----------------------------------------");
		DecimalFormat won = new DecimalFormat("#,###");
		System.out.println("금액 				₩"+won.format(1000*n));
		System.out.println("#########################################");
		
		ArrayList<Integer> 당첨번호 = new ArrayList();
		for (int i = 0; i < 7; i++) {
			당첨번호.add(i, (int)(Math.random()*45+1));
			for (int j = i-1; j >= 0; j--) {
				if ( 당첨번호.get(i) == 당첨번호.get(j) ) {
					당첨번호.remove(i);
					i--;
				}
			}
		}
		System.out.print("당첨번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(df.format(당첨번호.get(i)) + " ");
		}
//		당첨번호.add(0, 1);
//		당첨번호.add(1, 2);
//		당첨번호.add(2, 3);
//		당첨번호.add(3, 4);
//		당첨번호.add(4, 5);
//		당첨번호.add(5, 6);
//		당첨번호.add(6, 7); 테스트
		int 보너스번호 = 당첨번호.get(6);
		System.out.println();
		System.out.println("보너스 번호 : " + df.format(보너스번호));
		
		System.out.println("\n################## 당첨 결과 ###################### ");
		
		// 당첨결과 검사
		int count[] = new int[n];
		int 이등[] = new int[n];
		for (int i = 0; i < n; i++) {
			이등[i] = 0;
			for (int j = 0; j < 6; j++) {
				if ( j >= 6 )
					j = 0;
				for (int j2 = 0; j2 < 6; j2++) {
					if (당첨번호.get(j) == result[i][j2]) {
						count[i]++;
					}
					if (result[i][j2] == 보너스번호)
						이등[i] = 1;
				}
			}
		}
		
		// 당첨결과 출력
		for (int i = 0; i < n; i++) {
			if (auto[i] == 1)
			System.out.print((char)(i+65)+" 자 동 ");
			else if (auto[i] == 2)
				System.out.print((char)(i+65)+" 수 동 ");
			for (int j = 0; j < 6; j++) {
				System.out.print(df.format(result[i][j]) + " ");
			}
			
			if ( count[i] == 6 )
				System.out.print("(1등)");
			else if ( count[i] == 5 && 이등[i] == 1)
				System.out.print("(2등)");
			else if ( count[i] == 5 && 이등[i] == 0)
				System.out.print("(3등)");
			else if ( count[i] == 4 )
				System.out.print("(4등)");
			else if ( count[i] == 3 )
				System.out.print("(5등)");
			else
				System.out.print("(낙첨)");
			
			System.out.println();
		}
		System.out.println("#################################################");
	}

}


