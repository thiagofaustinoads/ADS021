package br.iesb.projeto.dao;

import br.iesb.projeto.entitybeans.Usuario;
import java.io.Serializable;

public class UsuarioDAO extends AbstractDAO<Usuario> implements Serializable {
    
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
}
