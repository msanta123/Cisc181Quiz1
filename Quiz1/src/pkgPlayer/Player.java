package pkgPlayer;
import java.util.Scanner;
public class Player {
	// Matt Santacecilia Quiz 1
	//main method
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//Initialize scanner object
		Scanner sc = new Scanner(System.in);
		
		//queries user to enter name
		System.out.println("Enter player's name");
		//queries user to enter info and scans and assigns given values
		String playerName;
		playerName = sc.nextLine();
		System.out.println("Enter player's total at bats");
		double playerAB = sc.nextDouble();
		System.out.println("Enter player's total hits");
		double playerH = sc.nextDouble();
		System.out.println("Enter player's total doubles");
		double playerDUB = sc.nextDouble();
		System.out.println("Enter player's total triples");
		double playerTRIP = sc.nextDouble();
		System.out.println("Enter player's total home runs");
		double playerHR = sc.nextDouble();
		System.out.println("Enter player's total runs");
		double playerR = sc.nextDouble();
		System.out.println("Enter player's total walks");
		double playerBB = sc.nextDouble();
		
		Player player = new Player(playerAB, playerH, playerDUB, playerTRIP, playerHR, playerR, playerBB);
		
		player.batAvg();
		player.onBasePercent();
		player.slugPercent();
		player.totalBases();
		player.onBaseAndSlugging();
		
		System.out.printf("%S'sB stats are:\nBA: %f\nOBP: %f\nSP: %f\nTB: %f\nOBS: %f\n", playerName, player.batAvg(), player.onBasePercent(),player.slugPercent(),player.totalBases(),player.onBaseAndSlugging());
		/*Player baberuth = new Player(8399, 2873, 506, 136, 714, 2174, 2062);
		
		baberuth.batAvg();
		baberuth.onBasePercent();
		baberuth.slugPercent();
		baberuth.totalBases();
		baberuth.onBaseAndSlugging();
		
		System.out.printf("BA: %f\nOBP: %f\nSP: %f\nTB: %f\nOBS: %f\n", baberuth.batAvg(), baberuth.onBasePercent(), baberuth.slugPercent(), baberuth.totalBases(), baberuth.onBaseAndSlugging() );
		*/
		
	}
	//attributes 
	 private double AB;
	 private double H;
	 private double DUB;
	 private double TRIPLE;
	 private double HR;
	 @SuppressWarnings("unused")
	private double R;
	 private double BB;
	 
	 //constructor
	 public Player(double AB, double H, double DUB, double TRIPLE, double HR, double R, double BB) {
		 this.AB = AB;
		 this.H = H;
		 this.DUB = DUB;
		 this.TRIPLE = TRIPLE;
		 this.HR = HR;
		 this.R = R;
		 this.BB = BB;
	 }
	 
	 //methods
	 public double batAvg() {
		
		
		return H  / AB;
		 
	 }
	 
	public double totalBases() {
		 
		return (H - DUB - TRIPLE - HR) + (2 * DUB) + (3 * TRIPLE) + (4 * HR);
		
	}
	
	public double slugPercent() {
		
		return ((H - DUB - TRIPLE - HR) + (2 * DUB) + (3 * TRIPLE) + (4 * HR)) / AB;
	}
	
	public double onBasePercent() {
		// no attribute to track hit by pitch or sac flies, as in formal calculation
		//still accurate out to second decimal
		
		return (H + BB) / (AB + BB);
		
	}
	
	public double onBaseAndSlugging() {
		
		//accurate out to second decimal
		return ((H + BB) / (AB + BB)) + (((H - DUB - TRIPLE - HR) + (2 * DUB) + (3 * TRIPLE) + (4 * HR)) / AB) ;
		
	}
}
