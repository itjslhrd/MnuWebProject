package model;

public class StudentRun {
	public static void main(String[] args) {
		Student st1 = new Student(1,"김학셍",90,88,79);
		
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.print(st1.bun + "\t");
		System.out.print(st1.name + "\t");
		System.out.print(st1.kor + "\t");
		System.out.print(st1.eng + "\t");
		System.out.print(st1.mat + "\t");
		System.out.print(st1.tot + "\t");
		System.out.print(st1.ave + "\n");


	}

}
