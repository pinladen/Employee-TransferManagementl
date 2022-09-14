package com.views.employee;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.entities.Department;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.models.EmpDepamentModel;
import com.models.EmpLocationModel;
import com.models.EmpProjectModel;
import com.models.TitlesModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class JPanelProfile extends JPanel {
	private Map<String, Object> data;
	private Employee employee;
	private EmployeeCustom employeeCustom;
	private JLabel jlabelName;
	private JLabel jlabelPhone;
	private JLabel jlabelEmail;
	private JLabel jlabelBirthday;
	private JLabel jlabelGender;
	private JLabel jlabelCreated;
	private JLabel jlabelTitle;
	private JLabel jlabelSalary;
	private JLabel jlabelLocation;
	private JLabel jlabelDepartment;
	private JLabel jlabelProject;
	private JLabel jlabelStatus;
	/**
	 * Create the panel.
	 */
	public JPanelProfile() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 830, 580);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(18, 83, 776, 314);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setBounds(60, 30, 78, 22);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone :");
		lblNewLabel_2_1.setBounds(60, 75, 78, 22);
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_2 = new JLabel("Email :");
		lblNewLabel_2_2.setBounds(60, 118, 78, 22);
		panel_2.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_3 = new JLabel("Birthday :");
		lblNewLabel_2_3.setBounds(60, 163, 78, 22);
		panel_2.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Gender :");
		lblNewLabel_2_3_1.setBounds(60, 207, 78, 22);
		panel_2.add(lblNewLabel_2_3_1);
		lblNewLabel_2_3_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_3_1_3 = new JLabel("Created :");
		lblNewLabel_2_3_1_3.setBounds(60, 254, 78, 22);
		panel_2.add(lblNewLabel_2_3_1_3);
		lblNewLabel_2_3_1_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelName = new JLabel("...");
		jlabelName.setForeground(Color.DARK_GRAY);
		jlabelName.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelName.setBounds(148, 34, 157, 16);
		panel_2.add(jlabelName);
		
		jlabelBirthday = new JLabel("...");
		jlabelBirthday.setForeground(Color.DARK_GRAY);
		jlabelBirthday.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelBirthday.setBounds(148, 167, 157, 16);
		panel_2.add(jlabelBirthday);
		
		jlabelPhone = new JLabel("...");
		jlabelPhone.setForeground(Color.DARK_GRAY);
		jlabelPhone.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelPhone.setBounds(148, 79, 157, 16);
		panel_2.add(jlabelPhone);
		
		jlabelEmail = new JLabel("...");
		jlabelEmail.setForeground(Color.DARK_GRAY);
		jlabelEmail.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelEmail.setBounds(148, 122, 157, 16);
		panel_2.add(jlabelEmail);
		
		jlabelGender = new JLabel("...");
		jlabelGender.setForeground(Color.DARK_GRAY);
		jlabelGender.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelGender.setBounds(150, 211, 157, 16);
		panel_2.add(jlabelGender);
		
		jlabelCreated = new JLabel("...");
		jlabelCreated.setForeground(Color.DARK_GRAY);
		jlabelCreated.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelCreated.setBounds(148, 258, 157, 16);
		panel_2.add(jlabelCreated);
		
		JLabel lblNewLabel_2_4 = new JLabel("Title :");
		lblNewLabel_2_4.setBounds(409, 30, 90, 22);
		panel_2.add(lblNewLabel_2_4);
		lblNewLabel_2_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelTitle = new JLabel("...");
		jlabelTitle.setForeground(Color.DARK_GRAY);
		jlabelTitle.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelTitle.setBounds(523, 30, 150, 16);
		panel_2.add(jlabelTitle);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Salary :");
		lblNewLabel_2_1_1_1.setBounds(409, 75, 90, 22);
		panel_2.add(lblNewLabel_2_1_1_1);
		lblNewLabel_2_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelSalary = new JLabel("...");
		jlabelSalary.setForeground(Color.DARK_GRAY);
		jlabelSalary.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelSalary.setBounds(523, 75, 150, 16);
		panel_2.add(jlabelSalary);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Location :");
		lblNewLabel_2_1_1.setBounds(409, 118, 90, 22);
		panel_2.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelLocation = new JLabel("...");
		jlabelLocation.setForeground(Color.DARK_GRAY);
		jlabelLocation.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelLocation.setBounds(523, 116, 150, 16);
		panel_2.add(jlabelLocation);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Department :");
		lblNewLabel_2_2_1.setBounds(409, 163, 102, 22);
		panel_2.add(lblNewLabel_2_2_1);
		lblNewLabel_2_2_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelDepartment = new JLabel("...");
		jlabelDepartment.setForeground(Color.DARK_GRAY);
		jlabelDepartment.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelDepartment.setBounds(523, 163, 150, 16);
		panel_2.add(jlabelDepartment);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Project :");
		lblNewLabel_2_3_2.setBounds(409, 207, 90, 22);
		panel_2.add(lblNewLabel_2_3_2);
		lblNewLabel_2_3_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelProject = new JLabel("...");
		jlabelProject.setForeground(Color.DARK_GRAY);
		jlabelProject.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelProject.setBounds(523, 207, 150, 16);
		panel_2.add(jlabelProject);
		
		JLabel lblNewLabel_2_3_1_2 = new JLabel("Status :");
		lblNewLabel_2_3_1_2.setBounds(409, 254, 90, 22);
		panel_2.add(lblNewLabel_2_3_1_2);
		lblNewLabel_2_3_1_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelStatus = new JLabel("...");
		jlabelStatus.setForeground(Color.DARK_GRAY);
		jlabelStatus.setFont(new Font("Microsoft Tai Le", Font.BOLD, 12));
		jlabelStatus.setBounds(523, 254, 150, 16);
		panel_2.add(jlabelStatus);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setIcon(new ImageIcon(JPanelProfile.class.getResource("/resources/icons8_web_design_24px.png")));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(18, 11, 126, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Notification", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(18, 432, 776, 91);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Have a nice day");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(JPanelProfile.class.getResource("/resources/icons8_exclamation_mark_24px.png")));
		lblNewLabel_1.setBounds(54, 31, 438, 33);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1, 51, 822, 1);
		panel.add(panel_4);

	}
	public JPanelProfile(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
		
	}
	
	private void loadData() {
		try {
			EmployeeCustom employeeCustom = (EmployeeCustom) data.get("employeeCustom");
			
			if(employeeCustom != null) {
				this.employeeCustom = employeeCustom;
				this.employee = employeeCustom.getEmployee();
				loadEmployee(employee);
				if(employeeCustom.getLocation()!=null) {
					loadLocation(employeeCustom.getLocation());
				}
				if(employeeCustom.getDepament()!=null) {
					loadDepartment(employeeCustom.getDepament());
				}
				if(employeeCustom.getProject()!=null) {
					loadProject(employeeCustom.getProject());
				}
				
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void loadEmployee(Employee employee) {
		try {
			if(employee !=null) {
				this.employee = employee;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				jlabelName.setText(employee.getName());
				jlabelEmail.setText(employee.getEmail());
				jlabelPhone.setText(employee.getPhone());
				jlabelGender.setText(employee.getGender());
				
				jlabelCreated.setText(simpleDateFormat.format(employee.getCreatedAt()));
				jlabelBirthday.setText(simpleDateFormat.format( employee.getDob()));
				
				TitlesModel titlesModel = new TitlesModel();
				Titles title = titlesModel.findById(employee.getTitleId());
				jlabelTitle.setText(title.getTitle_name());
				jlabelSalary.setText(String.valueOf(title.getSalaries()) + " $");
				if(employee.isStatus()) {
					jlabelStatus.setText("Working");
					jlabelStatus.setForeground(new Color(0,128,0));
				}else {
					jlabelStatus.setText("Quit one's job"); 
					jlabelStatus.setForeground(new Color(220,20,60));
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
					
				}
			}catch (Exception e2) {
				e2.getMessage();
			}
		}
		
		
		
		
		
		
}
