import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FR1 extends JFrame implements ActionListener
{
	JButton bt[]= new JButton[9];
	String Player ="X";
	JMenuBar mb;
	JMenu m;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;
	public FR1()
	{
		
		
		this.setTitle("Grid Demo");
		mb= new JMenuBar();
		m= new JMenu("Game");
		mi1= new JMenuItem("New Game");
		mi2= new JMenuItem("Metal");		
		mi3= new JMenuItem("Windows");	
		mi4= new JMenuItem("Motfit");
		mi5= new JMenuItem("Nimbus");
		mi6= new JMenuItem("Exit");
		setJMenuBar(mb);
		mb.add(m);
		m.add(mi1);
		m.add(mi2);
		m.add(mi3);
		m.add(mi4);
		m.add(mi5);
		m.add(mi6);
		mi1.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 {
		 
			reset();
		}
		});
	
		mi3.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 {
		 
		 	try
		 	{
		 		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		 		SwingUtilities.updateComponentTreeUI(FR1.this);
		    }
		    catch(Exception ex)
		    {
		    	JOptionPane.showMessageDialog(null,ex.getMessage());
		    
		    }
		}
		});
		
		
		mi4.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 {
		 
		 	try
		 	{
		 		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		 		SwingUtilities.updateComponentTreeUI(FR1.this);
		    }
		    catch(Exception ex)
		    {
		    	JOptionPane.showMessageDialog(null,ex.getMessage());
		    
		    }
		}
		});
		
		
		mi5.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 {
		 
		 	try
		 	{
		 		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		 		SwingUtilities.updateComponentTreeUI(FR1.this);
		    }
		    catch(Exception ex)
		    {
		    	JOptionPane.showMessageDialog(null,ex.getMessage());
		    
		    }
		}
		});
	
		mi6.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		 {
		 
		 	System.exit(0);
    	}
		});
	this.setSize(400,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new GridLayout(3,3,10,20));
	for(int i=0;i<9;i++)
	{
		bt[i] = new JButton("");
		bt[i].setBackground(Color.RED);
		bt[i].setFont(new Font("Comic Sans MS",Font.BOLD,50));
		add(bt[i]);
		bt[i].addActionListener(this);
		
	}
		try
		 	{
		 		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		 		SwingUtilities.updateComponentTreeUI(FR1.this);
		    }
		    catch(Exception ex)
		    {
		    	JOptionPane.showMessageDialog(null,ex.getMessage());
		    
		    }
   }
   public void actionPerformed(ActionEvent e)
   {
   	JButton b = (JButton)e.getSource();
   	if(b.getText().equals(""))
   	{
   		b.setText(Player);
   		if(win())
   		{
   			JOptionPane.showMessageDialog(null,"Player " + Player + " wins");
   			reset();
   		}
   		else if(draw())
   		{
   		 
   			JOptionPane.showMessageDialog(null,"Match Draw");
   			reset();	
   		}
   		else
   		Player = Player.equals("X")?"O":"X";
   	}
   }
   public boolean win()
   {
   	if(!bt[0].getText().equals("")
   	&& bt[0].getText().equals(bt[1].getText())
   	&& bt[0].getText().equals(bt[2].getText())
      )
    return true;
   	if(!bt[3].getText().equals("")
   	&& bt[3].getText().equals(bt[4].getText())
   	&& bt[3].getText().equals(bt[5].getText())
   	  )
    return true;
   	if(!bt[6].getText().equals("")
   	&& bt[6].getText().equals(bt[7].getText())
   	&& bt[6].getText().equals(bt[8].getText())
      )
    return true;
    if(!bt[0].getText().equals("")
   	&& bt[0].getText().equals(bt[3].getText())
   	&& bt[0].getText().equals(bt[6].getText())
      )
    return true;
    	if(!bt[1].getText().equals("")
   	&& bt[1].getText().equals(bt[4].getText())
   	&& bt[1].getText().equals(bt[7].getText())
   )
    return true;
    	if(!bt[2].getText().equals("")
   	&& bt[2].getText().equals(bt[5].getText())
   	&& bt[2].getText().equals(bt[8].getText())
   )
    return true;
    	if(!bt[0].getText().equals("")
   	&& bt[0].getText().equals(bt[4].getText())
   	&& bt[0].getText().equals(bt[8].getText())
   )
    return true;
    	if(!bt[2].getText().equals("")
   	&& bt[2].getText().equals(bt[4].getText())
   	&& bt[2].getText().equals(bt[8].getText())
   ) 
   return true;
   
   
    return false;
   }
   public boolean draw()
   {
   	for(JButton b : bt)
   	if(b.getText().equals(""))
   	return false;
   	return true;
   	}
   public void reset()
   {
   	for(JButton b: bt)
   	b.setText("");
   	Player="X";
   }
    public static void main(String args[])
    {
    	FR1 ref = new FR1();
    	ref.setVisible(true);
    }
 }
	
	
	

   
   