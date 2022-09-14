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
import com.entities.Employee;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.models.DepamentModel;
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
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;

public class JFrameAddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldName;
	private JTextField jtextFieldPhone;
	private JTextField jtextFieldEmail;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordFieldPassword;
	private JComboBox jcomboBoxTitle;
	private JComboBox jcomboBoxLocation;
	private JComboBox jcomboBoxdepartment;
	private JComboBox jcomboBoxProject;
	private File file;
	private JLabel jlabelImage;
	private JDateChooser jdateChooserBirthday;
	private JComboBox jcomboBoxGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

			UIManager.getDefaults().put("Table.alternateRowColor", new Color(240, 248, 255));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAddEmployee frame = new JFrameAddEmployee();
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
	public JFrameAddEmployee() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(JFrameAddEmployee.class.getResource("/resources/icons8_add_user_group_man_woman_24px.png")));
		setTitle("New Empployee");
		setBackground(new Color(0, 191, 255));
		setBounds(100, 100, 911, 745);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 10, 0, (Color) Color.DARK_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 44, 905, 637);
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
				try {
					JFileChooser jFileChooser = new JFileChooser("C:\\Users\\ducga\\OneDrive\\Desktop\\images");
					jFileChooser.setDialogTitle("Please select a photo");
					jFileChooser.addChoosableFileFilter(
							new FileNameExtensionFilter("png, jpg, jpeg, gif, bmp", "png", "jpg", "jpeg", "gif", "bmp"));

					jFileChooser.setFileFilter(new FileTypeFilter(".gif", "GIF"));
					jFileChooser.setFileFilter(new FileTypeFilter(".png", "PNG"));
					jFileChooser.setMultiSelectionEnabled(false);
					int result = jFileChooser.showOpenDialog(null);
					if (result == jFileChooser.APPROVE_OPTION) {
						file = jFileChooser.getSelectedFile();
						jlabelImage.setText("");
						jlabelImage.setIcon(new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
								.getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
					}
				}catch (Exception ea) {
					System.out.println(ea.getMessage());
				}
				
			}
		});
		btnChooseFile.setIcon(
				new ImageIcon(JFrameAddEmployee.class.getResource("/resources/icons8_open_in_browser_24px.png")));
		btnChooseFile.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnChooseFile.setBackground(new Color(0, 139, 139));
		btnChooseFile.setBounds(605, 470, 146, 33);
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
		btnSave.setBounds(745, 579, 128, 33);
		panel.add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(605, 579, 128, 33);
		panel.add(btnCancel);

		JLabel lblNewLabel_2 = new JLabel("New employee");
		lblNewLabel_2.setIcon(null);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(28, 10, 168, 26);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "User", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(67, 384, 331, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(40, 28, 91, 26);
		panel_1.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));

		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setBounds(124, 30, 168, 26);
		panel_1.add(jtextFieldUsername);
		jtextFieldUsername.setForeground(Color.BLACK);
		jtextFieldUsername.setBackground(Color.WHITE);
		jtextFieldUsername.setColumns(10);

		jpasswordFieldPassword = new JPasswordField();
		jpasswordFieldPassword.setBounds(124, 66, 168, 26);
		panel_1.add(jpasswordFieldPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 66, 91, 26);
		panel_1.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Infomation", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 139, 139)));
		panel_2.setBounds(67, 81, 331, 278);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(43, 31, 91, 26);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		jtextFieldName = new JTextField();
		jtextFieldName.setBounds(127, 31, 168, 26);
		panel_2.add(jtextFieldName);
		jtextFieldName.setColumns(10);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(43, 67, 91, 26);
		panel_2.add(lblBirthday);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 12));

		jdateChooserBirthday = new JDateChooser();
		jdateChooserBirthday.setBounds(127, 67, 168, 26);
		panel_2.add(jdateChooserBirthday);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(43, 103, 91, 26);
		panel_2.add(lblPhone);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));

		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setBounds(127, 103, 168, 26);
		panel_2.add(jtextFieldPhone);
		jtextFieldPhone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(43, 139, 91, 26);
		panel_2.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));

		jtextFieldEmail = new JTextField();
		jtextFieldEmail.setBounds(127, 139, 168, 26);
		panel_2.add(jtextFieldEmail);
		jtextFieldEmail.setColumns(10);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(43, 175, 91, 26);
		panel_2.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));

		jcomboBoxGender = new JComboBox();
		jcomboBoxGender.setBounds(127, 175, 168, 26);
		panel_2.add(jcomboBoxGender);
		jcomboBoxGender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female", "Other" }));

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(43, 211, 91, 26);
		panel_2.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));

		jcomboBoxTitle = new JComboBox();
		jcomboBoxTitle.setBounds(127, 214, 168, 26);
		panel_2.add(jcomboBoxTitle);

		JPanel panelCompany = new JPanel();
		panelCompany.setBorder(new TitledBorder(null, "Company", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 139, 139)));
		panelCompany.setBackground(Color.WHITE);
		panelCompany.setBounds(508, 81, 336, 169);
		panel.add(panelCompany);
		panelCompany.setLayout(null);

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(47, 33, 91, 26);
		panelCompany.add(lblLocation);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));

		jcomboBoxLocation = new JComboBox();
		jcomboBoxLocation.setBounds(131, 34, 168, 26);
		panelCompany.add(jcomboBoxLocation);

		JLabel lblDepament = new JLabel("Department");
		lblDepament.setBounds(47, 69, 91, 26);
		panelCompany.add(lblDepament);
		lblDepament.setFont(new Font("Tahoma", Font.BOLD, 12));

		jcomboBoxdepartment = new JComboBox();
		jcomboBoxdepartment.setBounds(131, 70, 168, 26);
		panelCompany.add(jcomboBoxdepartment);

		JLabel lblProject = new JLabel("Project");
		lblProject.setBounds(47, 105, 91, 26);
		panelCompany.add(lblProject);
		lblProject.setFont(new Font("Tahoma", Font.BOLD, 12));

		jcomboBoxProject = new JComboBox();
		jcomboBoxProject.setBounds(131, 106, 168, 26);
		panelCompany.add(jcomboBoxProject);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(
				new TitledBorder(null, "Image", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_3.setBounds(578, 262, 198, 207);
		panel.add(panel_3);
		panel_3.setLayout(null);

		jlabelImage = new JLabel();
		jlabelImage.setBounds(16, 20, 168, 169);
		jlabelImage.setIcon(new ImageIcon(new ImageIcon(JFrameAddEmployee.class.getResource("/resources/user.png")).getImage()
				.getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_DEFAULT)));
		panel_3.add(jlabelImage);
		jlabelImage.setBackground(Color.WHITE);
		jlabelImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jlabelImage.setHorizontalAlignment(SwingConstants.CENTER);
		loadData();
	}

	// ---------------------------------------------------------------------------------------------------------------
	// loadData
	private void loadData() {
		loadTitle();
		loadLocation();
		loadDepartment();
		loadProject();
	}

	// Combobox Title
	private void loadTitle() {
		TitlesModel titlesModel = new TitlesModel();
		List<Titles> titles = titlesModel.findAll();
		if (titles != null) {
			DefaultComboBoxModel<Titles> comboBoxModelTitles = new DefaultComboBoxModel<Titles>();
			for (Titles title : titles) {
				comboBoxModelTitles.addElement(title);
			}
			jcomboBoxTitle.setModel(comboBoxModelTitles);
			jcomboBoxTitle.setRenderer(new TitleCellRender());
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
			jcomboBoxdepartment.setModel(comboBoxModelDepartment);
			jcomboBoxdepartment.setRenderer(new DepartmentCellRender());
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

	// -----------------------------------------------------------------------------------------------
	// Action
	// - Button save
	public void btnSaveActionPerformed(ActionEvent e) {
		try {
			CheckValidate checkValidate = new CheckValidate();
			// Validate
			// I. Check name is not null
			if (jtextFieldName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Name is not null");
			} else {
				// Check name > 2
				if (checkValidate.checkName(jtextFieldName.getText())) {
					// Check age > 18
					if (checkValidate.checkDate(jdateChooserBirthday.getDate())) {
						// Check phone not null
						if (jtextFieldPhone.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Phone cannot be null");
						} else {
							// Check phone number and lenght
							if (checkValidate.checkPhone(jtextFieldPhone.getText())) {
								// Check mail not null
								if (jtextFieldEmail.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "Email cannot be null");
								} else {
									// Check mail
									if (checkValidate.checkEmail(jtextFieldEmail.getText())) {
										// check username not nyll
										if (jtextFieldUsername.getText().equals("")) {
											JOptionPane.showMessageDialog(null, "Username cannot be null");
										} else {
											// check username regex
											if (checkValidate.checkUsername(jtextFieldUsername.getText())) {
												// check password username
												if (checkValidate.checkUsernameUse(jtextFieldUsername.getText())) {
													// check password not null
													if (jpasswordFieldPassword.getPassword().length <1) {
														JOptionPane.showMessageDialog(null, "Password cannot be null");
													} else {
														// check password regex
														if (checkValidate.checkPasswordRegex(jtextFieldUsername.getText())) {
															// --------------Created Employee---------------------------
															EmployeeModel employeeModel = new EmployeeModel();
															int respone = JOptionPane.showConfirmDialog(null,
																	"Do you want to save ?", "Save", JOptionPane.YES_NO_OPTION);
															if (respone == JOptionPane.YES_OPTION) {
																Employee employee = new Employee();
																employee.setName(jtextFieldName.getText());
																employee.setDob(jdateChooserBirthday.getDate());
																employee.setEmail(jtextFieldEmail.getText());
																employee.setPhone(jtextFieldPhone.getText());
																employee.setGender(
																		jcomboBoxGender.getSelectedItem().toString());
																employee.setUsername(jtextFieldUsername.getText());
																employee.setPassword(BCrypt.hashpw(String.valueOf(jpasswordFieldPassword.getPassword()), BCrypt.gensalt()));
																employee.setCreatedAt(new Date());
																employee.setImage(ConvertFile(file.getAbsolutePath()));
																employee.setStatus(true);
																Titles title = (Titles) jcomboBoxTitle.getSelectedItem();
																employee.setRoleId(5);
																employee.setTitleId(title.getTitle_id());
																Location location = (Location) jcomboBoxLocation
																		.getSelectedItem();
																Department department = (Department) jcomboBoxdepartment
																		.getSelectedItem();
																Project project = (Project) jcomboBoxProject.getSelectedItem();
																if (employeeModel.create2(employee, location.getLocationId(),
																		department.getDepamentId(), project.getProjectId())) {
																	JOptionPane.showMessageDialog(null, "Success !!!");
																	this.setVisible(false);
																} else {
																	JOptionPane.showMessageDialog(null, "Faild !!!");
																}
															}
															// ----------------------------------------------------------
															
															
															
														} else {
															JOptionPane.showMessageDialog(null,
																	"Password is Minimum eight characters, at least one letter and one number:");
														}
													}
												} else {
													JOptionPane.showMessageDialog(null,
															"Username already taken, please re-enter");
												}
											} else {
												JOptionPane.showMessageDialog(null,
														"Username must be between 6 and 18 characters long");
											}
										}
									} else {
										JOptionPane.showMessageDialog(null, "Invalid email");
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "Invalid phone number");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Age must be 18");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Name must be between 2 and 30 characters long ");
				}
			}
			

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	// - button cancel
	public void btnCancel_actionPerformed(ActionEvent e) {
		int respone = JOptionPane.showConfirmDialog(null, "Do you want to cancel ?", "Cancel",
				JOptionPane.YES_NO_OPTION);
		if (respone == JOptionPane.YES_OPTION) {
			this.setVisible(false);
		}

	}

}
