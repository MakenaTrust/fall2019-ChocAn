package chocan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMenu window = new ManagerMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public ManagerMenu() throws ParseException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 * @throws IOException 
	 */
	private void initialize() throws ParseException, IOException {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 753, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ManagementActions actions = new ManagementActions();
		
		JRadioButton rdbtnManagerFile = new JRadioButton("Manager File");
		JRadioButton rdbtnProviderFile = new JRadioButton("Provider File");
		JRadioButton rdbtnMemberFile = new JRadioButton("Member File");
		JButton btnSelect = new JButton("Select");
		btnSelect.setEnabled(false);
		
		MaskFormatter mf1 = new MaskFormatter("#########");
		JFormattedTextField jfrtxtNumber = new JFormattedTextField(mf1);
		JLabel lblEnterNumber = new JLabel("Enter Number:");
		lblEnterNumber.setEnabled(false);
		
		JLabel lblSelect = new JLabel("Select which type of file to create");
		lblSelect.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelect.setForeground(new Color(0, 0, 0));
		lblSelect.setBounds(206, 111, 311, 20);
		frame.getContentPane().add(lblSelect);
		
		rdbtnMemberFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMemberFile.isSelected()) {
					rdbtnProviderFile.setSelected(false);
					rdbtnManagerFile.setSelected(false);
					jfrtxtNumber.setEnabled(true);
					lblEnterNumber.setEnabled(true);
					btnSelect.setEnabled(true);
				}
				else if (!rdbtnMemberFile.isSelected()) {
					jfrtxtNumber.setEnabled(false);
					lblEnterNumber.setEnabled(false);
					btnSelect.setEnabled(false);
				}
			}
		});
		rdbtnMemberFile.setBounds(283, 164, 155, 29);
		frame.getContentPane().add(rdbtnMemberFile);
		
		rdbtnProviderFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnProviderFile.isSelected()) {
					rdbtnMemberFile.setSelected(false);
					rdbtnManagerFile.setSelected(false);
					jfrtxtNumber.setEnabled(true);
					lblEnterNumber.setEnabled(true);
					btnSelect.setEnabled(true);
				}
				else if (!rdbtnProviderFile.isSelected()) {
					jfrtxtNumber.setEnabled(false);
					lblEnterNumber.setEnabled(false);
					btnSelect.setEnabled(false);
				}
			}
		});
		rdbtnProviderFile.setBounds(283, 217, 155, 29);
		frame.getContentPane().add(rdbtnProviderFile);
		
		rdbtnManagerFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnManagerFile.isSelected()) {
					rdbtnMemberFile.setSelected(false);
					rdbtnProviderFile.setSelected(false);
					btnSelect.setEnabled(true);
				}
				else if (!rdbtnManagerFile.isSelected()) {
					btnSelect.setEnabled(false);
				}
				jfrtxtNumber.setEnabled(false);
				lblEnterNumber.setEnabled(false);
			}
		});
		rdbtnManagerFile.setBounds(283, 270, 155, 29);
		frame.getContentPane().add(rdbtnManagerFile);
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "";
				//String temp = jfrtxtNumber.getText();
				if (rdbtnMemberFile.isSelected()) {
					try {
						actions.getMemberFile(jfrtxtNumber.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (rdbtnProviderFile.isSelected()) {
					try {
						message = actions.getProviderFile(jfrtxtNumber.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (rdbtnManagerFile.isSelected()) {
					try {
						message = actions.getManagerFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, message);
				jfrtxtNumber.setText("");
				rdbtnMemberFile.setSelected(false);
				rdbtnProviderFile.setSelected(false);
				rdbtnManagerFile.setSelected(false);
				jfrtxtNumber.setEnabled(false);
				lblEnterNumber.setEnabled(false);
			}
		});
		btnSelect.setBounds(291, 394, 115, 29);
		frame.getContentPane().add(btnSelect);
		
		jfrtxtNumber.setEnabled(false);
		jfrtxtNumber.setBounds(334, 334, 138, 26);
		frame.getContentPane().add(jfrtxtNumber);
		lblEnterNumber.setBounds(218, 337, 114, 20);
		frame.getContentPane().add(lblEnterNumber);
	}
}
