/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pupil
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/page1", "/page2", "/page3", "/page4", "/giveBook", "/page5"})
public class MyServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        List<Book> listBooks = new ArrayList<>();
        listBooks.add(new Book("123-123123", "Voyna i Mir", "Lev Nikolaevich Tolstoy"));
        listBooks.add(new Book("123-321123", "Skotniy Dvor", "Dwordz Oruell"));
        List<Reader> listReaders = new ArrayList<>();
        listReaders.add(new Reader("231", "Andrei", "Kovaljov"));
        listReaders.add(new Reader("412", "Oleg", "Nemcov"));
        String path = request.getServletPath();
        if ("/page2".equals(path)) {
            request.setAttribute("listBooks", listBooks);
            request.setAttribute("info", "page 2,привет из сервлета!");
            request.getRequestDispatcher("/WEB-INF/page2.jsp").forward(request, response);
        } else if ("/page3".equals(path)) {
            request.setAttribute("listReaders", listReaders);
            request.setAttribute("info", "page 3,привет из сервлета!");
            request.getRequestDispatcher("/page3.jsp").forward(request, response);
        } else if ("/page4".equals(path)) {
            request.setAttribute("listBooks", listBooks);
            request.setAttribute("listReaders", listReaders);
            request.getRequestDispatcher("/WEB-INF/page4.jsp").forward(request, response);
        } else if ("/page1".equals(path)) {
            request.getRequestDispatcher("/page1.jsp").forward(request, response);
        } 
             else if ("/giveBook".equals(path)) {
            String book = request.getParameter("book");
            String reader = request.getParameter("reader");
            Book giveBook = new Book();
            for (int i = 0; i < listBooks.size(); i++) {
                if (listBooks.get(i).getIsbn().equals(book)) {
                    giveBook = listBooks.get(i);
                }

            }
            Reader takeReader = new Reader();
            for (int i = 0; i < listReaders.size(); i++) {
                if (listReaders.get(i).getCode().equals(reader)) {
                    takeReader = listReaders.get(i);
                }

            }
            Calendar c = new GregorianCalendar();
            History history = new History(giveBook, takeReader, c.getTime());
            request.setAttribute("history", history);
            request.getRequestDispatcher("/WEB-INF/page5.jsp").forward(request, response);
        }

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
