package com.java.swing.horoscope;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.text.Document;

import javax.swing.event.ChangeEvent;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Interfacelayer {

	private JFrame frmHoroscope;
	private JTextField dateTextField_1;
	private JTextField dateTextField_2;
	Chooser ser_1 = Chooser.getInstance();
	Chooser ser_2 = Chooser.getInstance();
	People people_1;
	People people_2;
	private JTextArea textArea;
	private int egg = 0;
	public ArrayList<Integer> finalNum = new ArrayList<>();
	public int finalNumNoOutOfBounds;

	/**
	 * ��:Ů ��:��
	 */
	private int score = -1;
	private int result[][] = { { 87, 60, 72, 41, 91, 58, 78, 64, 96, 51, 82, 69 },
			{ 69, 88, 71, 78, 46, 93, 61, 65, 74, 99, 54, 82 }, { 88, 79, 90, 75, 82, 47, 94, 65, 85, 70, 99, 58 },
			{ 66, 81, 68, 88, 72, 75, 45, 97, 57, 78, 61, 93 },

			{ 99, 48, 79, 76, 89, 71, 81, 57, 93, 69, 86, 64 }, { 74, 97, 52, 82, 78, 89, 61, 84, 66, 92, 70, 87 },
			{ 84, 62, 97, 56, 79, 69, 87, 72, 81, 45, 92, 77 }, { 55, 84, 61, 91, 76, 88, 66, 89, 49, 81, 72, 95 },

			{ 95, 64, 85, 74, 98, 58, 88, 77, 90, 71, 80, 47 }, { 57, 92, 60, 80, 68, 97, 65, 84, 73, 87, 47, 76 },
			{ 78, 44, 92, 70, 81, 65, 98, 58, 86, 68, 89, 75 }, { 74, 77, 43, 97, 70, 80, 59, 92, 51, 85, 64, 88 } };

	public int getResult(int a, int b) {
		int num = result[a][b];
		return num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEgg() {
		return egg;
	}

	public void setEgg(int egg) {
		this.egg = egg;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// SwingUtilities.invokeLater ( new Runnable ()
		// {
		// public void run ()
		// {
		// // Install WebLaF as application L&F
		// WebLookAndFeel.install ();
		// }
		// } );

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfacelayer window = new Interfacelayer();
					window.frmHoroscope.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public Interfacelayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHoroscope = new JFrame();
		frmHoroscope.setTitle("Horoscope");
		frmHoroscope.setBounds(100, 100, 1000, 550);
		frmHoroscope.setLocationRelativeTo(null);// ���������ʾ
		frmHoroscope.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �رյ�ǰ����
		frmHoroscope.setResizable(false);
		people_1 = new People();
		people_2 = new People();

		/**
		 * �˵���
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 250, 250));
		frmHoroscope.setJMenuBar(menuBar);

		JMenu mnNew = new JMenu("New");
		mnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfacelayer window = new Interfacelayer();
				window.frmHoroscope.setVisible(true);
			}
		});
		mnNew.setFont(new Font("Segoe Script", Font.BOLD, 14));
		menuBar.add(mnNew);

		JMenu mnAbout = new JMenu("About");
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				About window = new About();
				window.getFrmAbout().setVisible(true);
			}
		});
		mnAbout.setFont(new Font("Segoe Script", Font.BOLD, 14));
		menuBar.add(mnAbout);

		JMenu mnExit = new JMenu("Exit");
		mnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setEgg(getEgg() + 1);
				if (getEgg() == 7) {
					TetrisApp tetrisApp = new TetrisApp();
					tetrisApp.setVisible(true);
					tetrisApp.setLocationRelativeTo(null);// ���������ʾ
					frmHoroscope.setVisible(false);
				}
			}
		});
		mnExit.setFont(new Font("Segoe Script", Font.BOLD, 14));
		menuBar.add(mnExit);
		frmHoroscope.getContentPane().setLayout(new BoxLayout(frmHoroscope.getContentPane(), BoxLayout.X_AXIS));

		/**
		 * �ָ����
		 * 
		 * @Description splitPane_1:���·ָ���� splitPane_2:���ҷָ����
		 */
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setDividerSize(5);
		splitPane_1.setDividerLocation(400);
		frmHoroscope.getContentPane().add(splitPane_1);
		splitPane_1.setEnabled(false);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setDividerSize(5);
		splitPane_2.setDividerLocation(490);
		splitPane_1.setLeftComponent(splitPane_2);
		splitPane_2.setEnabled(false);

		/**
		 * ����弰��ؼ�
		 */
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 245, 238));
		splitPane_2.setLeftComponent(leftPanel);
		leftPanel.setLayout(null);

		JRadioButton maleRdBtn_1 = new JRadioButton("\u7537");
		maleRdBtn_1.setBackground(new Color(255, 245, 238));
		maleRdBtn_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					people_1.setSex(true);
			}
		});
		maleRdBtn_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
		maleRdBtn_1.setBounds(134, 10, 100, 35);
		leftPanel.add(maleRdBtn_1);

		JRadioButton femaleRdBtn_1 = new JRadioButton("\u5973");
		femaleRdBtn_1.setBackground(new Color(255, 245, 238));
		femaleRdBtn_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					people_1.setSex(false);
			}
		});
		femaleRdBtn_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
		femaleRdBtn_1.setBounds(230, 10, 100, 35);
		leftPanel.add(femaleRdBtn_1);

		ButtonGroup group_1 = new ButtonGroup();
		group_1.add(maleRdBtn_1);
		group_1.add(femaleRdBtn_1);

		JLabel labelLeft = new JLabel("\u8BF7\u9009\u62E9\u6027\u522B\uFF1A");
		labelLeft.setFont(new Font("΢���ź�", Font.BOLD, 15));
		labelLeft.setBounds(10, 10, 100, 35);
		leftPanel.add(labelLeft);

		JLabel birthLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u51FA\u751F\u5E74\u6708\u65E5\uFF1A");
		birthLabel_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
		birthLabel_1.setBounds(10, 51, 150, 35);
		leftPanel.add(birthLabel_1);

		/**
		 * �����ؼ�
		 */
		dateTextField_1 = new JTextField();
		dateTextField_1.setBackground(new Color(255, 245, 238));
		dateTextField_1.setBounds(158, 55, 200, 30);
		dateTextField_1.setText("xxxx-xx-xx");
		ser_1.register(dateTextField_1);
		leftPanel.add(dateTextField_1);
		Document dt_1 = dateTextField_1.getDocument();
		dt_1.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				people_1.setDate(dateTextField_1.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

		});

		/**
		 * �������
		 */
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(230, 102, 249, 277);
		leftPanel.add(scrollPane_1);

		textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(255, 245, 238));
		textArea.setFont(new Font("���Ŀ���", Font.BOLD, 18));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea);

		/**
		 * ͼƬ���
		 */
		JPanel picPanel_1 = new JPanel();
		picPanel_1.setBackground(new Color(255, 245, 238));
		JLabel picLabel_1 = new JLabel();
		picPanel_1.setBorder(BorderFactory.createTitledBorder("E-Z"));
		picPanel_1.setBounds(0, 96, 232, 286);
		picLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel_1.setBounds(0, 0, 210, 245);
		picPanel_1.add(picLabel_1);
		leftPanel.add(picPanel_1);
//		picLabel_1.setIcon(new ImageIcon("D:\\Java\\Eclipse\\Horoscopes\\src\\com\\java\\swing\\horoscope\\0.jpg"));
		picLabel_1.setIcon(new ImageIcon("0.jpg"));

		JButton doneBtn_1 = new JButton("Done");
		doneBtn_1.setBackground(new Color(255, 245, 238));
		doneBtn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				// System.out.println(people_1.getDate()+" "+people_1.isSex());
				people_1.birthday();
//				picLabel_1.setIcon(new ImageIcon("D:\\Java\\Eclipse\\Horoscopes\\src\\com\\java\\swing\\horoscope\\"
//						+ people_1.birthday() + ".jpg"));
				picLabel_1.setIcon(new ImageIcon(people_1.birthday() + ".jpg"));
				for (int i = 0; i < 3; i++) {
					// System.out.println(people_1.EZ().list.get(i));
					textArea.append(people_1.EZ(0).list.get(i));
					if (i != 2)
						textArea.append("\n" + "����������������������" + "\n");
				}
				// System.out.println(people_1.getMonth()+" "+people_1.getDay());

			}
		});
		
		
		doneBtn_1.setFont(new Font("Segoe Script", Font.BOLD, 15));
		doneBtn_1.setBounds(368, 53, 73, 33);
		leftPanel.add(doneBtn_1);

		/**
		 * ����漰��ؼ�
		 */
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(255, 245, 238));
		splitPane_2.setRightComponent(rightPanel);
		rightPanel.setLayout(null);

		JRadioButton maleRdBtn_2 = new JRadioButton("\u7537");
		maleRdBtn_2.setBackground(new Color(255, 245, 238));
		maleRdBtn_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					people_2.setSex(true);
			}
		});
		maleRdBtn_2.setFont(new Font("΢���ź�", Font.BOLD, 15));
		maleRdBtn_2.setBounds(134, 10, 100, 35);
		rightPanel.add(maleRdBtn_2);

		JRadioButton femaleRdBtn_2 = new JRadioButton("\u5973");
		femaleRdBtn_2.setBackground(new Color(255, 245, 238));
		femaleRdBtn_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					people_2.setSex(false);
			}
		});
		femaleRdBtn_2.setFont(new Font("΢���ź�", Font.BOLD, 15));
		femaleRdBtn_2.setBounds(230, 10, 100, 35);
		rightPanel.add(femaleRdBtn_2);

		ButtonGroup group_2 = new ButtonGroup();
		group_2.add(maleRdBtn_2);
		group_2.add(femaleRdBtn_2);

		JLabel labelRight = new JLabel("\u8BF7\u9009\u62E9\u6027\u522B\uFF1A");
		labelRight.setFont(new Font("΢���ź�", Font.BOLD, 15));
		labelRight.setBounds(10, 10, 100, 35);
		rightPanel.add(labelRight);

		JLabel birthLabel_2 = new JLabel("\u8BF7\u9009\u62E9\u51FA\u751F\u5E74\u6708\u65E5\uFF1A");
		birthLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 15));
		birthLabel_2.setBounds(10, 51, 150, 35);
		rightPanel.add(birthLabel_2);

		/**
		 * �����ؼ�
		 */
		dateTextField_2 = new JTextField();
		dateTextField_2.setBackground(new Color(255, 245, 238));
		dateTextField_2.setText("xxxx-xx-xx");
		dateTextField_2.setBounds(158, 55, 200, 30);
		ser_2.register(dateTextField_2);
		rightPanel.add(dateTextField_2);
		Document dt_2 = dateTextField_2.getDocument();
		dt_2.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				people_2.setDate(dateTextField_2.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

		});

		/**
		 * �������
		 */
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(230, 102, 249, 277);
		rightPanel.add(scrollPane_2);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(255, 245, 238));
		textArea_2.setFont(new Font("���Ŀ���", Font.BOLD, 18));
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		scrollPane_2.setViewportView(textArea_2);

		/**
		 * ͼƬ���
		 */
		JPanel picPanel_2 = new JPanel();
		picPanel_2.setBackground(new Color(255, 245, 238));
		picPanel_2.setBorder(BorderFactory.createTitledBorder("E-Z"));
		picPanel_2.setBounds(2, 96, 232, 286);
		rightPanel.add(picPanel_2);
		JLabel picLabel_2 = new JLabel();
		picLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel_2.setBounds(2, 0, 210, 245);
		picPanel_2.add(picLabel_2);
		picLabel_2.setIcon(new ImageIcon("0.jpg"));

		JButton doneBtn_2 = new JButton("Done");
		doneBtn_2.setBackground(new Color(255, 245, 238));
		doneBtn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_2.setText("");
				people_2.birthday();
				picLabel_2.setIcon(new ImageIcon(people_2.birthday() + ".jpg"));
				for (int i = 0; i < 3; i++) {
					textArea_2.append(people_2.EZ(0).list.get(i));
					if (i != 2)
						textArea_2.append("\n" + "����������������������" + "\n");
				}
			}
		});
		doneBtn_2.setFont(new Font("Segoe Script", Font.BOLD, 15));
		doneBtn_2.setBounds(368, 53, 73, 33);
		rightPanel.add(doneBtn_2);

		/**
		 * �·���弰��ؼ�
		 */
		JPanel downPanel = new JPanel();
		splitPane_1.setRightComponent(downPanel);
		downPanel.setLayout(new GridLayout(1, 0, 0, 0));

		/**
		 * ƥ�䰴ť���л�����
		 */
		JButton downButton = new JButton("Match");
		downButton.setBackground(new Color(0, 0, 0));
		downButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int p1 = people_1.birthday();
					int p2 = people_2.birthday();
					
					if (people_1.isSex() == false)
						setScore(getResult(p1-1, p2-1));
					else
						setScore(getResult(p2-1, p1-1));
					finalNum.add(0,getScore());

					/**
					 * ƥ��������
					 */
					JFrame frmResult = new JFrame();
					frmResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frmResult.getContentPane().setBackground(Color.WHITE);
					frmResult.setTitle("Result");
					frmResult.setBounds(0, 0, 505, 350);
					frmResult.setLocationRelativeTo(null);// ���������ʾ
					frmResult.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frmResult.setResizable(false);
					frmResult.getContentPane().setLayout(null);
					
					ImageIcon backgroundIcon = new ImageIcon("textAreaIcon.jpg");
					JLabel label = new JLabel(backgroundIcon);
					label.setBounds(0, 0, 500, 340);
					frmResult.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
					JPanel j = (JPanel)frmResult.getContentPane();
					j.setOpaque(false);

					JTextArea textArea = new JTextArea();
					textArea.setBounds(0, 0, 500, 350);
					textArea.setOpaque(false);
					textArea.setEditable(false);
					textArea.setLineWrap(true);
					Font font = new Font("����", Font.BOLD, 12);
					textArea.setFont(font);
//					textArea.setFont(new Font("Courier New", Font.BOLD, 99));
					textArea.append("ƥ��ָ��:" + finalNum.get(0) + "\n");
					try {
						@SuppressWarnings("resource")
						Scanner input = new Scanner(new File("match.txt"));
						while(input.hasNext()) {
							String s = input.nextLine();
//							System.out.println(s);
							if((s.substring(0, 2).contains(""+p1) && s.substring(3).contains(""+p2)) || (s.substring(0, 2).contains(""+p2) && s.substring(3).contains(""+p1))) {
								s = input.nextLine() + "\n";
//								System.out.println(s);
								do {
									textArea.append(s);
									s = input.nextLine()+"\n";
								}while(!Character.isDigit(s.charAt(0)));
								break;
							}
						}
						
					}catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					frmResult.getContentPane().add(textArea);

					frmResult.setVisible(true);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		downButton.setFont(new Font("Segoe Script", Font.BOLD, 45));
		downPanel.add(downButton);
	}
}
