package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {
        String concatenatedString = "";
        for(int i=0;i<str.length;i++) {
        	concatenatedString+=str[i];
        }
        return concatenatedString;
    }

}
