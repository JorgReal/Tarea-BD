
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO extends Conexion {
    private String respuesta;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public String registrarCliente(Cliente cli){
        respuesta = null;
        try {
            this.Conectar();//1.conexion
            sql = "insert into cliente (nombre,apellido,direccion,telefono,nit)values(?,?,?,?,?)";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getDireccion());
            ps.setInt(4, cli.getTelefono());
            ps.setString(5, cli.getNit());//2.preparedStatement y la instruccion SQL
            ps.executeUpdate();//3.Ejecutar el PreparedStatement
            respuesta = "Registro insertado correctamente!!!";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = "No se pudo insertar el registro !!! ";
        }finally{
            this.cerrarConexion();
        }
    
     return respuesta;
    }
    public String modificarDatos(Cliente cli){
        respuesta = null;
        try {
            this.Conectar();
            sql = "update cliente set nombre=?, apellido=?, direccion=?, telefono=?, nit=? where codigo=? ";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getDireccion());
            ps.setInt(4, cli.getTelefono());
            ps.setString(5, cli.getNit());
            ps.setInt(6, cli.getCodigo());
            ps.executeUpdate();
            respuesta = "Actualizacion realiada correctamente !!! ";  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = "No se pudo actualizar correctamente !!! ";
        }finally{
            this.cerrarConexion();
        }
    return respuesta;
    }
    
    public String eliminarDatos(int codigo){
        respuesta = null;
        try {
            this.Conectar();
            sql = "delete from cliente where codigo=?";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            respuesta = "Cliente eliminado correctamente!!! ";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta = "No se pudo eliminar el cliente!!! ";
        }finally{
            this.cerrarConexion();
        }
    return respuesta;
    }
    public Cliente mostrarCliente (int Codigo){
        Cliente cliente = new Cliente();
        try {
            this.Conectar();
            sql = "select * from cliente where codigo=?";
            ps = this.getMiConexion().prepareStatement(sql);
            ps.setInt(1, Codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setNit(rs.getString("nit"));
            }           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            this.cerrarConexion();
        }
        return cliente;
    }
}
