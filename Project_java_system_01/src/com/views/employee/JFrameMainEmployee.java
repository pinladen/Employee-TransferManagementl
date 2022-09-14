package com.views.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.models.CustomEmployeeModel;
import com.views.JFrameDetailEmployee;
import com.views.admin.JPanelTransfer;
import com.views.login.LoginJFrame;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JFrameMainEmployee extends JFrame {

	private JPanel contentPane;
	private Map<String, Object> data;
	private EmployeeCustom employeeCustom;
	private Employee employee;
	private Location location;
	private JPanel jpanelMain;
	private JTextField jtextFiledName;
	private JLabel jlabelImage;
	private JButton jbuttonChangePassword;
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
					JFrameMainEmployee frame = new JFrameMainEmployee();
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
	public JFrameMainEmployee() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameMainEmployee.class.getResource("/resources/icons8_profile_24px_3.png")));
		setTitle("Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 167, 654);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton jbuttonProfile = new JButton("Profile");
		jbuttonProfile.setForeground(Color.WHITE);
		jbuttonProfile.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jbuttonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonProfile_actionPerformed(e);
			}
		});
		jbuttonProfile.setToolTipText("Profile");
		jbuttonProfile.setIcon(new ImageIcon(JFrameMainEmployee.class.getResource("/resources/icons8_resume_24px.png")));
		jbuttonProfile.setBackground(new Color(100, 149, 237));
		jbuttonProfile.setBounds(0, 234, 167, 45);
		panel.add(jbuttonProfile);
		
		jbuttonChangePassword = new JButton("Password");
		jbuttonChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonChangePassword_actionPerformed(e);
			}
		});
		jbuttonChangePassword.setForeground(Color.WHITE);
		jbuttonChangePassword.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jbuttonChangePassword.setToolTipText("Change password");
		jbuttonChangePassword.setIcon(new ImageIcon(JFrameMainEmployee.class.getResource("/resources/icons8_key_24px_3.png")));
		jbuttonChangePassword.setBackground(new Color(100, 149, 237));
		jbuttonChangePassword.setBounds(0, 327, 167, 45);
		panel.add(jbuttonChangePassword);
		
		JButton btnNewButton_3_1 = new JButton("Log out");
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJFrame loginJFrame = new LoginJFrame();
				loginJFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(JFrameMainEmployee.class.getResource("/resources/icons8_logout_24px_1.png")));
		btnNewButton_3_1.setBackground(new Color(100, 149, 237));
		btnNewButton_3_1.setBounds(22, 587, 120, 45);
		panel.add(btnNewButton_3_1);
		
		JButton jbuttonRequest = new JButton("Transfer ");
		jbuttonRequest.setForeground(Color.WHITE);
		jbuttonRequest.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jbuttonRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRequest_actionPerformed(e);
			}
		});
		jbuttonRequest.setToolTipText("Request");
		jbuttonRequest.setIcon(new ImageIcon(JFrameMainEmployee.class.getResource("/resources/icons8_request_service_24px.png")));
		jbuttonRequest.setBackground(new Color(100, 149, 237));
		jbuttonRequest.setBounds(0, 281, 167, 45);
		panel.add(jbuttonRequest);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(22, 16, 127, 143);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		jlabelImage = new JLabel("");
		jlabelImage.setBounds(6, 6, 115, 131);
		panel_2.add(jlabelImage);
		
		jtextFiledName = new JTextField();
		jtextFiledName.setForeground(new Color(0, 139, 139));
		jtextFiledName.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jtextFiledName.setEditable(false);
		jtextFiledName.setHorizontalAlignment(SwingConstants.CENTER);
		jtextFiledName.setText("name");
		jtextFiledName.setBounds(22, 172, 127, 28);
		panel.add(jtextFiledName);
		jtextFiledName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(71, 0, 1075, 25);
		contentPane.add(panel_1);
		
		jpanelMain = new JPanel();
		jpanelMain.setBackground(Color.WHITE);
		jpanelMain.setBounds(168, 25, 821, 583);
		contentPane.add(jpanelMain);
		jpanelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(168, 607, 1075, 47);
		contentPane.add(panel_1_1);
		loadView();
	}
	
	// loadData
		public JFrameMainEmployee(Map<String, Object> data) {
			this();
			this.data = data;
			loadData();
			loadView();
		}
		
		private void loadData() {
			try {
				EmployeeCustom employeeCustom = (EmployeeCustom) data.get("employeeCustom");
				
				if(employeeCustom != null) {
					this.employeeCustom = employeeCustom;
					this.employee = employeeCustom.getEmployee();
					jtextFiledName.setText(employee.getName());
					jlabelImage.setIcon(new ImageIcon(new ImageIcon(employee.getImage()).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		private void loadView() {
			clear();
			Map<String, Object> data = new  HashMap<String, Object>();
			if(employeeCustom!=null) {
				data.put("employeeCustom",employeeCustom );
				JPanelProfile jPanelProfile = new JPanelProfile(data);
				jpanelMain.add(jPanelProfile);
				jPanelProfile.setVisible(true);
			}
		}
		
		//action
		//button profile
		public void jbuttonProfile_actionPerformed(ActionEvent e) {
			loadView();
		}
		
		//button transfer request
		public void jbuttonRequest_actionPerformed(ActionEvent e) {
			clear();
			Map<String, Object> data = new  HashMap<String, Object>();
			if(employeeCustom!=null) {
				data.put("employeeCustom",employeeCustom);
				JPanelEmployeeTransfer jPanelEmployeeTransfer = new JPanelEmployeeTransfer(data);
				jpanelMain.add(jPanelEmployeeTransfer);
				jPanelEmployeeTransfer.setVisible(true);
			}
		}
		public void jbuttonChangePassword_actionPerformed(ActionEvent e) {
			clear();
			Map<String, Object> data = new  HashMap<String, Object>();
			if(employeeCustom!=null) {
				data.put("employeeCustom",employeeCustom);
				JPanelChangePassword jPanelChangePassword = new JPanelChangePassword(data);
				jpanelMain.add(jPanelChangePassword);
				jPanelChangePassword.setVisible(true);
			}
		}
		
		// clear view main
		private void clear() {
			jpanelMain.removeAll();
			jpanelMain.revalidate();
			jpanelMain.repaint();
		}
}
