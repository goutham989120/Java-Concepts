============================================== File I/O ======================================
File f = new File("abc.txt");
System.out.println(f.exists()); // False
f.createNewFile();
System.out.println(f.exists()); // True

Directory - We can use java file object to represent directory also.

File f = new File("FileName");
System.out.println(f.exists()); // False
f.mkdir();
System.out.println(f.exists()); // True

=========================================== File I/O ==========================================
=========================================== File Class Constructors ===========================

File f = new File(String name);
File f = new File(String ,String name);
File f = new File(File subdir, String name);

File f = new File("Directory_01");
f.mkdir();
File f1 = new File("Directory_01", "abc.txt");
File f1 = new File(f, "abc.txt");
f1.createNewFile();

File f = new File("E:\\xyz", "abc.txt");
f.createNewFile();

========================================== File Class Constructors ===============================
========================================== File Methods ==========================================
boolean exists(); - f.exists()
boolean createNewFile(); - f.createNewFile()
boolean mkdir(); - f.mkdir()
boolean isFile() - f.isFile()
f.isDirectory()
String[] s = f.list()
long l = f.length()
boolean delete(); - f.delete()

import java.io.*;
class Test {
	public static void main(String[] args) {
		int count = 0;
		File f = new File("C:\\2026\May2026");
		String[] s = f.list();
		for(String s1 : s) {
			count++;
			System.out.println(s1);
		}
		System.out.println("The total number :" + count);
	}
}

================================= To display only file names =====================================
import java.io.*;
class Test {
	public static void main(String[] args) {
		int count = 0;
		File f = new File("C:\\2026\May2026");
		String[] s = f.list();
		for(String s1 : s) {
			File f1 = new File(f,s1)
			if(s1.isFile()) {
				count++;
				System.out.println(s1);
			}
		}
		System.out.println("The total number of files are :" + count);
	}
}


				