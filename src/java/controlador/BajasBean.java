package controlador;


import dao.BajasDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ConsultaClientes;
@ManagedBean
@ViewScoped
public class BajasBean {
    private ConsultaClientes consulta =  new ConsultaClientes();
    private List<ConsultaClientes> listConsultacable;
    private List<ConsultaClientes> listConsultaint;
    public ConsultaClientes getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaClientes consulta) {
        this.consulta = consulta;
    }

    public List<ConsultaClientes> getListConsultacable() {
        return listConsultacable;
    }

    public void setListConsultacable(List<ConsultaClientes> listConsultacable) {
        this.listConsultacable = listConsultacable;
    }

    public List<ConsultaClientes> getListConsultaint() {
        return listConsultaint;
    }

    public void setListConsultaint(List<ConsultaClientes> listConsultaint) {
        this.listConsultaint = listConsultaint;
    }
    public void listarTodo() throws Exception {
        BajasDAO dao = new BajasDAO();

        try {
            listConsultacable = dao.listar(consulta);
            listConsultaint = dao.listarInternet(consulta);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
