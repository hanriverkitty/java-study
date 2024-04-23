package prob5;
public class Prob5 {

	public static void main(String[] args) {
		int i=0;
		while(i<100) {
			String strI = String.valueOf(i);
			int len = strI.length();
			int cnt=0;
			for(int j=0;j<len;j++) {
				if(strI.charAt(j)=='3' || strI.charAt(j)=='6' || strI.charAt(j)=='9') {
					cnt+=1;
				}
			}
			if(cnt>0) {
			System.out.print(strI+" ");
			for(int j=0;j<cnt;j++) {
				System.out.print("짝");
			}
			System.out.println();
			}
			i++;
		}
	}
}
