package lessionDesign;

public class Test {

	public static void main(String[] args) {
		
		 DBManager dbManager=new DBManager();
		//�������ݿ�
	       dbManager.getConnection();  
		
       logintest tLogintest=new logintest();
        tLogintest.loginInterface();
       
	}

}
