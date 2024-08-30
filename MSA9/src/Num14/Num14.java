package Num14;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * ALOHA 스터디에서 월말 코딩 대회를 열었다. 
 * 매니저는 학생들의 성적을 취합하여 “student.txt” 파일로 정리하였다. 
 * 한 학생의 성적은 다음과 같은 양식으로 기록되어 있다. txt 파일에서 
 * 학생들의 성적정보 (번호/이름/성적/수업이름) 추출하여, 
 * 성적순으로 내림차순, 번호 순으로 오름차순 정렬하여 출력하시오.

(txt파일)
<student.txt>
1/김조은/90/프론트엔드
2/박한별/80/퍼블리싱
3/이코딩/80/백엔드
4/최루프/45/프론트엔드
5/황이프/55/퍼블리싱
6/한로하/20/백엔드
7/감자바/90/백엔드
8/이에스/90/백엔드
9/수프링/100/백엔드
10/이액트/90/프론트엔드
(출력)
번호 이름 성적 반
9 수프링 100 백엔드
1 김조은 90 프론트엔드
7 감자바 90 백엔드
8 이에스 90 백엔드
10 이액트 90 프론트엔드
2 박한별 80 퍼블리싱
3 이코딩 80 백엔드
5 황이프 55 퍼블리싱
4 최루프 45 프론트엔드
6 한로하 20 백엔드
 */
public class Num14 {

	public static void main(String[] args) {

		// 파일 경로
		String filePath = "student.txt";

		try (
				// FilerReader 객체를 사용하여 파일을 문자 단위로 입력
				FileReader fr = new FileReader(filePath);
				// BufferedReader 객체로 파이 데이터 입력 성능 향상
				BufferedReader br = new BufferedReader(fr);) {
			String text;
			// readLine() : 파일의 문자 데이터를 한 줄씩 입력
			// 데이터가 더이상 없으면 null 반환
			while ((text = br.readLine()) != null) {
				System.out.println(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
