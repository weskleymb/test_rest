package dao;

import model.Sexo;
import util.GenericDAO;

public class SexoDAO extends GenericDAO<Sexo> {

    @Override
    public Class<Sexo> getClassType() {
        return Sexo.class;
    }
    
}
