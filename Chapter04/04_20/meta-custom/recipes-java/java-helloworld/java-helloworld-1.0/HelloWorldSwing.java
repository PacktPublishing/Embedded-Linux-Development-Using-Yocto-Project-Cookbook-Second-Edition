import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Hello World!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Hello World!");
		frame.getContentPane().add(label);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
