package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.Formulario;

public class ControladorCliente implements ActionListener, MouseListener {
    // Crear objetos de clase
    Formulario vista = new Formulario();
    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente modelo = new Cliente();
    // Crear un constructor
    public ControladorCliente(Formulario vista,ClienteDAO clienteDAO,Cliente modelo) {
        this.vista = vista;
        this.clienteDAO = clienteDAO;
        this.modelo = modelo;
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnConsultar.addActionListener(this);
    }
    public void insertarRegistro(){
    modelo.setNombre(vista.txtNombre.getText());
    modelo.setApellido(vista.txtApelllido.getText());
    modelo.setDireccion(vista.txtDireccion.getText());
    modelo.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
    modelo.setNit(vista.txtNit.getText());
    String respuesta = clienteDAO.registrarCliente(modelo);
        if (respuesta!=null) {
            JOptionPane.showMessageDialog(null, respuesta);
        }
    }
    public void actualizarRegistro(){
    modelo.setCodigo(Integer.parseInt(vista.txtCodigo.getText()));
    modelo.setNombre(vista.txtNombre.getText());
    modelo.setApellido(vista.txtApelllido.getText());
    modelo.setDireccion(vista.txtDireccion.getText());
    modelo.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
    modelo.setNit(vista.txtNit.getText());
    String respuesta = clienteDAO.modificarDatos(modelo);
        if (respuesta !=null) {
            JOptionPane.showMessageDialog(null, respuesta);
        }
    }
    
    public void eliminarRegistro(){
    int codigo = Integer.parseInt(vista.txtCodigo.getText());
    String respuesta = clienteDAO.eliminarDatos(codigo);
        if (respuesta!= null) {
            JOptionPane.showMessageDialog(null, respuesta);
        }
    }
    
    public void mostrarRegistro(){
    int codigo = Integer.parseInt(vista.txtCodigo.getText());
    modelo = clienteDAO.mostrarCliente(codigo);
    vista.txtNombre.setText(modelo.getNombre());
    vista.txtApelllido.setText(modelo.getApellido());
    vista.txtDireccion.setText(modelo.getDireccion());
    vista.txtTelefono.setText(String.valueOf(modelo.getTelefono()));
    vista.txtNit.setText(modelo.getNit());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vista.btnInsertar) {
            insertarRegistro();
        }
         if (e.getSource()== vista.btnActualizar) {
            actualizarRegistro();
        }
         if (e.getSource() ==vista.btnEliminar) {
            eliminarRegistro();
        }
         if (e.getSource() ==vista.btnConsultar) {
            mostrarRegistro();
        }
        
    }

    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
