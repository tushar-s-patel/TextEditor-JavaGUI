

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor implements ActionListener  {
	JFrame frame;
	JPanel nav;
	JTextArea textarea;
	JButton saveBtn;
	JSpinner fontsize;
	JLabel F_S;
	JLabel C_n;
	JButton colorbtn;
	Color clr =Color.black;
	JComboBox<String> Fontbox;
	JMenuBar menu;
	JMenu fileMenu;
	JMenu styleMenu;
	JMenuItem open;
	JMenuItem save;
	JMenuItem nWindow;
	JMenuItem exit;
	JMenuItem darkTheme ;
	JMenuItem lightTheme ;
	JMenuItem redTheme;
	JMenuItem blueTheme ;
	JMenuItem greenTheme ;
	JMenuItem grayTheme ;
	JLabel Fname;
	File file;
	
	
	
	public TextEditor() {
//		-----------------------MainFrame------------------------------------
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
//		-------------------------------------------------------------------
		
		
		
//		------------------------TextArea--------------------------------------
		textarea = new JTextArea();
//		textarea.setPreferredSize(new Dimension(450,450));
		textarea.setFont(new Font("Lucida Console",Font.PLAIN,15));
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		JScrollPane scroll =new JScrollPane(textarea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(450,450));
//		-----------------------------------------------------------------------
		
		
		
//		-------------------------NavArea-----------------------------------------
		nav=new JPanel();
		nav.setPreferredSize(new Dimension(500,25));
		nav.setBackground(new Color(200,200,200));
		nav.setLayout(null);
//		------------------------------------------------------------------------
		
		
		
//		-------------------------------SaveBTN-----------------------------------------
		saveBtn =new JButton("save");
		saveBtn.setBounds(0,0,50,25);
		saveBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		saveBtn.setFocusable(false);
		saveBtn.addActionListener(this);
		nav.add(saveBtn);
//		--------------------------------------------------------------------------------
		
		
		
//		-------------------------------FontSizeSpinner--------------------------------------
		F_S =new JLabel("FontSize : ");
		F_S.setBounds(60, 0, 70, 25);
		nav.add(F_S);
		fontsize=new JSpinner();
		fontsize.setBounds(120,0,40,25);
		fontsize.setValue(15);
		fontsize.addChangeListener(new ChangeListener()  {
			@Override
			public void stateChanged(ChangeEvent e) {
				textarea.setFont(new Font(textarea.getFont().getFamily(),Font.PLAIN,(int) fontsize.getValue()));
				
			}
		});
		nav.add(fontsize);
//		------------------------------------------------------------------------------------------
		
		
		
		
//		----------------------------------ColorBTN------------------------------------------------
		C_n =new JLabel("Color : ");
		C_n.setBounds(180, 0, 50, 25);
		nav.add(C_n);
		
		colorbtn=new JButton();
		colorbtn.setBounds(220,5,15,15);
		colorbtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		colorbtn.setFocusable(false);
		colorbtn.addActionListener(this);
		colorbtn.setBackground(clr);
		nav.add(colorbtn);
//		------------------------------------------------------------------------------------------
		
		
		
//		-----------------------------------------FontsBox----------------------------------
		String [] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		Fontbox =new JComboBox<String>(fonts);
		Fontbox.setBounds(250,0,150,25);
		Fontbox.addActionListener(this);
		Fontbox.setSelectedItem("Lucida Console");
		nav.add(Fontbox);
//		------------------------------------------------------------------------------------
		
		
		
//		------------------------------------FileName---------------------------------------
		Fname=new JLabel();
		Fname.setBounds(450, 0, 150, 25);
		nav.add(Fname);
//		-----------------------------------------------------------------------------------
		
		
		
		// ----------------------------------------JmenuBar---------------------------------------------//
//		-----------------------------------------------fileMenu-----------------//
		JMenuBar menu=new JMenuBar();
		fileMenu=new JMenu ("File");
		 open =new JMenuItem("Open");
		 save= new JMenuItem("Save");
		 exit=new JMenuItem("Exit");
		 nWindow=new JMenuItem("New Window");
		 fileMenu.add(open);
		 fileMenu.add(save);
		 fileMenu.add(nWindow);
		 fileMenu.add(exit);
		 
		 
		 open.addActionListener(this);
		 save.addActionListener(this);
		 exit.addActionListener(this);
		 nWindow.addActionListener(this);
		 menu.add(fileMenu);
//		 -----------------------------------------------------------------------------------
		 
		 
		 
//		--------------------------------EditMenu---------------------------------------------
		styleMenu=new JMenu ("Edit");
		lightTheme= new JMenuItem("Default");
		 darkTheme =new JMenuItem("DarkestDark");
		 redTheme =new JMenuItem("Red");
		 blueTheme =new JMenuItem("Blue");
		 greenTheme =new JMenuItem("Green");
		 grayTheme =new JMenuItem("Gray");
		 styleMenu.add(lightTheme);
		 styleMenu.add(darkTheme);
		 styleMenu.add(redTheme);
		 styleMenu.add(blueTheme);
		 styleMenu.add(greenTheme);
		 styleMenu.add(grayTheme);
		 lightTheme.addActionListener(this);
		 darkTheme.addActionListener(this);
		 redTheme .addActionListener(this);
		 blueTheme.addActionListener(this);
		 greenTheme.addActionListener(this);
		 grayTheme.addActionListener(this);
		 menu.add(styleMenu);
//		--------------------------------------------------------------------------------------

		frame.setJMenuBar(menu);
		frame.add(nav,BorderLayout.NORTH);
		frame.add(scroll,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
//		==================================================SaveBTN===============================================
		
		if(e.getSource()==saveBtn) {
			JFileChooser Filechooser=new JFileChooser();
			Filechooser.setCurrentDirectory(new File("JavaTextFolder"));
			PrintWriter writer=null;
			if(file!=null) {
				Fname.setText(file.getName());
				try {
					writer=new PrintWriter(file);
					writer.println(textarea.getText());
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					writer.close();
				}
			}
			else {
				int r=Filechooser.showSaveDialog(null);
				if(r==JFileChooser.APPROVE_OPTION) {
					file= new File(Filechooser.getSelectedFile().getAbsolutePath());
					Fname.setText(file.getName());
					try {
						writer=new PrintWriter(file);
						writer.println(textarea.getText());
					}
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally {
						writer.close();
					}
				}
			}

		}
//		===========================================================================================================		
		

		
//		==========================================ColorBTN=========================================================	
		if(e.getSource()==colorbtn) {
			 clr=JColorChooser.showDialog(null, "ChooseColor", clr);
			textarea.setForeground(clr);
			colorbtn.setBackground(clr);
		}
//		==========================================================================================================		
		
		
		
//		=======================================================FontBOX===================================================		
		if(e.getSource()==Fontbox) {
			textarea.setFont(new Font((String) Fontbox.getSelectedItem(),Font.PLAIN,(int) textarea.getFont().getSize()));
		}
//		==========================================================================================================
		
		
		
//		==================================================OpenMenuItem========================================================
		if(e.getSource()==open) {
			JFileChooser Filechooser=new JFileChooser();
			Filechooser.setCurrentDirectory(new File("JavaTextFolder"));
//			String[] extensions=
//			FileNameExtensionFilter filter=new FileNameExtensionFilter();
			int r=Filechooser.showOpenDialog(null);
			textarea.setText("");
			if(r==JFileChooser.APPROVE_OPTION) {
				file=new File(Filechooser.getSelectedFile().getAbsolutePath());
				Scanner reader=null;
				Fname.setText(file.getName());
				try {
					reader =new Scanner(file);
					if(file.isFile()) {
						while(reader.hasNextLine()) {
							String l=reader.nextLine()+"\n";
							textarea.append(l);
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					reader.close();
				}
			}
			
		}
//		==========================================================================================================
		
		
		
		
//		==================================================SaveMenuItem========================================================
		if(e.getSource()==save) {
			JFileChooser Filechooser=new JFileChooser();
			Filechooser.setCurrentDirectory(new File("JavaTextFolder"));
			PrintWriter writer=null;
			
			if(file.getAbsolutePath()!=null) {
				Fname.setText(file.getName());
				try {
					writer=new PrintWriter(file);
					writer.println(textarea.getText());
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					writer.close();
				}
			}
			else {
				int r=Filechooser.showSaveDialog(null);
				if(r==JFileChooser.APPROVE_OPTION) {
				
					file= new File(Filechooser.getSelectedFile().getAbsolutePath());
					Fname.setText(file.getName());
				
					try {
						writer=new PrintWriter(file);
						writer.println(textarea.getText());
					
					}
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally {
						writer.close();
					}
				}
			}
			
		}
		
//		==========================================================================================================
	
		
		
		
//		=================================================NWindowMenuItem=========================================================
		if(e.getSource()==nWindow) {
			new TextEditor();
		}
//		==========================================================================================================
		
		
		
		
//		===================================================ExitMenuItem=======================================================
		if(e.getSource()==exit) {
			System.exit(0);
		}
//		=======================================================================================================================		
		
		
//		==============================================StyleMenuItem======================================================
		if(e.getSource()==darkTheme) {
			textarea.setBackground(new Color(35,35,35));
			nav.setBackground(new Color(25,25,25));
			F_S.setForeground(Color.white);
			C_n.setForeground(Color.white);
			Fname.setForeground(Color.white);
			Fontbox.setForeground(Color.white);
			Fontbox.setBackground(new Color(25,25,25));
			colorbtn.setBorder(BorderFactory.createBevelBorder(1,new Color(138, 201, 235), Color.white));
			colorbtn.setBackground(Color.white);
			textarea.setForeground(Color.white);
			textarea.setCaretColor(Color.white);
		}
		
		
		if(e.getSource()==lightTheme) {
			textarea.setBackground(Color.white);
			nav.setBackground(new Color(200,200,200));
			F_S.setForeground(Color.black);
			C_n.setForeground(Color.black);
			Fname.setForeground(Color.black);
			Fontbox.setForeground(Color.black);
			Fontbox.setBackground(Color.white);
			colorbtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			textarea.setForeground(Color.black);
			colorbtn.setBackground(Color.black);
			textarea.setCaretColor(Color.black);
		}
		
		
		if(e.getSource()==redTheme) {
			textarea.setBackground(new Color(48, 2, 2));
			nav.setBackground(new Color(84, 8, 8));
			F_S.setForeground(Color.white);
			C_n.setForeground(Color.white);
			Fname.setForeground(Color.white);
			Fontbox.setForeground(Color.black);
			Fontbox.setBackground(Color.white);
			textarea.setForeground(new Color(255, 150, 150));
			colorbtn.setBorder(BorderFactory.createBevelBorder(1,new Color(168, 7, 7), Color.white));
			colorbtn.setBackground(new Color(255, 150, 150));
			textarea.setCaretColor(new Color(255, 150, 150));
		}
		
		
		if(e.getSource()==blueTheme) {
			textarea.setBackground(new Color(25, 25, 31));
			nav.setBackground(new Color(4, 4, 84));
			F_S.setForeground(Color.white);
			C_n.setForeground(Color.white);
			Fname.setForeground(Color.white);
			Fontbox.setForeground(Color.black);
			Fontbox.setBackground(Color.white);
			textarea.setForeground(new Color(71, 169, 255));
			colorbtn.setBorder(BorderFactory.createBevelBorder(1,new Color(7,7,168), Color.white));
			colorbtn.setBackground(new Color(71, 169, 255));
			textarea.setCaretColor(new Color(71, 169, 255));
		}
		
		if(e.getSource()==greenTheme) {
			textarea.setBackground(new Color(0, 0, 0));
			nav.setBackground(new Color(4, 44, 4));
			F_S.setForeground(Color.white);
			C_n.setForeground(Color.white);
			Fname.setForeground(Color.white);
			Fontbox.setForeground(Color.black);
			Fontbox.setBackground(Color.white);
			textarea.setForeground(new Color(0, 255,0));
			colorbtn.setBorder(BorderFactory.createBevelBorder(1,new Color(7,167,8), Color.white));
			colorbtn.setBackground(new Color(0, 255,0));
			textarea.setCaretColor(new Color(0, 255,0));
		}
		
		
		if(e.getSource()==grayTheme) {
			textarea.setBackground(new Color(34, 34, 34));
			nav.setBackground(new Color(54, 54, 54));
			F_S.setForeground(Color.white);
			C_n.setForeground(Color.white);
			Fname.setForeground(Color.white);
			Fontbox.setForeground(Color.black);
			Fontbox.setBackground(Color.white);
			textarea.setForeground(new Color(200,200,200));
			colorbtn.setBorder(BorderFactory.createBevelBorder(1,new Color(150,150,150), Color.white));
			colorbtn.setBackground(new Color(200,200,200));
			textarea.setCaretColor(new Color(200,200,200));
		}
		
	}
	
	
	
	
}
