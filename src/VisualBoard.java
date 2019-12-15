import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class VisualBoard {
	
	private Scorekeeper s;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public VisualBoard(Scorekeeper s) {
		this.s = s;
		initialize();
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
		
		JLabel leftTeamLabel = new JLabel(s.getSetTeam1().toString());
		leftTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftTeamLabel.setFont(new Font("Verdana", Font.PLAIN, 95));
		leftTeamLabel.setForeground(Color.WHITE);
		leftTeam.add(leftTeamLabel);
		
		JPanel rightTeam = new JPanel();
		rightTeam.setBackground(Color.GRAY);
		GridBagConstraints gbc_rightTeam = new GridBagConstraints();
		gbc_rightTeam.fill = GridBagConstraints.BOTH;
		gbc_rightTeam.gridx = 1;
		gbc_rightTeam.gridy = 0;
		panelTop.add(rightTeam, gbc_rightTeam);
		rightTeam.setLayout(new BorderLayout(0, 0));
		
		JLabel rightTeamLabel = new JLabel(s.getSetTeam2().toString());
		rightTeamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightTeamLabel.setForeground(Color.WHITE);
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
		panel.setBackground(Color.BLACK);
		midPanel.add(panel, gbc_panel1);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setForeground(Color.WHITE);
		lblHello.setFont(new Font("Verdana", Font.PLAIN, 99));
		panel.add(lblHello);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel_1.setBackground(Color.GRAY);
		midPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWorld = new JLabel("World");
		lblWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorld.setForeground(Color.WHITE);
		lblWorld.setFont(new Font("Verdana", Font.PLAIN, 99));
		panel_1.add(lblWorld);
		
		
		JPanel botPanel = new JPanel();
		GridBagConstraints gbc_panel11 = new GridBagConstraints();
		gbc_panel11.insets = new Insets(5, 0, 0, 0);
		gbc_panel11.fill = GridBagConstraints.BOTH;
		gbc_panel11.gridx = 0;
		gbc_panel11.gridy = 2;
		botPanel.setBackground(Color.GREEN);
		mainpanel.add(botPanel, gbc_panel11);
		botPanel.setLayout(new BorderLayout(0, 0));

				
		frame.setVisible(true);
	
		
	}
}
