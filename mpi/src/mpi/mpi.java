import mpi.*;

public class mpi_temp {
		public static void main(String [] args) throws Exception {
			MPI.Init(args);
			int rank = MPI.COMM_WORLD.Rank();
			int size = MPI.COMM_WORLD.Size();
			int root =0;
			int [] buff = new int[size];
			int [] out = new int[size];
			if(rank == root) {
				System.out.println("Root initializing buffer!");
				buff[0] =10;
				buff[1] =20;
				buff[2] =30;
				buff[3] =40;
				System.out.println("Buffer init done!");
			}
			MPI.COMM_WORLD.Scatter(buff, 0, 1, MPI.INT, out, 0, 1,MPI.INT,root);
			//the above is important, look at the type
			System.out.println("process with rank "+rank+" has "+out[0]);
			out[0]*=2;
			//the above is 0, its important
			MPI.COMM_WORLD.Gather(out, 0, 1, MPI.INT, buff, 0, 1, MPI.INT, root);
			if(rank == root) {
				System.out.println("root has:");
				for(int i=0;i<size;++i)
						System.out.printf("%d ",buff[i]);
						//the one that has to be outputed is the original buffer
			}
		}
}

//write the code in eclipse and add import mpi.*;
//first set MPJ_HOME, export MPJ_HOME=path to MPJ root (not $MPJ_HOME)
//then set path as PATH=$MPJ_HOME/lib:$PATH
//then compile as javac -cp $MPJ_HOmE/lib/mpj.jar filename.java (Watch for mpj)
//run using $MPJ_HOME/bin/mpjrun.sh -np 4 class_name 
//as u write on eclipse, there will be some errors of classpath, IGNORE