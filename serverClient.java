package server1;
import java.io.*; 
import java.util.*; 
import java.net.*; 
	
public class serverClient implements Runnable{
	Scanner sc = new Scanner(System.in);
	private String name;
	final DataInputStream di;
	final DataOutputStream dos;
	Socket s;
	boolean logged;
	
	public serverClient(Socket ss, String n, DataInputStream ddi, DataOutputStream ddo)
	{
		this.di = ddi;
		this.dos = ddo;
		this.s = ss;
		this.name = n;
	}
	
	public void run()
	{
		String rec;
		while(true)
		{
			try
			{
				rec = di.readUTF();
				System.out.println(rec);
				if(rec.equals("end"))
				{
					this.logged = false;
					this.s.close();
					break;
				}
				
				StringTokenizer st = new StringTokenizer(rec, "#");
				String msg = st.nextToken();
				String recpt = st.nextToken();
				
				
				for(serverClient sc : Server1.vec1)
				{
					
					if(sc.name.equals(rec) && sc.logged == true)
					{
						sc.dos.writeUTF(this.name + " : " + msg);
						break;
					}
				
				}
				
			}
			catch(IOException e)
			{
				
			}
		}
	}
	
}
