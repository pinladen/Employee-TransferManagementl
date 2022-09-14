package com.views.employee;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.entities.Department;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.entities.Transfer;
import com.models.DepamentModel;
import com.models.EmpDepamentModel;
import com.models.EmpLocationModel;
import com.models.EmpProjectModel;
import com.models.EmployeeModel;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.models.TitlesModel;
import com.models.TransferModel;



import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class JPanelEmployeeTransfer extends JPanel {
	private JTable jtabelTransferRequest;
	private JComboBox jcomboBoxLocation;
	private JComboBox jcomboBoxDepartment;
	private JComboBox jcomboBoxProject;
	private JCheckBox jcheckboxLocation;
	private JCheckBox jcheckboxDepartment;
	private JCheckBox jcheckboxProject;
	private JCheckBox jcheckboxConfirm;
	private Map<String, Object> data;
	private Employee employee;
	private Location location;
	private Department department1;
	private Project project;
	private JButton jbuttonSubmit;
	private JComboBox jcomboBoxLocation1;
	private JComboBox jcomboBoxDepartment1;
	private JComboBox jcomboBoxProject1;
	private JComboBox jcomboBoxStatus;
	/**
	 * Create the panel.
	 */
	public JPanelEmployeeTransfer() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transfer request");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(18, 11, 230, 35);
		add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1, 51, 822, 1);
		add(panel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(11, 64, 798, 174);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 812, 45);
		panel.add(panel_1);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Trasnfer Request");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel_2.setBounds(6, 0, 203, 45);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Location");
		lblNewLabel_1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(92, 62, 81, 20);
		panel.add(lblNewLabel_1);
		
		jcomboBoxLocation = new JComboBox();
		jcomboBoxLocation.setBounds(196, 57, 192, 28);
		panel.add(jcomboBoxLocation);
		
		JLabel lblNewLabel_1_1 = new JLabel("Department");
		lblNewLabel_1_1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(92, 94, 81, 20);
		panel.add(lblNewLabel_1_1);
		
		jcomboBoxDepartment = new JComboBox();
		jcomboBoxDepartment.setBounds(196, 89, 192, 28);
		panel.add(jcomboBoxDepartment);
		
		JLabel lblNewLabel_1_2 = new JLabel("Project");
		lblNewLabel_1_2.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(92, 126, 81, 20);
		panel.add(lblNewLabel_1_2);
		
		jcomboBoxProject = new JComboBox();
		jcomboBoxProject.setBounds(196, 121, 192, 28);
		panel.add(jcomboBoxProject);
		
		jbuttonSubmit = new JButton("Submit");
		jbuttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSubmit_actionPerformed(e);
			}
		});
		jbuttonSubmit.setBackground(new Color(30, 144, 255));
		jbuttonSubmit.setForeground(Color.WHITE);
		jbuttonSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbuttonSubmit.setBounds(500, 122, 136, 27);
		panel.add(jbuttonSubmit);
		
		jcheckboxConfirm = new JCheckBox("Confirm transfer request !");
		jcheckboxConfirm.setBounds(500, 96, 183, 18);
		panel.add(jcheckboxConfirm);
		
		jcheckboxLocation = new JCheckBox("Change");
		jcheckboxLocation.setBounds(400, 62, 70, 18);
		panel.add(jcheckboxLocation);
		
		jcheckboxDepartment = new JCheckBox("Change");
		jcheckboxDepartment.setBounds(400, 94, 70, 18);
		panel.add(jcheckboxDepartment);
		
		jcheckboxProject = new JCheckBox("Change");
		jcheckboxProject.setBounds(400, 126, 70, 18);
		panel.add(jcheckboxProject);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 249, 798, 320);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 810, 46);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Trasnfer Request History");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(6, 0, 276, 45);
		panel_3.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 79, 792, 241);
		panel_2.add(scrollPane);
		
		jtabelTransferRequest = new JTable();
		scrollPane.setViewportView(jtabelTransferRequest);
		
		jcomboBoxStatus = new JComboBox();
		jcomboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxStatus_actionPerformed(e);
			}
		});
		jcomboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Pending", "Resoved", "Cancelled"}));
		jcomboBoxStatus.setBounds(642, 51, 103, 26);
		panel_2.add(jcomboBoxStatus);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(601, 55, 40, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Project");
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(410, 56, 55, 16);
		panel_2.add(lblNewLabel_3_1);
		
		jcomboBoxProject1 = new JComboBox();
		jcomboBoxProject1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxProject1_actionPerformed(e);
			}
		});
		jcomboBoxProject1.setBounds(467, 51, 116, 26);
		panel_2.add(jcomboBoxProject1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Department");
		lblNewLabel_3_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(201, 55, 67, 16);
		panel_2.add(lblNewLabel_3_2);
		
		jcomboBoxDepartment1 = new JComboBox();
		jcomboBoxDepartment1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxDepartment1_actionPerformed(e);
			}
		});
		jcomboBoxDepartment1.setBounds(274, 51, 116, 26);
		panel_2.add(jcomboBoxDepartment1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Location");
		lblNewLabel_3_2_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3_2_1.setBounds(6, 55, 67, 16);
		panel_2.add(lblNewLabel_3_2_1);
		
		jcomboBoxLocation1 = new JComboBox();
		jcomboBoxLocation1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxLocation1_actionPerformed(e);
			}
		});
		jcomboBoxLocation1.setBounds(66, 51, 116, 26);
		panel_2.add(jcomboBoxLocation1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(194, 51, 1, 26);
		panel_2.add(panel_5);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(Color.DARK_GRAY);
		panel_5_1.setBounds(402, 51, 1, 26);
		panel_2.add(panel_5_1);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBackground(Color.DARK_GRAY);
		panel_5_1_1.setBounds(593, 51, 1, 26);
		panel_2.add(panel_5_1_1);
		
		JButton jbuttonRefesh = new JButton("");
		jbuttonRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefesh_actionPerformed(e);
			}
		});
		jbuttonRefesh.setBackground(new Color(100, 149, 237));
		jbuttonRefesh.setIcon(new ImageIcon(JPanelEmployeeTransfer.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		jbuttonRefesh.setBounds(752, 50, 40, 28);
		panel_2.add(jbuttonRefesh);

	}
	public JPanelEmployeeTransfer(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
		
	}
	
	private void loadData() {
		try {
			EmployeeCustom employeeCustom= (EmployeeCustom) data.get("employeeCustom");
			if(employeeCustom != null) {
				this.employee = employeeCustom.getEmployee();
				this.location = employeeCustom.getLocation();
				this.department1 = employeeCustom.getDepament();
				this.project = employeeCustom.getProject();
				loadLocation();
				loadDepartment();
				loadProject();
				TransferModel transferModel = new TransferModel();
				if(transferModel.searchByEmployeeId(employee.getEmployeeId())!=null) {
					List<Transfer> transfers = transferModel.searchByEmployeeId(employee.getEmployeeId());
					fillDatatoJTable(transfers);
				}
				if(transferModel.findByEmployeeId(employee.getEmployeeId(), 1)!=null) {
					Transfer transfer = transferModel.findByEmployeeId(employee.getEmployeeId() , 1);
					if(transfer.getStatus()==1) {
						
						jbuttonSubmit.setEnabled(false);
					}
				}
				
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	

	// Combobox location
	private void loadLocation() {
		LocationModel locationModel = new LocationModel();
		List<Location> locations = locationModel.findAll();
		if(locations !=null) {
			DefaultComboBoxModel<Location> comboBoxModelLocations = new DefaultComboBoxModel<Location>();
			for(Location location : locations) {
				comboBoxModelLocations.addElement(location);
			}
			jcomboBoxLocation.setModel(comboBoxModelLocations);
			jcomboBoxLocation.setRenderer(new LocationCellRender());
			jcomboBoxLocation1.setModel(comboBoxModelLocations);
			jcomboBoxLocation1.setRenderer(new LocationCellRender());
		}
		
	}
	
	private class LocationCellRender extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Location location = (Location) value;
			return super.getListCellRendererComponent(list, location.getLocationName(), index, isSelected, cellHasFocus);
		}
	}
	
	// Combobox department
	private void loadDepartment() {
		DepamentModel depamentModel = new DepamentModel();
		List<Department> departments = depamentModel.findAll();
		if(departments !=null) {
			DefaultComboBoxModel<Department> comboBoxModelDepartment = new DefaultComboBoxModel<Department>();
			for(Department department : departments) {
				comboBoxModelDepartment.addElement(department);
			}
			jcomboBoxDepartment.setModel(comboBoxModelDepartment);
			jcomboBoxDepartment.setRenderer(new DepartmentCellRender());
			jcomboBoxDepartment1.setModel(comboBoxModelDepartment);
			jcomboBoxDepartment1.setRenderer(new DepartmentCellRender());
		}else {
			System.out.println("err");
		}
		
	}
	
	private class DepartmentCellRender extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getDepamentName(), index, isSelected, cellHasFocus);
		}
	}
	
	
	// Combobox project
		private void loadProject() {
			ProjectModel projectModel = new ProjectModel();
			List<Project> projects = projectModel.findAll();
			if(projects !=null) {
				DefaultComboBoxModel<Project> comboBoxModelProjects = new DefaultComboBoxModel<Project>();
				for(Project project : projects) {
					comboBoxModelProjects.addElement(project);
				}
				jcomboBoxProject.setModel(comboBoxModelProjects);
				jcomboBoxProject.setRenderer(new ProjectCellRender());
				jcomboBoxProject1.setModel(comboBoxModelProjects);
				jcomboBoxProject1.setRenderer(new ProjectCellRender());
			}
			
		}
		
		private class ProjectCellRender extends DefaultListCellRenderer {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub
				Project project = (Project) value;
				return super.getListCellRendererComponent(list, project.getProjectName(), index, isSelected, cellHasFocus);
			}
		}
		
	// fill data
	private void fillDatatoJTable(List<Transfer> transfers) {
		try {
			DefaultTableModel defaultTableModel = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			defaultTableModel.addColumn("id");
			defaultTableModel.addColumn("Employee Id");
			defaultTableModel.addColumn("Employee name");
			defaultTableModel.addColumn("To Location");
			defaultTableModel.addColumn("To Department");
			defaultTableModel.addColumn("To Project");
			defaultTableModel.addColumn("Status");
			defaultTableModel.addColumn("Created");
			defaultTableModel.addColumn("Processing date");
			EmployeeModel employeeModel = new EmployeeModel();
			LocationModel locationModel = new LocationModel();
			DepamentModel depamentModel = new DepamentModel();
			ProjectModel projectModel = new ProjectModel();
			for (Transfer transfer : transfers) {
				System.out.println(transfer.toString());
				Employee employee = employeeModel.findById(transfer.getEmployee_id());
				Location location = locationModel.findById(transfer.getLocation_id());
				Department department = depamentModel.findById(transfer.getDepartment_id());
				Project project = projectModel.findById(transfer.getProject_id());
				String status = "";
				if(transfer.getStatus() == 1) {
					status = "Pending";
				}else if(transfer.getStatus() == 2){
					status = "Resoved";
				}else {
					status = "Cancelled";
				}
				defaultTableModel.addRow(new Object[] {
						transfer.getTransfer_id(), 
						employee.getEmployeeId(),
						employee.getName(),
						location.getLocationName(),
						department.getDepamentName(),
						project.getProjectName(),
						status,
						transfer.getCreated(),
						transfer.getProcessing_date()
				});
			}
			jtabelTransferRequest.setModel(defaultTableModel);
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	// action
	//button submit
	
	public void jbuttonSubmit_actionPerformed(ActionEvent e) {
		if(jcheckboxConfirm.isSelected()) {
			if(jcheckboxLocation.isSelected()== false &&jcheckboxDepartment.isSelected()== false &&jcheckboxProject.isSelected()== false) {
				JOptionPane.showMessageDialog(null, "You must select at least 1 to submit a transfer request");
			}else {
				Transfer transfer = new Transfer();
				// set Employee
				transfer.setEmployee_id(employee.getEmployeeId());
			
				// Check change and set LocationId for transfer
				if(jcheckboxLocation.isSelected()) {
					Location location =(Location) jcomboBoxLocation.getSelectedItem();
					if(this.location.getLocationId() != location.getLocationId()) {
						transfer.setLocation_id(location.getLocationId());
					}else {
						transfer.setLocation_id(this.location.getLocationId());
					}
				}else {
					transfer.setLocation_id(this.location.getLocationId());
				}
				
				// Check change and set LocationId for transfer
				if(jcheckboxLocation.isSelected()) {
					Location location =(Location) jcomboBoxLocation.getSelectedItem();
					if(this.location.getLocationId() != location.getLocationId()) {
						transfer.setLocation_id(location.getLocationId());
					}else {
						transfer.setLocation_id(this.location.getLocationId());
					}
				}else {
					transfer.setLocation_id(this.location.getLocationId());
				}
				// Check change and set DepartmentId for transfer
				if(jcheckboxDepartment.isSelected()) {
					Department department =(Department) jcomboBoxDepartment.getSelectedItem();
					if(this.department1.getDepamentId() != department.getDepamentId()) {
						transfer.setDepartment_id(department.getDepamentId());
					}else {
						transfer.setDepartment_id(this.department1.getDepamentId());
					}
					
				}else {
					transfer.setDepartment_id(this.department1.getDepamentId());
				}
				
				// Check change and set ProjectId for transfer
				if(jcheckboxProject.isSelected()) {
					Project project =(Project) jcomboBoxProject.getSelectedItem();
					if(this.project.getProjectId() != project.getProjectId()) {
						transfer.setProject_id(project.getProjectId());
					}else {
						transfer.setProject_id(this.project.getProjectId());
					}
				}else {
					transfer.setProject_id(this.project.getProjectId());
				}
				transfer.setCreated(new Date());
				transfer.setStatus(1);
				TransferModel transferModel = new TransferModel();
				if(transferModel.create(transfer)!=null) {
					JOptionPane.showMessageDialog(null, "Submit transfer request successfully");
					loadData();
				}else {
					JOptionPane.showMessageDialog(null, "Submit failed transfer request");
				}
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "You must confirm the transfer before submitting !");
		}
	}
	public void jbuttonRefesh_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		if(transferModel.searchByEmployeeId(employee.getEmployeeId())!=null) {
			List<Transfer> transfers = transferModel.searchByEmployeeId(employee.getEmployeeId());
			fillDatatoJTable(transfers);
		}
	}
	
	// combobox action
	public void jcomboBoxStatus_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		if(jcomboBoxStatus.getSelectedItem()!=null) {
			if(String.valueOf(jcomboBoxStatus.getSelectedItem())=="Pending") {
				
				fillDatatoJTable(transferModel.searchByStatusAndEmployeeId(1,employee.getEmployeeId()));
			}else if(String.valueOf(jcomboBoxStatus.getSelectedItem())=="Resoved") {
				
				fillDatatoJTable(transferModel.searchByStatusAndEmployeeId(2,employee.getEmployeeId()));
			}else if(String.valueOf(jcomboBoxStatus.getSelectedItem())=="Cancelled") {
				
				fillDatatoJTable(transferModel.searchByStatusAndEmployeeId(0,employee.getEmployeeId()));
			}
		}
	}
	
	public void jcomboBoxLocation1_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Location location = (Location) jcomboBoxLocation.getSelectedItem();
		if(transferModel.searchByLocationIdAndEmpId(location.getLocationId(),employee.getEmployeeId())!=null) {
			fillDatatoJTable(transferModel.searchByLocationIdAndEmpId(location.getLocationId(),employee.getEmployeeId()));
		}
	}
	
	public void jcomboBoxDepartment1_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Department department = (Department) jcomboBoxDepartment.getSelectedItem();
		if(transferModel.searchByDepartmentIdAndEmpId(department.getDepamentId(),employee.getEmployeeId())!=null) {
			fillDatatoJTable(transferModel.searchByDepartmentIdAndEmpId(department.getDepamentId(),employee.getEmployeeId()));
		}
	}
	
	public void jcomboBoxProject1_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Project project = (Project) jcomboBoxProject.getSelectedItem();
		if(transferModel.searchByProjectIdAndEmpID(project.getProjectId(),employee.getEmployeeId())!=null) {
			fillDatatoJTable(transferModel.searchByProjectIdAndEmpID(project.getProjectId(),employee.getEmployeeId()));
		}
	}
	
//	public void jdateChooserCreated_propertyChange(MouseEvent e) {
//		TransferModel transferModel = new TransferModel();
//		Date date = jdateChooserCreated.getDate();
//		System.out.println(date);
//		if(transferModel.searchByCreated(date)!=null) {
//			fillDatatoJTable(transferModel.searchByCreated(date));
//		}
//	}
	
	
}
