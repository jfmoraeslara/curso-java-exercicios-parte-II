package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		// gerar uma lista das pasta em certo diretório
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folder:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		// listar só os arquivos
		File[] files = path.listFiles(File::isFile);
		System.out.println("File:");
		for (File file : files) {
			System.out.println(file);
		}
		
		// criar uma sub-pasta pela linha de comando
		boolean success = new File(strPath + "\\sub-pasta").mkdir();
		System.out.println("Directory create successfully: " + success);
		
		sc.close();
	}
}
