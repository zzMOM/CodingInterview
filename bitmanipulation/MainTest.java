package bitmanipulation;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertMN insertmn = new InsertMN();
		insertmn.updateBits(1000, 23, 2, 8);
		
		RealNumToBinary rnb = new RealNumToBinary();
		rnb.printBinary1(0.125);
		rnb.printBinary2(0.125);
	}

}
