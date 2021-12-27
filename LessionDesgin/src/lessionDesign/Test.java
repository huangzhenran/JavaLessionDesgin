package lessionDesign;

public class Test {

	public static void main(String[] args) {
		
		 DBManager dbManager=new DBManager();
		//连接数据库
	       dbManager.getConnection();  
		
       logintest tLogintest=new logintest();
        tLogintest.loginInterface();
       
	}

}
