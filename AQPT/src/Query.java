import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.ResultSetMetaData;
import com.sun.corba.se.pept.transport.Connection;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import sun.nio.cs.Surrogate;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.* ;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Query {

	public static void main(String args[]) throws Exception
	{
		queryinterface1 f=new queryinterface1() ;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		f.setVisible(true) ;
	}
}




class queryinterface1 extends JFrame implements ActionListener
{
	HashMap hm=new HashMap() ;
	public String[][] answer=new String[10][10] ;
	int[] a=new int[6] ;
	Thread threadtime ;
	int total=0 ;
	int ptr=0,ptr1=34,ptr2=0 ;
	String Question ;
	java.sql.Connection con=null ;
	ResultSet rs=null ;
	JPanel Querypane,p,timerpanel,tuplespanel,outputpanel ;
	pname p1=new pname() ;
	JLabel l1,Tuples,Output ;
	JTextArea l2,t1,t2 ;
	JTextArea checkquery ;
	public String Ques[]=new String[15] ;
	JButton b1,b2,b3,b4,b5;
	JTable t ;
	public static int count=0 ;
	public static int indx=0 ;
	JScrollPane s1,s2 ;
	public queryinterface1() throws Exception 
	{
	
		// TODO Auto-generated constructor stub
		Toolkit t=Toolkit.getDefaultToolkit() ;
		Dimension d=t.getScreenSize() ;
		int screenwidth = (int) d.getWidth() ;
		int screenheight = (int) d.getHeight() ;
		setSize(screenwidth,screenheight) ; 
		setTitle("Q");
		filehandling(Ques) ;
		
		for(int i=0;i<6;i++)
			a[i]=i+1 ;
		hm.put('1', -1) ;
		hm.put('2', -1) ;
		hm.put('3', -1) ;
		hm.put('4', -1) ;
		hm.put('5', -1) ;
		hm.put('6', -1) ;
		Font tuplfont=new Font("Times New Roman",Font.BOLD,20) ;
		
		threadtime=new Thread(p1) ;
		threadtime.start() ;
		/*System.out.println("\nTHe LENGTH OF THE TEXT AREA IS "+ "select * from login where name = othin elseer and is the nss nothing else is that he is a stupid person to deal with and he".length()) ;*/
		Querypane = new Querypanel() ;
		Font myFont=new Font("Monotype Corsiva",Font.BOLD+Font.ROMAN_BASELINE,20);

		tuplespanel = new JPanel() ;
		tuplespanel.setBorder(new TitledBorder(new EtchedBorder(),"DisplayArea")); 
		
		p= new JPanel() ;
		p.setOpaque(false) ;
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/files/database.jpg")))));
		p.setLayout(new BorderLayout()) ;
		setLayout(new GridBagLayout()) ;
		Querypane.setBorder(BorderFactory.createMatteBorder(10,2,2,2,new Color(221, 255, 123))) ;
		Querypane.setBackground(new Color(30,30,7,60)) ;
	
		
		Querypane.setLayout(new GridBagLayout()) ;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width =(int) screenSize.getWidth();
		final int height =(int) screenSize.getHeight();
		setSize(width,height) ;
		l1=new JLabel("Your Query Here") ;
		l1.setFont(myFont);
		l1.setForeground(new Color(221, 255, 123)) ;
		Question=Ques[0] ;
		l2=new JTextArea(5,10) ;
		String str = Quesreturn(Ques[0]);
		
		while(ptr2<Question.length())
		{
			
			str=str + Question.substring((int) ptr ,(int) ptr1) ;
			str=str+"\n" ;
			ptr=(ptr+35)%Ques[0].length() ;
			ptr1=(ptr1+35)%Ques[0].length()  ;
			
			ptr2=ptr+35 ;
			System.out.println("\nptr is "+ptr + "\n ptr1 is "+ptr1+ " ptr2 is "+ptr2) ; 
		}
		str=str+Question.substring(ptr-1,Ques[0].length()) ;
		Font txtarea=new Font("Times New Roman",Font.BOLD,20) ;
		l2.setFont(txtarea) ;
		l2.setOpaque(false) ;
		l2.setText(str) ;
		l2.setEditable(false) ;
		
		
		l2.setMaximumSize(screenSize) ;
		l2.setForeground(new Color(221, 255, 150)) ;
		Tuples = new JLabel("TUPLES") ;
		Tuples.setFont(tuplfont) ;
		Tuples.setForeground(new Color(221, 255, 123)) ;
		Output = new JLabel("RESULT") ;
		Output.setFont(tuplfont) ;
		Output.setForeground(new Color(221, 255, 123)) ;
		
        UIManager.put ("Button.focus", new Color(221, 255, 123));
		b1=new JButton("Store") ;
		Border bdButton = new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK);
		Insets insetbutton=b1.getMargin() ;
		Border bdMargin = new EmptyBorder (insetbutton.top+1, insetbutton.left+1,
				insetbutton.bottom+1, insetbutton.right+1);
		b1.setBorder(new CompoundBorder(bdButton,bdMargin)) ;
		b1.setOpaque(false) ;
		b2=new JButton("Next") ;
		b3=new JButton("Previous") ;
		b4=new JButton("CheckQuery") ;
		b5=new JButton("SubmitTest") ;
		t1=new JTextArea(4, 30) ;
		t1.setTabSize(1) ;
		s2=new JScrollPane(t1) ;
		//t1.setLineWrap(true);
		t1.setWrapStyleWord(true);
		t2=new JTextArea(10,8) ;
		s1=new JScrollPane(t2) ;
		s1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS) ;
		
		
		checkquery = new JTextArea(4,4) ;
		
		GridBagConstraints c=new GridBagConstraints() ;
		c.ipadx=50 ;
		c.anchor=c.CENTER  ;
		c.gridx=2 ;
		c.gridy=0 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(l1,c) ;
		c.gridx=0 ;
		c.gridy=1 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		c.insets=new Insets(30, 30, 30, 30) ;
		Querypane.add(l2,c) ;
		c.gridx=0 ;
		c.gridy=2 ;
		c.fill=GridBagConstraints.VERTICAL ;
		Querypane.add(s2,c) ;
		c.gridx=0 ;
		c.gridy=3;
		c.fill=GridBagConstraints.VERTICAL ;
		Querypane.add(b1,c) ;
		c.gridx=1 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b3,c) ;
		c.gridx=2 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b2,c) ;
		c.gridx=3 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b4,c) ;
		c.gridx=4 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b5,c) ;
		t2.setEnabled(false) ;
		checkquery.setEnabled(false) ;
		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				b1.setBackground(new Color(221, 255, 123));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
				b1.setBackground(UIManager.getColor("control"));
				}
		});
		
		b2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				b2.setBackground(new Color(221, 255, 123));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
				b2.setBackground(UIManager.getColor("control"));
				}
		});
		
		b3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				b3.setBackground(new Color(221, 255, 123));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
				b3.setBackground(UIManager.getColor("control"));
				}
		});
		
		b4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				b4.setBackground(new Color(221, 255, 123));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
				b4.setBackground(UIManager.getColor("control"));
				}
		});
		c.gridx=3 ;
		c.gridy=2 ;
		Querypane.add(s1,c) ;
		c.gridx=3 ;
		c.gridy=1 ;
		Querypane.add(Tuples,c) ;
		c.gridx=4 ;
		c.gridy=2 ;
		Querypane.add(checkquery,c) ;
		c.gridx=4 ;
		c.gridy=1 ;
		Querypane.add(Output,c) ;
		Querypane.setOpaque(false);
		
		p.add(Querypane,BorderLayout.CENTER) ;
		p.add(p1,BorderLayout.NORTH) ;
		
		add(p,new GridBagConstraints()) ;
		
		b4.setActionCommand("check") ;
		b2.setActionCommand("next");
		b3.setActionCommand("previous");
		b1.setActionCommand("Submit") ;
		b5.setActionCommand("Submittest") ;
		
		b1.addActionListener(this) ;
		b2.addActionListener(this) ;
		b3.addActionListener(this) ;
		b4.addActionListener(this) ;
		b5.addActionListener(this) ;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver") ;
		}
			catch (ClassNotFoundException e2) 
			{
				e2.printStackTrace();
			}
		try 
		{
		
			con=DriverManager.getConnection("jdbc:mysql://localhost/round2", "root", "vasanthi") ;
			System.out.println("\nSuccessfully Connected") ;
		} 
		catch (SQLException e1) {
		e1.printStackTrace();
		}	
		
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) 
	{ 
		
	
		if(e.getActionCommand()=="Submit") 
		{
			rs=null ;
			String query=t1.getText() ;
			try
			{
				System.out.println("\nTHe value is "+query) ;
			PreparedStatement pstmt=con.prepareStatement(query) ;
			rs= pstmt.executeQuery() ;
			if(rs.next())
			{
				rs.last() ;
		
				Display(rs) ;
				
				
			}
			
			
			
			}
			catch(Exception e1)
			{
				System.out.println("\ncaught here") ;
				JOptionPane.showMessageDialog(this,"Sorry Table Doesnot Exists" ) ;
				File f=new File(this.getClass().getResource("src/files/out_"+l2.getText().charAt(1)+".txt").toString()) ;
				FileWriter fstream = null;
				try {
					fstream = new FileWriter(f);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					System.out.println("\nMESSAGE IS "+e2.getMessage()) ;
					e2.printStackTrace();
				}
				BufferedWriter out=new BufferedWriter(fstream) ;
				try {
					out.write(" ") ;
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			
		}
		else if(e.getActionCommand()=="next")
		{indx++ ;
		if(indx>=0)
			b3.setEnabled(true) ;
		
			if(indx==6)
			{
				b2.setEnabled(false) ;
				return ;
			}
			
			l2.setText(Quesreturn(Ques[indx])) ;
			t1.setText("") ;
			System.out.println("\nINSIDE THE NEXT "+l2.getText().charAt(1)) ;
			if((Integer) hm.get(l2.getText().charAt(1))==0)
			{
				checkquery.setBackground(Color.RED) ;
			}
			else if((Integer) hm.get(l2.getText().charAt(1))==1)
			{
				checkquery.setBackground(Color.GREEN) ;
			}
			else
			checkquery.setBackground(Color.WHITE) ;


			
			
			
		}
		else if(e.getActionCommand()=="previous")
		{	
			if(indx==0)
			{
				b3.setEnabled(false) ;
				return ;
			}
			indx-- ;
	
		if(indx<6)
			b2.setEnabled(true) ;
			l2.setText(Quesreturn(Ques[indx])) ;
			t1.setText("") ;
			if((Integer) hm.get(l2.getText().charAt(1))==0)
			{
				checkquery.setBackground(Color.RED) ;
			}
			else if((Integer) hm.get(l2.getText().charAt(1))==1)
			{
				checkquery.setBackground(Color.GREEN) ;
			}
			else
			checkquery.setBackground(Color.WHITE) ;

			
		}
		else if(e.getActionCommand()=="Submittest") 
		{
			dispose() ;
			Finalp f = null;
			try {
				f = new Finalp(total);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
			f.setVisible(true) ;
			
		}
		
		else
		{
			try {
				if(check()==0)
				{
					checkquery.setBackground(Color.RED) ;
					hm.put(l2.getText().charAt(1), 0) ;
					System.out.println("\nHELLO INSIDE RED"+hm.get(l2.getText().charAt(1)).getClass()) ;
					
		
				}
				else
				{
					checkquery.setBackground(Color.GREEN) ;
					char index1=l2.getText().charAt(1) ;
					int index=Integer.parseInt(Character.toString(index1)) ;
					System.out.println("\nHello this is test"+index) ;
					hm.put(l2.getText().charAt(1), 1) ;
					System.out.println("\nHELLO INSIDE GREEN"+hm.get(l2.getText().charAt(1))) ;
					total=total+a[index-1] ;
					a[index-1]=0 ;
					
					
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public int check() throws Exception
	{
		String  str1,str2 ;
		int i=0 ;
		int index=Integer.parseInt(Character.toString(l2.getText().charAt(1))) ;
		str1="/files/out_"+l2.getText().charAt(1)+".txt" ;
		str2="/files/corout_"+l2.getText().charAt(1)+".txt" ;
		BufferedReader br=null ;
		
		System.out.println("HELO MIGHT BE THE REASON"+str1+"\t"+str2) ;

		
		DataInputStream stream =new DataInputStream(queryinterface1.class.getResourceAsStream(str2)) ;//new FileInputStream(new File("src/files/out_1.txt"))) ;
		 br=new BufferedReader(new InputStreamReader(stream)) ;
		

		DataInputStream stream1 =new DataInputStream(queryinterface1.class.getResourceAsStream(str2)) ;//new FileInputStream(new File("src/files/out_1.txt"))) ;
		BufferedReader br1=new BufferedReader(new InputStreamReader(stream1)) ;
	
		for(i=0;i<=2;i++)
		{
			
				System.out.println("Success"+answer[index][i]) ;
			
		}
		
		str1=br.readLine() ;
		str2=br1.readLine() ;
		System.out.println("\nHERE"+str2) ;
		i=0 ;
		try
		{
			
		while(answer[index][i]!=null || str2!=null)
		{
			if(answer[index][i].equals(str2))
			{
				System.out.println("\nString123"+answer[index][i]+str2+"\n") ;
				i++ ;
				str2=br1.readLine() ;
			//	System.out.println("\nString123\t"+str1+"\n"+str2+"\n") ;
			}
			else
				return 0 ;
		}
		
		return 1 ;
		}
		catch(Exception e)
		{
			

			
		}
		return 0 ;

		
	}
	
	
	public void Display(ResultSet rs) throws Exception
	{
		String str ;
		t2.setText(" ") ;
		java.sql.ResultSetMetaData rsmd ;
		int i=0,j=0,index=0  ;
		
		try
		{
		int rowcount=0,columncount=0  ;
		rowcount=rs.getRow() ;
		rsmd=rs.getMetaData() ;
		

		StringBuilder s=new StringBuilder() ;
		columncount=rsmd.getColumnCount() ;
		index=Integer.parseInt(Character.toString(l2.getText().charAt(1))) ;

		
		if(answer[index][0]!=null)
		{
			int x=JOptionPane.showConfirmDialog(this,"Do you want to Overwrite the previous Query OK/CANCEL") ;

			if(x==0)
			{
				for(i=0;i<10;i++)
				{
					//System.out.println("\nITHE") ;
					answer[index][i]=null ;
				}
					
			}
			if(x==1||x==2)
				return ;
			
		}
		
		rs.first() ;
		answer[index][0]=Integer.toString(index)+"." ;
		

			i=0 ;
			while(i<rowcount) 
			{j=0 ;
			
			while(j<columncount)
			{
				
				
				t2.append(rs.getString(j+1))  ;
				s.append(rs.getString(j+1))  ;
				if((j+1)!=columncount)
				s.append(" ") ;
		//		answer[index][i+1]=answer[index][i+1].substring(4, answer[index][i+1].length()) ;
				t2.append("\t") ;
				j++ ;
			}
			answer[index][i+1]=s.toString() ;
			s.delete(0,s.length()) ;
			i++ ;
			
			
			rs.next();
			
			t2.append("\n") ;


		}
		}
		catch(Exception e)
		{
			System.out.println("\nException is "+e.getMessage()) ;

		}
		
		
	}
	
	public void filehandling(String[] Ques) throws Exception
	{

		String str ;
		int index=0 ;
		String str1="/input.txt" ;

		DataInputStream stream =new DataInputStream(queryinterface1.class.getResourceAsStream(str1)) ;
		 BufferedReader br=new BufferedReader(new InputStreamReader(stream)) ;

/*		FileInputStream stream=new FileInputStream(f) ;
		DataInputStream f1=new DataInputStream(stream) ;
		BufferedReader br=new BufferedReader(new InputStreamReader(f1)) ;*/
		while((str=br.readLine())!=null)
		{
			Ques[index]=new String() ;
			Ques[index]=str ;		
			index++ ;
			count++ ;
		}
		
		String Ques_final[]=new String[15] ;
		for(int i=0;i<count;i++)
		{
			Random gen=new Random() ;
			Ques_final[i]=Ques[(gen.nextInt(15))%Ques.length] ;

		}
		

		
	}
	public String Quesreturn(String temp)
	{
		ptr=0;
		ptr1=35 ;
		ptr2=0 ;
		Question=temp ;
		String str1="";
		while(ptr2<temp.length())
		{
			
			str1=str1 + Question.substring((int) ptr ,(int) ptr1) ;
			str1=str1+"\n" ;
			ptr=(ptr+35)%temp.length() ;
			ptr1=(ptr1+35)%temp.length()  ;
			
			ptr2=ptr+35 ;
		 
		}

		str1=str1+Question.substring(ptr-1,temp.length()) ;
		return str1;
		
	}
	

}


