/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.access;

import com.dao.correoHelper;
import com.dao.personaHelper;
import com.dao.telefonoHelper;
import com.dao.usuarioHelper;
import entity.Correos;
import entity.Persona;
import entity.Telefonos;
import entity.Usuarios;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usuario
 */
public class ingreso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        personaHelper pp = new personaHelper();
        usuarioHelper ww = new usuarioHelper();
        telefonoHelper tt = new telefonoHelper();
        correoHelper mE = new correoHelper();
        Persona person = new Persona(BigDecimal.valueOf(Integer.parseInt(request.getParameter("id"))),
                request.getParameter("name"),
                request.getParameter("lastname"));
        Telefonos tel = new Telefonos(BigDecimal.valueOf(tt.listarTodo().size() + 1), person, request.getParameter("phone"));
        Correos mail = new Correos(BigDecimal.valueOf(mE.listarTodo().size() + 1), person, request.getParameter("email"));
        pp.agregar(person);
        tt.agregar(tel);
        Usuarios User = new Usuarios(BigDecimal.valueOf(ww.nroDeUsuarios()),
                person, request.getParameter("user"),
                request.getParameter("pass"), new Date());
        ww.agregar(User);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession s = request.getSession();
        if (request.getParameter("action").equals("signOut")) {
            s.invalidate();
        } else {
            if (new usuarioHelper().ingresar(request.getParameter("user"), request.getParameter("pass"))) {
                s.setAttribute("user", request.getParameter("user"));
                s.setAttribute("pass", request.getParameter("pass"));
                response.sendRedirect("general_elements.html");
            } else {
                RequestDispatcher a = request.getRequestDispatcher("login.jsp?msg=Usuario y/o contraseña incorrectos&msgAlt=danger");
                a.forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
