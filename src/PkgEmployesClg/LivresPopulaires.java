package PkgEmployesClg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Font;

public class LivresPopulaires {

	private JFrame frame;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////2
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivresPopulaires window = new LivresPopulaires();
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
	public LivresPopulaires() {
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
		
		JList LV_LivresPopulaires = new JList();
		LV_LivresPopulaires.setBounds(67, 49, 506, 301);
		frame.getContentPane().add(LV_LivresPopulaires);
		
		JLabel LB_LivresPopulaires_1 = new JLabel("Les livres les plus emprunt\u00E9s");
		LB_LivresPopulaires_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		LB_LivresPopulaires_1.setBounds(184, 16, 287, 31);
		frame.getContentPane().add(LB_LivresPopulaires_1);
		
		JButton BTN_Retour = new JButton("Retour");
		BTN_Retour.setBounds(458, 368, 115, 29);
		frame.getContentPane().add(BTN_Retour);
	}
}
