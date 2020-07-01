package br.iesb.projeto.managedbeans;

import br.iesb.projeto.entitybeans.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private Usuario usuario;
    private boolean autenticado;

    public LoginMB() {
        usuario = new Usuario();
        autenticado = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public String entrar() {
        if (usuario.getNome().equals("admin")) {
            autenticado = true;
            return "/pages/index?faces-redirect=true";
        }

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login inválido!", "");
        context.addMessage(null, mensagem);
        
        return "";
    }

    public String sair() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

}
