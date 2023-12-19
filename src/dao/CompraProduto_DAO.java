/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CompraFgv;
import bean.CompraprodutoFgv;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 *
 */
public class CompraProduto_DAO extends DAOAbstract {

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
    public void deleteTabela(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();

        if (object instanceof CompraFgv) {
            CompraFgv compraFgv = (CompraFgv) object;

            Criteria criteria = session.createCriteria(CompraprodutoFgv.class);
            criteria.add(Restrictions.eq("compraFgv.idcompraFgv", compraFgv.getIdcompraFgv()));

            List lista = criteria.list();
            for (Object produto : lista) {
                session.delete(produto);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CompraFgv.class);
        criteria.add(Restrictions.eq("idcompraprodutoFgv", id));
        List Lista = criteria.list();
        session.getTransaction().commit();
        return Lista.get(0);
    }

    public List listProduto(CompraFgv compraFgv) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CompraprodutoFgv.class);
        criteria.add(Restrictions.eq("compraFgv", compraFgv));
        List Lista = criteria.list();
        session.getTransaction().commit();
        return Lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CompraFgv.class);
        List Lista = criteria.list();
        session.getTransaction().commit();
        return Lista;
    }

}
