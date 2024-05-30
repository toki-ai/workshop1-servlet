package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarDAO {
    public static Connection getConnect() throws Exception {
        Connection connection = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433; databaseName= MytStock";
            String username = "sa";
            String password = "12345";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public CarDAO() {
    }
    
    //CRUD
    public boolean createNewCar(Car item) throws Exception{ 
        PreparedStatement preStm = null;
        Connection connect = null;
        String query = "INSERT INTO Cars (CarName, Manufacturer, Price, ReleasedYear) VALUES  (?, ?, ?, ?)"; 
        try{
            connect = getConnect();
            preStm = connect.prepareStatement(query);
            preStm.setString(1, item.getCarName());
            preStm.setString(2, item.getManufacturer());
            preStm.setInt(3, item.getPrice());
            preStm.setInt(4, item.getReleasedYear());
            return preStm.executeUpdate() > 0;
            //nó trả về số hàng bị ảnh hưởng 
        }catch(Exception e){
            throw e;
        }finally{
            if (preStm != null){
                preStm.close();
            }
            if(connect != null){
                connect.close();
            }
        }
    }
    
    public List<Car> viewListCars() throws Exception{
        PreparedStatement preStm = null;
        Connection connect = null;
  
        List<Car> carList= new ArrayList<>();
        String sql = "SELECT CarID, CarName,Manufacturer,Price, ReleasedYear FROM Cars";
            try{
                connect = getConnect();
                preStm = connect.prepareStatement(sql);
                ResultSet rs = preStm.executeQuery();
                
                    while (rs.next()) {
                        int id = rs.getInt("CarID");
                        String name = rs.getString("CarName");
                        String type = rs.getString("Manufacturer");
                        int price = rs.getInt("Price");
                        int year = rs.getInt("ReleasedYear");
                        Car item = new Car(id, name, type, price, year);
                        carList.add(item);
                    }
                
            }catch(Exception e){
                throw e;
            }
        return carList;
    }
    
    public boolean updateCarInfor() throws Exception{ return true; }
    
    public boolean deleteCar() throws Exception{ return true; }
}
