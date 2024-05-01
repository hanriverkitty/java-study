package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	public static void main(String[] args) {
		try {
			// ip address 객체 받음
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();

			System.out.println(hostName);
			System.out.println(hostIpAddress);

			byte[] IpAddresses = inetAddress.getAddress();
			for (byte IpAddress : IpAddresses) {
				
				// ???????
				System.out.println(IpAddress & 0x000000ff);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
