package school;

public class Score {
	int studentId;  // �й�
	Subject subject; // ����
	int point; // ����
	
	public Score(int sudentId, Subject subject, int point) {
		this.studentId = sudentId;
		this.subject = subject;
		this.point = point;
	}

	public int getSudentId() {
		return studentId;
	}

	public void setSudentId(int sudentId) {
		this.studentId = sudentId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "�й� : " + studentId + "," + subject.getSubjectName() + ":" + point;
	}
}
