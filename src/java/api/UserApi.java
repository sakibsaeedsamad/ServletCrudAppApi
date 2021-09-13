/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.json.simple.JSONObject;

/**
 *
 * @author SCUBE
 */
@WebServlet(name = "UserApi", urlPatterns = {"/api-login"})
public class UserApi extends HttpServlet {

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
            out.println("<title>Servlet UserApi</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserApi at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String requestCode = request.getParameter("requestCode");
        System.out.println("requestCode = " + requestCode);

        if ("1".equals(requestCode)) {

            String phone = request.getParameter("phone");
            System.out.println("phone = " + phone);
            String password = request.getParameter("password");
            System.out.println("password = " + password);

            User model = new User();
            model.setPhone(phone);
            model.setPassword(password);
            try {
                JSONObject json = new JSONObject();
                UserDao dao = new UserDao();
                User Outmodel = dao.getUserData(model);

                json.put("name", Outmodel.getName());
                json.put("outCode", Outmodel.getOutCode());
                json.put("outMessege", Outmodel.getOutMessege());

                System.out.println("User Login Json " + json);
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(json.toString());
                response.getWriter().flush();
            } catch (Exception ex) {
                Logger.getLogger(UserApi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("2".equals(requestCode)) {
            String name = request.getParameter("name");
            System.out.println("name = " + name);
            String phone = request.getParameter("phone");
            System.out.println("phone = " + phone);
            String password = request.getParameter("password");
            System.out.println("password = " + password);
            String id = request.getParameter("id");
            System.out.println("id = " + id);

            User model = new User();
            model.setId(Integer.parseInt(id));
            model.setName(name);
            model.setPhone(phone);
            model.setPassword(password);

            try {
                JSONObject json = new JSONObject();
                UserDao dao = new UserDao();
                User Outmodel = dao.saveUserData(model);

                json.put("id", Outmodel.getId());
                json.put("name", Outmodel.getName());
                json.put("phone", Outmodel.getPhone());
                json.put("password", Outmodel.getPassword());

//                json.put("outCode", Outmodel.getOutCode());
//                json.put("outMessege", Outmodel.getOutMessege());
                System.out.println("User Save Json " + json);
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(json.toString());
                response.getWriter().flush();
            } catch (Exception ex) {
                Logger.getLogger(UserApi.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else if("3".equals(requestCode)){
            
            String phone = request.getParameter("phone");
            System.out.println("phone = " + phone);
            

            User model = new User();
            model.setPhone(phone);

            try {
                JSONObject json = new JSONObject();
                UserDao dao = new UserDao();
                User Outmodel = dao.deleteUserData(model);

                json.put("phone", Outmodel.getPhone());

//                json.put("outCode", Outmodel.getOutCode());
//                json.put("outMessege", Outmodel.getOutMessege());
                System.out.println("User Delete Json " + json);
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(json.toString());
                response.getWriter().flush();
            } catch (Exception ex) {
                Logger.getLogger(UserApi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }else if("4".equals(requestCode)){
            
            
            String phone = request.getParameter("phone");
            System.out.println("phone = " + phone);
            String password = request.getParameter("password");
            System.out.println("password = " + password);
            

            User model = new User();
           
            model.setPhone(phone);
            model.setPassword(password);

            try {
                JSONObject json = new JSONObject();
                UserDao dao = new UserDao();
                User Outmodel = dao.updateUserData(model);

               
                json.put("phone", Outmodel.getPhone());
                json.put("password", Outmodel.getPassword());

//                json.put("outCode", Outmodel.getOutCode());
//                json.put("outMessege", Outmodel.getOutMessege());
                System.out.println("User password update Json " + json);
                response.addHeader("Access-Control-Allow-Origin", "*");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(json.toString());
                response.getWriter().flush();
            } catch (Exception ex) {
                Logger.getLogger(UserApi.class.getName()).log(Level.SEVERE, null, ex);
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
