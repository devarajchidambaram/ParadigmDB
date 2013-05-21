import java.util.* ;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.* ;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import quicktime.app.event.MouseButtonListener;

import com.sun.awt.AWTUtilities;

public class Interfacecheck {

	public static void main(String args[]) throws IOException
	{
	
		Interface f=new Interface() ;
	
        

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		f.setVisible(true) ;
		
		
	}
	
		
}



class Interface extends JFrame 
{
	JPanel p ;
	pname p1=new pname() ;
	JPanel Querypane ;
	JLabel l1,l2 ;
	
	JTextArea t1,t2 ;
	JTextArea checkquery ;
	public String Ques[]=new String[15] ;
	JButton b1,b2,b3,b4 ;

	Interface() throws IOException
	{
		Thread t=new Thread(p1) ;
		t.start() ;
		System.out.println("\nTHe LENGTH OF THE TEXT AREA IS "+ "select * from login where name = othin elseer and is the nss nothing else is that he is a stupid person to deal with and he".length()) ;
		Querypane = new Querypanel() ;
		Font myFont=new Font("Monotype Corsiva",Font.BOLD+Font.ROMAN_BASELINE,20);

		
		p= new JPanel() ;
		p.setOpaque(false) ;
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("files/database.jpg")))));
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
		l1=new JLabel("Your Query Here") ;
		l1.setFont(myFont);
		l1.setForeground(Color.GREEN) ;
		l2=new JLabel("Question no 2") ;
		l2.setForeground(Color.GREEN) ;
		
		l2.setFont(myFont);
        UIManager.put ("Button.focus", new Color(221, 255, 123));
		b1=new JButton("Submit") ;
		Border bdButton = new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK);
		Insets insetbutton=b1.getMargin() ;
		Border bdMargin = new EmptyBorder (insetbutton.top+1, insetbutton.left+1,
				insetbutton.bottom+1, insetbutton.right+1);
		b1.setBorder(new CompoundBorder(bdButton,bdMargin)) ;
		b1.setOpaque(false) ;
		b2=new JButton("Next") ;
		b3=new JButton("Previous") ;
		b4=new JButton("CheckQuery") ;
		t1=new JTextArea(4, 30) ;
		t1.setTabSize(1) ;
		//t1.setLineWrap(true);
		t1.setWrapStyleWord(true);

		GridBagConstraints c=new GridBagConstraints() ;
		c.ipadx=50 ;
		c.anchor=c.CENTER  ;
		c.gridx=1 ;
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
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(t1,c) ;
		c.gridx=0 ;
		c.gridy=3;
		c.fill=GridBagConstraints.VERTICAL ;
		Querypane.add(b1,c) ;
		c.gridx=1 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b2,c) ;
		c.gridx=2 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b3,c) ;
		c.gridx=3 ;
		c.gridy=3 ;
		c.fill=GridBagConstraints.HORIZONTAL ;
		Querypane.add(b4,c) ;
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
		
		p.add(Querypane,BorderLayout.CENTER) ;
		p.add(p1,BorderLayout.NORTH) ;
		add(p,new GridBagConstraints()) ;
		
	}

	
}



class Querypanel extends JPanel{

    private BufferedImage image;

    public Querypanel() {
       try {                
          image = ImageIO.read(this.getClass().getResource("/files/plogo.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,20,-25, null); // see javadoc for more info on the parameters            
    }

}



