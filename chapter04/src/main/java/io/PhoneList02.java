package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			File file = new File("./phone.txt");
			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}
			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "Bytes");

			Date d = new Date(file.lastModified());
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d));
			System.out.println();

			System.out.println("=== 전화번호 ===");
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();

				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
		} catch (FileNotFoundException e) {
			System.out.println("error:" + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
