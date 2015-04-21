package PkgEmployesClg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Font;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 657, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(67, 49, 506, 336);
		frame.getContentPane().add(list);
		
		JLabel lblLesLivresLes = new JLabel("Les livres les plus emprunt\u00E9s");
		lblLesLivresLes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLesLivresLes.setBounds(184, 16, 287, 31);
		frame.getContentPane().add(lblLesLivresLes);
	}
}
