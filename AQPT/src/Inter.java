import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.pept.transport.Connection;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
public class Inter {

	public static void main(String args[]) throws IOException
	{
		
		
		frame f=new frame() ;
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		f.setVisible(true) ;
	}
}



class frame extends JFrame implements ActionListener
{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	java.sql.Connection con=null ;
	
	JButton b1,b2 ;
	JLabel l1,l2 ;
	JTextField t1 ;
	JLabel Description  ;
	JPasswordField t2 ;
	private JPanel p,Querypane ;
	private JPanel p1 ;

	
	public frame() throws IOException 
	{
		
		Querypane = new Querypanel() ;
		Font myFont=new Font("Monotype Corsiva",Font.BOLD+Font.ROMAN_BASELINE,20);
		
		p= new JPanel() ;
		p.setOpaque(false) ;
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/files/database.jpg")))));
		p.setLayout(new BorderLayout()) ;
		setLayout(new GridBagLayout()) ;
		Querypane.setBorder(BorderFactory.createMatteBorder(10,2,2,2,new Color(221, 255, 123))) ;
		Querypane.setBackground(new Color(30,30,7,60)) ;
	//	setLayout(new BorderLayout()) ;
		
		Querypane.setLayout(new GridBagLayout()) ;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width =(int) screenSize.getWidth();
		final int height =(int) screenSize.getHeight();
		setSize(width,height) ;
		l1=new JLabel("Username: ") ;
		l1.setFont(myFont);
		l1.setForeground(Color.GREEN) ;
		l2=new JLabel("Password:") ;
		l2.setForeground(Color.GREEN) ;
		t1=new JTextField(10) ;
		t2=new JPasswordField(10) ;
		Description=new JLabel("*Sorry Cannot Authenticate") ;
		Description.setForeground(Color.RED) ;
		Description.setVisible(false) ;
		Description.setFont(myFont) ;
		Querypane.setOpaque(false);
		l2.setFont(myFont);
        UIManager.put ("Button.focus", new Color(221, 255, 123));
		b1=new JButton("Login") ;
		Border bdButton = new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK);
		Insets insetbutton=b1.getMargin() ;
		Border bdMargin = new EmptyBorder (insetbutton.top+1, insetbutton.left+1,
		insetbutton.bottom+1, insetbutton.right+1);
		b1.setBorder(new CompoundBorder(bdButton,bdMargin)) ;
		b1.setOpaque(false) ;
	
		
	
		GridBagConstraints c=new GridBagConstraints() ;
		c.ipadx=50 ;
		c.anchor=c.CENTER  ;
		c.gridx=(int) 0.5 ;
		c.gridy=0 ;
		c.insets=new Insets(0,30,0,0) ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(l1,c) ;
		c.gridx=1 ;
		c.gridy=0 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		c.insets=new Insets(40, 30, 30, 30) ;
		Querypane.add(t1,c) ;
		c.gridx=0 ;
		c.gridy=2 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(l2,c) ;
		c.gridx=1 ;
		c.gridy=2;
		c.fill=GridBagConstraints.VERTICAL ;
		Querypane.add(t2,c) ;
		c.gridx=2 ;
		c.gridy=2 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(Description,c) ;
		c.gridx=1 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b1,c) ;
		
		p.add(Querypane,BorderLayout.CENTER) ;
		
		
		add(p,new GridBagConstraints()) ;
		
		
			b1.setActionCommand("login") ;
			b1.addActionListener(this) ;
	
			
			
			
		
}
	
	
	public void actionPerformed(ActionEvent e)
	{
		try {
				Class.forName("com.mysql.jdbc.Driver") ;
			}
		catch (ClassNotFoundException e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			
			con=DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ssn") ;
			System.out.println("\nSuccessfully Connected") ;
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(e.getActionCommand()=="login") 
		{
			String x,y ;
			ResultSet rs=null ;
			Description.setVisible(false) ;
			x=t1.getText();
			y=t2.getText() ;
			try
			{
			PreparedStatement pstmt=con.prepareStatement("select * from login where reg_id=? and password=? ") ;
			pstmt.setString(1,x) ;
			pstmt.setString(2,y) ;
			rs=pstmt.executeQuery() ;
			if(rs.next())
			{System.out.println("\nSucceeded") ;
			dispose() ;
			startest s=new startest() ;
			s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
			s.setVisible(true) ;
			
			}
			else
			{
				Description.setVisible(true) ;
				System.out.println("\nCAUGHT") ;
			}
			}
			catch(Exception e1)
			{
				
			}
			
			
		}
		if(e.getActionCommand()=="test") 
		{
			String x ;
			
			x=t1.getText();
			
			try
			{
			PreparedStatement pstmt=con.prepareStatement("delete from login where reg_id=? ") ;
			pstmt.setString(1,x) ;
		
			pstmt.executeUpdate() ;
			}
			catch(Exception e1)
			{}
			System.out.println("\nHEllo inside test") ;
		}
	}
}

class startest extends JFrame implements ActionListener
{
	JButton start ;
	JPanel startpanel ;
	public startest() throws IOException
	{
		setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() , (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() ) ;
		setLayout(new GridBagLayout()) ;
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/files/database.jpg")))));
		startpanel=new JPanel() ;
		startpanel.setBorder(BorderFactory.createMatteBorder(10,2,2,2,new Color(221, 255, 123))) ;

		start=new JButton("CLICK TO START THE COMPETITION") ;
		
		startpanel.add(start) ;
		add(startpanel,new GridBagConstraints()) ;
		
		start.addActionListener((ActionListener) this) ;
		start.setActionCommand("startest") ;
	}
	@Override
	public void actionPerformed(ActionEvent ac) {
		// TODO Auto-generated method stub
		if(ac.getActionCommand()=="startest")
		{
			dispose() ;
			queryinterface1 q = null;
			try {
				q = new queryinterface1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
			q.setVisible(true) ;
		}
		
	}
	
	
}
