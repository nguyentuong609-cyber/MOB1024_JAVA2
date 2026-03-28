package InClass;

public class inClass01 {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		
		try {
//			System.out.println("Result: " + (a/b));
			System.out.println("tong: " + tong(a,b));
		} catch (ArithmeticException e ) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static int tong(int a, int b) {
		int t = a + b;
		return t;
	}
}
