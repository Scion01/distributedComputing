package elections;

import java.util.Scanner;

public class ring {
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
	public static String util12 = "Enter the pID for process %d\n";
	public static String util13 = "Queue after calling election:\n";
	
	public static int init( int [] active, int [] processes, int n) {
		int max = -10000;
		int coord = n;
		for(int i=0;i<n;++i) {
			active[i]=1;
			System.out.printf(util12,i+1);
			Scanner sc = new Scanner(System.in);
			processes[i]=sc.nextInt();
			if(processes[i] >max) {
				max = processes[i];
				coord = i+1;
			}
		}
		return coord;
	}
	public static void main(String [] args) {
		boolean run = true;
		System.out.print(inputMsg);
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] active = new int[n];
		int [] processes = new int[n];
		
		int coord = init(active, processes, n);
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
		int [] ezQueue = new int[n];
		int qSize=1;
		ezQueue[qSize-1]=p-1;
		for(int i=p%n;i!=p-1;i=(i+1)%n) {
			if(active[i] == 1)
				ezQueue[qSize++]=i;
		}
		System.out.print(util13);
		int max=-10000;
		int coord=p;
		for(int i=0;i<qSize;++i) {
			System.out.print(ezQueue[i]+1+" ");
			if(processes[ezQueue[i]]>max) {
				max = processes[ezQueue[i]];
				coord = ezQueue[i];
			}
		}
		System.out.print("\n");
		return coord+1;
	}
}
