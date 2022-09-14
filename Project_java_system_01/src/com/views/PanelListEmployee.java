package com.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.entities.Department;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.models.CustomEmployeeModel;
import com.models.DepamentModel;
import com.models.EmployeeModel;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.models.TitlesModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import com.toedter.calendar.JDateChooser;


public class PanelListEmployee extends JPanel {
	private JTable jtableEmployee;
	private JLabel jlabelID;
	private JLabel jlabelName;
	private JLabel jlabelTitle;
	private JLabel jlabelSalaries;
	private JLabel jlabelLocation;
	private JLabel jlabelDepament;
	private JLabel jlabelProject;
	private JTextField jtextFieldId;
	private JLabel jlabelTotal;
	private JButton jbtnFind;
	private JLabel jlabelErr1;
	private JLabel jlabelImage;
	private JButton jbtnUpdate;
	private JButton jbtnProfile;
	private JTextField jtextFieldName;

	/**
	 * Create the panel.
	 */
	public PanelListEmployee() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jlabelErr1.setText("");
			}
		});
		setBackground(SystemColor.textHighlightText);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 139, 139), 3, true));
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
			}
		});
		scrollPane.setBounds(23, 223, 734, 500);
		add(scrollPane);
		
		jtableEmployee = new JTable();
		JTableHeader header = jtableEmployee.getTableHeader();
		header.setFont(new Font("SansSerif",Font.BOLD,14));
		jtableEmployee.setGridColor(new Color(0, 128, 128));
		jtableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableEmployee_mouseClicked(e);
			}
		});
		jtableEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableEmployee);
		
		JButton jbuttonAddEmployee = new JButton("Add Employee");
		jbuttonAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAddEmployee_actionPerformed(e);
			}
		});
		jbuttonAddEmployee.setBackground(SystemColor.text);
		jbuttonAddEmployee.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbuttonAddEmployee.setIcon(new ImageIcon(PanelListEmployee.class.getResource("/resources/icons8_add_24px.png")));
		jbuttonAddEmployee.setBounds(783, 240, 239, 33);
		add(jbuttonAddEmployee);
		
		jbtnProfile = new JButton("Profile");
		jbtnProfile.setEnabled(false);
		jbtnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnProfile_actionPerformed(e);
			}
		});
		jbtnProfile.setBackground(SystemColor.text);
		jbtnProfile.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnProfile.setIcon(new ImageIcon(PanelListEmployee.class.getResource("/resources/icons8_profile_24px_3.png")));
		jbtnProfile.setBounds(783, 285, 239, 33);
		add(jbtnProfile);
		
		jbtnUpdate = new JButton("Update");
		jbtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnUpdate_actionPerformed(e);
			}
		});
		jbtnUpdate.setEnabled(false);
		jbtnUpdate.setBackground(SystemColor.text);
		jbtnUpdate.setIcon(new ImageIcon(PanelListEmployee.class.getResource("/resources/icons8_restart_24px.png")));
		jbtnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnUpdate.setBounds(783, 330, 239, 33);
		add(jbtnUpdate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Profile", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBackground(SystemColor.text);
		panel.setBounds(783, 375, 239, 348);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 141, 30, 16);
		panel.add(lblNewLabel);
		
		jlabelID = new JLabel("");
		jlabelID.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelID.setForeground(new Color(70, 130, 180));
		jlabelID.setBounds(82, 141, 147, 16);
		panel.add(jlabelID);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName.setBounds(10, 169, 54, 16);
		panel.add(lblName);
		
		jlabelName = new JLabel("");
		jlabelName.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelName.setForeground(new Color(70, 130, 180));
		jlabelName.setBounds(82, 168, 147, 16);
		panel.add(jlabelName);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTitle.setBounds(10, 197, 38, 16);
		panel.add(lblTitle);
		
		jlabelTitle = new JLabel("");
		jlabelTitle.setForeground(new Color(70, 130, 180));
		jlabelTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelTitle.setBounds(82, 195, 147, 16);
		panel.add(jlabelTitle);
		
		JLabel lblSalaries = new JLabel("Salaries :");
		lblSalaries.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSalaries.setBounds(10, 225, 54, 16);
		panel.add(lblSalaries);
		
		jlabelSalaries = new JLabel("");
		jlabelSalaries.setForeground(new Color(70, 130, 180));
		jlabelSalaries.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelSalaries.setBounds(82, 222, 147, 16);
		panel.add(jlabelSalaries);
		
		JLabel lblDepament = new JLabel("Location :");
		lblDepament.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDepament.setBounds(10, 253, 72, 16);
		panel.add(lblDepament);
		
		JLabel lblProject = new JLabel("Depament");
		lblProject.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblProject.setBounds(10, 281, 65, 16);
		panel.add(lblProject);
		
		JLabel lblProject_1 = new JLabel("Project :");
		lblProject_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblProject_1.setBounds(10, 309, 72, 16);
		panel.add(lblProject_1);
		
		jlabelLocation = new JLabel("");
		jlabelLocation.setForeground(new Color(70, 130, 180));
		jlabelLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelLocation.setBounds(82, 253, 147, 16);
		panel.add(jlabelLocation);
		
		jlabelDepament = new JLabel("");
		jlabelDepament.setForeground(new Color(70, 130, 180));
		jlabelDepament.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelDepament.setBounds(82, 281, 147, 16);
		panel.add(jlabelDepament);
		
		jlabelProject = new JLabel("");
		jlabelProject.setForeground(new Color(70, 130, 180));
		jlabelProject.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlabelProject.setBounds(82, 308, 147, 16);
		panel.add(jlabelProject);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(72, 18, 117, 117);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		jlabelImage = new JLabel("No image");
		jlabelImage.setBounds(16, 10, 85, 95);
		panel_1.add(jlabelImage);
		jlabelImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		jtextFieldId = new JTextField();
		jtextFieldId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE )) {
					e.consume();
				}
			}
		});
		jtextFieldId.setBounds(67, 168, 122, 28);
		add(jtextFieldId);
		jtextFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1.setBounds(37, 172, 32, 16);
		add(lblNewLabel_1);
		
		jbtnFind = new JButton("");
		jbtnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnFind_actionPerformed(e);
			}
		});
		jbtnFind.setIcon(new ImageIcon(PanelListEmployee.class.getResource("/resources/icons8_find_user_male_24px.png")));
		jbtnFind.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnFind.setBackground(Color.WHITE);
		jbtnFind.setBounds(199, 163, 39, 33);
		add(jbtnFind);
		
		JLabel lblNewLabel_2 = new JLabel("Employees Management");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setBounds(37, 46, 985, 28);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Employee total :");
		lblNewLabel_3.setBounds(37, 131, 92, 16);
		add(lblNewLabel_3);
		
		jlabelTotal = new JLabel("0");
		jlabelTotal.setForeground(new Color(128, 128, 128));
		jlabelTotal.setFont(new Font("SansSerif", Font.BOLD, 16));
		jlabelTotal.setBounds(132, 130, 25, 16);
		add(jlabelTotal);
		
		JButton jbtnReLoad = new JButton("Refesh");
		jbtnReLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnReLoad_actionPerformed(e);
			}
		});
		
		jbtnReLoad.setIcon(new ImageIcon(PanelListEmployee.class.getResource("/resources/icons8_refresh_24px.png")));
		jbtnReLoad.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnReLoad.setBackground(Color.WHITE);
		jbtnReLoad.setBounds(654, 178, 115, 33);
		add(jbtnReLoad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name  ");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(273, 173, 52, 16);
		add(lblNewLabel_1_1);
		
		JButton jbtnSearchByName = new JButton("Search");
		jbtnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSearchByName_actionPerformed(e);
			}
		});
		jbtnSearchByName.setIcon(new ImageIcon(PanelListEmployee.class.getResource("/resources/icons8_find_user_male_24px.png")));
		jbtnSearchByName.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnSearchByName.setBackground(Color.WHITE);
		jbtnSearchByName.setBounds(514, 165, 105, 33);
		add(jbtnSearchByName);
		
		jlabelErr1 = new JLabel("");
		jlabelErr1.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlabelErr1.setForeground(new Color(255, 69, 0));
		jlabelErr1.setBounds(640, 121, 367, 26);
		add(jlabelErr1);
		
		jtextFieldName = new JTextField();
		jtextFieldName.setColumns(10);
		jtextFieldName.setBounds(331, 168, 173, 28);
		add(jtextFieldName);
		loadata();
	}
	
	private void loadata() {
		
		EmployeeModel employeeModel = new EmployeeModel();
		List<Employee> employees = employeeModel.findAll();
		jlabelTotal.setText(String.valueOf(employees.size()));
		fillData(employees);
	}
	
	
	
	
	
	// Action
	// Table click
	public void jtableEmployee_mouseClicked(MouseEvent e) {
		try {
			// enabel button action
			
			jbtnProfile.setEnabled(true);
			jbtnUpdate.setEnabled(true);
			// clean info
			clean();
			
			// set infor
			TableModel model = jtableEmployee.getModel();
			String value = model.getValueAt(jtableEmployee.getSelectedRow(), 0).toString();
			CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
			EmployeeCustom employeeCustom = customEmployeeModel.findById(Integer.parseInt(value));
			Employee employee = employeeCustom.getEmployee();
			System.out.println(employeeCustom.toString());
			jlabelImage.setText("");
			jlabelImage.setIcon(new ImageIcon(new ImageIcon(employee.getImage()).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
			jlabelName.setText(employee.getName());
			jlabelID.setText(String.valueOf(employee.getEmployeeId()));
			TitlesModel titlesModel = new TitlesModel();
			Titles title = titlesModel.findById(employee.getTitleId());
			if(title !=null) {
				jlabelSalaries.setText(String.valueOf(title.getSalaries()));
				jlabelTitle.setText(title.getTitle_name());
			}
			Location location = employeeCustom.getLocation();
			if(location!=null) {
				jlabelLocation.setText(location.getLocationName());
			}
			Department department = employeeCustom.getDepament();
			if(department!=null) {
				jlabelDepament.setText(department.getDepamentName());
			}
			Project project = employeeCustom.getProject();
			if(project!=null) {
				jlabelProject.setText(project.getProjectName());
			}
			
		}catch (Exception eTableClick) {
			JOptionPane.showMessageDialog(null, "Not found !");
		}	
	}
	
	private void clean() {
		jlabelImage.setIcon(null);
		jlabelImage.setText("No image");
		jlabelName.setText("");
		jlabelID.setText("");
		jlabelLocation.setText("");
		jlabelDepament.setText("");
		jlabelProject.setText("");
	}
	
	// button Find
	public void jbtnFind_actionPerformed(ActionEvent e) {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			EmployeeModel employeeModel = new EmployeeModel();
			if(jtextFieldId.getText() != "") {
				Employee employee = employeeModel.findById(Integer.parseInt(jtextFieldId.getText()));
				employees.add(employee);
				fillData(employees);
				//jbtnFind.setVisible(false);
			}else {
				System.out.println("Lõi");
			}
		}catch (Exception e1) {
			e1.getMessage();
		}
	}
	
	// button Reload
	public void jbtnReLoad_actionPerformed(ActionEvent e) {
		loadata();
	}
	
	
	// fillData
	private void fillData(List<Employee> employees) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel defaultTableModelEmployee = new DefaultTableModel();
			defaultTableModelEmployee.addColumn("Id");
			defaultTableModelEmployee.addColumn("Name");
			defaultTableModelEmployee.addColumn("BirthDay");
			defaultTableModelEmployee.addColumn("Phone");
			defaultTableModelEmployee.addColumn("Email");
			defaultTableModelEmployee.addColumn("Created");
			defaultTableModelEmployee.addColumn("Status");
			for(Employee employee: employees) {
				defaultTableModelEmployee.addRow(new Object[] {
						employee.getEmployeeId(),
						employee.getName(),
						dateFormat.format(employee.getDob())	,
						employee.getPhone(),
						employee.getEmail(),
						dateFormat.format(employee.getCreatedAt()),
						employee.isStatus() ? "Active" : "Inactive"
				});
			}
			jtableEmployee.setModel(defaultTableModelEmployee);
		}catch (Exception e) {
			e.getMessage();
		}
	}
	///----------------------------------------------------------
	// action
	// button add
	public void jbuttonAddEmployee_actionPerformed(ActionEvent e) {
		JFrameAddEmployee jFrameAddEmployee = new JFrameAddEmployee();
		jFrameAddEmployee.setVisible(true);
	}
	
	// button employee detail
	public void jbtnProfile_actionPerformed(ActionEvent e) {
		try {
			int selectedRow = jtableEmployee.getSelectedRow();
			int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
			if(id > 0) {
				CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
				Map<String, Object> data = new  HashMap<String, Object>();
				if(customEmployeeModel.findById(id)!=null) {
					data.put("employeeCustom",customEmployeeModel.findById(id) );
					JFrameDetailEmployee jFrameDetailEmployee = new JFrameDetailEmployee(data);
					jFrameDetailEmployee.setVisible(true);
				}
			}else {
				jlabelErr1.setText("select id to perform operations !");
			}
		}catch (Exception eProfile) {
			System.out.println(eProfile.getMessage());
			jlabelErr1.setText("select id to perform operations !");
		}
		
	}
	
	// button employee Update
	public void jbtnUpdate_actionPerformed(ActionEvent e) {
		try {
			int selectedRow = jtableEmployee.getSelectedRow();
			int id = Integer.parseInt(jtableEmployee.getValueAt(selectedRow, 0).toString());
			if(id > 0) {
				CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
				Map<String, Object> data = new  HashMap<String, Object>();
				if(customEmployeeModel.findById(id)!=null) {
					data.put("employeeCustom",customEmployeeModel.findById(id) );
					JFrameUpdateEmployee frameUpdateEmployee = new JFrameUpdateEmployee(data);
					frameUpdateEmployee.setVisible(true);
				}
			}else {
				jlabelErr1.setText("select id to perform operations !");
			}
		}catch (Exception eProfile) {
			System.out.println(eProfile.getMessage());
			jlabelErr1.setText("select id to perform operations !");
		}
		
	}
	
	public void jbtnSearchByName_actionPerformed(ActionEvent e) {
		EmployeeModel employeeModel = new EmployeeModel();
		List<Employee> employees = employeeModel.searchByName(jtextFieldName.getText());
		if(employees!=null) {
			fillData(employees);
		}
	}
}
