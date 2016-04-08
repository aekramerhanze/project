package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class GUI {

	private JFrame frame;
	private Simulator simulator;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI(simulator);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public GUI(Simulator simulator) {
		this.simulator = simulator;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 179);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinnerSteps = new JSpinner();
		spinnerSteps.setModel(new SpinnerNumberModel(1, 0, 100, 1));
		spinnerSteps.setBounds(50, 41, 56, 22);
		frame.getContentPane().add(spinnerSteps);
		
		JButton btnSteps = new JButton("Do Steps");
		btnSteps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int steps = (Integer) spinnerSteps.getValue();
				System.out.println("Performing "+steps+" steps.");
				simulator.doSteps(steps);
			}
		});
		btnSteps.setBounds(36, 77, 97, 25);
		frame.getContentPane().add(btnSteps);
		frame.setVisible(true);
	}
}
