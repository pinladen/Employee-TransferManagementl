package com.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

import com.models.CustomEmployeeModel;
import com.views.admin.JPanelDepartment;
import com.views.admin.JPanelLocation;
import com.views.admin.JPanelProject;
import com.views.admin.JPanelTitles;
import com.views.admin.JPanelTransfer;
import com.views.login.LoginJFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;
	private JButton jbuttonEmployee;
	private JButton jbuttonTransfer;
	private JButton jbuttonLocation;
	private JButton jbuttonDepartment;
	private JButton jbuttonProject;
	private JButton jbuttonTitle;
	private JButton jbuttonSetting;
	private JPanel panel;
	private JPanel panel_3;
	private JLabel jlabelImage;
	private JButton jbuttonDashboard;
	private JLabel jlabelTime;

	
	
	
	public MainView(JPanel jpanelMain) throws HeadlessException {
		super();
		this.jpanelMain = jpanelMain;
	}

	public JPanel getJpanelMain() {
		return jpanelMain;
	}

	public void setJpanelMain(JPanel jpanelMain) {
		this.jpanelMain = jpanelMain;
	}

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
					MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setTitle("Transfer employee manage");
		setBackground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 870);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(10, 10, 5, 100));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 160, 859);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 153, 160, 700);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		jbuttonEmployee = new JButton("Employee");
		jbuttonEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonEmployee.setBounds(-6, 69, 146, 51);
		panel_2.add(jbuttonEmployee);
		jbuttonEmployee.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_profile_24px_3.png")));
		jbuttonEmployee.setSelectedIcon(null);
		jbuttonEmployee.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonEmployee.setForeground(Color.BLACK);
		jbuttonEmployee.setBackground(Color.WHITE);
		
		jbuttonSetting = new JButton("Setting");
		jbuttonSetting.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonSetting.setBounds(-6, 499, 146, 51);
		panel_2.add(jbuttonSetting);
		jbuttonSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSetting_actionPerformed(e);
			}
		});
		jbuttonSetting.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_services_24px.png")));
		jbuttonSetting.setForeground(Color.BLACK);
		jbuttonSetting.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonSetting.setBackground(Color.WHITE);
		
		jbuttonTransfer = new JButton("Transfer");
		jbuttonTransfer.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonTransfer.setBounds(-6, 132, 146, 51);
		panel_2.add(jbuttonTransfer);
		jbuttonTransfer.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_online_money_transfer_24px.png")));
		jbuttonTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonTransfer_actionPerformed(e);
			}
		});
		jbuttonTransfer.setForeground(Color.DARK_GRAY);
		jbuttonTransfer.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonTransfer.setBackground(Color.WHITE);
		
		jbuttonProject = new JButton("Project");
		jbuttonProject.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonProject.setBounds(-6, 321, 146, 51);
		panel_2.add(jbuttonProject);
		jbuttonProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonProject_actionPerformed(e);
			}
		});
		jbuttonProject.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_web_design_24px.png")));
		jbuttonProject.setForeground(Color.DARK_GRAY);
		jbuttonProject.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonProject.setBackground(Color.WHITE);
		
		jbuttonTitle = new JButton("Title");
		jbuttonTitle.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonTitle.setBounds(-6, 384, 146, 51);
		panel_2.add(jbuttonTitle);
		jbuttonTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonTitle_actionPerformed(e);
			}
		});
		jbuttonTitle.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_tag_window_24px.png")));
		jbuttonTitle.setForeground(Color.DARK_GRAY);
		jbuttonTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonTitle.setBackground(Color.WHITE);
		
		jbuttonLocation = new JButton("Location");
		jbuttonLocation.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonLocation.setBounds(-6, 195, 146, 51);
		panel_2.add(jbuttonLocation);
		jbuttonLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLocation_actionPerformed(e);
			}
		});
		jbuttonLocation.setSelectedIcon(null);
		jbuttonLocation.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_Location_24px_1.png")));
		jbuttonLocation.setForeground(Color.DARK_GRAY);
		jbuttonLocation.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonLocation.setBackground(Color.WHITE);
		
		jbuttonDepartment = new JButton("Deparment");
		jbuttonDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonDepartment.setBounds(-6, 258, 146, 51);
		panel_2.add(jbuttonDepartment);
		jbuttonDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDepartment_actionPerformed(e);
			}
		});
		jbuttonDepartment.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_department_24px_2.png")));
		jbuttonDepartment.setForeground(Color.DARK_GRAY);
		jbuttonDepartment.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonDepartment.setBackground(Color.WHITE);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJFrame loginJFrame = new LoginJFrame();
				loginJFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnLogout.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_logout_rounded_up_24px.png")));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLogout.setBackground(new Color(0, 139, 139));
		btnLogout.setBounds(-6, 562, 146, 41);
		panel_2.add(btnLogout);
		
		jbuttonDashboard = new JButton("Dashboard");
		jbuttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDashboard_actionPerformed(e);
			}
		});
		jbuttonDashboard.setIcon(new ImageIcon(MainView.class.getResource("/resources/icons8_dashboard_layout_24px_1.png")));
		jbuttonDashboard.setBounds(-6, 6, 146, 51);
		panel_2.add(jbuttonDashboard);
		jbuttonDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		jbuttonDashboard.setForeground(Color.BLACK);
		jbuttonDashboard.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonDashboard.setBackground(Color.WHITE);
		
		jlabelImage = new JLabel("New label");
		jlabelImage.setBounds(49, 19, 69, 64);
		jlabelImage.setIcon(new ImageIcon(new ImageIcon(MainView.class.getResource("/resources/images.png")).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
		panel.add(jlabelImage);
		
		jlabelTime = new JLabel("ADMIN");
		jlabelTime.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		jlabelTime.setForeground(new Color(144, 238, 144));
		jlabelTime.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelTime.setBounds(0, 95, 160, 46);
		panel.add(jlabelTime);
		jbuttonEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonHome_actionPerformed(e);
			}
		});
		
		jpanelMain = new JPanel();
		jpanelMain.setBackground(Color.WHITE);
		jpanelMain.setBorder(new LineBorder(Color.LIGHT_GRAY));
		jpanelMain.setBounds(164, 41, 1090, 769);
		contentPane.add(jpanelMain);
		jpanelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(89, -11, 1245, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transfer management employee");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(240, 248, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel.setBounds(38, 10, 1180, 37);
		panel_1.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 139, 139));
		panel_3.setBounds(156, 814, 1098, 29);
		contentPane.add(panel_3);
		LoadViewMain();
		
	}
	//LoadView
	public void LoadViewMain() {
		clear();
		ClearButtonLeft();
		JPanelDashboard panelDashboard = new JPanelDashboard();
		jpanelMain.add(panelDashboard);
		panelDashboard.setVisible(true);
		jbuttonDashboard.setBounds(-6, 6, 181, 51);
		
	}
	
	// button menu dashboard
	public void jbuttonDashboard_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonDashboard.setBounds(-6, 6, 181, 51);
		JPanelDashboard panelDashboard = new JPanelDashboard();
		jpanelMain.add(panelDashboard);
		panelDashboard.setVisible(true);
	}
	
	// buuton menu employee
	public void jbuttonHome_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonEmployee.setBounds(-6, 69, 181, 51);
		PanelListEmployee pnEmployee = new PanelListEmployee();
		jpanelMain.add(pnEmployee);
		pnEmployee.setVisible(true);
		
	}
	
	// buuton menu transfer
	public void jbuttonTransfer_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonTransfer.setBounds(-6, 132, 181, 51);
		JPanelTransfer jPanelTransfer = new JPanelTransfer();
		jpanelMain.add(jPanelTransfer);
		jPanelTransfer.setVisible(true);
	}
	
	// button menu location
	public void jbuttonLocation_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonLocation.setBounds(-6, 195, 181, 51);
		JPanelLocation panelLocation = new JPanelLocation();
		jpanelMain.add(panelLocation);
		panelLocation.setVisible(true);
		
		
	}
	
	// button menu department
	public void jbuttonDepartment_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonDepartment.setBounds(-6, 258, 181, 51);
		JPanelDepartment jPanelDepartment = new JPanelDepartment();
		jpanelMain.add(jPanelDepartment);
		jPanelDepartment.setVisible(true);
	}
	// button menu project
	public void jbuttonProject_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonProject.setBounds(-6, 321, 181, 51);
		JPanelProject jPanelProject = new JPanelProject();
		jpanelMain.add(jPanelProject);
		jPanelProject.setVisible(true);
	}
	// button menu title
	public void jbuttonTitle_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonTitle.setBounds(-6, 384, 181, 51);
		JPanelTitles panelTitles = new JPanelTitles();
		jpanelMain.add(panelTitles);
		panelTitles.setVisible(true);
	}
	// button menu Setting
	public void jbuttonSetting_actionPerformed(ActionEvent e) {
		clear();
		ClearButtonLeft();
		jbuttonSetting.setBounds(-6, 499, 181, 51);
	}
	
	// Clear
	private void clear() {
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		jpanelMain.repaint();
	}
	
	private void ClearButtonLeft() {
		jbuttonDashboard.setBounds(-6, 6, 146, 51);
		jbuttonEmployee.setBounds(-6, 69, 146, 51);
		jbuttonLocation.setBounds(-6, 195, 146, 51);
		jbuttonTransfer.setBounds(-6, 132, 146, 51);
		jbuttonDepartment.setBounds(-6, 258, 146, 51);
		jbuttonTitle.setBounds(-6, 384, 146, 51);
		jbuttonProject.setBounds(-6, 321, 146, 51);
		jbuttonSetting.setBounds(-6, 499, 146, 51);
		
	}
	
	
}
