package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.check.CheckValidate;
import com.entities.Location;
import com.models.LocationModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class JPanelLocation extends JPanel {
	private JTextField jtextName;
	private JTextField jtextAddress;
	private JTable jTableLcation;
	private JCheckBox jcheckStatus;
	private JTextField jtextFind;
	private JButton btnUpdate;
	private JLabel jlabelSizeLocations;

	/**
	 * Create the panel.
	 */
	public JPanelLocation() {
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
		scrollPane.setBounds(130, 111, 867, 202);
		add(scrollPane);
		
		jTableLcation = new JTable();
		JTableHeader header = jTableLcation.getTableHeader();
		header.setFont(new Font("SansSerif",Font.BOLD,14));
		jTableLcation.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jTableLcation.setBackground(Color.WHITE);
		jTableLcation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickData_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jTableLcation);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel.setBounds(130, 416, 482, 234);
		add(panel);
		panel.setLayout(null);
		
		jtextName = new JTextField();
		jtextName.setBounds(102, 45, 329, 40);
		panel.add(jtextName);
		jtextName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 52, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(25, 121, 77, 13);
		panel.add(lblAddress);
		
		jtextAddress = new JTextField();
		jtextAddress.setBounds(102, 107, 329, 43);
		panel.add(jtextAddress);
		jtextAddress.setColumns(10);
		
		jcheckStatus = new JCheckBox("Status");
		jcheckStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
		jcheckStatus.setBounds(102, 162, 90, 40);
		panel.add(jcheckStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_1.setBounds(636, 416, 361, 234);
		add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(JPanelLocation.class.getResource("/resources/icons8_Add_New_24px.png")));
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(0, 139, 139));
		btnAdd.setBounds(79, 42, 215, 42);
		panel_1.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 139, 139));
		btnUpdate.setBounds(79, 96, 215, 42);
		panel_1.add(btnUpdate);
		
		JButton JButtonReset = new JButton("reset");
		JButtonReset.setIcon(new ImageIcon(JPanelLocation.class.getResource("/resources/icons8_reset_24px_1.png")));
		JButtonReset.setFont(new Font("SansSerif", Font.BOLD, 12));
		JButtonReset.setForeground(Color.WHITE);
		JButtonReset.setBackground(new Color(0, 139, 139));
		JButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButtonReset_actionPerformed(e);
			}
		});
		JButtonReset.setBounds(79, 150, 215, 42);
		panel_1.add(JButtonReset);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Find", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_2.setBounds(130, 325, 867, 79);
		add(panel_2);
		panel_2.setLayout(null);
		
		jtextFind = new JTextField();
		jtextFind.setBounds(21, 23, 411, 35);
		panel_2.add(jtextFind);
		jtextFind.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.setIcon(new ImageIcon(JPanelLocation.class.getResource("/resources/search_24px.png")));
		btnFind.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnFind.setForeground(Color.WHITE);
		btnFind.setBackground(new Color(0, 139, 139));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFind_actionPerformed(e);
			}
		});
		btnFind.setBounds(478, 23, 170, 35);
		panel_2.add(btnFind);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(JPanelLocation.class.getResource("/resources/icons8_reset_24px_1.png")));
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(0, 139, 139));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		btnReset.setBounds(660, 23, 166, 35);
		panel_2.add(btnReset);
		
		JLabel lblNewLabel_3 = new JLabel("Locations :");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(130, 74, 75, 25);
		add(lblNewLabel_3);
		
		jlabelSizeLocations = new JLabel("0");
		jlabelSizeLocations.setFont(new Font("SansSerif", Font.BOLD, 12));
		jlabelSizeLocations.setBounds(205, 74, 55, 25);
		add(jlabelSizeLocations);
		
		JLabel lblNewLabel_2 = new JLabel("Locations Management");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(130, 21, 867, 41);
		add(lblNewLabel_2);
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
     jtextAddress.setText("");
     jcheckStatus.setText("");
     jcheckStatus.setSelected(false);
     jcheckStatus.setText("status");
	}
	public void btnFind_actionPerformed(ActionEvent e) {
		String dataFind = jtextFind.getText();
		CheckValidate check = new CheckValidate();
		if(check.checkString(dataFind)) {
			LocationModel lo = new LocationModel();
			List<Location> locations = lo.searchByKeyword(dataFind);
			fillDatatoJTable(locations);
		}else {
			JOptionPane.showMessageDialog(null, "String is not null");
		}
		
		
	}
	
	public void clickData_mouseClicked(MouseEvent e) {
		int selectedRow = jTableLcation.getSelectedRow();
		int id = Integer.parseInt(jTableLcation.getValueAt(selectedRow, 0).toString());
		//System.out.print("id: " + id);
		LocationModel locationModel = new LocationModel();
		Location location = locationModel.findById(id);
		jtextName.setText(location.getLocationName());
		jtextAddress.setText(location.getStreetAddress());
		jcheckStatus.setSelected(location.isStatus());
		btnUpdate.setEnabled(true);
		
	}
	
	public void btnUpdate_actionPerformed(ActionEvent e) {
		int selectedRow = jTableLcation.getSelectedRow();
		int id = Integer.parseInt(jTableLcation.getValueAt(selectedRow, 0).toString());
		System.out.print("id: " + id);
		LocationModel locationModel = new LocationModel();
		Location location = new Location();
		location.setLocationId(id);
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		String address = jtextAddress.getText();
		if(check.checkName(name)) {
			location.setLocationName(name);
			if(check.checkAddress(address)) {
				location.setStreetAddress(address);
				location.setStatus(jcheckStatus.isSelected());
				if(locationModel.update(location)) {
					JOptionPane.showMessageDialog(null, "Success");
					loadData();
				}else {
					JOptionPane.showMessageDialog(null, "False");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Address is not null");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
		
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		LocationModel locationModel = new LocationModel();
		Location location = new Location();
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		String address = jtextAddress.getText();
		if(check.checkName(name)) {
			location.setLocationName(name);
			if(check.checkAddress(address)) {
				location.setStreetAddress(address);
				location.setStatus(jcheckStatus.isSelected());
				if(locationModel.create(location)) {
					JOptionPane.showMessageDialog(null, "Success");
					loadData();
				}else {
					JOptionPane.showMessageDialog(null, "False");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Address is not null");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
		
		
	}
	
	private void fillDatatoJTable(List<Location> locations) {
		jlabelSizeLocations.setText(String.valueOf(locations.size()));
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Status");

		for (Location pr : locations) {
			defaultTableModel.addRow(new Object[] { pr.getLocationId(), pr.getLocationName(), pr.getStreetAddress(),
					pr.isStatus() ? "show" : "hide"

			});
		}
		jTableLcation.setModel(defaultTableModel);
		jTableLcation.getTableHeader().setReorderingAllowed(false);

	}
	
	private void loadData() {
		LocationModel locationModel = new LocationModel();
		fillDatatoJTable(locationModel.findAll());
	}
}
