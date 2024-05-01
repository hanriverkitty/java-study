package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String dns = null;
			while(!"exit".equals(dns)) {
				dns = sc.nextLine();
				InetAddress[] inetAddresses = InetAddress.getAllByName(dns);
				for (InetAddress ip : inetAddresses) {
					System.out.println(dns+" : "+ip.getHostAddress());
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
