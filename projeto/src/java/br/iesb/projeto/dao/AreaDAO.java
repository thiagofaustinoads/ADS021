package br.iesb.projeto.dao;

import br.iesb.projeto.entitybeans.Area;
import java.io.Serializable;


public class AreaDAO extends AbstractDAO<Area> implements Serializable{

    public AreaDAO() {
        super(Area.class);
    }
    
    
}
