package accessDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import util.DBUtil;
import DAO.GuitarDAO;
import Model.Builder;
import Model.Guitar;
import Model.GuitarSpec;
import Model.Type;
import Model.Wood;

public class GuitarDAOImpl implements GuitarDAO {

	// 增加操作
	@Override
	public void insert(Guitar guitar) throws Exception {
		String serialNumber = guitar.getSerialNumber();
		double price = guitar.getPrice();
		GuitarSpec spec = guitar.getSpec();

		String sql = "insert into Guitar (serialNumber,price,";
		for (Iterator i = spec.getProperties().keySet().iterator(); i.hasNext();) {
			String propertyName = (String) i.next();
			sql += propertyName + ",";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ") values('" + serialNumber + "'," + price + ",";
		for (Iterator i = spec.getProperties().keySet().iterator(); i.hasNext();) {
			String propertyName = (String) i.next();
			String propertyValue = spec.getProperty(propertyName).toString();
			sql += "'" + propertyValue + "',";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ")";

		Connection Conn = DBUtil.getAccessConnection();
		try {
			Statement stmt = Conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("操作中出现错误！！！");
		}

	}

	// 删除操作
	@Override
	public void delete(String serialNumber) throws Exception {
		String sql = "DELETE FROM Guitar WHERE serialNumber=?";
		PreparedStatement pstmt = null;
		Connection Conn = DBUtil.getAccessConnection();
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作中出现错误！！！");
		}
	}
  
	// 查询全部
		public List<Guitar> queryAll() throws Exception
		{
			Connection Conn = DBUtil.getAccessConnection();
			String sql = "select * from Guitar";
			List<Guitar> all = new ArrayList<Guitar>();
			try {
				PreparedStatement pstmt = Conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Map properties = new HashMap();
					properties.put("builder",
							Builder.fromString(rs.getString("builder")));
					properties.put("model", rs.getString("model"));
					properties.put("type", Type.fromString(rs.getString("type")));
					properties.put("backWood",
							Wood.fromString(rs.getString("backWood")));
					properties.put("topWood",
							Wood.fromString(rs.getString("topWood")));
					GuitarSpec spec = new GuitarSpec(properties);
					
					Guitar guitar = new Guitar(rs.getString("serialNumber"),rs.getDouble("price"),spec);
					all.add(guitar);				
				}			
				rs.close();
				pstmt.close();
				Conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch(Exception e){
			    e.printStackTrace();	
			}finally{
				try{
			         if(Conn!=null)
			        	 Conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			}
			return all;
		}

	// 模糊查询
	@Override
	public List<Guitar> queryByLike(String cond) throws Exception {

		List<Guitar> all = new ArrayList<Guitar>();
		String sql = "SELECT serialNumber,price,builder,model,type,backWood,topWood FROM Guitar WHERE builder LIKE ? or type LIKE ? or model LIKE ?  or backWood LIKE ? or topWood LIKE ?";
		PreparedStatement pstmt = null;
		Connection Conn = DBUtil.getAccessConnection();
		try {
			pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, "%" + cond + "%");
			pstmt.setString(2, "%" + cond + "%");
			pstmt.setString(3, "%" + cond + "%");
			pstmt.setString(4, "%" + cond + "%");
			pstmt.setString(5, "%" + cond + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Map properties = new HashMap();
				properties.put("builder",
						Builder.fromString(rs.getString("builder")));
				properties.put("model", rs.getString("model"));
				properties.put("type", Type.fromString(rs.getString("type")));
				properties.put("backWood",
						Wood.fromString(rs.getString("backWood")));
				properties.put("topWood",
						Wood.fromString(rs.getString("topWood")));
				GuitarSpec spec = new GuitarSpec(properties);
				Guitar guitar = new Guitar(rs.getString(1),
						rs.getDouble(2), spec);
				all.add(guitar);

			}
			 rs.close() ;  
             pstmt.close() ;  
         }  
       catch (Exception e)  
         {  
            System.out.println(e) ;  
             throw new Exception("操作中出现错误！！！") ;  
        }  
        finally  
        {  
            Conn.close() ;  
        }  
        return all ;  
	}
}
