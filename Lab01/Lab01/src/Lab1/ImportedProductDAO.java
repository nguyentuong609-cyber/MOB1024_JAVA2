package Lab1;
import java.util.Scanner;

public class ImportedProductDAO extends ImportedProduct{
	Scanner sc = new Scanner(System.in);
	
	private ImportedProduct importedProduct;
	public boolean NewImportedProduct() {
		// nhap ID
		String id;
		do {	
			System.out.print("Nhap ID: ");
			id = sc.nextLine();
		}while(!this.setiD(id));
		
		// nhap Gia
		System.out.print("Nhap ten SP: ");
		this.setName(sc.nextLine());
		
		do {
			double basePrice;
			System.out.print("Nhap gia: ");
			basePrice = sc.nextDouble();
			if(!this.setBasePrice(basePrice)){
				System.out.println("Ban nhap gia lon hon 0");
			}else {
				break;
			}
		}while(true);
		
		//Nhap thue
		do {
			double taxRate;
			System.out.print("Nhap thue: ");
			taxRate = sc.nextDouble();
			if(!this.setImportTaxRate(taxRate)) {
				System.out.println("Nhap thue >= 0 ");
			}
			else {
				break;
			}
		}while(true);
		
		
		//Nhap shipping fee
		do {
			double shippingFee;
			System.out.print("Nhap Shipping Fee: ");
			shippingFee = sc.nextDouble();
			if(!this.setShippingFee(shippingFee)) {
				System.out.println("Shipping Fee must be over 0");
			}
			else {
				break;
			}
		}while(true);
		
		return true;
	}
}
