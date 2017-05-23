package seikimatu;

import java.io.Serializable;

public class HistoryBean implements Serializable{
	private String itemid;
	private String itemName;
	private int itemByQuantity;

	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemByQuantity() {
		return itemByQuantity;
	}
	public void setItemByQuantity(int itemByQuantity) {
		this.itemByQuantity = itemByQuantity;
	}



}
