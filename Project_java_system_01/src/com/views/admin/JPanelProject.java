package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.check.CheckValidate;
import com.entities.Location;
import com.entities.Project;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class JPanelProject extends JPanel {
	private JTextField jtextName;
	private JTable jtableProject;
	private JTextField jtextFind;
	private JLabel jlabelProjects;

	/**
	 * Create the panel.
	 */
	public JPanelProject() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
	        UIManager.getDefaults().put("Table.alternateRowColor", new Color(240,248,255));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 139, 139), 3));
		scrollPane.setBounds(114, 177, 884, 212);
		add(scrollPane);
		
		jtableProject = new JTable();
		JTableHeader header = jtableProject.getTableHeader();
		header.setFont(new Font("SansSerif",Font.BOLD,14));
		jtableProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTable_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableProject);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Find", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(114, 409, 884, 79);
		add(panel_2);
		
		jtextFind = new JTextField();
		jtextFind.setColumns(10);
		jtextFind.setBounds(21, 23, 349, 35);
		panel_2.add(jtextFind);
		
		JButton btnFind = new JButton("Find");
		btnFind.setIcon(new ImageIcon(JPanelProject.class.getResource("/resources/search_24px.png")));
		btnFind.setBackground(new Color(0, 139, 139));
		btnFind.setForeground(Color.WHITE);
		btnFind.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFind_actionPerformed(e);
			}
		});
		btnFind.setBounds(424, 22, 183, 35);
		panel_2.add(btnFind);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(JPanelProject.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		btnReset.setBackground(new Color(0, 139, 139));
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		btnReset.setBounds(639, 22, 190, 35);
		panel_2.add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(114, 500, 505, 195);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(41, 83, 67, 26);
		panel.add(lblNewLabel);
		
		jtextName = new JTextField();
		jtextName.setBounds(149, 79, 301, 37);
		panel.add(jtextName);
		jtextName.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Projects Management");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(165, 57, 755, 43);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Projects :");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_3.setBounds(163, 140, 75, 25);
		add(lblNewLabel_3);
		
		jlabelProjects = new JLabel("7");
		jlabelProjects.setFont(new Font("SansSerif", Font.BOLD, 14));
		jlabelProjects.setBounds(238, 140, 55, 25);
		add(jlabelProjects);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Action", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(631, 500, 360, 195);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(JPanelProject.class.getResource("/resources/icons8_Add_New_24px.png")));
		btnAdd.setBounds(93, 37, 194, 37);
		panel_1.add(btnAdd);
		btnAdd.setBackground(new Color(0, 139, 139));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(JPanelProject.class.getResource("/resources/icons8_reset_24px_1.png")));
		btnUpdate.setBounds(93, 86, 194, 37);
		panel_1.add(btnUpdate);
		btnUpdate.setBackground(new Color(0, 139, 139));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton JButtonReset = new JButton("reset");
		JButtonReset.setIcon(new ImageIcon(JPanelProject.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		JButtonReset.setBounds(93, 135, 194, 37);
		panel_1.add(JButtonReset);
		JButtonReset.setBackground(new Color(0, 139, 139));
		JButtonReset.setForeground(Color.WHITE);
		JButtonReset.setFont(new Font("SansSerif", Font.BOLD, 14));
		JButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButtonReset_actionPerformed(e);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_actionPerformed(e);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		loadData();
		
	}
	
	public void JButtonReset_actionPerformed(ActionEvent e) {
     jtextName.setText("");
    
    
     
     
	}
	public void btnFind_actionPerformed(ActionEvent e) {
		String dataFind = jtextFind.getText();
		CheckValidate check = new CheckValidate();
		if(check.checkString(dataFind)) {			
			ProjectModel projectModel = new ProjectModel();
			List<Project> pro = projectModel.searchByKeyword(dataFind);
			fillDatatoJTable(pro);
		}else {
			JOptionPane.showMessageDialog(null, "String is not null");
		}
	}
	
	private void fillDatatoJTable(List<Project> projects) {
		
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Created");
		defaultTableModel.addColumn("Status");

		for (Project pr : projects) {
			defaultTableModel.addRow(new Object[] { 
				pr.getProjectId(),
				pr.getProjectName(),
				pr.getCreated(),
				pr.isStatus() ? "show" : "hide"

			});
		}
	    jtableProject.setModel(defaultTableModel);
		jtableProject.getTableHeader().setReorderingAllowed(false);

	}
	
	private void loadData() {
		ProjectModel projectModel = new ProjectModel();
		fillDatatoJTable(projectModel.findAll());
		jlabelProjects.setText(String.valueOf(projectModel.findAll().size()));
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		ProjectModel projectModel = new ProjectModel();
		Project project = new Project();
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		
		
		if(check.checkName(name)) {
			project.setProjectName(name);		
			project.setCreated(new Date());
			project.setStatus(true);
			if(projectModel.create(project)) {
				JOptionPane.showMessageDialog(null, "Success");
				loadData();
			}else {
				JOptionPane.showMessageDialog(null, "False");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
		
		
		
	}
	
	public void clickTable_mouseClicked(MouseEvent e) {
		int selectedRow = jtableProject.getSelectedRow();
		int id = Integer.parseInt(jtableProject.getValueAt(selectedRow, 0).toString());
		System.out.print("id: " + id);
		ProjectModel projectModel = new ProjectModel();
		Project pro = projectModel.findById(id);
		jtextName.setText(pro.getProjectName());
		
	}
	
	public void btnUpdate_actionPerformed(ActionEvent e) {
		int selectedRow = jtableProject.getSelectedRow();
		int id = Integer.parseInt(jtableProject.getValueAt(selectedRow, 0).toString());
		ProjectModel projectModel = new ProjectModel();
		Project project = projectModel.findById(id);
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		if(check.checkName(name)) {
			project.setProjectName(name);
			if(projectModel.update(project)) {
				JOptionPane.showMessageDialog(null, "Success");
				loadData();
			}else {
				JOptionPane.showMessageDialog(null, "Can not update !!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
	}
}
