import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.util.* ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.xml.internal.bind.CycleRecoverable.Context;


class pname extends JPanel implements Runnable 	
{	
	JLabel l =new JLabel() ;
	Font myFont ;
	String timevar;
	int score =0 ;
	pname()
	{
		myFont=new Font("Tahoma",Font.BOLD+Font.ROMAN_BASELINE,20);
		l.setFont(myFont) ;
		setSize(500,500) ;
		
		JPanel p=new JPanel() ;
		p.add(l) ;
		
		add(p) ;
		
		
		String name="PARADIGM" ;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int hours=0 ;
		int minutes=20 ;
		int seconds=0;

		System.out.println("\nThread Started") ;
		while(minutes!=-1)
		{
			timevar=minutes+":"+(seconds%60)+" " ;

			if(seconds==0)
			{
				if(seconds==0 && minutes==0)
					break;
				minutes-- ;
				seconds=60;
			}
		//	System.out.println("\n "+timevar) ;
			l.setText(timevar) ;
			
			try {
				--seconds ;
				Thread.sleep(1000) ;
				//tf.setText("") ;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
			System.out.println("\nCAUGHT minutes = "+ minutes + "Seconds="+ seconds) ;
			
		/*	try {
				int x=JOptionPane.showConfirmDialog(this,"Times UP... Click YES to Submit The Test?") ;
				if(x==0)
				{
					
					Finalp e = new Finalp (0);
					e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
					e.setVisible(true) ;
				} 
			}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			
		
	}
	
}
