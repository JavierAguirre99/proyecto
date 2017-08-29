package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuarios;

public class UsuariosDAO extends DAO{
    public List<Usuarios> listar() throws Exception{
        List<Usuarios> lista;
        ResultSet result;
        
        try {
            this.conectar();
            PreparedStatement st =   this.getCn().prepareCall("SELECT id_usuario, nombre, contraseña, id_tipoUsuario FROM usuarios where");
            result = st.executeQuery();
            lista = new ArrayList();
            
            while(result.next()){
                Usuarios pac = new Usuarios();
                pac.setCodpaciente(Integer.parseInt(result.getString("cod_paciente")));
                pac.setNombre(result.getString("nombre"));
                pac.setApellido(result.getString("apellido"));
                pac.setDireccion(result.getString("direccion"));
                pac.setTelefono(Integer.parseInt(result.getString("tel_movil")));
                lista.add(pac);
            }
        } catch (Exception e)  {
            throw e;
        }finally{
            this.cerrar();            
        }
        return lista;   
    }
}
