package algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem_Kakao_Blind_No1 {

    @Test
    void test() {
        assertThat(solution("...!@BaT#*..y.abcdefghijklm")).isEqualTo("bat.y.abcdefghi");
        assertThat(solution("z-+.^.")).isEqualTo("z--");
        assertThat(solution("=.=")).isEqualTo("aaa");
        assertThat(solution("123_.def")).isEqualTo("123_.def");
        assertThat(solution("abcdefghijklmn.p")).isEqualTo("abcdefghijklmn");
        assertThat(solution("b")).isEqualTo("bbb");
        assertThat(solution(".")).isEqualTo("aaa");
        assertThat(solution("................b")).isEqualTo("bbb");
        assertThat(solution(".1.")).isEqualTo("111");
        assertThat(solution("~!@#$%&*()=+[{]}:?,<>/")).isEqualTo("aaa");
        assertThat(solution("abcdefghijklnmoptqrsvwxyz")).isEqualTo("abcdefghijklnmo");
        assertThat(solution(".....b....b......")).isEqualTo("b.b");
    }

    private String solution(String new_id) {
        new_id = new_id.toLowerCase();
        List<Character> special_char = new ArrayList<>();
        special_char.add('-');
        special_char.add('_');
        special_char.add('.');
        StringBuilder builder = new StringBuilder(new_id);
        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c) && !special_char.contains(c)) {
                builder.deleteCharAt(i);
                i--;
            }
        }
        StringBuilder tmp_builder = new StringBuilder();
        boolean find_dot = false;
        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            if (c == '.') {
                if (!find_dot) {
                    find_dot = true;
                } else {
                    continue;
                }
            } else {
                find_dot = false;
            }
            tmp_builder.append(c);
        }
        builder = tmp_builder;

        if (builder.length() > 0) {
            if (builder.charAt(0) == '.') {
                builder.deleteCharAt(0);
            }
        }
        if (builder.length() > 0) {
            if (builder.charAt(builder.length() - 1) == '.') {
                builder.deleteCharAt(builder.length() - 1);
            }
        }

        if (builder.length() == 0) {
            builder.append('a');
        } else if (builder.length() > 15) {
            builder.delete(15, builder.length());
        }
        if (builder.charAt(builder.length()-1) == '.') {
            builder.deleteCharAt(builder.length()-1);
        }
        if (builder.length() < 3) {
            while (builder.length() < 3) {
                builder.append(builder.charAt(builder.length()-1));
            }
        }
        return builder.toString();
    }
}
