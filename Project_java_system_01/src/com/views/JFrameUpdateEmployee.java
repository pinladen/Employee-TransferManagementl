package com.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.check.CheckValidate;
import com.entities.Department;
import com.entities.EmpLocation;
import com.entities.EmpProject;
import com.entities.Empdepartment;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.models.CustomEmployeeModel;
import com.models.DepamentModel;
import com.models.EmpDepamentModel;
import com.models.EmpLocationModel;
import com.models.EmpProjectModel;
import com.models.EmployeeModel;
import com.models.FileTypeFilter;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.models.TitlesModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameUpdateEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldName;
	private JTextField jtextFieldPhone;
	private JTextField jtextFieldEmail;
	private JComboBox jcomboBoxLocation;
	private JComboBox jcomboBoxdepartment;
	private JComboBox jcomboBoxProject;
	private File file;
	private JLabel jlabelImage;
	private JDateChooser jdateChooserBirthday;
	private JComboBox jcomboBoxGender;
	private Map<String, Object> data;
	private Employee employee;
	private JComboBox jcomboBoxTitles;
	private JLabel jlabelLocation;
	private JLabel jlabelDepartment;
	private JLabel jlabelProject;
	private JCheckBox jcheckboxLocation;
	private JCheckBox jcheckboxDepartment;
	private JCheckBox jcheckboxProject;
	private JCheckBox jcheckboxTitle;
	private JLabel jlabelTitle;
	private EmployeeCustom employeeCustom;
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
					JFrameUpdateEmployee frame = new JFrameUpdateEmployee();
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
	public JFrameUpdateEmployee() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameUpdateEmployee.class.getResource("/resources/icons8_add_user_group_man_woman_24px.png")));
		setTitle("Update Empployee");
		setBackground(new Color(0, 191, 255));
		setBounds(100, 100, 974, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 9, 1, (Color) new Color(64, 64, 64)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 40, 968, 637);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1_1.setBounds(-15, 566, 1023, 1);
		panel.add(panel_1_1_1);
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.setForeground(Color.WHITE);
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser("C:\\Users\\ducga\\OneDrive\\Desktop\\images");
				jFileChooser.setDialogTitle("Please select a photo");
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("png, jpg, jpeg, gif, bmp", "png", "jpg", "jpeg", "gif", "bmp"));
				
				jFileChooser.setFileFilter(new FileTypeFilter(".gif","GIF"));
				jFileChooser.setFileFilter(new FileTypeFilter(".png","PNG"));
				jFileChooser.setMultiSelectionEnabled(false);
				int result =jFileChooser.showOpenDialog(null);
				if(result == jFileChooser.APPROVE_OPTION) {
					file = jFileChooser.getSelectedFile();
					jlabelImage.setText("");
					jlabelImage.setIcon(new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
				}
			}
		});
		btnChooseFile.setIcon(new ImageIcon(JFrameUpdateEmployee.class.getResource("/resources/icons8_open_in_browser_24px.png")));
		btnChooseFile.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnChooseFile.setBackground(new Color(0, 139, 139));
		btnChooseFile.setBounds(636, 394, 168, 33);
		panel.add(btnChooseFile);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaveActionPerformed(e);
			}
		});
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSave.setBackground(new Color(0, 139, 139));
		btnSave.setBounds(809, 579, 128, 33);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(669, 579, 128, 33);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("Update Employee");
		lblNewLabel_2.setIcon(null);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(27, 41, 168, 26);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Infomation", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_2.setBounds(64, 92, 295, 394);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(21, 50, 91, 26);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(105, 50, 168, 26);
		panel_2.add(jtextFieldName);
		jtextFieldName.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(21, 102, 91, 26);
		panel_2.add(lblBirthday);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jdateChooserBirthday = new JDateChooser();
		jdateChooserBirthday.setBackground(new Color(0, 139, 139));
		jdateChooserBirthday.getCalendarButton().setBackground(new Color(0, 128, 128));
		jdateChooserBirthday.setBounds(105, 102, 168, 26);
		panel_2.add(jdateChooserBirthday);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(21, 152, 91, 26);
		panel_2.add(lblPhone);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setBounds(105, 152, 168, 26);
		panel_2.add(jtextFieldPhone);
		jtextFieldPhone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 200, 91, 26);
		panel_2.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jtextFieldEmail = new JTextField();
		jtextFieldEmail.setBounds(105, 200, 168, 26);
		panel_2.add(jtextFieldEmail);
		jtextFieldEmail.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(21, 249, 91, 26);
		panel_2.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jcomboBoxGender = new JComboBox();
		jcomboBoxGender.setForeground(new Color(255, 255, 255));
		jcomboBoxGender.setBackground(new Color(169, 169, 169));
		jcomboBoxGender.setBounds(105, 249, 168, 26);
		panel_2.add(jcomboBoxGender);
		jcomboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(21, 304, 91, 26);
		panel_2.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jcomboBoxTitles = new JComboBox();
		jcomboBoxTitles.setBackground(new Color(0, 139, 139));
		jcomboBoxTitles.setBounds(102, 343, 149, 26);
		panel_2.add(jcomboBoxTitles);
		
		jcheckboxTitle = new JCheckBox("");
		jcheckboxTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcheckboxTitle.isSelected()) {
					jcomboBoxTitles.enable(true);
				}else {
					jcomboBoxTitles.enable(false);
				}
			}
		});
		jcheckboxTitle.setBounds(83, 347, 27, 18);
		panel_2.add(jcheckboxTitle);
		
		jlabelTitle = new JLabel("...");
		jlabelTitle.setBounds(105, 309, 155, 18);
		panel_2.add(jlabelTitle);
		
		JPanel panelCompany = new JPanel();
		panelCompany.setBorder(new TitledBorder(null, "Company", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panelCompany.setBackground(Color.WHITE);
		panelCompany.setBounds(402, 92, 535, 175);
		panel.add(panelCompany);
		panelCompany.setLayout(null);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(30, 33, 91, 26);
		panelCompany.add(lblLocation);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jcomboBoxLocation = new JComboBox();
		jcomboBoxLocation.setEnabled(false);
		jcomboBoxLocation.setBounds(331, 33, 168, 26);
		panelCompany.add(jcomboBoxLocation);
		
		JLabel lblDepament = new JLabel("Department");
		lblDepament.setBounds(30, 71, 91, 26);
		panelCompany.add(lblDepament);
		lblDepament.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jcomboBoxdepartment = new JComboBox();
		jcomboBoxdepartment.setEnabled(false);
		jcomboBoxdepartment.setBounds(331, 69, 168, 26);
		panelCompany.add(jcomboBoxdepartment);
		
		JLabel lblProject = new JLabel("Project");
		lblProject.setBounds(30, 105, 91, 26);
		panelCompany.add(lblProject);
		lblProject.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		jcomboBoxProject = new JComboBox();
		jcomboBoxProject.setEnabled(false);
		jcomboBoxProject.setBounds(331, 105, 168, 26);
		panelCompany.add(jcomboBoxProject);
		
		jcheckboxLocation = new JCheckBox("");
		jcheckboxLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jcheckboxLocation.isSelected()) {
					jcomboBoxLocation.enable(true);
				}else {
					jcomboBoxLocation.enable(false);
				}
			}
		});
		jcheckboxLocation.setBounds(301, 37, 28, 18);
		panelCompany.add(jcheckboxLocation);
		
		jcheckboxDepartment = new JCheckBox("");
		jcheckboxDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcheckboxDepartment.isSelected()) {
					jcomboBoxdepartment.enable(true);
				}else {
					jcomboBoxdepartment.enable(false);
				}
			}
		});
		jcheckboxDepartment.setBounds(301, 73, 43, 18);
		panelCompany.add(jcheckboxDepartment);
		
		jcheckboxProject = new JCheckBox("");
		jcheckboxProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcheckboxProject.isSelected()) {
					jcomboBoxProject.enable(true);
				}else {
					jcomboBoxProject.enable(false);
				}
			}
		});
		jcheckboxProject.setBounds(301, 109, 43, 18);
		panelCompany.add(jcheckboxProject);
		
		jlabelLocation = new JLabel("...");
		jlabelLocation.setBounds(133, 37, 155, 18);
		panelCompany.add(jlabelLocation);
		
		jlabelDepartment = new JLabel("...");
		jlabelDepartment.setBounds(133, 75, 155, 18);
		panelCompany.add(jlabelDepartment);
		
		jlabelProject = new JLabel("...");
		jlabelProject.setBounds(133, 109, 155, 18);
		panelCompany.add(jlabelProject);
		
		JLabel lblNewLabel_1 = new JLabel("Check to change !");
		lblNewLabel_1.setBounds(301, 137, 228, 26);
		panelCompany.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(null, "Image", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_3.setBounds(412, 279, 198, 207);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		jlabelImage = new JLabel("No Image");
		jlabelImage.setBounds(16, 20, 168, 169);
		panel_3.add(jlabelImage);
		jlabelImage.setBackground(Color.WHITE);
		jlabelImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelImage.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
	//---------------------------------------------------------------------------------------------------------------
	

		public JFrameUpdateEmployee(Map<String, Object> data) {
			
			this();
			System.out.println(data);
			this.data = data;
			loadData();
			
		}
	// loadData
	private void loadData() {
		EmployeeCustom employeeCustom = (EmployeeCustom) data.get("employeeCustom");
		
		if(employeeCustom != null) {
			this.employee = employeeCustom.getEmployee();
			loadEmployee(employeeCustom.getEmployee());
			loadLocation(employeeCustom.getLocation());
			loadDepartment(employeeCustom.getDepament());
			loadProject(employeeCustom.getProject());
		}
		// Loading combobox
		loadTitle() ;
		loadLocation();
		loadDepartment();
		loadProject();
	}
	
	private void loadEmployee(Employee employee) {
		try {
			if(employee !=null) {
				this.employee = employee;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				jtextFieldName.setText(employee.getName());
				jtextFieldEmail.setText(employee.getEmail());
				jtextFieldPhone.setText(employee.getPhone());
				jdateChooserBirthday.setDate(employee.getDob());
				jlabelImage.setIcon(new ImageIcon(new ImageIcon(employee.getImage()).getImage().getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
				jlabelImage.setText("");
				TitlesModel titlesModel = new TitlesModel();
				if(titlesModel.findById(employee.getTitleId())!=null) {
					Titles title = titlesModel.findById(employee.getTitleId());
					jlabelTitle.setText(title.getTitle_name());
				}
				
				jdateChooserBirthday.setDate(employee.getDob());
				
				
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
	
	
	
	// Combobox Title
	private void loadTitle() {
		TitlesModel titlesModel = new TitlesModel();
		List<Titles> titles = titlesModel.findAll();
		if(titles !=null) {
			DefaultComboBoxModel<Titles> comboBoxModelTitles = new DefaultComboBoxModel<Titles>();
			System.out.println(titles.toString());
			for(Titles title : titles) {
				comboBoxModelTitles.addElement(title);
			}
			jcomboBoxTitles.setModel(comboBoxModelTitles);
			jcomboBoxTitles.setRenderer(new TitleCellRender());
		}
		
	}
	
	private class TitleCellRender extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Titles title = (Titles) value;
			return super.getListCellRendererComponent(list, title.getTitle_name(), index, isSelected, cellHasFocus);
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
			jcomboBoxdepartment.setModel(comboBoxModelDepartment);
			jcomboBoxdepartment.setRenderer(new DepartmentCellRender());
		}else {
			System.out.println("haiz");
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
		
		
		//-----------------------------------------------------------------------------------------------
		// Action
		// - Button save
		public void btnSaveActionPerformed(ActionEvent e) {
			try {
				CheckValidate checkValidate = new CheckValidate();
				// Validate
				// I. Check name is not null
				if(jtextFieldName.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Name is not null");
				}else {
					// Check name > 2
					if(checkValidate.checkName(jtextFieldName.getText())) {
						// Check age > 18
						if(checkValidate.checkDate(jdateChooserBirthday.getDate())) {
							// Check phone not null
							if(jtextFieldPhone.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Phone cannot be null");
							}else {
								// Check phone number and lenght
								if(checkValidate.checkPhone(jtextFieldPhone.getText())) {
									// Check mail not null
									if(jtextFieldEmail.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "Email cannot be null");
									}else {
										// Check mail 
										if(checkValidate.checkEmail(jtextFieldEmail.getText())) {
											//----------------------------
											//Update employee
											EmployeeModel employeeModel = new EmployeeModel();
											int respone = JOptionPane.showConfirmDialog(null,"Do you want to save ?","Save",JOptionPane.YES_NO_OPTION );
											if(respone == JOptionPane.YES_OPTION) {
												Employee employee = this.employee;
												employee.setName(jtextFieldName.getText());
												employee.setDob(jdateChooserBirthday.getDate());
												employee.setEmail(jtextFieldEmail.getText());
												employee.setPhone(jtextFieldPhone.getText());
												employee.setGender(jcomboBoxGender.getSelectedItem().toString());
												if(file !=null) {
													employee.setImage(ConvertFile(file.getAbsolutePath()));
												}
												if(jcheckboxTitle.isSelected()) {
													Titles title = (Titles) jcomboBoxTitles.getSelectedItem();
													employee.setTitleId(title.getTitle_id());
												}
												if(employeeModel.update(employee)) {
													JOptionPane.showMessageDialog(null, "Update Success !!!");
												}else {
													JOptionPane.showMessageDialog(null, "Faild !!!");
												}
												
												// Update empLocation
												if(jcheckboxLocation.isSelected()) {
													Location location =(Location) jcomboBoxLocation.getSelectedItem();
													EmpLocationModel empLocationModel = new EmpLocationModel();
													EmpLocation ep1 = empLocationModel.findById(employee.getEmployeeId());
													if(ep1!=null) {
														if(ep1.getLocationId() != location.getLocationId()) {
														   	empLocationModel.create(new EmpLocation(null,employee.getEmployeeId(),location.getLocationId(),new Date(),null,null));
														}
													}else {
														empLocationModel.create(new EmpLocation(null,employee.getEmployeeId(),location.getLocationId(),new Date(),null,null));
													}
												}
												
												// Update empDepartment
												if(jcheckboxDepartment.isSelected()) {
													
													Department department =(Department) jcomboBoxdepartment.getSelectedItem();
													EmpDepamentModel depamentModel = new EmpDepamentModel();
													Empdepartment ep2 = depamentModel.findById(employee.getEmployeeId());
													if(ep2!=null) {
														if(ep2.getDepartmentId() != department.getDepamentId()) {
															depamentModel.create(new Empdepartment(null,employee.getEmployeeId(),department.getDepamentId(),new Date(),null,null));
														}
													}else {
														depamentModel.create(new Empdepartment(null,employee.getEmployeeId(),department.getDepamentId(),new Date(),null,null));
													}
												}
												
												// Update empProject
												if(jcheckboxProject.isSelected()) {
													Project project =(Project) jcomboBoxProject.getSelectedItem();
													EmpProjectModel empProjectModel = new EmpProjectModel();
													EmpProject ep3 = empProjectModel.findById(employee.getEmployeeId());
													if(ep3!=null) {
														if(ep3.getProjectId() != project.getProjectId()) {
															empProjectModel.create(new EmpProject(null,employee.getEmployeeId(),project.getProjectId(),new Date(),null,null));
														}
													}else {
														empProjectModel.create(new EmpProject(null,employee.getEmployeeId(),project.getProjectId(),new Date(),null,null));
													}
												}
											}
											
											CustomEmployeeModel customEmployeeModel = new CustomEmployeeModel();
											Map<String, Object> data = new  HashMap<String, Object>();
											if(customEmployeeModel.findById(employee.getEmployeeId())!=null) {
												data.put("employeeCustom",customEmployeeModel.findById(employee.getEmployeeId()) );
												JFrameDetailEmployee frameDetailEmployee = new JFrameDetailEmployee(data);
												frameDetailEmployee.setVisible(true);
												this.setVisible(false);
											}									
										}else {
											JOptionPane.showMessageDialog(null, "Invalid email");
										}
									}
								}else {
									JOptionPane.showMessageDialog(null, "Invalid phone number");
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "Age must be 18");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Name should be between 2 and 30 characters long ");
					}
					
				}
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		
		// - button cancel
		public void btnCancel_actionPerformed(ActionEvent e) {
			int respone = JOptionPane.showConfirmDialog(null,"Do you want to cancel ?","Cancel",JOptionPane.YES_NO_OPTION );
			if(respone == JOptionPane.YES_OPTION) {
				this.setVisible(false);
			}
			
		}
}
