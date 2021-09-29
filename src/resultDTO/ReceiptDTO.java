package resultDTO;

public class ReceiptDTO {
    static Integer total;
    static String menu_1_name;
    static String menu_2_name;
    static String menu_3_name;
    static Integer menu_1_count;
    static Integer menu_2_count;
    static Integer menu_3_count;
    static Integer menu_1_price;
    static Integer menu_2_price;
    static Integer menu_3_price;
    static String card;
    static String takeAway;
    private int orderNum;
    
    public int getOrderNum() { return orderNum; }
	public void setOrderNum(int orderNum) { this.orderNum = orderNum; }
    
    public static String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public static String getTakeAway() {
		return takeAway;
	}
	public void setTakeAway(String takeAway) {
		this.takeAway = takeAway;
	}
	public static Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public static String getMenu_1_name() {
        return menu_1_name;
    }
    public void setMenu_1_name(String menu_1_name) {
        this.menu_1_name = menu_1_name;
    }
    public static String getMenu_2_name() {
        return menu_2_name;
    }
    public void setMenu_2_name(String menu_2_name) {
        this.menu_2_name = menu_2_name;
    }
    public static String getMenu_3_name() {
        return menu_3_name;
    }
    public void setMenu_3_name(String menu_3_name) {
        this.menu_3_name = menu_3_name;
    }
    public static Integer getMenu_1_count() {
        return menu_1_count;
    }
    public void setMenu_1_count(Integer menu_1_count) {
        this.menu_1_count = menu_1_count;
    }
    public static Integer getMenu_2_count() {
        return menu_2_count;
    }
    public void setMenu_2_count(Integer menu_2_count) {
        this.menu_2_count = menu_2_count;
    }
    public static Integer getMenu_3_count() {
        return menu_3_count;
    }
    public void setMenu_3_count(Integer menu_3_count) {
        this.menu_3_count = menu_3_count;
    }
    public static Integer getMenu_1_price() {
        return menu_1_price;
    }
    public void setMenu_1_price(Integer menu_1_price) {
        this.menu_1_price = menu_1_price;
    }
    public static Integer getMenu_2_price() {
        return menu_2_price;
    }
    public void setMenu_2_price(Integer menu_2_price) {
        this.menu_2_price = menu_2_price;
    }
    public static Integer getMenu_3_price() {
        return menu_3_price;
    }
    public void setMenu_3_price(Integer menu_3_price) {
        this.menu_3_price = menu_3_price;
    }
}