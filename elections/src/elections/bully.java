package elections;

import java.util.Scanner;



public class bully {
	public static String menuString = "1. Revive a process\n2. Kill a process\n3. Send a message to coord\n4. exit!\n";
	public static String inputMsg = "Enter the number of processes!\n";
	public static String util1 = "%d Processes are active!\n";
	public static String util2 = "Which Process to bring up?\n";
	public static String util3 = "Nigga u high? its already up!\n";
	public static String util4 = "%d Process calling election now!\n";
	public static String util5 = "Which Process to bring down?\n";
	public static String util6 = "%d is down!\n";
	public static String util7 = "%d Sending message to coordinator!\n";
	public static String util8 = "%For what is dead may never die!\n";
	public static String util9 = "%d is the Coordinator!\n";
	public static String util10 = "%d replied Ok\n";
	public static String util11 = "Which Process should msg the coordinator?\n";
	
	public static void init( int [] active, int [] processes, int n) {
		for(int i=0;i<n;++i) {
			active[i]=1;
			processes[i]=i+1;
		}
	}
	public static void main(String [] args) {
		boolean run = true;
		System.out.print(inputMsg);
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] active = new int[n];
		int [] processes = new int[n];
		init(active, processes, n);
		int coord = n;
		System.out.printf(util9,coord);
		int option;
		System.out.printf(util1,n);
		while(run) {
			System.out.print(menuString);
			option = s.nextInt();
			if(option == 4)
				run = false;
			else if(option == 1) {
				System.out.print(util2);
				int p = s.nextInt();
				if(active[p-1]==1)
					System.out.print(util3);
				else {
					active[p-1]=1;
					System.out.printf(util4,p);
					coord = elec(p,active,processes,n);
					System.out.printf(util9,coord);
				}
			}else if(option == 2) {
				System.out.print(util5);
				int p = s.nextInt();
				active[p-1]=0;
				System.out.printf(util6,p);
			}else if(option == 3){
				System.out.println(util11);
				int p = s.nextInt();
				if(active[p-1]==1) {
					System.out.printf(util7,p);
					if(active[coord-1]== 0) {
						System.out.printf(util4,p);
						coord=elec(p,active,processes,n);
						System.out.printf(util9,coord);
					}
				}else 
					System.out.print(util8);
			}else {
				System.out.println("One should always tread carefully! :)");
				run=false;
			}
		}
	}
	private static int elec(int p, int[] active, int[] processes, int n) {
		boolean found=false;
		int next=-1;
		for(int i=0;i<n;++i) {
			if(processes[i]>processes[p-1]&&active[i]==1&&i!=p-1) {
				System.out.printf(util10,i+1);
				if(!found)
					next=i+1;
				//we only want the first which sent Ok
				found=true;
			}
			
		}
		if(found) {
			System.out.printf(util4,next);
			return(elec(next,active,processes,n));
		}
		return p;
	}
}
