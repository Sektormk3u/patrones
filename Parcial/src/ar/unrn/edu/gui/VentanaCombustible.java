package ar.unrn.edu.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.unrn.edu.modelo.NaftaComun;//
import ar.unrn.edu.modelo.NaftaSuper;//
import ar.unrn.edu.modelo.RepositorioDeVentas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class VentanaCombustible extends JFrame {

	private JPanel contentPane;
	private RepositorioDeVentas repo;
	private NaftaSuper naftaSuper;//
	private NaftaComun naftaComun;//

	public VentanaCombustible(RepositorioDeVentas repo) {
		this.repo = repo;
	}

	private void setupVentana() {
		this.naftaComun = new NaftaComun();
		this.naftaSuper = new NaftaSuper();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblLitros = new JLabel("Litros");
		panel.add(lblLitros);
		TextField textFieldLitros = new TextField();
		panel.add(textFieldLitros);
		JLabel lblTipoNafta = new JLabel("Tipo combustible");
		panel.add(lblTipoNafta);
		JComboBox comboBoxNafta = new JComboBox();
		panel.add(comboBoxNafta);
		comboBoxNafta.addItem("Super");
		comboBoxNafta.addItem("Comun");
		JButton btnCalculo = new JButton("Calcular monto a pagar");
		panel.add(btnCalculo);
		btnCalculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!validarCampo(textFieldLitros.getText())) {
					JOptionPane.showMessageDialog(btnCalculo, "Escriba un valor valido");
				} else {
					double litros = Double.parseDouble(textFieldLitros.getText());
					if (comboBoxNafta.getSelectedItem().toString() == "Super") {
						JOptionPane.showInternalMessageDialog(btnCalculo,
								"El precio es: $" + naftaSuper.calcularDescuento(litros, LocalDateTime.now()));
					} else {
						JOptionPane.showMessageDialog(btnCalculo,
								"El precio es: $" + naftaComun.calcularDescuento(litros, LocalDateTime.now()));
					}
				}
			}
		});
		JButton btnPagar = new JButton("Pagar");
		panel.add(btnPagar);
		btnPagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!validarCampo(textFieldLitros.getText())) {
					JOptionPane.showMessageDialog(btnCalculo, "Escriba un valor valido");
				} else {
					if (comboBoxNafta.getSelectedItem().toString() == "Super") {
						repo.realizarVenta(Double.parseDouble(textFieldLitros.getText()), naftaSuper
								.calcularDescuento(Double.parseDouble(textFieldLitros.getText()), LocalDateTime.now()),
								LocalDateTime.now());
					} else {
						repo.realizarVenta(Double.parseDouble(textFieldLitros.getText()), naftaComun
								.calcularDescuento(Double.parseDouble(textFieldLitros.getText()), LocalDateTime.now()),
								LocalDateTime.now());
					}
					JOptionPane.showMessageDialog(btnPagar, "Pago registrado con exito");
					textFieldLitros.setText("");
				}

			}
		});
	}

	public void mostrarVentana() {
		setupVentana();
		this.setVisible(true);
	}

	private boolean validarCampo(String s) {
		try {
			Double.parseDouble(s);
			if (s.isBlank()) {
				return false;
			}
			if (s.isEmpty()) {
				return false;
			}
			if (Double.parseDouble(s) == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
