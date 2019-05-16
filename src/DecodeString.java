import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        if (!s.contains("[") || !s.contains("]")) return s;
        int i = 0;
        StringBuilder retString = new StringBuilder();
        char[] chars = s.toCharArray();
        while (i < chars.length) {
            StringBuilder numBuilder = new StringBuilder();
            while (!Character.isDigit(chars[i])) {
                retString.append(chars[i++]);
                if(i >= chars.length) return retString.toString();
            }
            while (chars[i] != '[')
                numBuilder.append(chars[i++]);
            i++;
            int times = Integer.parseInt(numBuilder.toString());
            int openCounter = 1;
            StringBuilder innerSubStringRep = new StringBuilder();

            while (openCounter != 0) {
                char curChar = chars[i++];
                if (curChar == '[') openCounter++;
                else if (curChar == ']') openCounter--;
                if (openCounter != 0)
                    innerSubStringRep.append(curChar);
            }
            String innerSubstring = decodeString(innerSubStringRep.toString());
            for (int j = 0; j < times; j++)
                retString.append(innerSubstring);
        }
        return retString.toString();
    }
}
