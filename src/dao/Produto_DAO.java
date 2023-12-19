/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ProdutoFgv;
import bean.UsuarioFgv;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Felipe Ronceti
 */
public class Produto_DAO extends DAOAbstract{

    @Override
   public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutoFgv.class);
        criteria.add(Restrictions.eq("idprodutoFgv", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);

    }

    @Override
    public List listAll() {
       session.beginTransaction();
       Criteria criteria = session.createCriteria(ProdutoFgv.class);
       List lista = criteria.list();
       session.getTransaction().commit();
       return (ArrayList) lista;
    }

public List listNome(String nomeFgv) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(ProdutoFgv.class);
    criteria.add(Restrictions.like("nomeFgv", "%"+nomeFgv+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listMarca(String marcaFgv) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(ProdutoFgv.class);
    criteria.add(Restrictions.like("marcaFgv", "%"+marcaFgv+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    }
    
    public List listNomeMarca(String nomeFgv, String marcaFgv) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(ProdutoFgv.class);
    criteria.add(Restrictions.like("nomeFgv", "%"+nomeFgv+"%"));
    criteria.add(Restrictions.like("marcaFgv", "%"+marcaFgv+"%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
    
    }
}
    
