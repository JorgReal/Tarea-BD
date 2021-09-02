package crudmvc529;

import controlador.ControladorCliente;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.Formulario;

public class Main {

    public static void main(String[] args) {
        Formulario vista = new Formulario();
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente modelo = new Cliente();
        ControladorCliente control = new ControladorCliente(vista, clienteDAO,modelo);
        vista.setVisible(true);
    }

}
