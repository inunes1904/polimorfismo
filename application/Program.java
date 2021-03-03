package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String args[]) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat manufactureDate = new SimpleDateFormat("dd/MM/yyyy");
	List<Product> product = new ArrayList<>();
	System.out.print("Enter the number of products: ");
	int n = sc.nextInt();
	for (int i = 1; i <= n; i++) {
		System.out.println("Product #"+i+" data:");
		System.out.println("Common, used or imported (c/u/i):");
		char tipo = sc.next().charAt(0);
		sc.nextLine();
		System.out.println("Product name:");
		String name = sc.nextLine();
		System.out.println("Product price:");
		double price = sc.nextDouble();		
		if (tipo == 'i') {
			System.out.println("Customs fee:");
			double tax = sc.nextDouble();
			product.add( new ImportedProduct(name, price, tax));
		}
		if (tipo == 'u') {
			System.out.println("Product manufacture Date(dd/MM/yyyy):");
			Date manufdate = manufactureDate.parse(sc.next());
			product.add(new UsedProduct(name, price, manufdate));
		}
		if (tipo == 'c'){
			product.add(new Product(name, price));
		}
	}
	System.out.println("PRICE TAGS:");
	for (Product product1 : product) {
		System.out.println(product1.toString());
	}
	sc.close();	
	}
}
