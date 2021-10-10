//package filter.proxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//public class ProxyTest {
//    public static void main(String[] args) {
//        Lenovo lenovo=new Lenovo();
//
//        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                System.out.println("该方法执行了");
////                System.out.println(method.getName());
////                System.out.println(args[0]);
//                if (method.getName().equals("sale")){
//                    double money=(double) args[0]*0.85;
//                    String obj =(String) method.invoke(lenovo,money);
//                    return obj+"  鼠标垫  "+" 键盘 "+"鼠标";
//                }
//                Object obj = method.invoke(lenovo,args);
//                return obj;
//            }
//        });
//
//        String computer=proxy_lenovo.sale(9000.0);
//        System.out.println(computer);
//        proxy_lenovo.show();
//
//
//
//
//
//    }
//}
