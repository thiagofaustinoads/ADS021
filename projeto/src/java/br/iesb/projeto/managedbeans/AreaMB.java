package br.iesb.projeto.managedbeans;

import br.iesb.projeto.dao.AreaDAO;
import br.iesb.projeto.entitybeans.Area;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "areaMB")
@RequestScoped
public class AreaMB implements Serializable {

    private Area area;
    private AreaDAO dao;
    private List<Area> lista;

    public AreaMB() {
        this.area = new Area();
        this.dao = new AreaDAO();
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Area> getLista() {
        if (lista == null) {
            lista = dao.findAll();
        }
        return lista;
    }

    public void setLista(List<Area> lista) {
        this.lista = lista;
    }

    public String criar() {
        this.area = new Area();
        return "/pages/area/criar";
    }

    public String editar(Area area) {
        this.area = area;
        return "/pages/area/criar";
    }

    public String remover(Area area) {
        dao.remove(area);
        return "/pages/area/listar?faces-redirect=true";
    }

    public String salvar(Area area) {
        if (area.getId() == null) {
            dao.create(area);
        } else {
            dao.edit(area);
        }
        return "/pages/area/listar?faces-redirect=true";
    }

}
