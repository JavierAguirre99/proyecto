package controlador;

import dao.*;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ConsultaClientes;

@ManagedBean
@ViewScoped
public class consultaClientesBean {

    private ConsultaClientes cli = new ConsultaClientes();
    private List<ConsultaClientes> lstclientes;
    private ConsultaClientes Cliente = new ConsultaClientes();
    private List<ConsultaClientes> lstClientes;

    public ConsultaClientes getCliente() {
        return Cliente;
    }

    public void setCliente(ConsultaClientes Cliente) {
        this.Cliente = Cliente;
    }

    public List<ConsultaClientes> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<ConsultaClientes> lstClientes) {
        this.lstClientes = lstClientes;
    }

    
    public ConsultaClientes getCli() {
        return cli;
    }

    public void setCli(ConsultaClientes cli) {
        this.cli = cli;
    }

    public List<ConsultaClientes> getLstclientes() {
        return lstclientes;
    }

    public void setLstclientes(List<ConsultaClientes> lstclientes) {
        this.lstclientes = lstclientes;
    }

    public void listarCable() throws Exception {
        consultaClientesDao dao = new consultaClientesDao();

        try {
            lstclientes = dao.listar(cli);
            lstClientes = dao.listarInternet(cli);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
