import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader; 
import java.util.Arrays;
import java.util.Random;




public class FileHandling {
	public static int count=0 ;
	@SuppressWarnings("null")
	/*public static void main(String args[]) throws Exception  
	{*/
	public void filehandling1() throws Exception
	{
		String[] Ques = new String[15]   ;
		String str ;
		int index=0 ;
		File f=new File("D:\\DBDEsign\\input.txt") ;
		
		FileInputStream stream=new FileInputStream(f) ;
		DataInputStream f1=new DataInputStream(stream) ;
		BufferedReader br=new BufferedReader(new InputStreamReader(f1)) ;
		while((str=br.readLine())!=null)
		{
			Ques[index]=new String() ;
			Ques[index]=str ;		
			index++ ;
			count++ ;
		}
		
		//for(int i=0;i<count;i++)
		//System.out.println("\n"+ Ques[i] ) ; 
		String Ques_final[]=new String[15] ;
		for(int i=0;i<count;i++)
		{
			Random gen=new Random() ;
			Ques_final[i]=Ques[(gen.nextInt(15))%Ques.length] ;
			System.out.println("\n"+ Ques_final[i]) ;
		}
		
		//System.out.println("\n"+ Arrays.asList(Ques_final)) ;
		
	}
}
