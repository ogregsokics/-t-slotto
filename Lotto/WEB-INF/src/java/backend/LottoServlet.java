/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.persistence.exceptions.JAXBException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Gerg
 */
public class LottoServlet extends HttpServlet {

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
        response.setContentType("application/json");
        
         PrintWriter out = response.getWriter();
        try {
        
        

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LottoPU");
            EntityManager em = emf.createEntityManager();
            

            if(request.getParameter("task").equals("inditas")){
                
                Sorsolo n = new Sorsolo();
                n.start();
           
                StoredProcedureQuery spq = em.createStoredProcedureQuery("eredmenyekIN");
                spq.registerStoredProcedureParameter("sorsoltIN", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("tippekIN", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("talalatokIN", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("szamIN", Integer.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("elsosorIN", String.class, ParameterMode.IN);
                spq.registerStoredProcedureParameter("masodiksorIN", String.class, ParameterMode.IN);
                
                spq.setParameter("sorsoltIN", n.getSor1());
                spq.setParameter("tippekIN", n.getSor2());
                spq.setParameter("talalatokIN", n.getSor3());
                spq.setParameter("szamIN", n.getnumberOfTalalatok());
                spq.setParameter("elsosorIN", n.getElsosor());
                spq.setParameter("masodiksorIN", n.getMasodiksor());
                spq.execute();

            }

            if(request.getParameter("task").equals("percent")){
                

                JSONArray szazalekok = new JSONArray();
                
                for (int i = 0; i < 6; i++) {
                    
                    StoredProcedureQuery spq3 = em.createStoredProcedureQuery("getProcent");
                    spq3.registerStoredProcedureParameter("szamIN", Integer.class, ParameterMode.IN);
                    spq3.registerStoredProcedureParameter("szamOUT", String.class, ParameterMode.OUT);
                    spq3.setParameter("szamIN", i);
                    spq3.execute();
                    
                    String szaz = spq3.getOutputParameterValue("szamOUT").toString();
                    JSONObject szazalek = new JSONObject();
                    szazalek.put("percent", szaz);
                    
                    szazalekok.put(szazalek);
                 
                }
                
                out.write(szazalekok.toString());
            }
            
            if(request.getParameter("task").equals("delete")){
                
                StoredProcedureQuery spq4 = em.createStoredProcedureQuery("deleteAll");
                spq4.execute();
                
                
            }
            
            if(request.getParameter("task").equals("getresults")){
                
                    StoredProcedureQuery spq2 = em.createStoredProcedureQuery("getResults");
                
                    List<Object[]> felhasznalok = spq2.getResultList();
       
                    JSONArray adatok = new JSONArray();
                    for (Object [] felhasznalo : felhasznalok) {
                        JSONObject obj = new JSONObject();
                        
                        int szamm = Integer.parseInt(felhasznalo[0].toString());

                        Lotto l = em.find(Lotto.class, szamm);
       
                        obj.put("sorsolt", l.getSorsolt()); 
                        obj.put("tippek", l.getTippek()); 
                        obj.put("talalatok", l.getTalalatok()); 
                        obj.put("elsosor", l.getElsosor()); 
                        obj.put("masodiksor", l.getMasodiksor()); 

                        adatok.put(obj);
                }
                out.write(adatok.toString());
             
            }
            
            em.close();
            emf.close();
      
        }
        finally {
         out.close();  // Always close the output writer
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
        processRequest(request, response);
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
