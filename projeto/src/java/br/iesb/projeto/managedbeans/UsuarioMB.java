package br.iesb.projeto.managedbeans;

import br.iesb.projeto.dao.UsuarioDAO;
import br.iesb.projeto.entitybeans.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuarioMB")
@RequestScoped
public class UsuarioMB implements Serializable {

    private Usuario usuario;
    private UsuarioDAO dao;
    private List<Usuario> lista;

    public UsuarioMB() {
        this.usuario = new Usuario();
        this.dao = new UsuarioDAO();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        if (lista == null) {            
            lista = dao.findAll();
        }
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
            
    public String criar() {
        this.usuario = new Usuario();
        return "/pages/usuarios/criar";
    }
    
    public String editar(Usuario usuario) {
        this.usuario = usuario;
        return "/pages/usuarios/criar";
    }
    
    public String remover(Usuario usuario) {
        dao.remove(usuario);
        return "/pages/usuarios/listar?faces-redirect=true";
    }
    
    public String salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            dao.create(usuario);
        } else {
            dao.edit(usuario);
        }
        return "/pages/usuarios/listar?faces-redirect=true";
    }

}
