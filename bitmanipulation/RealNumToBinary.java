package bitmanipulation;

/*
 * Given a (decimal - e g 3 72) number that is passed in as a string, print the binary representation.
 *  If the number can not be represented accurately in binary, print ERROR
 *  
 */
public class RealNumToBinary {
	/*
	 * 0.25 -> 0.01
 *  0.25*2=0.5..................0
 *  0.5*2 = 1...................1
 *  0.8125 -> 0.1101
 *  0.8125*2=1.6250.............1
 *  0.6250*2=1.2500.............1
 *  0.25*2  =0.5................0
 *  0.5*2   =1..................1
	 */
	public void printBinary1(double num){
		if(num > 1 || num < 0){
			System.out.println("ERROR");
		}
		
		StringBuilder binary = new StringBuilder();
		binary.append("0.");
		while(num > 0){
			//setting a limit on length: 32 characters
			if(binary.length() >= 32){
				System.out.println("ERROR");
			}
			
			double r = num * 2;
			if(r >= 1){
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		System.out.println(binary.toString());
	}
	
	/*
	 * 0.25 -> 0.01
 *  0.25 < frac =0.5..................0
 *  0.25 = frac=0.5/2.................1
 *  
 *  0.8125 -> 0.1101
 *  0.8125 > frac=0.5    .............1
 *  0.3125 > frac=0.5/2  .............1
 *  0.3125-0.25=0.0625 < frac=0.25/2................0
 *  0.0.0625 = 0.125/2   ..................1
	 */
	public void printBinary2(double num){
		if(num > 1 || num < 0){
			System.out.println("ERROR");
		}
		
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append("0.");
		while(num > 0){
			//setting a limit on length: 32 characters
			if(binary.length() >= 32){
				System.out.println("ERROR");
			}
			
			if(num >= frac){
				binary.append(1);
				num = num - frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		System.out.println(binary.toString());
	}
}
