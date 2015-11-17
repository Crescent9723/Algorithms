import java.util.Scanner;

public class KaratsubaMultiplication {
	public static void main(String[] args){
		long x, y, product = 0;
		int xDigit, yDigit;
		Scanner scan = new Scanner(System.in);
		x = scan.nextLong();
		y = scan.nextLong();
		
		product = compute(x, y);
		
		System.out.println(product);
	}
	
	public static long compute(long x, long y){
		if (x < 10 || y < 10){
			return x * y;
		}
		int digit = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
		if (digit % 2 != 0){
			digit++;
		}
		String xStr = parseZero(x, digit);
		String yStr = parseZero(y, digit);
		long a = Long.parseLong(xStr.substring(0, digit/2));
		long b = Long.parseLong(xStr.substring(digit/2, digit));
		long c = Long.parseLong(yStr.substring(0, digit/2));
		long d = Long.parseLong(yStr.substring(digit/2, digit));
		long z0 = compute(a, c);
		long z1 = compute(b, d);
		long z2 = compute((a+b), (c+d)) - z1 - z0;
		return (long) (z0*Math.pow(10, digit) + ((z2)*Math.pow(10, Math.ceil(digit/2)) + z1));
	}

	private static String parseZero(long x, int digit) {
		String str = String.valueOf(x);
		while (str.length() < digit){
			str = '0' + str;
		}
		return str;
	}
}
