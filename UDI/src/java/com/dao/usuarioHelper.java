/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import entity.Persona;
import entity.Usuarios;
import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.md5;

/**
 *
 * @author usuario
 */
public class usuarioHelper {

    Date fecha;
    Session session = null;

    public usuarioHelper() {
        fecha = new Date();
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public boolean ingresar() {
        session.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Usuarios u = (Usuarios) session.createQuery("from Usuarios as U where U.nusuario = 'superUsu' and U.pass='superUsu'").uniqueResult();
            if (u != null) {
                u.setLta(fecha);
                session.save(u);
                t.commit();
                return true;
            } else {
                t.commit();
                return false;
            }
        } catch (Exception e) {
            session.close();
            return false;
        }
    }

    public boolean actualizarPass(String id, String pass) {
        session.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Usuarios u = new Usuarios();
        try {
            u = (Usuarios) session.get(Usuarios.class, BigDecimal.valueOf(Integer.parseInt(id)));
            u.setPass(md5.getMD5(pass));
            session.update(u);
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

    public boolean buscarUsu(String id) {
        try {
            Usuarios u = (Usuarios) session.createQuery("from Usuarios as U where U.idusu = '" + id + "'").uniqueResult();
            if (u != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarUsu(String id) {
        session.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Usuarios u = new Usuarios();
        try {
            u = (Usuarios) session.get(Usuarios.class, BigDecimal.valueOf(Integer.parseInt(id)));
            session.delete(u);
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

    public boolean agregarUsu(Usuarios u) {
        session.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            if (!buscarUsu(u.getIdusu().toString())) {
                System.out.println("No");
                session.save(u);
                t.commit();
                return true;
            } else {
                System.out.println("Si");
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

    public boolean actualizarUsu(Usuarios x) {
        session.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Usuarios u = new Usuarios();
        try {
            u = (Usuarios) session.get(Usuarios.class, x.getIdusu());
            u = x;
            session.update(u);
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

//    public static void main(String[] args) {
//        usuarioHelper x = new usuarioHelper();
//
//        //x.buscarUsu("-1");
//        // System.out.println(x.agregarUsu(new Usuarios(BigDecimal.valueOf(1234), new Persona(BigDecimal.valueOf(-1), null, null), "Prueba", "1231", x.fecha)));
//        // x.borrarUsu("1234");
//    }

}
