import jakarta.servlet.http.*;  
import jakarta.servlet.*;  
import java.io.*; 
import java.sql.*;  

public class DemoServlet extends HttpServlet {  
    public void doPost(HttpServletRequest req, HttpServletResponse res)  
        throws ServletException, IOException {  

        res.setContentType("text/html");  
        PrintWriter pw = res.getWriter();   

        
        try { 

            int id=Integer.parseInt(req.getParameter("t1"));
            String title= req.getParameter("t2");
            String author= req.getParameter("t3");
            Double Price=Double.parseDouble( req.getParameter("t4"));
            int quantity= Integer.parseInt(req.getParameter("t5"));
            // ✅ Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");  

            // ✅ Connect to the database
            String url = "jdbc:mysql://localhost:3306/MiniBini?useSSL=false&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");  // replace "" with password if any

            

            PreparedStatement stmt = con.prepareStatement("insert into sneha values(?,?,?,?,?)");
            stmt.setInt(1,id );
            stmt.setString(2,title);
            stmt.setString(3,author);
            stmt.setDouble(4,Price);
            stmt.setInt(5,quantity);
            int i= stmt.executeUpdate();

            if(i==1){
                pw.println("successfull");
            }
            else{
                pw.println("Not added");
            }

            

           


        } catch (Exception e) {
           
        

        pw.println("</table>");
        pw.println("</body></html>");    
        pw.close();  
    } 
}}