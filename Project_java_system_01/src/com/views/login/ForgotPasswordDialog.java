package com.views.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.check.CheckValidate;
import com.entities.Employee;
import com.models.EmployeeModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPasswordField;

public class ForgotPasswordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel btnClose;
	private JPanel panelClose;

	// Declare variable
	private String email = null;
	private int xPosition, yPosition, mouseX, mouseY;

	// Declare Frame

	// Declare Class
	public static Employee employeeMain = null;
	private JPasswordField joldpasswordField;
	private JPasswordField jNewpasswordField;
	private JPasswordField jConfirmpasswordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForgotPasswordDialog dialog = new ForgotPasswordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ForgotPasswordDialog() {
		setModal(true);
		getContentPane().setEnabled(false);
		setUndecorated(true);
		setBounds(100, 100, 400, 285);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 39, 199, 36);
		contentPanel.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				try {
					panel_mouseDragged(arg0);
				} catch (Exception e) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				try {
					panel_mouseMoved(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}
		});
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 400, 36);
		contentPanel.add(panel);
		panel.setLayout(null);

		panelClose = new JPanel();
		panelClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelClose.setBackground(new Color(51, 51, 51));
		panelClose.setBounds(364, 0, 36, 36);
		panel.add(panelClose);
		panelClose.setLayout(null);

		btnClose = new JLabel("X");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					btnClose_mouseClicked(e);
				} catch (Exception e2) {
					showMessenger("Something was wrong! Please try again");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelClose.setBackground(new Color(87, 87, 87));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelClose.setBackground(new Color(51, 51, 51));
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setForeground(Color.RED);
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setBounds(0, 0, 36, 36);
		panelClose.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("OLD Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 103, 103, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 145, 103, 13);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 191, 125, 13);
		contentPanel.add(lblNewLabel_1_2);
		
		joldpasswordField = new JPasswordField();
		joldpasswordField.setBounds(145, 92, 154, 29);
		contentPanel.add(joldpasswordField);
		
		jNewpasswordField = new JPasswordField();
		jNewpasswordField.setBounds(145, 139, 154, 29);
		contentPanel.add(jNewpasswordField);
		
		jConfirmpasswordField = new JPasswordField();
		jConfirmpasswordField.setBounds(145, 185, 154, 29);
		contentPanel.add(jConfirmpasswordField);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave_actionPerformed(e);
			}
		});
		btnSave.setBounds(138, 224, 103, 29);
		contentPanel.add(btnSave);

		loadData();
	}

	private void loadData() {
	}

	public void btnSave_actionPerformed(ActionEvent e) {
		try {
			String oldpass = String.valueOf(joldpasswordField.getPassword());
			String newPass = String.valueOf(jNewpasswordField.getPassword());
			String confirm = String.valueOf(jConfirmpasswordField.getPassword());
			
			if(oldpass.equals(employeeMain.getPassword())) {
				if(newPass.equals(confirm)) {
					EmployeeModel employeeModel = new EmployeeModel();
//					if (employeeModel.update(newPass, employeeMain.getEmployeeId())) {
//						JOptionPane.showMessageDialog(null, "Completed");
//						LoginJFrame login = new LoginJFrame();
//						login.setVisible(true);
//						this.setVisible(false);
//					} else {
//						JOptionPane.showMessageDialog(null, "Faild");
//					}
					
				}else {
					JOptionPane.showConfirmDialog(null, "Confirm khong trung new passrowd");
				}
				
			}else {
				JOptionPane.showConfirmDialog(null, "Sai password");
				
			}
			
		} catch (Exception e2) {
			JOptionPane.showConfirmDialog(null, e2.getMessage());
		}
		
		
	}
	

	// Show error message
	private void showMessenger(String mess) {
		JOptionPane.showMessageDialog(null, mess);
	}

	// Close button
	private void btnClose_mouseClicked(MouseEvent e) {
		this.dispose();
		this.setVisible(false);
	}

	// Drag & move window
	private void panel_mouseDragged(MouseEvent e) {
		xPosition = e.getXOnScreen();
		yPosition = e.getYOnScreen();
		this.setLocation(xPosition - mouseX, yPosition - mouseY);
	}

	private void panel_mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
}
