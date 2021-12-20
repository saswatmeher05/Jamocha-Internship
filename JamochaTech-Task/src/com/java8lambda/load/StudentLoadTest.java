package com.java8lambda.load;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*	
 	10000 records in list
	populate that with map
	filter/group by them with any of the property
	use foreach and stream api
*/
public class StudentLoadTest {

	public static void main(String[] args) {
		String courses[] = { "java", "python", "html", "css", "dotnet", "javascript", "php", "cobol" };
		ArrayList<Student> al = new ArrayList<Student>();

		Map<Integer, Student> map = new LinkedHashMap<Integer, Student>();
		Student st;
		for (int i = 0, j = 0; i < 20; i++, j++) {
			st = new Student();
			st.setId(i);
			st.setName("somu");
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
		
		Map<String, List<Student>> groupingByCourse = al.stream().collect(Collectors.groupingBy(Student::getCourse));

		System.out.println("Students With Specific subject:");
		System.out.println("---------------------------");
		javaStdMap.entrySet().forEach(mp -> {
			System.out.println(mp.getValue().getId());
			System.out.println(mp.getValue().getName());
			System.out.println(mp.getValue().getCourse());
			System.out.println("---------------------------");
		});

		System.out.println("Map<Subject,List<Student>:");
		System.out.println("---------------------------");
		groupingByCourse.entrySet().forEach(mp -> {
			System.out.print(mp.getKey() + ":\n");
			mp.getValue().stream().forEach(std -> {
				System.out.println(std.getId() + "," + std.getName());
			});
			System.out.println("---------------------------");
		});

	}

}
