/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import static com.dao.helper.s;
import entity.Telefonos;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class telefonoHelper implements helper {

    public telefonoHelper() {

    }

    @Override
    public boolean buscar(String id) {
        try {
            s.getSessionFactory().openSession();
            List<Telefonos> telefonos = s.createQuery("from Telefonos where idPersona='" + id + "'").list();
            if (telefonos != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            s.getSessionFactory().close();
        }
    }

    @Override
    public boolean borrar(String Id) {
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Telefonos u = new Telefonos();
        try {
            u = (Telefonos) s.get(Telefonos.class, BigDecimal.valueOf(Integer.parseInt(Id)));
            s.delete(u);
            t.commit();
            return true;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                return false;
            }
            throw e;
        }
    }

    @Override
    public boolean agregar(Object x) {
        Telefonos u = (Telefonos) x;
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try {
            if (!buscar(u.getPersona().toString())) {
                s.save(u);
                t.commit();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                return false;
            }
            throw e;
        } finally {
            s.getSessionFactory().close();
        }
    }

    @Override
    public boolean actualizar(Object y) {
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Telefonos u = new Telefonos(), x = (Telefonos) y;
        try {
            u = (Telefonos) s.get(Telefonos.class, x.getIdphone());
            u = x;
            s.update(u);
            t.commit();
            return true;
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                return false;
            }
            throw e;
        }
    }

    @Override
    public List listarTodo() {
        try {
            s.getSessionFactory().openSession();
            List<Telefonos> telefonos = s.createQuery("from Telefonos").list();
            if (telefonos != null) {
                return telefonos;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.print(e.toString());
            return null;
        } finally {
            s.getSessionFactory().close();
        }
    }

    /**
     * Cargar una lista de telefonos de un usuario.
     *
     * @param id Codigo identificador de un usuario.
     * @return Lista con todos los números de un usuario.
     */
    public List<Telefonos> listarTodo(String id) {
        try {
            s.getSessionFactory().openSession();
            List<Telefonos> telefonos = s.createQuery("from Telefonos where idPersona=" + id).list();
            if (telefonos != null) {
                return telefonos;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.print(e.toString());
            return null;
        } finally {
            s.getSessionFactory().close();
        }
    }
}
