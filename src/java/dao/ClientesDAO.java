package dao;

import java.sql.PreparedStatement;
import modelo.Clientes;

public class ClientesDAO extends DAO{
    public void registrar(Clientes cliente)throws Exception{
        try{
            System.out.println(cliente.getDpi());
            System.out.println(cliente.getCelura());
            System.out.println(cliente.getNit());
            this.conectar();
            PreparedStatement st= this.getCn().prepareStatement("insert into clientes values(?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, cliente.getId_cliente());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getApellido());
            st.setString(4, cliente.getDireccion());
            st.setInt(5, cliente.getNit());
            st.setInt(6, cliente.getDpi());
            st.setString(7, cliente.getFechanac());
            st.setInt(8, cliente.getTelefono());
            st.setInt(9, cliente.getCelura());
            st.setInt(10, cliente.getId_categoria());
            st.setInt(11, cliente.getId_estado());
            st.setInt(12, cliente.getId_tipo_cliente());
            st.executeUpdate();            
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }
    }
}
