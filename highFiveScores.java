import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Student {
	int id;
	int[] scores;
	Student(int id, int[] scores) {
		this.id = id;
		this.scores = scores;
	}
}

public class highFiveScores {
	
	public static HashMap<Integer, Double> averageFiveScores(ArrayList<Student> students) {
		HashMap<Integer, Double> average = new HashMap<>();
		PriorityQueue<Integer> scores = new PriorityQueue<>(5, new Comparator<Integer>() {
			@Override
			public int compare (Integer a, Integer b) {
				return b-a;
			}
		});
		
		for (Student student : students) {
			for (int score : student.scores) {
				scores.add(score);
			}
			average.put(student.id, getFiveAverage(scores));
		}
		
		return average;
	}
	
	public static double getFiveAverage(PriorityQueue<Integer> scores) {
		double average = 0.0;
		
		for (int i = 0; i < 5; i++) {
			average += scores.poll();
		}
		
		scores.clear();
		
		return average/5.0;
	}
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		
		int[] scores1 = {90,90,80,80,75,80,90};
		int[] scores2 = {70,40,60,80,75,60,60};
		int[] scores3 = {95,97,84,88,79,82,94};
		int[] scores4 = {49,32,95,100,100,100,100};
		
		Student student1 = new Student(1, scores1);
		Student student2 = new Student(2, scores2);
		Student student3 = new Student(3, scores3);
		Student student4 = new Student(4, scores4);
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		
		HashMap<Integer, Double> reportAverage = averageFiveScores(students);
		
		System.out.println(reportAverage);
	}
}