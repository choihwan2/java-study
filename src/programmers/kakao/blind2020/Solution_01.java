package programmers.kakao.blind2020;

/*
 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
단, 마침표(.)는 처음과 끝에 사용할 없으며 또한 연속으로 사용할 수 없습니다.
 */
public class Solution_01 {
	public String solution(String new_id) {
		StringBuilder stb = new StringBuilder(new_id);
		// 소문자 만들기
		for (int i = 0; i < stb.length(); i++) {
			stb.setCharAt(i, Character.toLowerCase(stb.charAt(i)));
		}
		// 특수문자 지우기
		for (int i = 0; i < stb.length(); i++) {
			char c = stb.charAt(i);
			if (c == '-' || c == '_' || c == '.')
				continue;
			if (c >= 'a' && c <= 'z')
				continue;
			if (c >= '0' && c <= '9')
				continue;
			stb.deleteCharAt(i);
			i--;
		}
		// 두번연속 . 하나로 만들기
		char before = stb.charAt(0);
		for (int i = 1; i < stb.length(); i++) {
			char now = stb.charAt(i);
			if (before == '.' && before == now) {
				stb.deleteCharAt(i);
				i--;
				continue;
			}
			before = now;
		}

		// 앞 뒤 . 제거
		if (stb.charAt(0) == '.')
			stb.deleteCharAt(0);

		if (stb.length() > 0 && stb.charAt(stb.length() - 1) == '.')
			stb.deleteCharAt(stb.length() - 1);

		// 빈문자열이라면 a 대입
		if (stb.length() == 0) {
			stb.append('a');
		}

		if (stb.length() >= 16) {
			stb = new StringBuilder(stb.substring(0, 15).toString());
		}

		if (stb.charAt(stb.length() - 1) == '.')
			stb.deleteCharAt(stb.length() - 1);

		if (stb.length() <= 2) {
			char c = stb.charAt(stb.length() - 1);
			while (stb.length() != 3) {
				stb.append(c);
			}
		}

		return stb.toString();
	}
}
