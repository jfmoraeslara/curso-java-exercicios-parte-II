package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		// criando o arquivo out
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		System.out.println("Directory create successfully:");
		// criando tabela com preço total dos produtos
		String targetFileStr = sourceFolderStr + "\\out\\summary.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {			
			String itemTxt = br.readLine();
			while (itemTxt != null) {

				String[] fields = itemTxt.split(", ");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				itemTxt = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Product item : list) {
					bw.write(item.getName() + ", " + String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println("Data table created successfully:");
				System.out.println(targetFileStr + " CREATED!");
				
			} 
			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} 
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}
