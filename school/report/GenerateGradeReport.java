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
	public static final String TITLE = " ������ ���� \t\t\n";
	public static final String HEADER = " �̸� | �й� | �ʼ����� | ���� \n";
	public static final String LINE = "-----------------------------\n";
	
	// ���� : Page 372 ~ Page 374 String, StringBuilder, StringBuffer ���� Ȯ�� �ٶ� 		
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString(); // String���� ��ȯ
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
				
				getScoreGrade(student, subject); // �л��� ���� ���� ���� ���
				
				buffer.append("\n");
				buffer.append(LINE);
			}
		}
		
	public  void getScoreGrade(Student student, Subject subject) {
		
				ArrayList<Score> scoreList = student.getScoreList();
				int majorId = student.getMajorSubject().getSubjectId();
	// ������ �����ϱ� ���� ����ϴ� Ŭ������ ����ó�� �迭�� �����Ͽ���. ���� �� Ŭ������ GradeEvaluation �������̽��� �����Ͽ��⿡
	// GradeEvaluation������ ������ �ΰ� �ν��Ͻ��� ������ �� �ʿ��� �� ����ϸ� ��
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation(),
				new PassFailEvaluation()};  //���� �� Ŭ������	
				
		for (int i = 0; i < scoreList.size(); i++) { // �л��� ���� ������ 
		
				Score score = scoreList.get(i);
				// ���� ������ ������ ����
				
				if(score.getSubject().getSubjectId() == subject.getSubjectId()) {
					String grade;
	// ������ ����Ϸ��� ������ ������ �ʼ��� ��� Define.SAB_TYPE ���� �迭�� �־���. �׷��� MajorEvaluation()�޼��� ��� ����� �����					
				
					
					if(subject.getGradeType() == Define.PF_TYPE) {
						grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
					}
					else {
					    if(score.getSubject().getSubjectId() == majorId)  // ���� ������ ���
						    grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());//���� ���� ���� �� ���  
					    else
					    	grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint()); // ���� ������ �ƴ� ���
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
	
		
		
