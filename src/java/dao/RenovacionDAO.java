package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.RenovacionContratos;

public class RenovacionDAO extends DAO {

    public List<RenovacionContratos> listar(RenovacionContratos codigo) throws Exception {
        List<RenovacionContratos> lista;
        ResultSet rs;

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareCall("select * from contrataciones where id_cliente=?");
            st.setInt(1, codigo.getId_cliente());

            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                RenovacionContratos renovacion = new RenovacionContratos();
                renovacion.setId_contracion(rs.getInt("id_contratacion"));
                renovacion.setFecha_contratacion(rs.getString("fecha_contratacion"));
                renovacion.setFecha_renovacion(rs.getString("fecha_renovacion"));
                renovacion.setFecha_culminacion(rs.getString("fecha_culminacion"));
                renovacion.setId_cliente(rs.getInt("id_cliente"));
                renovacion.setId_paquete(rs.getInt("id_paquete"));
                renovacion.setDireccion(rs.getString("direccion"));
                renovacion.setZona(rs.getString("zona"));
                renovacion.setId_municipio(rs.getInt("id_municipio"));
                renovacion.setId_empleado(rs.getInt("id_empleado"));
                lista.add(renovacion);
            }
        } catch (Exception e) {
            System.out.println("Error en el DAO ListaCable" + e);
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public RenovacionContratos leerID(RenovacionContratos pac) throws Exception {
        RenovacionContratos renovacion = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("select contrataciones.* \n"
                    + "from contrataciones inner join clientes on contrataciones.id_cliente = clientes.id_cliente\n"
                    + "where clientes.id_cliente=?;");
            st.setInt(1, pac.getId_cliente());
            rs = st.executeQuery();
            while (rs.next()) {
                renovacion = new RenovacionContratos();
                renovacion.setId_contracion(rs.getInt("id_contratacion"));
                renovacion.setFecha_contratacion(rs.getString("fecha_contratacion"));
                renovacion.setFecha_renovacion(rs.getString("fecha_renovacion"));
                renovacion.setFecha_culminacion(rs.getString("fecha_culminacion"));
                renovacion.setId_paquete(rs.getInt("id_paquete"));
                renovacion.setDireccion(rs.getString("direccion"));
                renovacion.setZona(rs.getString("zona"));
                renovacion.setId_municipio(rs.getInt("id_municipio"));
                renovacion.setId_empleado(rs.getInt("id_empleado"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return renovacion;
    }

    public void modificar(RenovacionContratos nueva) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE contratacion SET fecha_contratacion=?,fecha_renovacion=?,fecha_culminacion=?,id_paquete=?,direccion=?,zona=?,id_municipio=?,id_empleado=? where id_cliente =?");
            st.setString(1, nueva.getFecha_contratacion());
            st.setString(2, nueva.getFecha_renovacion());
            st.setString(3, nueva.getFecha_culminacion());
            st.setInt(4, nueva.getId_paquete());
            st.setString(5, nueva.getDireccion());
            st.setString(6, nueva.getZona());
            st.setInt(7, nueva.getId_municipio());
            st.setInt(8, nueva.getId_empleado());
            st.setInt(9, nueva.getId_cliente());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
