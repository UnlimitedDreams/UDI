/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import static com.dao.helper.s;
import entity.Correos;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class correoHelper implements helper {

    @Override
    public boolean buscar(String id) {
        try {
            s.getSessionFactory().openSession();
            List<Correos> correos = s.createQuery("from Correos where idPersona='" + id + "'").list();
            if (correos != null) {
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
        Correos u = new Correos();
        try {
            u = (Correos) s.get(Correos.class, BigDecimal.valueOf(Integer.parseInt(Id)));
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
        Correos u = (Correos) x;
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
        Correos u = new Correos(), x = (Correos) y;
        try {
            u = (Correos) s.get(Correos.class, x.getIdcorreo());
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
            List<Correos> correos = s.createQuery("from Correos").list();
            if (correos != null) {
                return correos;
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
    public List<Correos> listarTodo(String id) {
        try {
            s.getSessionFactory().openSession();
            List<Correos> correos = s.createQuery("from Correos where idPersona=" + id).list();
            if (correos != null) {
                return correos;
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
