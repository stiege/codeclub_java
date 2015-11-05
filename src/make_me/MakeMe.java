package make_me;
import java.math.BigInteger;

public class MakeMe {
	
	public static double return_divide_by_two(double a){
		return a/2;
	}

	public static String return_hello_world(){
		return "Hello world";
	}

	public static BigInteger return_nth_fibonacci(int n){
		BigInteger i = new BigInteger("1");
		BigInteger j = new BigInteger("1");
		BigInteger next_val = new BigInteger("0");
		int start = n;
		while (start > 2){
			next_val = i.add(j);
			j = i;
			i = next_val;
			start--;
		}
		return next_val;
	}

	public static IDuck return_a_duck(){
		final class Duck implements IDuck{

			@Override
			public void eat(IConsumable edible) {
				edible.consume();
			}

			@Override
			public String quack() {
				return "quack";
			}

			@Override
			public String walk() {
				return "waddle, waddle, waddle";
			}
		}
		return new Duck();
	}
}
