package seikimatu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingDao {
	private Connection connection;

	public ShoppingDao() throws ClassNotFoundException,SQLException{
		String url ="jdbc:mysql://localhost:3306/java_test";
		String user ="root";
		String password ="aljep009";
		connection = DriverManager.getConnection(url,user,password);
	}
	public void close(){
		try{
			if(connection != null){
				connection.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

public ArrayList<itemBean> selectitem()throws SQLException {
	ArrayList<itemBean> AL = null;
	PreparedStatement pstatement = null;
	ResultSet rs = null;
	try{
		String sql = "select b.item_id, b.item_name ,b.price,a.quantity from stok a, item b where a.item_id = b.item_id";
			pstatement =connection.prepareStatement(sql);

			rs = pstatement.executeQuery();
			AL = new ArrayList<itemBean>();

			while(rs.next()){
				itemBean iB= new itemBean();
				iB.setItemid(rs.getString("item_id"));
				iB.setItemname(rs.getString("item_name"));
				iB.setItemprice(rs.getInt("price"));
				iB.setItemQuantity(rs.getInt("quantity"));
				AL.add(iB);
			}
			rs.close();
		}finally{
			pstatement.close();
		}
		return AL;
}
public itemBean selectitem(String item_id)throws SQLException{
	itemBean ib=null;
	PreparedStatement pstatement =null;
	ResultSet rs = null;
	try{
		String sql ="select item.item_id,item.item_name, item.price ,stok.quantity from stok , item  where stok.item_id = item.item_id and item.item_id = ?";
		pstatement =connection.prepareStatement(sql);
		pstatement.setString(1,item_id);
		rs = pstatement.executeQuery();

		if(rs.next()){
			ib=new itemBean();
			ib.setItemid(rs.getString("item.item_id"));
			ib.setItemname(rs.getString("item.item_name"));
			ib.setItemprice(rs.getInt("item.price"));
			ib.setItemQuantity(rs.getInt("quantity"));
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return ib;
		}
public ArrayList<HistoryBean> getHistory(String userId)throws SQLException{
	ArrayList<HistoryBean> AH =null;
	PreparedStatement pstatement =null;
	ResultSet rs =null;
	try{
		String sql ="select a.item_id, b.item_name, a.quantity from history a , item b where a.id = ? and a.item_id = b.item_id";
		pstatement =connection.prepareStatement(sql);
		pstatement.setString(1, userId);
		rs = pstatement.executeQuery();
		AH = new ArrayList<HistoryBean>();

		while(rs.next()){
			HistoryBean iB=new HistoryBean();
			iB.setItemid(rs.getString("a.item_id"));
			iB.setItemName(rs.getString("b.item_name"));
			iB.setItemByQuantity(rs.getInt("a.quantity"));
			AH.add(iB);
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return AH;
		}
public void updateitem(String item_id,int buyCount)throws SQLException{
	PreparedStatement pstatement=null;

	try{
		String sql ="update stok set quantity = quantity - ? where item_id = ?";
		pstatement= connection.prepareStatement(sql);
		pstatement.setString(2, item_id);
		pstatement.setInt(1, buyCount);
		pstatement.executeUpdate();

}finally{
	pstatement.close();
}
}
public void updateHistory(String id,String item_id,int quantity)throws SQLException{
	PreparedStatement pstatement=null;

	try{
		String sql ="insert into history (id, item_id, quantity) values (?, ?, ?)";
		pstatement= connection.prepareStatement(sql);
		pstatement.setString(1, id);
		pstatement.setString(2, item_id);
		pstatement.setInt(3, quantity);
		pstatement.executeUpdate();

}finally{
	pstatement.close();
}
}
public ArrayList<itemBean> itemSerch(String price1,String price2)throws SQLException{
	PreparedStatement pstatement=null;
	ArrayList<itemBean> ab = new ArrayList<itemBean>();
	ResultSet rs = null;
	try{
		String sql="select * from item join stok on item.item_id=stok.item_id where price between ? and ?";
		pstatement= connection.prepareStatement(sql);
		pstatement.setString(1, price1);
		pstatement.setString(2, price2);
		rs =pstatement.executeQuery();

		while(rs.next()){
			itemBean bean = new itemBean();
			bean.setItemid(rs.getString("item_id"));
			bean.setItemname(rs.getString("item_name"));
			bean.setItemprice(rs.getInt("price"));
			bean.setItemQuantity(rs.getInt("quantity"));
		ab.add(bean);
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return ab;
}
public itemBean AdditemQuantity(int quantity,String itemid)throws SQLException{
	PreparedStatement pstatement = null;
	itemBean bean = new itemBean();
	try{
		String sql="update stok set quantity= quantity + ? where item_id=?";
		pstatement=connection.prepareStatement(sql);
		pstatement.setInt(1, quantity);
		pstatement.setString(2, itemid);
		pstatement.executeUpdate();

	}catch(SQLException e){
		e.printStackTrace();
	}
	return bean;
}
public ArrayList<itemBean> sort()throws SQLException{
	PreparedStatement pstatement = null;
	ArrayList<itemBean> ai = new ArrayList<itemBean>();
	ResultSet rs;
	try{
		String sql="select item.item_id,item.item_name, item.price ,stok.quantity from item join stok on item.item_id=stok.item_id order by price";
		pstatement=connection.prepareStatement(sql);
		rs=pstatement.executeQuery();

		while(rs.next()){
			itemBean bean = new itemBean();
			bean.setItemid(rs.getString("item_id"));
			bean.setItemname(rs.getString("item_name"));
			bean.setItemprice(rs.getInt("price"));
			bean.setItemQuantity(rs.getInt("quantity"));
			ai.add(bean);
		}
		rs.close();

	}finally{
		pstatement.close();
	}
	return ai;
}
public int totalPrice(String itemid)throws SQLException{
	PreparedStatement pstatement = null;
	int price=0;
	ResultSet rs;
	try{
		String sql="select price from item where item_id =?";
		pstatement =connection.prepareStatement(sql);
		pstatement.setString(1, itemid);
		rs=pstatement.executeQuery();

		while(rs.next()){
		itemBean bean = new itemBean();
		bean.setItemprice(rs.getInt("price"));
		price =bean.getItemprice();
		}
		rs.close();

	}finally{
		pstatement.close();
	}
	return price;

}
}