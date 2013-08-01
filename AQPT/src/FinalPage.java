import java.util.* ;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.* ;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




class Finalp extends JFrame
{
	JPanel p,ScoreDisplay,paraimage ;
	String str ;
	JLabel ThnxDescription,Score;
	public Finalp(int value) throws IOException
	{
		setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()) ;
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/files/database.jpg")))));
		ThnxDescription = new JLabel("Thanks for participating in the contest and Your Score is ") ;
		Score=new JLabel(Integer.toString(value)) ;
		Font font=new Font("Times New Roman",Font.BOLD+Font.ITALIC,40) ;
		ThnxDescription.setFont(font) ;
		ThnxDescription.setForeground(Color.WHITE) ;
		Score.setFont(font);
		Score.setForeground(new Color(221, 255, 123) );
		setLayout(new GridBagLayout()) ;
		p=new JPanel() ;
		paraimage=new ImagePanel() ;
		p.setLayout(new BorderLayout());
		p.add(ThnxDescription,BorderLayout.CENTER) ;
		p.add(Score,BorderLayout.EAST) ;
		
		
		
		p.setOpaque(false) ;
		add(p,new GridBagConstraints()) ;
		
		GridBagConstraints c=new GridBagConstraints() ;
		c.gridx=0 ;
		c.gridy=0 ;
		c.insets=new Insets(100,100, 100, 100) ; 
		c.ipadx=500 ;
		c.ipady=500 ;
		paraimage.setOpaque(false) ;
		add(paraimage,c) ;
		
		
	}

		
	
}




class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(this.getClass().getResource("/files/plogo.png"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,40,-30, null); // see javadoc for more info on the parameters            
    }

}




/*public Finalp(final int value) throws IOException
{
	str="THANKS FOR PARTICIPATING , RESULTS WILL BE ANNOUNCED SOON " +
			"\nYour Score is ";
	setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()) ;
	this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("database.jpg")))));
	this.setLayout(new GridBagLayout()) ;
	p=new JPanel() 
	{
		public void paintComponent(Graphics g)
		{	        super.paintComponent(g);
			
			g.drawString(str, 0, 200) ;
			this.setBackground(Color.GREEN) ;
		}
	} ;
	p.setOpaque(false) ;
	ScoreDisplay = new JPanel() 
	{
		public void paintComponent(Graphics g)
		{	 
			super.paintComponent(g);
			Font myFont=new Font("Tahoma",Font.BOLD+Font.ROMAN_BASELINE,20);
			this.setFont(myFont) ;
			g.drawString(Integer.toString(value), 0, 200) ;
			//this.setBackground(Color.GREEN) ;
		}
	};
	GridBagConstraints c=new GridBagConstraints() ;
	c.gridx=0 ;
	c.gridy=0 ;
	c.ipadx=400 ;
	c.ipady=400;
	c.weightx=100;
	c.insets=new Insets(100, 100, 100, 100) ;
	p.add(ScoreDisplay) ;
	add(p,c) ;
	*/