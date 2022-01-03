package com.java8lambda.load;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/*	
 	insert multiple records in list
	populate that with map
	filter/group by with any of the property
	use foreach and stream api
*/
public class StudentLoadTest {

	public static void main(String[] args) {
		String courses[] = { "java", "python", "html", "css", "dotnet", "javascript", "php", "cobol" };
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb=new StringBuffer();
		Random random=new Random();
		//length of random string
		int len=5;
		ArrayList<Student> al = new ArrayList<Student>();

		Map<Integer, Student> map = new LinkedHashMap<Integer, Student>();
		Student st;
		for (int i = 1, j = 0; i <= 20; i++, j++) {
			st = new Student();
			st.setId(i);
			sb.delete(0, sb.length());
			for(int k=0;k<len;k++) {
				int index=random.nextInt(alphabet.length());
				sb.append(alphabet.charAt(index));
			}
			st.setName(sb.toString());
			if (j >= courses.length) {
				j = 0;
			}
			st.setCourse(courses[j]);
			al.add(st);
			map.put(i, st);
		}

//		Map<Integer, Student> javaStdMap = map.entrySet().stream()
//				.filter(map1 -> map1.getValue().getCourse().equals("java"))
//				.collect(Collectors.toMap(map1 -> map1.getKey(), map1 -> map1.getValue()));

		Map<Integer, Student> javaStdMap = al.stream().filter(sst -> sst.getCourse().equals("java"))
				.collect(Collectors.toMap(s -> s.getId(), s -> s));

//		Map<String, List<Student>> groupingByCourse=al.stream().collect(Collectors.groupingBy(stds->stds.getCourse(),Collectors.toList()));

		Map<String, List<Student>> groupingByCourse = al.stream()
				.collect(Collectors.groupingBy(std -> std.getCourse())); // or Student::getCourse

		System.out.println("Students With Specific subject(java):");
		System.out.println("-------------------------------------");

		javaStdMap.entrySet().forEach(mp -> {
			System.out.println("ID:"+mp.getValue().getId());
			System.out.println("Name:"+mp.getValue().getName());
			System.out.println("Subject:"+mp.getValue().getCourse());
			System.out.println("---------------------------");
		});

		System.out.println("Map<Subject,List<Student>:");
		System.out.println("--------------------------");

		groupingByCourse.entrySet().forEach(mp -> {
			System.out.print(mp.getKey() + ":\n");
			mp.getValue().stream().forEach(std -> {
				System.out.println("ID:"+std.getId() + ",Name:" + std.getName());
			});
			System.out.println("---------------------------");
		});

	}

}
