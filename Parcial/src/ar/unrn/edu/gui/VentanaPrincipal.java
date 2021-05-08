package ar.unrn.edu.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.unrn.edu.modelo.RepositorioDeVentas;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private RepositorioDeVentas repoVentas;

	public VentanaPrincipal(RepositorioDeVentas repo) {
		this.repoVentas = repo;
	}

	private void setupVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnMenuCombustible = new JMenu("Menu combustible");
		menuBar.add(mnMenuCombustible);
		JMenuItem itemMenuCargarCombustible = new JMenuItem("Cargar combustible");
		mnMenuCombustible.add(itemMenuCargarCombustible);
		itemMenuCargarCombustible.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCombustible ventanaCombustible = new VentanaCombustible(repoVentas);
				ventanaCombustible.mostrarVentana();
			}
		});
		JMenu mnMenuVentas = new JMenu("Menu de ventas");
		menuBar.add(mnMenuVentas);
		JMenuItem itemMenuVerVentas = new JMenuItem("Consultar ventas realizadas");
		mnMenuVentas.add(itemMenuVerVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		itemMenuVerVentas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaIntroducirFecha ventanaVentas = new VentanaIntroducirFecha(repoVentas);
				ventanaVentas.mostrarVentana();
			}
		});
	}

	public void mostrarVentana() {
		setupVentana();
		setVisible(true);
	}
}
