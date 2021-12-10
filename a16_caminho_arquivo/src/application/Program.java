package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("Mostrar só o arquivo - getName: " + path.getName());
		System.out.println("Caminho do arquivo sem o arquivo - getParente: " + path.getParent());
		System.out.println("Todo o caminho do arquivo- getPath: " + path.getPath());
		
		
		sc.close();
	}
}
