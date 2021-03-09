package java_chobo2.ch14.stream;

public class Student implements Comparable<Student> {
	private String name;
	private int ban;
	private int totalscore;
	
	public Student(String name, int ban, int totalscore) {
		this.name = name;
		this.ban = ban;
		this.totalscore = totalscore;
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalscore() {
		return totalscore;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s, %s]", name, ban, totalscore);
	}

	@Override
	public int compareTo(Student o) {
		return (this.totalscore - o.totalscore) * -1;
	}

}
