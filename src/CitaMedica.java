import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;//Mediante esta clase podemos obtener los datos de la tabla
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class CitaMedica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTelefono;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CitaMedica frame = new CitaMedica();
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
	public CitaMedica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(21, 33, 85, 13);
		contentPane.add(lblNombre);
		
		JLabel lbApellido = new JLabel("Apellido:");
		lbApellido.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbApellido.setBounds(21, 56, 85, 13);
		contentPane.add(lbApellido);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTelefono.setBounds(21, 79, 85, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblFecha = new JLabel("Fecha de la cita:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFecha.setBounds(21, 102, 133, 13);
		contentPane.add(lblFecha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 148, 405, 74);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Tel\u00E9fono", "Fecha de cita"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAgregar = new JButton(" Agregar Cita");
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.setBounds(167, 232, 113, 21);
		contentPane.add(btnAgregar);
		
		btnAgregar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       
		        String nombre = tfNombre.getText();
		        String apellido = tfApellido.getText();
		        String telefono = tfTelefono.getText();

		        
		        java.util.Date fechaElegida = dateChooser.getDate();

		        
		        if (!nombre.isEmpty() && !apellido.isEmpty() && !telefono.isEmpty() && fechaElegida != null) {
		           
		            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		            String fecha = sdf.format(fechaElegida);

		            
		            DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		            modelo.addRow(new Object[]{nombre, apellido, telefono, fecha});

		            
		            tfNombre.setText("");
		            tfApellido.setText("");
		            tfTelefono.setText("");
		            dateChooser.setDate(null);
		        } else {
		            
		            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos correctamente.");
		        }
		    }
		});


		

		
		tfNombre = new JTextField();
		tfNombre.setBounds(227, 27, 199, 19);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(227, 53, 199, 19);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(227, 76, 199, 19);
		contentPane.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		dateChooser = new JDateChooser();
		
		dateChooser.setBounds(227, 102, 199, 19);
		contentPane.add(dateChooser);
		// Obtener el modelo de la tabla
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();

				
				String nombre = tfNombre.getText();
				String apellido = tfApellido.getText();
				String telefono = tfTelefono.getText();

				
				if (!nombre.isEmpty() && !apellido.isEmpty() && !telefono.isEmpty() ) {
				    
				    modelo.addRow(new Object[]{nombre, apellido, telefono});//Si todo ok añadimos fila

				    
				    tfNombre.setText("");
				    tfApellido.setText("");
				    tfTelefono.setText("");
				   
				} else {
				    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
				}
	}
}
