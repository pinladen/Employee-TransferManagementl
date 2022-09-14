package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.entities.Department;
import com.entities.EmpLocation;
import com.entities.EmpProject;
import com.entities.Empdepartment;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.entities.Transfer;
import com.models.CustomEmployeeModel;
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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;


import javax.swing.SwingConstants;

public class JPanelTransfer extends JPanel {
	private JTable jtableTransfer;
	private JLabel jlabelEmployeeId;
	private JLabel jlabelEmployeeName;
	private JLabel jlabelLocation;
	private JLabel jlabelDepartment;
	private JLabel jlabelProject;
	private JLabel jlabelStatus;
	private JButton jbtnAccept;
	private JButton jbtnCancel;
	private JTextField jtextFieldEmployeeID;
	private Transfer transfer;
	private JLabel jlabelStatusPending;
	private JLabel jlabelStatusResoved;
	private JLabel jlabelStatusCancelled;
	private JComboBox jcomboBoxStatus;
	private JLabel jlabelCreated;
	private JLabel jlabelImage;
	private JLabel jlabelEmployeeName_1;
	private JLabel jlabelTitle;
	private JLabel jlabelProject_1;
	private JLabel jlabelLocation_1;
	private JLabel jlabelDepartment_1;
	private JComboBox jcomboBoxLocation;
	private JComboBox jcomboBoxDepartment;
	private JComboBox jcomboBoxProject;
	private JDateChooser jdateChooserCreated;
	private JButton jbuttonSearch;

	/**
	 * Create the panel.
	 */
	public JPanelTransfer() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		scrollPane.setBounds(10, 392, 1060, 348);
		add(scrollPane);
		
		jtableTransfer = new JTable();
		
		jtableTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableTransfer_mouseClicked(e);
			}
		});
		jtableTransfer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableTransfer.setFont(new Font("SansSerif", Font.PLAIN, 12));
		scrollPane.setViewportView(jtableTransfer);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Request ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 190, 1060, 113);
		add(panel);
		panel.setLayout(null);
		
		jlabelEmployeeId = new JLabel("...");
		jlabelEmployeeId.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelEmployeeId.setForeground(new Color(0, 139, 139));
		jlabelEmployeeId.setBounds(149, 21, 163, 34);
		panel.add(jlabelEmployeeId);
		
		JLabel lblNewLabel = new JLabel("EmployeeID :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 19, 103, 34);
		panel.add(lblNewLabel);
		
		JLabel lblEmployeeName = new JLabel("Employee name :");
		lblEmployeeName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmployeeName.setBounds(24, 65, 124, 34);
		panel.add(lblEmployeeName);
		
		jlabelEmployeeName = new JLabel("...");
		jlabelEmployeeName.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelEmployeeName.setForeground(new Color(0, 139, 139));
		jlabelEmployeeName.setBounds(149, 66, 157, 34);
		panel.add(jlabelEmployeeName);
		
		JLabel lblLocation = new JLabel("To Location :");
		lblLocation.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLocation.setBounds(318, 21, 103, 34);
		panel.add(lblLocation);
		
		jlabelLocation = new JLabel("...");
		jlabelLocation.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelLocation.setForeground(new Color(0, 139, 139));
		jlabelLocation.setBounds(437, 21, 161, 34);
		panel.add(jlabelLocation);
		
		JLabel lblDepartment = new JLabel("To Department");
		lblDepartment.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDepartment.setBounds(318, 67, 103, 34);
		panel.add(lblDepartment);
		
		jlabelDepartment = new JLabel("...");
		jlabelDepartment.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelDepartment.setForeground(new Color(0, 139, 139));
		jlabelDepartment.setBounds(437, 67, 157, 34);
		panel.add(jlabelDepartment);
		
		JLabel lblProject = new JLabel("To Project :");
		lblProject.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProject.setBounds(606, 19, 84, 34);
		panel.add(lblProject);
		
		jlabelProject = new JLabel("...");
		jlabelProject.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelProject.setForeground(new Color(0, 139, 139));
		jlabelProject.setBounds(694, 19, 137, 34);
		panel.add(jlabelProject);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblStatus.setBounds(606, 65, 70, 34);
		panel.add(lblStatus);
		
		jlabelStatus = new JLabel("...");
		jlabelStatus.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelStatus.setBounds(672, 67, 124, 34);
		panel.add(jlabelStatus);
		
		jbtnAccept = new JButton("Accept");
		jbtnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnAccept_actionPerformed(e);
			}
		});
		jbtnAccept.setEnabled(false);
		jbtnAccept.setForeground(Color.WHITE);
		jbtnAccept.setBackground(new Color(0, 139, 139));
		jbtnAccept.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnAccept.setBounds(843, 68, 83, 31);
		panel.add(jbtnAccept);
		
		jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnCancel_actionPerformed(e);
			}
		});
		jbtnCancel.setEnabled(false);
		jbtnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		jbtnCancel.setBounds(938, 68, 83, 31);
		panel.add(jbtnCancel);
		
		JLabel lblCreated = new JLabel("Created :");
		lblCreated.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCreated.setBounds(843, 20, 70, 34);
		panel.add(lblCreated);
		
		jlabelCreated = new JLabel("...");
		jlabelCreated.setForeground(new Color(0, 139, 139));
		jlabelCreated.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelCreated.setBounds(930, 20, 124, 34);
		panel.add(jlabelCreated);
		
		jtextFieldEmployeeID = new JTextField();
		jtextFieldEmployeeID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jtextFieldEmployeeID_keyReleased(e) ;
				
			}
		});
		jtextFieldEmployeeID.setBounds(6, 346, 126, 34);
		add(jtextFieldEmployeeID);
		jtextFieldEmployeeID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(6, 312, 126, 34);
		add(lblNewLabel_1);
		
		jcomboBoxStatus = new JComboBox();
		jcomboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxStatus_actionPerformed(e);
			}
		});
		jcomboBoxStatus.setFont(new Font("SansSerif", Font.BOLD, 14));
		jcomboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Pending", "Resoved", "Cancelled"}));
		jcomboBoxStatus.setBounds(869, 346, 145, 34);
		add(jcomboBoxStatus);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Status");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(869, 317, 144, 34);
		add(lblNewLabel_1_1_1);
		
		JButton jbuttonRefesh = new JButton("");
		jbuttonRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		jbuttonRefesh.setIcon(new ImageIcon(JPanelTransfer.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		jbuttonRefesh.setBackground(new Color(0, 139, 139));
		jbuttonRefesh.setSelectedIcon(new ImageIcon(JPanelTransfer.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		jbuttonRefesh.setBounds(1018, 346, 52, 34);
		add(jbuttonRefesh);
		
		JLabel lblNewLabel_2_2 = new JLabel("Transfer Request ");
		lblNewLabel_2_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(10, 6, 267, 28);
		add(lblNewLabel_2_2);
		
		jcomboBoxLocation = new JComboBox();
		jcomboBoxLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxLocation_actionPerformed(e);
			}
		});
		jcomboBoxLocation.setBounds(144, 346, 153, 34);
		add(jcomboBoxLocation);
		
		JLabel lblNewLabel_1_1 = new JLabel("Location");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(144, 312, 126, 34);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Department");
		lblNewLabel_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(324, 312, 126, 34);
		add(lblNewLabel_1_1_2);
		
		jcomboBoxDepartment = new JComboBox();
		jcomboBoxDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxDepartment_actionPerformed(e);
			}
		});
		jcomboBoxDepartment.setBounds(324, 346, 153, 34);
		add(jcomboBoxDepartment);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Project");
		lblNewLabel_1_1_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(499, 312, 126, 34);
		add(lblNewLabel_1_1_3);
		
		jcomboBoxProject = new JComboBox();
		jcomboBoxProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxProject_actionPerformed(e);
			}
		});
		jcomboBoxProject.setBounds(499, 346, 153, 34);
		add(jcomboBoxProject);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Created");
		lblNewLabel_1_1_3_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1_1_3_1.setBounds(664, 312, 126, 34);
		add(lblNewLabel_1_1_3_1);
		
		jdateChooserCreated = new JDateChooser();
		jdateChooserCreated.setBounds(664, 346, 145, 34);
		add(jdateChooserCreated);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Present", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 59, 1060, 119);
		add(panel_1);
		
		JLabel lblLocation_1 = new JLabel("Location :");
		lblLocation_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLocation_1.setBounds(497, 19, 103, 34);
		panel_1.add(lblLocation_1);
		
		jlabelLocation_1 = new JLabel("...");
		jlabelLocation_1.setForeground(Color.DARK_GRAY);
		jlabelLocation_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelLocation_1.setBounds(623, 21, 167, 34);
		panel_1.add(jlabelLocation_1);
		
		JLabel lblDepartment_1 = new JLabel("Department :");
		lblDepartment_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDepartment_1.setBounds(497, 66, 103, 34);
		panel_1.add(lblDepartment_1);
		
		jlabelDepartment_1 = new JLabel("...");
		jlabelDepartment_1.setForeground(Color.DARK_GRAY);
		jlabelDepartment_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelDepartment_1.setBounds(623, 66, 167, 34);
		panel_1.add(jlabelDepartment_1);
		
		JLabel lblProject_1 = new JLabel("Project :");
		lblProject_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProject_1.setBounds(816, 19, 70, 34);
		panel_1.add(lblProject_1);
		
		jlabelProject_1 = new JLabel("...");
		jlabelProject_1.setForeground(Color.DARK_GRAY);
		jlabelProject_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelProject_1.setBounds(903, 19, 124, 34);
		panel_1.add(jlabelProject_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(60, 18, 82, 81);
		panel_1.add(panel_1_1);
		
		jlabelImage = new JLabel("");
		jlabelImage.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelImage.setBounds(11, 10, 60, 60);
		panel_1_1.add(jlabelImage);
		
		JLabel lblEmployeeName_1 = new JLabel("Employee name :");
		lblEmployeeName_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmployeeName_1.setBounds(181, 18, 124, 34);
		panel_1.add(lblEmployeeName_1);
		
		jlabelEmployeeName_1 = new JLabel("...");
		jlabelEmployeeName_1.setBackground(Color.DARK_GRAY);
		jlabelEmployeeName_1.setForeground(Color.DARK_GRAY);
		jlabelEmployeeName_1.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelEmployeeName_1.setBounds(317, 18, 141, 34);
		panel_1.add(jlabelEmployeeName_1);
		
		JLabel lblEmployeeTitle = new JLabel("Title :");
		lblEmployeeTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmployeeTitle.setBounds(181, 66, 124, 34);
		panel_1.add(lblEmployeeTitle);
		
		jlabelTitle = new JLabel("...");
		jlabelTitle.setForeground(Color.DARK_GRAY);
		jlabelTitle.setFont(new Font("Microsoft Tai Le", Font.BOLD, 14));
		jlabelTitle.setBounds(317, 66, 141, 34);
		panel_1.add(jlabelTitle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(469, 6, 601, 41);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Request Pending :");
		lblNewLabel_2.setBounds(20, 6, 134, 28);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		
		jlabelStatusPending = new JLabel("0");
		jlabelStatusPending.setBounds(166, 6, 29, 28);
		panel_2.add(jlabelStatusPending);
		jlabelStatusPending.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("Request Resoved :");
		lblNewLabel_2_1.setBounds(207, 6, 134, 28);
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelStatusResoved = new JLabel("0");
		jlabelStatusResoved.setBounds(353, 6, 29, 28);
		panel_2.add(jlabelStatusResoved);
		jlabelStatusResoved.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Request cancelled :");
		lblNewLabel_2_1_1.setBounds(412, 6, 153, 28);
		panel_2.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_2_1_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jlabelStatusCancelled = new JLabel("0");
		jlabelStatusCancelled.setBounds(566, 6, 29, 28);
		panel_2.add(jlabelStatusCancelled);
		jlabelStatusCancelled.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		jbuttonSearch = new JButton("");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setIcon(new ImageIcon(JPanelTransfer.class.getResource("/resources/search_24px.png")));
		jbuttonSearch.setBackground(new Color(0, 139, 139));
		jbuttonSearch.setBounds(815, 346, 52, 34);
		add(jbuttonSearch);
		loadData();
	}
	
	private void loadData() {
		loadLocation();
		loadDepartment();
		loadProject();
		TransferModel transferModel = new TransferModel();
		fillDatatoJTable(transferModel.findAll());
		loadStatus();
	}
	
	// load combobox
		// Combobox Title
			
			// Combobox location
			private void loadLocation() {
				LocationModel locationModel = new LocationModel();
				List<Location> locations = locationModel.findAll();
				if (locations != null) {
					DefaultComboBoxModel<Location> comboBoxModelLocations = new DefaultComboBoxModel<Location>();
					for (Location location : locations) {
						comboBoxModelLocations.addElement(location);
					}
					jcomboBoxLocation.setModel(comboBoxModelLocations);
					jcomboBoxLocation.setRenderer(new LocationCellRender());
				}

			}

			private class LocationCellRender extends DefaultListCellRenderer {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
						boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Location location = (Location) value;
					return super.getListCellRendererComponent(list, location.getLocationName(), index, isSelected,
							cellHasFocus);
				}
			}

			// Combobox department
			private void loadDepartment() {
				DepamentModel depamentModel = new DepamentModel();
				List<Department> departments = depamentModel.findAll();
				if (departments != null) {
					DefaultComboBoxModel<Department> comboBoxModelDepartment = new DefaultComboBoxModel<Department>();
					for (Department department : departments) {
						comboBoxModelDepartment.addElement(department);
					}
					jcomboBoxDepartment.setModel(comboBoxModelDepartment);
					jcomboBoxDepartment.setRenderer(new DepartmentCellRender());
				} else {
					System.out.println("haiz");
				}

			}

			private class DepartmentCellRender extends DefaultListCellRenderer {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
						boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Department department = (Department) value;
					return super.getListCellRendererComponent(list, department.getDepamentName(), index, isSelected,
							cellHasFocus);
				}
			}

			// Combobox project
			private void loadProject() {
				ProjectModel projectModel = new ProjectModel();
				List<Project> projects = projectModel.findAll();
				if (projects != null) {
					DefaultComboBoxModel<Project> comboBoxModelProjects = new DefaultComboBoxModel<Project>();
					for (Project project : projects) {
						comboBoxModelProjects.addElement(project);
					}
					jcomboBoxProject.setModel(comboBoxModelProjects);
					jcomboBoxProject.setRenderer(new ProjectCellRender());
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
	 // combobox status
	private void loadStatus() {
		TransferModel transferModel = new TransferModel();
		if(transferModel.searchByStatus(1)!=null) {
			
			jlabelStatusPending.setText(String.valueOf(transferModel.searchByStatus(1).size()));
		}else {
			jlabelStatusPending.setText("0");
		}
		if(transferModel.searchByStatus(2)!=null) {
			jlabelStatusResoved.setText(String.valueOf(transferModel.searchByStatus(2).size()));
		}else {
			jlabelStatusResoved.setText("0");
		}
		if(transferModel.searchByStatus(0)!=null) {
			jlabelStatusCancelled.setText(String.valueOf(transferModel.searchByStatus(0).size()));
		}else {
			jlabelStatusCancelled.setText("0");
		}
	}
	
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
			jtableTransfer.setModel(defaultTableModel);
		}catch (Exception e) {
			e.getMessage();
		}
	}

	public void jtableTransfer_mouseClicked(MouseEvent e) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			jbtnCancel.setEnabled(false);
			jbtnAccept.setEnabled(false);
			jlabelStatus.setForeground(Color.black);
			int selectedRow = jtableTransfer.getSelectedRow();
			int id = Integer.parseInt(jtableTransfer.getValueAt(selectedRow, 0).toString());
			System.out.print("id: " + id);
			TransferModel transferModel = new TransferModel();
			if(transferModel.findById(id)!=null) {
				transfer = transferModel.findById(id);
				EmployeeModel employeeModel = new EmployeeModel();
				LocationModel locationModel = new LocationModel();
				DepamentModel depamentModel = new DepamentModel();
				ProjectModel projectModel = new ProjectModel();
				Employee employee = employeeModel.findById(transfer.getEmployee_id());
				Location location = locationModel.findById(transfer.getLocation_id());
				Department department = depamentModel.findById(transfer.getDepartment_id());
				Project project = projectModel.findById(transfer.getProject_id());
				// Customer employee 
				CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
				if(customEmployeeModel.findById(transfer.getEmployee_id())!=null) {
					EmployeeCustom employeeCustom = customEmployeeModel.findById(transfer.getEmployee_id());
					if(employeeCustom.getEmployee()!=null) {
						jlabelEmployeeName_1.setText(employeeCustom.getEmployee().getName());
					}
					if(employeeCustom.getLocation()!=null) {
						jlabelLocation_1.setText(employeeCustom.getLocation().getLocationName());
					}
					if(employeeCustom.getDepament()!=null) {
						jlabelDepartment_1.setText(employeeCustom.getDepament().getDepamentName());
					}
					if(employeeCustom.getProject()!=null) {
						jlabelProject_1.setText(employeeCustom.getProject().getProjectName());
					}
				}
				// load title
				TitlesModel titlesModel = new TitlesModel();
				Titles title = titlesModel.findById(employee.getTitleId());
				if(title !=null) {
					jlabelTitle.setText(title.getTitle_name());
				}
				
				jlabelEmployeeId.setText(String.valueOf(employee.getEmployeeId()));
				jlabelEmployeeName.setText(employee.getName());
				jlabelLocation.setText(location.getLocationName());
				jlabelDepartment.setText(department.getDepamentName());
				jlabelProject.setText(project.getProjectName());
				jlabelCreated.setText(simpleDateFormat.format(transfer.getCreated()));
				jlabelImage.setIcon(new ImageIcon(new ImageIcon(employee.getImage()).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
				if(transfer.getStatus() == 1) {
					jlabelStatus.setText("Pending"); 
					jlabelStatus.setForeground(new Color(65,105,255));
					jbtnCancel.setEnabled(true);
					jbtnAccept.setEnabled(true);
				}else if(transfer.getStatus() == 2){
					jlabelStatus.setText("Resoved"); 
					jlabelStatus.setForeground(new Color(0,128,0));
				}else {
					jlabelStatus.setText("Cancelled"); 
					jlabelStatus.setForeground(new Color(220,20,60));
				}
			}
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

	}
	
	// jbuton accept
	public void jbtnAccept_actionPerformed(ActionEvent e) {
		boolean reusltEmpLocation = false;
		boolean reusltEmpDepartment = false;
		boolean reusltEmpProject = false;
		try {
			int respone = JOptionPane.showConfirmDialog(null,"Do you want to accept? ","Accept",JOptionPane.YES_NO_OPTION );
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
							loadData();
							JOptionPane.showMessageDialog(null, "Success !!!");
							if(transfer.getStatus() == 1) {
								jlabelStatus.setText("Pending"); 
								jlabelStatus.setForeground(new Color(65,105,255));
								jbtnCancel.setEnabled(true);
								jbtnAccept.setEnabled(true);
							}else if(transfer.getStatus() == 2){
								jlabelStatus.setText("Resoved"); 
								jlabelStatus.setForeground(new Color(0,128,0));
								jbtnAccept.setEnabled(false);
								jbtnCancel.setEnabled(false);
							}else {
								jlabelStatus.setText("Cancelled"); 
								jlabelStatus.setForeground(new Color(220,20,60));
								jbtnAccept.setEnabled(false);
								jbtnCancel.setEnabled(false);
							}
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
		int respone = JOptionPane.showConfirmDialog(null,"Do you want to cancel? ","Cancel",JOptionPane.YES_NO_OPTION );
		if(respone == JOptionPane.YES_OPTION) {
			Transfer transfer = this.transfer;
			TransferModel transferModel = new TransferModel();
			transfer.setProcessing_date(new Date());
			transfer.setStatus(0);
			if(transferModel.update(transfer)) {
				loadData();
				JOptionPane.showMessageDialog(null, "Cancel successfully !");
			}else {
				JOptionPane.showMessageDialog(null, "Error !");
			}
		}
	}
	
	
	
	
	// action keyReleased EmployeeID
	public void jtextFieldEmployeeID_keyReleased(KeyEvent e) {
		char c = e.getKeyChar();
		if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE )) {
			e.consume();
		}
		TransferModel transferModel = new TransferModel();
		if(jtextFieldEmployeeID.getText().isEmpty()) {
			fillDatatoJTable(transferModel.findAll());
		}else {
			int employeeId = Integer.parseInt(jtextFieldEmployeeID.getText());
			if(jtextFieldEmployeeID.getText() != "") {
				List<Transfer> transfers = transferModel.searchByEmployeeId(employeeId);
				System.out.println(transfers);
				if(transfers!=null) {
					fillDatatoJTable(transfers);
				}
				
			}
		}
	}
	public void jcomboBoxStatus_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		if(jcomboBoxStatus.getSelectedItem()!=null) {
			if(String.valueOf(jcomboBoxStatus.getSelectedItem())=="Pending") {
				System.out.println("pending");
				fillDatatoJTable(transferModel.searchByStatus(1));
			}else if(String.valueOf(jcomboBoxStatus.getSelectedItem())=="Resoved") {
				System.out.println("Resoved");
				fillDatatoJTable(transferModel.searchByStatus(2));
			}else if(String.valueOf(jcomboBoxStatus.getSelectedItem())=="Cancelled") {
				System.out.println("Cancelled");
				fillDatatoJTable(transferModel.searchByStatus(0));
			}
		}
	}
	
	public void jcomboBoxLocation_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Location location = (Location) jcomboBoxLocation.getSelectedItem();
		if(transferModel.searchByLocationId(location.getLocationId())!=null) {
			fillDatatoJTable(transferModel.searchByLocationId(location.getLocationId()));
		}
	}
	
	public void jcomboBoxDepartment_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Department department = (Department) jcomboBoxDepartment.getSelectedItem();
		if(transferModel.searchByDepartmentId(department.getDepamentId())!=null) {
			fillDatatoJTable(transferModel.searchByDepartmentId(department.getDepamentId()));
		}
	}
	
	public void jcomboBoxProject_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Project project = (Project) jcomboBoxProject.getSelectedItem();
		if(transferModel.searchByProjectId(project.getProjectId())!=null) {
			fillDatatoJTable(transferModel.searchByProjectId(project.getProjectId()));
		}
	}
	
	
	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		TransferModel transferModel = new TransferModel();
		Date date = jdateChooserCreated.getDate();
		System.out.println(date);
		if(transferModel.searchByCreated(date)!=null) {
			fillDatatoJTable(transferModel.searchByCreated(date));
		}
	}
}
