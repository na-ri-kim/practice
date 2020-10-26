package school;

public class Score {
	int studentId;  // 학번
	Subject subject; // 과목
	int point; // 점수
	
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
		return "학번 : " + studentId + "," + subject.getSubjectName() + ":" + point;
	}
}
