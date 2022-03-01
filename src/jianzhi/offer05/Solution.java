package jianzhi.offer05;

public class Solution {
    public String replaceSpace(String s) {
        var res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (ch == ' ') {
                res.append("%20");
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
