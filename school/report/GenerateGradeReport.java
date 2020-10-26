package school.report;

import school.Student;
import school.Subject;
import utils.Define;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import grade.PassFailEvaluation;
import school.School;
import school.Score;



public class GenerateGradeReport {

	School school = School.getInstance();
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름 | 학번 | 필수과목 | 점수 \n";
	public static final String LINE = "-----------------------------\n";
	
	// 교재 : Page 372 ~ Page 374 String, StringBuilder, StringBuffer 차이 확인 바람 		
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString(); // String으로 반환
	}
		
		public void makeHeader(Subject subject) {
			buffer.append(GenerateGradeReport.LINE);
			buffer.append("\t" + subject.getSubjectName());
			buffer.append(GenerateGradeReport.TITLE);
			buffer.append(GenerateGradeReport.HEADER);
			buffer.append(GenerateGradeReport.LINE);
		}
		
		public void makeBody(Subject subject) {
			ArrayList<Student> studentList = subject.getStudentList();
			
			for(int i = 0; i < studentList.size(); i++) {
				Student student = studentList.get(i);
				buffer.append(student.getStudentName());
				buffer.append(" | ");
				buffer.append(student.getStudentId());
				buffer.append(" | ");
				buffer.append(student.getMajorSubject().getSubjectName() + "\t");
				buffer.append(" | ");
				
				getScoreGrade(student, subject); // 학생별 수강 과목 학점 계산
				
				buffer.append("\n");
				buffer.append(LINE);
			}
		}
		
	public  void getScoreGrade(Student student, Subject subject) {
		
				ArrayList<Score> scoreList = student.getScoreList();
				int majorId = student.getMajorSubject().getSubjectId();
	// 학점을 산출하기 위해 사용하는 클래스를 다음처럼 배열로 정의하였음. 학점 평가 클래스는 GradeEvaluation 인터페이스를 구현하였기에
	// GradeEvaluation형으로 선언해 두고 인스턴스를 생성한 후 필요할 때 사용하면 됨
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation(),
				new PassFailEvaluation()};  //학점 평가 클래스들	
				
		for (int i = 0; i < scoreList.size(); i++) { // 학생이 가진 점수들 
		
				Score score = scoreList.get(i);
				// 현재 학점을 산출할 과목
				
				if(score.getSubject().getSubjectId() == subject.getSubjectId()) {
					String grade;
	// 학점을 계산하려는 점수의 과목이 필수일 경우 Define.SAB_TYPE 값을 배열에 넣었음. 그러면 MajorEvaluation()메서드 계산 방법이 적용됨					
				
					
					if(subject.getGradeType() == Define.PF_TYPE) {
						grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
					}
					else {
					    if(score.getSubject().getSubjectId() == majorId)  // 중점 과목인 경우
						    grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());//중점 과목 학점 평가 방법  
					    else
					    	grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint()); // 중점 과목이 아닌 경우
					}
					buffer.append(score.getPoint());
					buffer.append(":");
					buffer.append(grade);
					buffer.append(" | ");
				}
		}
	}
	public void makeFooter() {
		buffer.append("\n");
	}
}
	
		
		
