package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {

	
	private String subjectName; // 과목 이름
	private int subjectId; // 과목 고유 번호
	private int gradeType; // 학점 평가 정책
	
	// 이 과목을 수강 신청한 학생 리스트 : register() 메서드를 호출하면 이 리스트에 추가됨
	private ArrayList<Student> studentList = new ArrayList<>();

	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		this.gradeType = Define.AB_TYPE; // 학점 평가 정책의 기본 디폴트 방식 지정
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void register(Student student) { // 수강 신청 register()메서드 선언
		studentList.add(student);
	}
	
}
