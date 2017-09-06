package controlador;

import dao.ClientesDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Clientes;

@ManagedBean
@ViewScoped
public class ClientesBean {
    private Clientes cliente = new Clientes();

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    public void registrar() throws Exception {
        System.out.println("llega aqui>?");
        ClientesDAO dao;

        try {
            dao = new ClientesDAO();
            dao.registrar(cliente);
        } catch (Exception e) {
            throw e;
        }
    } 
}
