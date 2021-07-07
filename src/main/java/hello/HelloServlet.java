/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Criando e populando dicionários de cumprimentos
        HashMap<String, String> dicionarioDia = new HashMap<>();
        dicionarioDia.put("pt", "bom dia");
        dicionarioDia.put("en", "good morning");
        dicionarioDia.put("fr", "bonjour");
        dicionarioDia.put("de", "guten Morgen");
        dicionarioDia.put("es", "buenos días");
        dicionarioDia.put("zh", "zaoshang hao");

        HashMap<String, String> dicionarioTarde = new HashMap<>();
        dicionarioTarde.put("pt", "boa tarde");
        dicionarioTarde.put("en", "good afternoon");
        dicionarioTarde.put("fr", "bonne apres-midi");
        dicionarioTarde.put("de", "guten Tag");
        dicionarioTarde.put("es", "buenas tardes");
        dicionarioTarde.put("zh", "xiawu hao");

        HashMap<String, String> dicionarioNoite = new HashMap<>();
        dicionarioNoite.put("pt", "boa noite");
        dicionarioNoite.put("en", "good night");
        dicionarioNoite.put("fr", "bonne nuit");
        dicionarioNoite.put("de", "gute Nacht");
        dicionarioNoite.put("es", "buenas noches");
        dicionarioNoite.put("zh", "wan'an");
        
        String msg = "";
        String periodo = "";
        
        int horaAtual = ZonedDateTime.now().getHour();
        if (horaAtual >= 12 && horaAtual < 19){
            periodo = "tarde";
        }
        else if (horaAtual >= 19 && horaAtual < 4) {
            periodo = "noite";
        }
        else{
            periodo = "dia";
        }
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        
        switch(periodo){
            case "dia":
                msg = dicionarioDia.get(lang).substring(0,1).toUpperCase() +
                        dicionarioDia.get(lang).substring(1) + ", ";
                break;
            case "tarde":
                msg = dicionarioTarde.get(lang).substring(0,1).toUpperCase() +
                        dicionarioTarde.get(lang).substring(1) + ", ";
                break;
            case "noite":
                msg = dicionarioNoite.get(lang).substring(0,1).toUpperCase() +
                        dicionarioNoite.get(lang).substring(1) + ", ";
                break;            
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String msg = "";
        String msgDataDeHoje = "";
        
        //Criando e populando dicionários de cumprimentos
        HashMap<String, String> dicionarioDia = new HashMap<>();
        dicionarioDia.put("pt", "bom dia");
        dicionarioDia.put("en", "good morning");
        dicionarioDia.put("fr", "bonjour");
        dicionarioDia.put("de", "guten Morgen");
        dicionarioDia.put("es", "buenos días");
        dicionarioDia.put("zh", "zaoshang hao");

        HashMap<String, String> dicionarioTarde = new HashMap<>();
        dicionarioTarde.put("pt", "boa tarde");
        dicionarioTarde.put("en", "good afternoon");
        dicionarioTarde.put("fr", "bonne apres-midi");
        dicionarioTarde.put("de", "guten Tag");
        dicionarioTarde.put("es", "buenas tardes");
        dicionarioTarde.put("zh", "xiawu hao");

        HashMap<String, String> dicionarioNoite = new HashMap<>();
        dicionarioNoite.put("pt", "boa noite");
        dicionarioNoite.put("en", "good night");
        dicionarioNoite.put("fr", "bonne nuit");
        dicionarioNoite.put("de", "gute Nacht");
        dicionarioNoite.put("es", "buenas noches");
        dicionarioNoite.put("zh", "wan'an");
        
        HashMap<String, String> dicionarioDataAtual = new HashMap<>();
        dicionarioDataAtual.put("pt", "hoje é o dia ");
        dicionarioDataAtual.put("en", "today is the day ");
        dicionarioDataAtual.put("fr", "c'est aujourd'hui le jour ");
        dicionarioDataAtual.put("de", "heute ist der Tag ");
        dicionarioDataAtual.put("es", "hoy es el día ");
        dicionarioDataAtual.put("zh", "Jīntiān de rìqí shì ");
        
        String periodo = "";
        
        int horaAtual = ZonedDateTime.now().getHour();
        if (horaAtual >= 12 && horaAtual < 19){
            periodo = "tarde";
        }
        else if (horaAtual >= 19 || horaAtual < 4) {
            periodo = "noite";
        }
        else{
            periodo = "dia";
        }
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        
        switch(periodo){
            case "dia":
                msg = dicionarioDia.get(lang).substring(0,1).toUpperCase() +
                        dicionarioDia.get(lang).substring(1) + ", ";
                break;
            case "tarde":
                msg = dicionarioTarde.get(lang).substring(0,1).toUpperCase() +
                        dicionarioTarde.get(lang).substring(1) + ", ";
                break;
            case "noite":
                msg = dicionarioNoite.get(lang).substring(0,1).toUpperCase() +
                        dicionarioNoite.get(lang).substring(1) + ", ";
                break;            
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        String showData = request.getParameter("showData");
        if(showData != null) {           
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm z");
            String dataDeHoje = ZonedDateTime.now().format(formatter);
            
            msgDataDeHoje = dicionarioDataAtual.get(lang).substring(0,1).toUpperCase() +
                        dicionarioDataAtual.get(lang).substring(1) + dataDeHoje;
        };
        
        
        msg = msg+nome+"!";
        

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + msgDataDeHoje + "</p>");
            out.println("</body>");
            out.println("</html>");
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
