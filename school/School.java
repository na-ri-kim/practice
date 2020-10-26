package school;

import java.util.ArrayList;

public class School {

	private static School instance = new School();
	
	private ArrayList<Student> studentList = new ArrayList<>(); // ��ϵ� �л� ����Ʈ ����
	private ArrayList<Subject> subjectList = new ArrayList<>(); // ���� ����Ʈ ����
	
	private School() {
		
	}
	
	public static School getInstance() {
		if(instance == null)
			instance = new School();
		return instance;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> sujectList) {
		this.subjectList = sujectList;
	}
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	
}
