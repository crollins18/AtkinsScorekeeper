import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*TODO PTS indicator selection
*/
public class VisualBoard {
	
	private Scorekeeper s;
	private JPanel ptssix;
	private ScoreTransporter transpo;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public VisualBoard(Scorekeeper s) {
		this.s = s;
		initialize();
		transpo = new ScoreTransporter(0);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame("AHS Trivia Contest Scorekeeper by Caleb Rollins");
		frame.setSize(screenSize.width, screenSize.height);
		frame.setLocationRelativeTo (null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainpanel = new JPanel();
		
		frame.getContentPane().add(mainpanel);
		GridBagLayout gbl_mainpanel = new GridBagLayout();
		gbl_mainpanel.columnWidths = new int[]{screenSize.width, 0};
		gbl_mainpanel.rowHeights = new int[]{(int)(screenSize.height/6), (int)(screenSize.height * (5.0/8)), 0, 0};
		gbl_mainpanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_mainpanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainpanel.setLayout(gbl_mainpanel);
		
		JPanel panelTop = new JPanel();
		GridBagConstraints gbc_panelTop = new GridBagConstraints();
		gbc_panelTop.fill = GridBagConstraints.BOTH;
		gbc_panelTop.insets = new Insets(5, 0, 5, 0);
		gbc_panelTop.gridx = 0;
		gbc_panelTop.gridy = 0;
		mainpanel.add(panelTop, gbc_panelTop);
		GridBagLayout gbl_panelTop = new GridBagLayout();
		gbl_panelTop.columnWidths = new int[]{(int)(screenSize.width/2), (int)(screenSize.width/2), 0};
		gbl_panelTop.rowHeights = new int[]{(int)(screenSize.height/6), 0};
		gbl_panelTop.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTop.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTop.setLayout(gbl_panelTop);
		
		JPanel leftTeam = new JPanel();
		leftTeam.setBackground(Color.BLACK);
		GridBagConstraints gbc_leftTeam = new GridBagConstraints();
		gbc_leftTeam.fill = GridBagConstraints.BOTH;
		gbc_leftTeam.insets = new Insets(0, 0, 0, 0);
		gbc_leftTeam.gridx = 0;
		gbc_leftTeam.gridy = 0;
		panelTop.add(leftTeam, gbc_leftTeam);
		leftTeam.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont leftTeamLabel = new ResizeLabelFont(s.getSetTeam1().toString());
		leftTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftTeamLabel.setFont(new Font("Verdana", Font.PLAIN, 95));
		leftTeamLabel.setForeground(Color.WHITE);
		leftTeam.add(leftTeamLabel);
		
		JPanel rightTeam = new JPanel();
		rightTeam.setBackground(Color.WHITE);
		GridBagConstraints gbc_rightTeam = new GridBagConstraints();
		gbc_rightTeam.fill = GridBagConstraints.BOTH;
		gbc_rightTeam.gridx = 1;
		gbc_rightTeam.gridy = 0;
		panelTop.add(rightTeam, gbc_rightTeam);
		rightTeam.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont rightTeamLabel = new ResizeLabelFont(s.getSetTeam2().toString());
		rightTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightTeamLabel.setForeground(Color.BLACK);
		rightTeamLabel.setFont(new Font("Verdana", Font.PLAIN, 95));
		rightTeam.add(rightTeamLabel);
		
		JPanel midPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		midPanel.setBackground(Color.WHITE);
		mainpanel.add(midPanel, gbc_panel);
		GridBagLayout gbl_midPanel = new GridBagLayout();
		gbl_midPanel.columnWidths = new int[]{(int)(screenSize.width/2), (int)(screenSize.width/2), 0};
		gbl_midPanel.rowHeights = new int[]{(int)(screenSize.height * (5.0/8)), 0};
		gbl_midPanel.columnWeights = new double[]{1.0, 1.0};
		gbl_midPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		midPanel.setLayout(gbl_midPanel);
		
		JPanel panel = new JPanel();

		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.insets = new Insets(0, 0, 0, 0);
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 0;
		midPanel.add(panel, gbc_panel1);
		panel.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont lblHello = new ResizeLabelFont(Integer.toString(s.getSetTeam1().getScore()));
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setForeground(Color.BLACK);
		lblHello.setFont(new Font("Verdana", Font.PLAIN, 500));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					lblHello.setText(Integer.toString(Integer.parseInt(lblHello.getText()) + transpo.getScore())); 
				}
				else if(SwingUtilities.isRightMouseButton(e)) {
					lblHello.setText(Integer.toString(Integer.parseInt(lblHello.getText()) - transpo.getScore())); 
				}
			}
		});
		panel.add(lblHello);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;

		midPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont lblWorld = new ResizeLabelFont(Integer.toString(s.getSetTeam2().getScore()));
		lblWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorld.setForeground(Color.BLACK);
		lblWorld.setFont(new Font("Verdana", Font.PLAIN, 500));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					lblWorld.setText(Integer.toString(Integer.parseInt(lblWorld.getText()) + transpo.getScore())); 
				}
				else if(SwingUtilities.isRightMouseButton(e)) {
					lblWorld.setText(Integer.toString(Integer.parseInt(lblWorld.getText()) - transpo.getScore())); 
				}
			}
		});
		panel_1.add(lblWorld);
		
		
		JPanel botPanel = new JPanel();
		GridBagConstraints gbc_panel11 = new GridBagConstraints();
		gbc_panel11.insets = new Insets(5, 0, 0, 0);
		gbc_panel11.fill = GridBagConstraints.BOTH;
		gbc_panel11.gridx = 0;
		gbc_panel11.gridy = 2;
		botPanel.setBackground(Color.GRAY);
		mainpanel.add(botPanel, gbc_panel11);
		GridBagLayout gbl_botPanel = new GridBagLayout();
		gbl_botPanel.columnWidths = new int[]{((int) (screenSize.width * 0.85)), (int)(screenSize.width * 0.15)};
		gbl_botPanel.rowHeights = new int[]{(int)(screenSize.height/6), 0};
		gbl_botPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_botPanel.rowWeights = new double[]{1.0, 1.0};
		botPanel.setLayout(gbl_botPanel);
		
		JPanel leftbot = new JPanel();
		GridBagConstraints gbc_leftbot = new GridBagConstraints();
		gbc_leftbot.fill = GridBagConstraints.BOTH;
		gbc_leftbot.gridx = 0;
		gbc_leftbot.gridy = 0;
		botPanel.add(leftbot, gbc_leftbot);
		leftbot.setLayout(new GridLayout(2, 4, 5, 5));
		
		JPanel ptsone = new JPanel();
		ptsone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(1);
			}
		});
		ptsone.setBackground(Color.GRAY);
		leftbot.add(ptsone);
		ptsone.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label = new ResizeLabelFont("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptsone.add(label);
		
		JPanel ptsthree = new JPanel();
		ptsthree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(3);
			}
		});
		ptsthree.setBackground(Color.GRAY);
		leftbot.add(ptsthree);
		ptsthree.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_3 = new ResizeLabelFont("3");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptsthree.add(label_3);
		
		ptssix = new JPanel();
		ptssix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(6);
			}
		});
		ptssix.setBackground(Color.GRAY);
		leftbot.add(ptssix);
		ptssix.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_5 = new ResizeLabelFont("6");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptssix.add(label_5);
		
		JPanel ptsnine = new JPanel();
		ptsnine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(9);
			}
		});
		ptsnine.setBackground(Color.GRAY);
		leftbot.add(ptsnine);
		ptsnine.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_6 = new ResizeLabelFont("9");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptsnine.add(label_6);
		
		JPanel ptstwo = new JPanel();
		ptstwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(2);
			}
		});
		ptstwo.setBackground(Color.GRAY);
		leftbot.add(ptstwo);
		ptstwo.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_2 = new ResizeLabelFont("2");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptstwo.add(label_2);
		
		JPanel ptsfour = new JPanel();
		ptsfour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(4);
			}
		});
		ptsfour.setBackground(Color.GRAY);
		leftbot.add(ptsfour);
		ptsfour.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_4 = new ResizeLabelFont("4");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptsfour.add(label_4);
		
		JPanel ptseight = new JPanel();
		ptseight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(8);
			}
		});
		ptseight.setBackground(Color.GRAY);
		leftbot.add(ptseight);
		ptseight.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_7 = new ResizeLabelFont("8");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptseight.add(label_7);
		
		JPanel ptstwelve = new JPanel();
		ptstwelve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(12);
			}
		});
		ptstwelve.setBackground(Color.GRAY);
		leftbot.add(ptstwelve);
		ptstwelve.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_8 = new ResizeLabelFont("12");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Verdana", Font.PLAIN, 35));
		ptstwelve.add(label_8);
		
		JPanel rightbot = new JPanel();
		rightbot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transpo.setScore(5);
			}
		});
		rightbot.setBackground(Color.GRAY);
		GridBagConstraints gbc_rightbot = new GridBagConstraints();
		gbc_rightbot.fill = GridBagConstraints.BOTH;
		gbc_rightbot.gridx = 1;
		gbc_rightbot.gridy = 0;
		gbc_rightbot.insets = new Insets(0, 5, 0, 0);
		botPanel.add(rightbot, gbc_rightbot);
		rightbot.setLayout(new BorderLayout(0, 0));
		
		ResizeLabelFont label_1 = new ResizeLabelFont("5");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 45));
		
		rightbot.add(label_1);

				
		frame.setVisible(true);
	
		
	}
}
