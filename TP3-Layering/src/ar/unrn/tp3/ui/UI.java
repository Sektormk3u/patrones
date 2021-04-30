package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.modelo.Participante; //Dependencia
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class UI extends JFrame {

	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private RepositorioDeParticipantes repo;

	public UI(RepositorioDeParticipantes repositorio) {
		this.repo = repositorio;
	}

	public void mostrarVentana() {
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");

		botonCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!validarTelefono(telefono.getText()) && !esCampoVacio(nombre.getText())
						&& !esCampoVacio(region.getText())) {
					JOptionPane.showMessageDialog(botonCargar,
							"Verifique sus datos. Formato telefono: XXXX-XXXXXX. No dejar campos vacios");
					;
				} else {
					Participante P = new Participante(nombre.getText(), telefono.getText(), region.getText());
					try {
						repo.nuevoParticipante(P);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);

	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	private boolean esCampoVacio(String dato) {
		if (dato == "") {
			return true;
		}
		return false;
	}

}
