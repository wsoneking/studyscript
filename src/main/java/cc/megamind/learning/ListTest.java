package cc.megamind.learning;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String... args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add(new String("ni hao"));
		System.out.println(list);

	}
}
