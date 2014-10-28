import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DropMode;

import twitter4j.Trends;

import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JTextArea;


public class IHM extends JFrame {

	private JPanel contentPane;
	private JTextField txtTrendsTopics;
	private int localisation = 1;
	private Trends tt;


	public IHM() {
		
		setTitle("Twing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txtTrendsTopics = new JTextField();
		txtTrendsTopics.setBackground(Color.LIGHT_GRAY);
		txtTrendsTopics.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		txtTrendsTopics.setForeground(Color.BLACK);
		txtTrendsTopics.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrendsTopics.setEditable(false);
		txtTrendsTopics.setText("Trends Topics");
		txtTrendsTopics.setBounds(31, 13, 116, 22);
		contentPane.add(txtTrendsTopics);
		txtTrendsTopics.setColumns(10);
		InterractionTwitter();
		bMonde();
		bFrance();
		afficheurTT(tt);
	}
	
	public void InterractionTwitter(){
		DialogueTwitter d = new DialogueTwitter();
		d.identification();
		tt = d.recupTends(localisation);
	}
	
	public void bMonde(){
		JButton btnNewButton = new JButton("Monde");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				localisation = 1;
			}
		});
		btnNewButton.setBounds(170, 13, 97, 25);
		contentPane.add(btnNewButton);
	}
	
	public void bFrance(){
		JButton btnFrance = new JButton("France");
		btnFrance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				localisation =  23424819;
			}
		});
		
		btnFrance.setBounds(279, 13, 97, 25);
		contentPane.add(btnFrance);
	}
	
	public void afficheurTT(Trends tt){
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(41, 47, 366, 193);
		for (int i = 0; i < tt.getTrends().length; i++) {
			textArea.append(tt.getTrends()[i].getName());
			textArea.append("\n");
		}
		contentPane.add(textArea);
	}
	
	
}

 