/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import entity.Usuarios;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.md5;

/**
 *
 * @author Miguel Angel Lemos
 */
public class usuarioHelper implements helper {

    public usuarioHelper() {

    }

    public boolean ingresar(String user, String pass) {
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try {
            Usuarios u = (Usuarios) s.createQuery("from Usuarios as U "
                    + "where U.nusuario = '" + user + "' "
                    + "and U.pass='" + pass + "'").uniqueResult();
            if (u != null) {
                u.setLta(fecha);
                s.save(u);
                t.commit();
                return true;
            } else {
                t.commit();
                return false;
            }
        } catch (Exception e) {
            s.close();
            return false;
        }
    }

    public boolean actualizarPass(String id, String pass) {
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Usuarios u = new Usuarios();
        try {
            u = (Usuarios) s.get(Usuarios.class, BigDecimal.valueOf(Integer.parseInt(id)));
            u.setPass(md5.getMD5(pass));
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
    public boolean buscar(String id) {
        try {
            Usuarios u = (Usuarios) s.createQuery("from Usuarios as U where U.idusu = '" + id + "'").uniqueResult();
            if (u != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean borrar(String id) {
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Usuarios u = new Usuarios();
        try {
            u = (Usuarios) s.get(Usuarios.class, BigDecimal.valueOf(Integer.parseInt(id)));
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
    public boolean agregar(Object y) {
        Usuarios u = (Usuarios) y;
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try {
            if (!buscar(u.getIdusu().toString())) {
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
        }
    }

    @Override
    public boolean actualizar(Object y) {
        Usuarios x = (Usuarios) y;
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Usuarios u = new Usuarios();
        try {
            u = (Usuarios) s.get(Usuarios.class, x.getIdusu());
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
        s.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try {
            return s.createQuery("from Usuarios").list();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
                return null;
            }
            throw e;
        } finally {
            t.commit();
            s.getSessionFactory().close();
        }
    }

    public int nroDeUsuarios() {
        int u = 0;
        try {
            u = listarTodo().size();
            return u + 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
