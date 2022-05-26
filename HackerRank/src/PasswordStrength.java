import java.util.ArrayList;
import java.util.List;

public class PasswordStrength {
	public static void main(String[] args) {
		String s = "hackerrank";

		int srngth = 0;
		int vowel = 0;
		int conso = 0;


		List<Character> vowels = new ArrayList<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		for (int i = 0; i < s.length(); i++) {
			if (vowels.contains(s.charAt(i)))
				vowel++;
			else
				conso++;

			if (vowel >= 1 && conso >= 1) {
				srngth++;
				vowel = 0;
				conso = 0;
			}
		}
		System.out.println(srngth);
	}
}
