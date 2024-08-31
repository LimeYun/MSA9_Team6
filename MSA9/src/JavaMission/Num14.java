package JavaMission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
class student implements Comparator<student> {

	int number;
	String name;
	int score;
	String subject;

	@Override
	public int compare(student o1, student o2) {

		int score1 = o1.getScore();
		int score2 = o2.getScore();
		
		int num1 = o1.getNumber();
		int num2 = o2.getNumber();

		int gap = score1-score2;
		int result = num1-num2;

		return gap == 0 ? result : -gap;	// 성적이 같을 경우 번호순
	}


	@Override
	public String toString() {
		return number + "\t" + name + "\t" + score + "\t" + subject;
	}


	public student() {
	}


	public student(int number, String name, int score, String subject) {
		this.number = number;
		this.name = name;
		this.score = score;
		this.subject = subject;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

}

public class Num14 {

	public static void main(String[] args) {

		// 파일 경로
		String filePath = "student.txt";

		try (
				
				FileReader fr = new FileReader(filePath);
				BufferedReader br = new BufferedReader(fr);) {
			List<student> studentList = new ArrayList<student>();
			
			// 추출
			String text;
			while ((text = br.readLine()) != null) {
				System.out.println(text);
				String str = text;
				String[] sp = str.split("/");	// "/"을 기준으로 한글자씩 배열요소로 반환
				studentList.add(new student(Integer.parseInt(sp[0]), sp[1], Integer.parseInt(sp[2]), sp[3]));
			}
			
			Collections.sort(studentList, new student());
			
			System.out.println("---------------------------");
			System.out.println("번호\t이름\t성적\t반");
			for (student student : studentList) {
				System.out.println(student);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}