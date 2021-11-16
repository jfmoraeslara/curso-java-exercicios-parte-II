package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Cliente cliente = new Cliente(name, email, birthDate);

		System.out.println("Enter order date: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, cliente);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item date:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, productPrice);

			OrderItem it = new OrderItem(quantity, productPrice, product);

			order.addItem(it);

		}

		System.out.println("");
		System.out.println("ORDER SUMARY: " + order.getStatus());
		System.out.println("---------------------------------------------------");
		System.out.println(order);

		System.out.println();
		System.out.print("Enter order status: ");
		int x = sc.nextInt();
		if (x == 1) {
			System.out.println(OrderStatus.PENDING_PAYMENT);
		}
		if (x == 2) {
			System.out.println(OrderStatus.PROCESSING);
		}
		if (x == 3) {
			System.out.println(OrderStatus.SHIPPED);
		}
		if (x == 4) {
			System.out.println(OrderStatus.DELIVERED);
		} else {
		}

		sc.close();
	}

}
