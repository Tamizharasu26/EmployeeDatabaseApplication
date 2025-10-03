import java.sql.*;

public class EmployeeDB {
    public void addEmployee(String name, String dept, double Salary ){
        String sql="INSERT INTO employee(name,department,Salary) VALUES(?,?,?)";
        try(Connection conn=DBConnection.getConnection(); PreparedStatement pst=conn.prepareStatement(sql)){
            pst.setString(1,name);
            pst.setString(2,dept);
            pst.setDouble(3,Salary);
            pst.executeUpdate();
            System.out.println("Employee added successfully");
            System.out.println();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void viewEmployee(){
        String sql="SELECT * FROM employee";
        try(Connection conn=DBConnection.getConnection();
            PreparedStatement p= conn.prepareStatement(sql);
            ResultSet rs=p.executeQuery()){
            System.out.println("ID\tName\tDepartment\tSalary");
            while(rs.next()){
                System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getString("department")+"\t"+rs.getDouble("salary"));
            }
            System.out.println();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateEmployeeSalary(int id, double salary){
        String sql="Update employee set salary=? where id=?";
        try(Connection conn=DBConnection.getConnection(); PreparedStatement pst=conn.prepareStatement(sql)){
            pst.setDouble(1,salary);
            pst.setInt(2,id);
            int rows=pst.executeUpdate();
            if(rows>0) {
                System.out.println("Employee salary updated successfully");
            }
            else {
                System.out.println("Employee not found");
            }
            System.out.println();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteEmployee(int id){
        String sql="Delete from employee where id=?";
        try(Connection conn=DBConnection.getConnection();
            PreparedStatement pst=conn.prepareStatement(sql)){
            pst.setInt(1,id);
            int rows=pst.executeUpdate();
            if(rows>0) {
                System.out.println("Employee deleted successfully");
            }
            else {
                System.out.println("Employee not found");
            }
            System.out.println();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
