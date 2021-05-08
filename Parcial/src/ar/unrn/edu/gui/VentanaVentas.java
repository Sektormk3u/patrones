package ar.unrn.edu.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PersistenceDelegate;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.jmx.LoadBalanceConnectionGroupManager;

import ar.unrn.edu.modelo.RepositorioDeVentas;

import javax.swing.JList;

public class VentanaVentas extends JFrame {

	private JPanel contentPane;
	private RepositorioDeVentas repo;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;

	public VentanaVentas(RepositorioDeVentas repo, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		this.repo = repo;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
	}

	private void setupVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JList list = new JList();
		contentPane.add(list, BorderLayout.CENTER);
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < repo.listadoVentas(fechaInicio, fechaFin).size(); i++) {
			listModel.add(i, repo.listadoVentas(fechaInicio, fechaFin).get(i));
		}
		list.setModel(listModel);
	}

	public void mostrarVentana() {
		setupVentana();
		this.setVisible(true);
	}
}
