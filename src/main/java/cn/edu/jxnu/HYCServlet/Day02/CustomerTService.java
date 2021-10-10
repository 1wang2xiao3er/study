package cn.edu.jxnu.HYCServlet.Day02;

public class CustomerTService {
//    public static void main(String[] args) {
//        CustomerT cust=new CustomerT();
//        cust.setName("zhaoYun");
//        cust.setPwd("123");
//        cust.setEmail("22312@qq.com");
//        CustomerTService service=new CustomerTService();
//       boolean flag= service.add(cust);
//       if (flag){
//           System.out.println("ok");
//       }else
//           System.out.println("error");
//
//
//    }

    private static CustomerTDao dao=new CustomerTDao();
    public Boolean add(CustomerT cust){
        return dao.add(cust);
    }
}
