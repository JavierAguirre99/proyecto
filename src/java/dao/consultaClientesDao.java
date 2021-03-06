package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.ConsultaClientes;

public class consultaClientesDao extends DAO{
    public List<ConsultaClientes> listar(ConsultaClientes codigo) throws Exception {
        List<ConsultaClientes> lista;
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select contrataciones.id_contratacion,contrataciones.id_cliente, clientes.nombre,paquetes.id_paquete,paquetes.nombre as \"NomPaquete\", tipos_servicios.nombre as \"TipodeServicio\"\n"
                    + "from contrataciones inner join clientes on contrataciones.id_cliente = clientes.id_cliente \n"
                    + "inner join paquetes on contrataciones.id_paquete = paquetes.id_paquete\n"
                    + "inner join tipos_servicios on paquetes.id_tiposervicio = tipos_servicios.id_tiposervicio\n"
                    + "where clientes.id_cliente=? and tipos_servicios.nombre='cable'");
           
                    st.setInt(1, codigo.getId_cliente());
            
            result = st.executeQuery();
            lista = new ArrayList();

            while (result.next()) {
                ConsultaClientes con = new ConsultaClientes();
                con.setId_contratacion(Integer.parseInt(result.getString("id_contratacion")));
                con.setId_cliente(Integer.parseInt(result.getString("id_cliente")));
                con.setNombre(result.getString("nombre"));
                con.setId_paquete(Integer.parseInt(result.getString("id_paquete")));
                con.setNom_paquete(result.getString("NomPaquete"));
                con.setTipo_servicio(result.getString("TipodeServicio"));
                lista.add(con);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    public List<ConsultaClientes> listarInternet(ConsultaClientes internet) throws Exception {
        List<ConsultaClientes> lista2;
        ResultSet result;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select contrataciones.id_contratacion,contrataciones.id_cliente, clientes.nombre,paquetes.id_paquete,paquetes.nombre as \"NomPaquete\", tipos_servicios.nombre as \"TipodeServicio\"\n"
                    + "from contrataciones inner join clientes on contrataciones.id_cliente = clientes.id_cliente \n"
                    + "inner join paquetes on contrataciones.id_paquete = paquetes.id_paquete\n"
                    + "inner join tipos_servicios on paquetes.id_tiposervicio = tipos_servicios.id_tiposervicio\n"
                    + "where clientes.id_cliente=? and tipos_servicios.nombre='internet'");
           System.out.println(internet.getId_cliente());
                    st.setInt(1, internet.getId_cliente());
            
            result = st.executeQuery();
            lista2 = new ArrayList();

            while (result.next()) {
                ConsultaClientes con = new ConsultaClientes();
                con.setId_contratacion(Integer.parseInt(result.getString("id_contratacion")));
                con.setId_cliente(Integer.parseInt(result.getString("id_cliente")));
                con.setNombre(result.getString("nombre"));
                con.setId_paquete(Integer.parseInt(result.getString("id_paquete")));
                con.setNom_paquete(result.getString("NomPaquete"));
                con.setTipo_servicio(result.getString("TipodeServicio"));
                lista2.add(con);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista2;
    }
}
