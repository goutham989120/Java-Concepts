=================================== File I/O (FileWriter) ====================================
We can use FileWriter to write character data to the file.

Constructors -
FileWriter fw = new FileWriter(String fileName); // which file to write
FileWriter fw = new FileWriter(File f);
FileWriter fw = new FileWriter(String fileName, boolean append);
FileWriter fw = new FileWriter(File f, boolean append);