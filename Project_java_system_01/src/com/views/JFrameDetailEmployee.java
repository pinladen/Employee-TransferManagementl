package com.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entities.Department;
import com.entities.EmpLocation;
import com.entities.EmpProject;
import com.entities.Empdepartment;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Roles;
import com.entities.Titles;
import com.entities.Transfer;
import com.models.CustomEmployeeModel;
import com.models.DepamentModel;
import com.models.EmpDepamentModel;
import com.models.EmpLocationModel;
import com.models.EmpProjectModel;
import com.models.EmployeeModel;
import com.models.FileTypeFilter;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.models.RolesModel;
import com.models.TitlesModel;
import com.models.TransferModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.management.relation.Role;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFrameDetailEmployee extends JFrame {

	private JPanel contentPane;
	private File file;
	private JLabel jlabelImage;
	private JTextField jtextFieldDescription;
	private Map<String, Object> data;
	private JLabel jlabelPresent_Location;
	private JLabel jlabelPresent_Department;
	private JLabel jlabelPresent_Project;
	private JLabel jlabelNew_Location;
	private JLabel jlabelNew_Department;
	private JLabel jlabelNew_Project;
	private JLabel jlabelId;
	private JPanel jpannelTransfer;
	private JPanel jpanelPresent;
	private JLabel jlabelDescription;
	private JButton jbtnAccept;
	private JButton jbtnCancel;
	private JLabel jlabelTrasferIcon2;
	private JLabel jlabelTrasferIcon1;
	private JLabel jlabelNothing;
	private JTable jtableLocationHistory;
	private JLabel jlabelName;
	private JLabel jlabelEmail;
	private JLabel jlabelPhone;
	private JLabel jlabelGender;
	private JLabel jlabelCreated;
	private JLabel jlabelBirthday;
	private JLabel jlabelLocation;
	private JLabel jlabelDepartment;
	private JLabel jlabelProject;
	private JLabel jlabelTitle;
	private JPanel jpanelNewTransfer;
	private JLabel jlabelNew_Created;
	private JTable jtableDepartment;
	private JPasswordField jpasswordField;
	private JLabel jlabelNoth;
	private Transfer transfer;
	private Employee employee;
	private Location location;
	private Department department;
	private Project project;
	private JLabel jlabelSalary;
	private JTable jtabelProject;
	private JLabel jlabelUsername;
	
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
					JFrameDetailEmployee frame = new JFrameDetailEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private byte[] ConvertFile(String fileName) {
		FileInputStream fileInputStream = null;
		File file = new File(fileName);
		byte[] bFile = new byte[(int) file.length()];
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			bFile = null;
		}
		return bFile;
	}

	/**
	 * Create the frame.
	 */
	public JFrameDetailEmployee() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameDetailEmployee.class.getResource("/resources/icons8_head_profile_24px.png")));
		setTitle("Employee Detail");
		setBackground(new Color(0, 191, 255));
		setBounds(100, 100, 834, 836);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, SystemColor.menu));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 53, 808, 709);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_back_24px.png")));
		btnCancel.setToolTipText("Back to main");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(659, 666, 128, 33);
		panel.add(btnCancel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(3, 3, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(193, 25, 590, 268);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 41, 88, 26);
		panel_3.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 78, 88, 26);
		panel_3.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(10, 115, 88, 26);
		panel_3.add(lblPhone);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(10, 152, 88, 26);
		panel_3.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setBounds(309, 78, 88, 26);
		panel_3.add(lblLocation);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setBounds(309, 115, 88, 26);
		panel_3.add(lblDepartment);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblProject = new JLabel("Project :");
		lblProject.setBounds(309, 152, 88, 26);
		panel_3.add(lblProject);
		lblProject.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRole = new JLabel("Title :");
		lblRole.setBounds(309, 189, 88, 26);
		panel_3.add(lblRole);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCreatedAt = new JLabel("Created  :");
		lblCreatedAt.setBounds(10, 189, 88, 26);
		panel_3.add(lblCreatedAt);
		lblCreatedAt.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblBrithday = new JLabel("Brithday :");
		lblBrithday.setBounds(309, 41, 88, 26);
		panel_3.add(lblBrithday);
		lblBrithday.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton jbuttonEdit = new JButton("Edit");
		jbuttonEdit.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_edit_24px_1.png")));
		jbuttonEdit.setBounds(492, 231, 83, 31);
		panel_3.add(jbuttonEdit);
		jbuttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEdit_actionPerformed(e);
			}
		});
		jbuttonEdit.setForeground(SystemColor.desktop);
		jbuttonEdit.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonEdit.setBackground(SystemColor.info);
		
		JLabel lblNewLabel_4 = new JLabel("Information");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 11, 128, 19);
		panel_3.add(lblNewLabel_4);
		
		jlabelName = new JLabel("New label");
		jlabelName.setForeground(new Color(0, 139, 139));
		jlabelName.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelName.setBounds(94, 41, 182, 23);
		panel_3.add(jlabelName);
		
		jlabelEmail = new JLabel("New label");
		jlabelEmail.setForeground(new Color(0, 139, 139));
		jlabelEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelEmail.setBounds(94, 77, 182, 23);
		panel_3.add(jlabelEmail);
		
		jlabelPhone = new JLabel("New label");
		jlabelPhone.setForeground(new Color(0, 139, 139));
		jlabelPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelPhone.setBounds(94, 114, 182, 23);
		panel_3.add(jlabelPhone);
		
		jlabelGender = new JLabel("New label");
		jlabelGender.setForeground(new Color(0, 139, 139));
		jlabelGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelGender.setBounds(94, 155, 182, 23);
		panel_3.add(jlabelGender);
		
		jlabelCreated = new JLabel("New label");
		jlabelCreated.setForeground(new Color(0, 139, 139));
		jlabelCreated.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelCreated.setBounds(94, 188, 182, 23);
		panel_3.add(jlabelCreated);
		
		jlabelBirthday = new JLabel("New label");
		jlabelBirthday.setForeground(new Color(0, 139, 139));
		jlabelBirthday.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelBirthday.setBounds(401, 41, 174, 23);
		panel_3.add(jlabelBirthday);
		
		jlabelLocation = new JLabel("New label");
		jlabelLocation.setForeground(new Color(0, 139, 139));
		jlabelLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelLocation.setBounds(401, 78, 174, 23);
		panel_3.add(jlabelLocation);
		
		jlabelDepartment = new JLabel("New label");
		jlabelDepartment.setForeground(new Color(0, 139, 139));
		jlabelDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelDepartment.setBounds(401, 115, 174, 23);
		panel_3.add(jlabelDepartment);
		
		jlabelProject = new JLabel("New label");
		jlabelProject.setForeground(new Color(0, 139, 139));
		jlabelProject.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelProject.setBounds(401, 152, 174, 23);
		panel_3.add(jlabelProject);
		
		jlabelTitle = new JLabel("New label");
		jlabelTitle.setForeground(new Color(0, 139, 139));
		jlabelTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelTitle.setBounds(401, 188, 174, 23);
		panel_3.add(jlabelTitle);
		
		JLabel lblRole_1 = new JLabel("Salary  :");
		lblRole_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRole_1.setBounds(10, 227, 59, 26);
		panel_3.add(lblRole_1);
		
		jlabelSalary = new JLabel("New label");
		jlabelSalary.setForeground(new Color(0, 139, 139));
		jlabelSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelSalary.setBounds(94, 227, 135, 23);
		panel_3.add(jlabelSalary);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(16, 331, 767, 304);
		panel.add(tabbedPane);
		
		jpannelTransfer = new JPanel();
		tabbedPane.addTab("Transfer Request", new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_request_service_24px.png")), jpannelTransfer, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.DARK_GRAY);
		jpannelTransfer.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpannelTransfer.setBackground(SystemColor.text);
		jpannelTransfer.setLayout(null);
		
		jpanelPresent = new JPanel();
		jpanelPresent.setVisible(false);
		jpanelPresent.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Present", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		jpanelPresent.setBackground(SystemColor.menu);
		jpanelPresent.setBounds(10, 35, 254, 214);
		jpannelTransfer.add(jpanelPresent);
		jpanelPresent.setLayout(null);
		
		JLabel lblLocation_1 = new JLabel("Location :");
		lblLocation_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocation_1.setBounds(10, 28, 88, 26);
		jpanelPresent.add(lblLocation_1);
		
		JLabel lblDepartment_1 = new JLabel("Department :");
		lblDepartment_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment_1.setBounds(10, 65, 88, 26);
		jpanelPresent.add(lblDepartment_1);
		
		JLabel lblProject_1 = new JLabel("Project :");
		lblProject_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProject_1.setBounds(10, 101, 88, 26);
		jpanelPresent.add(lblProject_1);
		
		jlabelPresent_Department = new JLabel("New lable");
		jlabelPresent_Department.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelPresent_Department.setForeground(new Color(119, 136, 153));
		jlabelPresent_Department.setBounds(99, 68, 145, 19);
		jpanelPresent.add(jlabelPresent_Department);
		
		jlabelPresent_Project = new JLabel("New lable");
		jlabelPresent_Project.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelPresent_Project.setForeground(new Color(119, 136, 153));
		jlabelPresent_Project.setBounds(99, 104, 145, 19);
		jpanelPresent.add(jlabelPresent_Project);
		
		jlabelPresent_Location = new JLabel("New lable");
		jlabelPresent_Location.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelPresent_Location.setBounds(99, 33, 145, 19);
		jpanelPresent.add(jlabelPresent_Location);
		jlabelPresent_Location.setForeground(new Color(119, 136, 153));
		
		jpanelNewTransfer = new JPanel();
		jpanelNewTransfer.setVisible(false);
		jpanelNewTransfer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "New ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		jpanelNewTransfer.setBackground(SystemColor.menu);
		jpanelNewTransfer.setBounds(316, 35, 265, 214);
		jpannelTransfer.add(jpanelNewTransfer);
		jpanelNewTransfer.setLayout(null);
		
		JLabel lblLocation_1_1 = new JLabel("Location :");
		lblLocation_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocation_1_1.setBounds(10, 27, 88, 26);
		jpanelNewTransfer.add(lblLocation_1_1);
		
		JLabel lblDepartment_1_1 = new JLabel("Department :");
		lblDepartment_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartment_1_1.setBounds(10, 64, 88, 26);
		jpanelNewTransfer.add(lblDepartment_1_1);
		
		JLabel lblProject_1_1 = new JLabel("Project :");
		lblProject_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProject_1_1.setBounds(10, 101, 88, 26);
		jpanelNewTransfer.add(lblProject_1_1);
		
		JLabel lblCreated = new JLabel("Created  :");
		lblCreated.setBounds(10, 177, 88, 26);
		jpanelNewTransfer.add(lblCreated);
		lblCreated.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jlabelNew_Location = new JLabel("New lable");
		jlabelNew_Location.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelNew_Location.setForeground(new Color(0, 139, 139));
		jlabelNew_Location.setBounds(108, 31, 147, 19);
		jpanelNewTransfer.add(jlabelNew_Location);
		
		jlabelNew_Department = new JLabel("New lable");
		jlabelNew_Department.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelNew_Department.setForeground(new Color(0, 139, 139));
		jlabelNew_Department.setBounds(108, 68, 143, 19);
		jpanelNewTransfer.add(jlabelNew_Department);
		
		jlabelNew_Project = new JLabel("New lable");
		jlabelNew_Project.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelNew_Project.setForeground(new Color(0, 139, 139));
		jlabelNew_Project.setBounds(108, 105, 147, 19);
		jpanelNewTransfer.add(jlabelNew_Project);
		
		jlabelNew_Created = new JLabel("New lable");
		jlabelNew_Created.setForeground(Color.DARK_GRAY);
		jlabelNew_Created.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlabelNew_Created.setBounds(84, 181, 153, 19);
		jpanelNewTransfer.add(jlabelNew_Created);
		
		jlabelTrasferIcon1 = new JLabel("");
		jlabelTrasferIcon1.setVisible(false);
		jlabelTrasferIcon1.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_right_28px_2.png")));
		jlabelTrasferIcon1.setBounds(274, 148, 43, 48);
		jpannelTransfer.add(jlabelTrasferIcon1);
		
		jlabelTrasferIcon2 = new JLabel("");
		jlabelTrasferIcon2.setVisible(false);
		jlabelTrasferIcon2.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_right_28px_2.png")));
		jlabelTrasferIcon2.setBounds(274, 89, 43, 48);
		jpannelTransfer.add(jlabelTrasferIcon2);
		
		jbtnAccept = new JButton("Accept");
		jbtnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnAccept_actionPerformed(e);
			}
		});
		jbtnAccept.setVisible(false);
		jbtnAccept.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_checked_checkbox_28px.png")));
		jbtnAccept.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnAccept.setBackground(Color.WHITE);
		jbtnAccept.setBounds(611, 170, 128, 33);
		jpannelTransfer.add(jbtnAccept);
		
		jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnCancel_actionPerformed(e);
			}
		});
		jbtnCancel.setVisible(false);
		jbtnCancel.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_cancel_28px.png")));
		jbtnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnCancel.setBackground(Color.WHITE);
		jbtnCancel.setBounds(611, 210, 128, 33);
		jpannelTransfer.add(jbtnCancel);
		
		jtextFieldDescription = new JTextField();
		jtextFieldDescription.setBackground(new Color(250, 250, 210));
		jtextFieldDescription.setVisible(false);
		jtextFieldDescription.setBounds(611, 60, 128, 95);
		jpannelTransfer.add(jtextFieldDescription);
		jtextFieldDescription.setColumns(10);
		
		jlabelDescription = new JLabel("Description");
		jlabelDescription.setVisible(false);
		jlabelDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelDescription.setBounds(611, 40, 75, 14);
		jpannelTransfer.add(jlabelDescription);
		
		jlabelNothing = new JLabel("not have request !");
		jlabelNothing.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelNothing.setFont(new Font("Tahoma", Font.BOLD, 19));
		jlabelNothing.setBounds(10, 97, 746, 40);
		jpannelTransfer.add(jlabelNothing);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Location History", new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_location_24px.png")), panel_1, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.DARK_GRAY);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 762, 269);
		panel_1.add(scrollPane);
		
		jtableLocationHistory = new JTable();
		JTableHeader header = jtableLocationHistory.getTableHeader();
		header.setFont(new Font("SansSerif",Font.BOLD,14));
		scrollPane.setViewportView(jtableLocationHistory);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Department history", new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_department_24px_1.png")), panel_2, null);
		tabbedPane.setForegroundAt(2, Color.WHITE);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 762, 269);
		panel_2.add(scrollPane_1);
		
		jtableDepartment = new JTable();
		scrollPane_1.setViewportView(jtableDepartment);
		JTableHeader header1 = jtableDepartment.getTableHeader();
		header1.setFont(new Font("SansSerif",Font.BOLD,14));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Project History", new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_project_24px.png")), panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 767, 266);
		panel_4.add(scrollPane_2);
		
		jtabelProject = new JTable();
		JTableHeader headerProject = jtableLocationHistory.getTableHeader();
		headerProject.setFont(new Font("SansSerif",Font.BOLD,14));
		scrollPane_2.setViewportView(jtabelProject);
		
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		tabbedPane.addTab("Change password", new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_Password_Key_24px.png")), panel_9, null);
		tabbedPane.setBackgroundAt(4, Color.DARK_GRAY);
		panel_9.setLayout(null);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setCaretColor(new Color(0, 0, 255));
		jpasswordField.setBounds(276, 82, 305, 33);
		panel_9.add(jpasswordField);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(119, 75, 147, 43);
		panel_9.add(lblNewLabel_1);
		
		JButton jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setForeground(new Color(0, 139, 139));
		jbuttonSave.setToolTipText("Back to main");
		jbuttonSave.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonSave.setBackground(Color.WHITE);
		jbuttonSave.setBounds(354, 132, 128, 33);
		panel_9.add(jbuttonSave);
		
		JLabel lblNewLabel_5 = new JLabel("Username :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(119, 30, 107, 33);
		panel_9.add(lblNewLabel_5);
		
		jlabelUsername = new JLabel("...");
		jlabelUsername.setForeground(new Color(30, 144, 255));
		jlabelUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlabelUsername.setBounds(276, 30, 107, 33);
		panel_9.add(jlabelUsername);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_7.setBackground(UIManager.getColor("Button.highlight"));
		panel_7.setBounds(15, 25, 168, 210);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		jlabelImage = new JLabel("No Image");
		jlabelImage.setBounds(11, 20, 148, 174);
		panel_7.add(jlabelImage);
		jlabelImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 139, 139));
		panel_8.setBounds(193, 293, 590, 4);
		panel.add(panel_8);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(0, 139, 139));
		panel_8_1.setBounds(16, 631, 767, 7);
		panel.add(panel_8_1);
		
		JLabel lblNewLabel_3 = new JLabel("ID : ");
		lblNewLabel_3.setBounds(50, 247, 45, 32);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		jlabelId = new JLabel("123");
		jlabelId.setBounds(92, 247, 81, 33);
		panel.add(jlabelId);
		jlabelId.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlabelId.setForeground(new Color(0, 0, 0));
		
		jlabelNoth = new JLabel("Request of the employee who wants to transfer");
		jlabelNoth.setVisible(false);
		jlabelNoth.setBounds(28, 671, 364, 24);
		panel.add(jlabelNoth);
		jlabelNoth.setForeground(new Color(0, 0, 0));
		jlabelNoth.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelNoth.setIcon(new ImageIcon(JFrameDetailEmployee.class.getResource("/resources/icons8_exclamation_mark_24px.png")));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(-14, 0, 857, 43);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Detail");
		lblNewLabel.setBackground(new Color(255, 0, 102));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 837, 43);
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(-14, 775, 857, 43);
		contentPane.add(panel_6);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 139, 139));
		panel_10.setBounds(-4, 41, 832, 10);
		contentPane.add(panel_10);
		
		JPanel panel_10_1 = new JPanel();
		panel_10_1.setBackground(new Color(0, 139, 139));
		panel_10_1.setBounds(-4, 765, 832, 10);
		contentPane.add(panel_10_1);
		
	}
	//---------------------------------------------------------------------------------------------------------------
	// loadData
	public JFrameDetailEmployee(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
		
	}
	
	private void loadData() {
		try {
			EmployeeCustom employeeCustom = (EmployeeCustom) data.get("employeeCustom");
			if(employeeCustom != null) {
				loadEmployee(employeeCustom.getEmployee());
				loadLocation(employeeCustom.getLocation());
				loadDepartment(employeeCustom.getDepament());
				loadProject(employeeCustom.getProject());
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	// loadData employee
	private void loadEmployee(Employee employee) {
		try {
			if(employee !=null) {
				this.employee = employee;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				jlabelName.setText(employee.getName());
				jlabelEmail.setText(employee.getEmail());
				jlabelPhone.setText(employee.getPhone());
				jlabelGender.setText(employee.getGender());
				jlabelImage.setIcon(new ImageIcon(new ImageIcon(employee.getImage()).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
				jlabelImage.setText("");
				jlabelCreated.setText(simpleDateFormat.format(employee.getCreatedAt()));
				jlabelBirthday.setText(simpleDateFormat.format( employee.getDob()));
				jlabelId.setText(String.valueOf(employee.getEmployeeId()));
				TitlesModel titlesModel = new TitlesModel();
				Titles title = titlesModel.findById(employee.getTitleId());
				jlabelTitle.setText(title.getTitle_name());
				jlabelSalary.setText(String.valueOf(title.getSalaries()) + " $");
				jlabelUsername.setText(employee.getUsername());
				// load transfer
				loadTransferRequest(employee.getEmployeeId());
				//load location histor
				EmpLocationModel empLocationModel = new EmpLocationModel();
				if(empLocationModel.findAllByEmployeeId(employee.getEmployeeId()) !=null) {					
					fillDataLocation(empLocationModel.findAllByEmployeeId(employee.getEmployeeId()));
				}
				
				//load department histor
				EmpDepamentModel empDepamentModel = new EmpDepamentModel();
				if(empDepamentModel.findAllByEmployeeId(employee.getEmployeeId()) !=null) {					
					fillDataDepartment(empDepamentModel.findAllByEmployeeId(employee.getEmployeeId()));
				}
				
				EmpProjectModel empProjectModel = new EmpProjectModel();
				if(empProjectModel.findById(employee.getEmployeeId()) !=null) {					
					fillDataProject(empProjectModel.findAllByEmployeeId(employee.getEmployeeId()));
				}
				
			}
		}catch (Exception e2) {
			e2.getMessage();
		}
	}
	
	// loadData employee . location
	private void loadLocation(Location location) {
		try {
			if(location !=null) {
				jlabelLocation.setText(location.getLocationName());
				jlabelPresent_Location.setText(location.getLocationName());
			}
		}catch (Exception e2) {
			e2.getMessage();
		}
	}
	
	// loadData employee . department
	private void loadDepartment(Department department) {
		try {
			if(department !=null) {
				jlabelDepartment.setText(department.getDepamentName());
				jlabelPresent_Department.setText(department.getDepamentName());
			}
		}catch (Exception e2) {
			e2.getMessage();
		}
	}
	
	// loadData employee . project
	private void loadProject(Project project) {
		try {
			if(project !=null) {
				jlabelProject.setText(project.getProjectName());
				jlabelPresent_Project.setText(project.getProjectName());
			}
		}catch (Exception e2) {
			e2.getMessage();
		}
	}
	
	// loadData employee . transfer request
	private void loadTransferRequest(int employeeID) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			TransferModel transferModel = new TransferModel();
			// Status ( if status == 1 this Processing , if status == 0 this cancel and 2 this accept)
			// get status processing
			transfer = transferModel.findByEmployeeId(employeeID , 1);
			if (transfer != null) {
				// show j
				jpanelPresent.setVisible(true);
				jpanelNewTransfer.setVisible(true);
				jlabelTrasferIcon1.setVisible(true);
				jlabelTrasferIcon2.setVisible(true);
				jlabelDescription.setVisible(true);
				jtextFieldDescription.setVisible(true);
				jbtnAccept.setVisible(true);
				jbtnCancel.setVisible(true);
				jlabelNothing.setVisible(false);
				jlabelNoth.setVisible(true);
				// loadData
				// Present 
				
				
				//New
				// loadLocation
				LocationModel locationModel = new LocationModel();
				Location location = locationModel.findById(transfer.getLocation_id());
				jlabelNew_Location.setText(location.getLocationName());
				// loadDepartment
				DepamentModel depamentModel = new DepamentModel();
				Department department = depamentModel.findById(transfer.getDepartment_id());
				jlabelNew_Department.setText(department.getDepamentName());
				// loadProject
				ProjectModel projectModel = new ProjectModel();
				Project project = projectModel.findById(transfer.getProject_id());
				jlabelNew_Project.setText(project.getProjectName());
				jlabelNew_Created.setText(simpleDateFormat.format(transfer.getCreated()));
				
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	// Action
	// button cancel
	public void btnCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		
	}
	// button edit
	public void jbuttonEdit_actionPerformed(ActionEvent e) {
		CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
		Map<String, Object> data = new  HashMap<String, Object>();
		if(customEmployeeModel.findById(employee.getEmployeeId())!=null) {
			data.put("employeeCustom",customEmployeeModel.findById(employee.getEmployeeId()) );
			JFrameUpdateEmployee frameUpdateEmployee = new JFrameUpdateEmployee(data);
			frameUpdateEmployee.setVisible(true);
			this.setVisible(false);
		}
	}
	
	// fill Data
	// Data location history
	private void fillDataLocation(List<EmpLocation> empLocations) {
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel defaultTableModelLocation = new DefaultTableModel();
			defaultTableModelLocation.addColumn("");
			defaultTableModelLocation.addColumn("Location");
			defaultTableModelLocation.addColumn("From_date");
			defaultTableModelLocation.addColumn("To_date");
			defaultTableModelLocation.addColumn("Description");
			
			int index = 1;
			for(EmpLocation empLocation: empLocations) {
				System.out.println(empLocation.toString());
				String todate = "";
				if(empLocation.getToDate()!=null) {
					todate = dateFormat.format(empLocation.getToDate());
				}
				LocationModel  locationModel = new LocationModel();
				Location location = locationModel.findById(empLocation.getLocationId());
				defaultTableModelLocation.addRow(new Object[] {
						index,
						location.getLocationName(),
						dateFormat.format(empLocation.getFromDate()),
						todate,
						empLocation.getDescription()
				});
				index++;
				
			}
			
			jtableLocationHistory.setModel(defaultTableModelLocation);
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	// Data department history
	private void fillDataDepartment(List<Empdepartment> empdepartments) {
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel defaultTableModelLocation = new DefaultTableModel();
			defaultTableModelLocation.addColumn("");
			defaultTableModelLocation.addColumn("Department");
			defaultTableModelLocation.addColumn("From_date");
			defaultTableModelLocation.addColumn("To_date");
			defaultTableModelLocation.addColumn("Description");
			int index = 1;
			for(Empdepartment empdepartment: empdepartments) {
				String todate = "";
				if(empdepartment.getToDate()!=null) {
					todate = dateFormat.format(empdepartment.getToDate());
				}
				DepamentModel  depamentModel = new DepamentModel();
				Department department = depamentModel.findById(empdepartment.getDepartmentId());
				defaultTableModelLocation.addRow(new Object[] {
						index,
						department.getDepamentName(),
						dateFormat.format(empdepartment.getFromDate()),
						todate,
						empdepartment.getDescription()
				});
				index++;
				
			}
			
			jtableDepartment.setModel(defaultTableModelLocation);
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	// Data department history
		private void fillDataProject(List<EmpProject> empProjects) {
			try {
				System.out.println(empProjects);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				DefaultTableModel defaultTableModelLocation = new DefaultTableModel();
				defaultTableModelLocation.addColumn("");
				defaultTableModelLocation.addColumn("Project");
				defaultTableModelLocation.addColumn("From_date");
				defaultTableModelLocation.addColumn("To_date");
				defaultTableModelLocation.addColumn("Description");
				int index = 1;
				for(EmpProject empProject: empProjects) {
					String todate = "";
					if(empProject.getToDate()!=null) {
						todate = dateFormat.format(empProject.getToDate());
					}
					ProjectModel  projectModel = new ProjectModel();
					Project project = projectModel.findById(empProject.getProjectId());
					defaultTableModelLocation.addRow(new Object[] {
							index,
							project.getProjectName(),
							dateFormat.format(empProject.getFromDate()),
							todate,
							empProject.getDescription()
					});
					index++;
					
				}
				
				jtabelProject.setModel(defaultTableModelLocation);
			}catch (Exception e) {
				e.getMessage();
			}
		}
	
	
	// action
	//  button accept
	public void jbtnAccept_actionPerformed(ActionEvent e) {
		boolean reusltEmpLocation = false;
		boolean reusltEmpDepartment = false;
		boolean reusltEmpProject = false;
		try {
			int respone = JOptionPane.showConfirmDialog(null,"Do you want to accept? ","Save",JOptionPane.YES_NO_OPTION );
			if(respone == JOptionPane.YES_OPTION) {
				System.out.println(this.transfer);
				Transfer transfer = this.transfer;
				if(transfer != null) {
					// Created EmpLocation 
					EmpLocationModel empLocationModel = new EmpLocationModel();
					EmpLocation empLocation = new EmpLocation();
					empLocation.setEmployeeId(transfer.getEmployee_id());
					empLocation.setLocationId(transfer.getLocation_id());
					if(empLocationModel.create(empLocation)) {
						System.out.println("--> Created EmpLocation Success");
						reusltEmpLocation = true ;
					}else {
						JOptionPane.showMessageDialog(null, "Error!");
						System.out.println("--> Created EmpLocation . Error !!");
					}
					
					// Created EmpDepartment 
					EmpDepamentModel empDepamentModel = new EmpDepamentModel();
					Empdepartment empdepartment = new Empdepartment();
					empdepartment.setEmployeeId(transfer.getEmployee_id());
					empdepartment.setDepartmentId(transfer.getDepartment_id());
					if(empDepamentModel.create(empdepartment)) {
						System.out.println("--> Created EmpDepartment Success");
						reusltEmpDepartment = true;
					}else {
						JOptionPane.showMessageDialog(null, "Error!");
						System.out.println("--> Created EmpDepartment . Error !!");
					}
					
					// Created Project 
					EmpProjectModel empProjectModel = new EmpProjectModel();
					EmpProject empProject = new EmpProject();
					empProject.setEmployeeId(transfer.getEmployee_id());
					empProject.setProjectId(transfer.getProject_id());
					if(empProjectModel.create(empProject)) {
						System.out.println("--> Created EmpProject Success");
						reusltEmpProject = true;
					}else {
						JOptionPane.showMessageDialog(null, "Error!");
						System.out.println("--> Created EmpProject . Error !!");
					}
					
					if(reusltEmpLocation == true && reusltEmpDepartment == true && reusltEmpProject == true) {
						TransferModel transferModel = new TransferModel();
						transfer.setProcessing_date(new Date());
						transfer.setStatus(2);
						if(transferModel.update(transfer)) {
							JOptionPane.showMessageDialog(null, "Success !!!");
							// show new
							jpanelPresent.setVisible(false);
							jpanelNewTransfer.setVisible(false);
							jlabelTrasferIcon1.setVisible(false);
							jlabelTrasferIcon2.setVisible(false);
							jlabelDescription.setVisible(false);
							jtextFieldDescription.setVisible(false);
							jbtnAccept.setVisible(false);
							jbtnCancel.setVisible(false);
							jlabelNothing.setVisible(true);
							jlabelNoth.setVisible(false);
							// loadLocation
							LocationModel locationModel = new LocationModel();
							Location location = locationModel.findById(transfer.getLocation_id());
							jlabelLocation.setText(location.getLocationName());
							// loadDepartment
							DepamentModel depamentModel = new DepamentModel();
							Department department = depamentModel.findById(transfer.getDepartment_id());
							jlabelDepartment.setText(department.getDepamentName());
							// loadProject
							ProjectModel projectModel = new ProjectModel();
							Project project = projectModel.findById(transfer.getProject_id());
							jlabelProject.setText(project.getProjectName());
							
						}
					}
					
				}
			}
		}catch (Exception e3) {
			JOptionPane.showMessageDialog(null, e3.getMessage());
		}

	}
	
	// button cancel
	public void jbtnCancel_actionPerformed(ActionEvent e) {
		int respone = JOptionPane.showConfirmDialog(null,"Do you want to cancel? ","Save",JOptionPane.YES_NO_OPTION );
		if(respone == JOptionPane.YES_OPTION) {
			Transfer transfer = this.transfer;
			TransferModel transferModel = new TransferModel();
			transfer.setProcessing_date(new Date());
			transfer.setStatus(0);
			if(transferModel.update(transfer)) {
				JOptionPane.showMessageDialog(null, "Cancel successfully !");
				// show new
				jpanelPresent.setVisible(false);
				jpanelNewTransfer.setVisible(false);
				jlabelTrasferIcon1.setVisible(false);
				jlabelTrasferIcon2.setVisible(false);
				jlabelDescription.setVisible(false);
				jtextFieldDescription.setVisible(false);
				jbtnAccept.setVisible(false);
				jbtnCancel.setVisible(false);
				jlabelNothing.setVisible(true);
				jlabelNoth.setVisible(false);
			}
		}
	}
	
	// change password
	// button save
	public void jbuttonSave_actionPerformed(ActionEvent e) {
		if(jpasswordField.getPassword().equals("")) {
			JOptionPane.showMessageDialog(null,"Password is not null !!" );
		}else {
			String password = String.valueOf(jpasswordField.getPassword());
			if(password.length() > 16 || password.length() < 6) {
				JOptionPane.showMessageDialog(null, "Password must be between 6 and 16 . in length");
			}else {
				employee.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
				EmployeeModel employeeModel = new EmployeeModel();
				if (employeeModel.update(employee)) {
					JOptionPane.showMessageDialog(null, "Change password successfully ");
				}else {
					JOptionPane.showMessageDialog(null, "Password change failed ! ");
					
				}
			}
		}
		
		
	}
}
