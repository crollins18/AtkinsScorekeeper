import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {

	private JPanel mainPanel;
	private JPanel northPanel;
	private JPanel middlePanel;
	private JButton select;
	private JButton exit;
	private JComboBox comboBox;
	private ArrayList<Team> list;
	private JComboBox comboBox_1;
	private JLabel lblTeam;
	private JLabel lblTeam_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Scorekeeper main = new Scorekeeper();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame("Select Teams");
		JFrame frameMain = new JFrame("AHS Trivia Competition");
		frameMain.setSize(screenSize.width, screenSize.height);
		frameMain.setLocationRelativeTo (null);
		frame.setSize(293, 226);
		frame.setLocationRelativeTo (null);
		mainPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel();
		select = new JButton("Select Teams");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team TmpTm1 = (Team) comboBox.getSelectedItem();
				Team TmpTm2 = (Team) comboBox_1.getSelectedItem();
				main.setTeams(TmpTm1, TmpTm2);
				//main.printSetTeams();
				frame.setVisible(false);
				frame.disable();
				frameMain.setVisible(true);

			}
		});
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		northPanel.add(select);
		northPanel.add(exit);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		frame.getContentPane().add(mainPanel);
		middlePanel = new JPanel();
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		middlePanel.setLayout(null);
		comboBox = new JComboBox();
		comboBox.setBounds(125, 11, 142, 22);
		middlePanel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(125, 44, 142, 22);
		middlePanel.add(comboBox_1);
		
		JLabel lblScoringEngineCreated = new JLabel("Scoring Engine Created by Caleb Rollins");
		lblScoringEngineCreated.setBounds(10, 121, 257, 22);
		middlePanel.add(lblScoringEngineCreated);
		
		lblTeam = new JLabel("Team 1");
		lblTeam.setBounds(25, 15, 48, 14);
		middlePanel.add(lblTeam);
		
		lblTeam_1 = new JLabel("Team 2");
		lblTeam_1.setBounds(25, 48, 48, 14);
		middlePanel.add(lblTeam_1);
		list = main.getAllTeams();
		
		for(Team t: list) {
			comboBox.addItem(t);
		}
		
		for(Team t: list) {
			comboBox_1.addItem(t);
		}
		
		frame.setVisible(true);
		frameMain.setVisible(false);
		mainPanel.setVisible(true);
		northPanel.setVisible(true);
		mainPanel.setVisible(true);
		select.setVisible(true);
		exit.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
}
