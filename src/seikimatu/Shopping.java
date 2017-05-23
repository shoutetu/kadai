package seikimatu;

import java.sql.SQLException;
import java.util.ArrayList;

public class Shopping {
	public ArrayList<itemBean> getitem()throws Exception{
		ArrayList<itemBean> alib= new ArrayList<itemBean>();
		ShoppingDao sdao= new ShoppingDao();
		try{
			alib = sdao.selectitem();
			System.out.print(alib);

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(sdao != null){
				sdao.close();
			}
		}


		return alib;

	}
	public itemBean getitem(String item_id)throws Exception{
		itemBean ib = new itemBean();
		ShoppingDao dao = new ShoppingDao();
		try{
			ib=dao.selectitem(item_id);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(dao != null){
				dao.close();
			}
		}
		return ib;

}
	public ArrayList<HistoryBean> getHistory(String userId)throws Exception{
		ArrayList<HistoryBean> AH= new ArrayList<HistoryBean>();
		ShoppingDao dao =new ShoppingDao();
		try{
			AH=dao.getHistory(userId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(dao != null){
				dao.close();
			}
		}
		return AH;

	}
}
