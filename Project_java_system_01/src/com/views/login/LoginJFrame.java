package com.views.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.check.CheckValidate;
import com.entities.Employee;
import com.entities.Roles;
import com.models.CustomEmployeeModel;
import com.models.EmployeeModel;
import com.models.RolesModel;
import com.views.JFrameAddEmployee;
import com.views.JFrameDetailEmployee;
import com.views.MainView;
import com.views.employee.JFrameMainEmployee;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField JtextFieldUsername;
	private JPasswordField JtextFieldPassword;
	private EmployeeModel employeeModel;
	private JLabel jlabelImage;
	private JLabel jlabelErr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
	        UIManager.getDefaults().put("Table.alternateRowColor", new Color(240,248,255));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	public LoginJFrame() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, -16, 862, 455);
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(428, 16, 402, 435);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBackground(new Color(0, 139, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 76, 377, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(98, 135, 100, 32);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 12));
		
		JtextFieldUsername = new JTextField();
		JtextFieldUsername.setBounds(98, 160, 225, 32);
		panel.add(JtextFieldUsername);
		JtextFieldUsername.setFont(new Font("SansSerif", Font.BOLD, 14));
		JtextFieldUsername.setForeground(Color.BLACK);
		JtextFieldUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(98, 204, 100, 25);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 12));
		
		JButton JButtonLogin = new JButton("Login");
		JButtonLogin.setBounds(139, 279, 141, 38);
		panel.add(JButtonLogin);
		JButtonLogin.setForeground(Color.WHITE);
		JButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnLogin_actionPerformed(e);
			}
		});
		
		JButtonLogin.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 20));
		JButtonLogin.setBackground(new Color(0, 139, 139));
		
		JtextFieldPassword = new JPasswordField();
		JtextFieldPassword.setBounds(98, 223, 225, 32);
		panel.add(JtextFieldPassword);
		
		jlabelErr = new JLabel("");
		jlabelErr.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelErr.setFont(new Font("SansSerif", Font.BOLD, 14));
		jlabelErr.setForeground(new Color(255, 69, 0));
		jlabelErr.setBounds(6, 340, 377, 38);
		panel.add(jlabelErr);
		
		JLabel lblNewLabel_3 = new JLabel("Have a nice day");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(45, 179, 347, 78);
		panel_2.add(lblNewLabel_3);
		
		jlabelImage = new JLabel("");
		jlabelImage.setBounds(0, 16, 425, 435);
		jlabelImage.setIcon(new ImageIcon(new ImageIcon(JFrameAddEmployee.class.getResource("/resources/pexels-jess-loiterton-4319847.jpg")).getImage()
				.getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
		panel_2.add(jlabelImage);
	}
	public void BtnLogin_actionPerformed(ActionEvent e) {
		try {
			jlabelErr.setText("");
			String username = JtextFieldUsername.getText().trim();
			String password = String.valueOf(JtextFieldPassword.getPassword());
			if(JtextFieldUsername.getText().equals("")) {
				jlabelErr.setText("Username is not null");
			}else {
				if(JtextFieldPassword.getPassword().equals("")) {
					jlabelErr.setText("Password is not null");
				}else {
					if (username.isEmpty() || password.isEmpty()) {
						jlabelErr.setText("Please fill out all fields!");
					} else {
						Employee employee = employeeModel.checkLogin(username);
						if (employee == null) {
							jlabelErr.setText("The username or password you entered is incorrect ");
						} else {
						
							if (CheckValidate.checkPassword(password)) {
								String password_hash = employee.getPassword();
								if (BCrypt.checkpw(password, password_hash)) {
									RolesModel roleModel = new RolesModel();
									Roles role = roleModel.findById(employee.getRoleId());
									if(role.getName().equals("admin")) {
										this.setVisible(false);
										MainView mainView = new MainView();
										mainView.setVisible(true);
										this.dispose();
									}else if(role.getName().equals("employee")) {
										
										CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
										Map<String, Object> data = new  HashMap<String, Object>();
										if(customEmployeeModel.findById(employee.getEmployeeId())!=null) {
											data.put("employeeCustom",customEmployeeModel.findById(employee.getEmployeeId()) );
											JFrameMainEmployee jFrameMainEmployee = new JFrameMainEmployee(data);
											jFrameMainEmployee.setVisible(true);
											this.setVisible(false);
										}
									}
								} else {
									
									jlabelErr.setText("The username or password you entered is incorrect");
								}
							} else {
								jlabelErr.setText("Password must at least 5 characters");		
							}
						
						}
					}
				}
			}
			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERROR!!");
		}
		
	}
}
