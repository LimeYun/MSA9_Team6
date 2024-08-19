package JavaMission;

import java.util.Scanner;

public class Num1 {
	/*
	 학생의 영어, 수학, 자바 성적을 각각 정수형 변수 eng, math, java 로 선언하고, 순서대로 점수를 입력 받아 성적의 총 합
	계와 평균을 계산하여 출력하는 프로그램을 작성하시오.
	
	입력
	80 90 100 
	
	출력
	영어 점수 : 80
	수학 점수 : 90
	자바 점수 : 100
	총점 : 270
	평균 : 90.0
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int eng = sc.nextInt();
		int math = sc.nextInt();
		int java = sc.nextInt();
		
		System.out.println("영어 점수 : "+eng);
		System.out.println("수학 점수 : "+math);
		System.out.println("자바 점수 : "+java);
		
		int sum = eng+math+java;
		double avg = (double)sum/3;
		
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+avg);
		
		sc.close();
		
	}
}
