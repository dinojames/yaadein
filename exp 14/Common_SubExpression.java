
import java.io.*;
import java.util.*;

class Common_SubExpression
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));     
		PrintWriter pw=new PrintWriter(new FileOutputStream(new File("output.txt")),true);                
		Vector L = new Vector();
		
		String s;
		Boolean flag=false;
	
		while((s=br.readLine())!=null)
		{
			flag=false;
			String r=s.substring(s.indexOf("=")+1);		
			for(int i=0;i < L.size();i++)
			{
				if((L.elementAt(i)).equals(r))	
					flag=true; 		
			}
			
			if(!flag)
			{
				L.addElement(r);	
				pw.println(s);
			}
		}
		
	}
}
