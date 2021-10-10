package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
//            String realPath = servletContext.getRealPath("/Users/huangyachen/ServletTest/src/main/webapp/txt/敏感词汇.txt");
//            System.out.println(realPath);
            BufferedReader br = new BufferedReader(new FileReader("/Users/huangyachen/ServletTest/src/main/webapp/txt/敏感词汇.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现错误！");

        }


    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(servletRequest, args);
                    if (value != null) {
                        for (String str : list) {

                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }

                    return value;

                }



                return method.invoke(servletRequest,args);
            }
        });


        filterChain.doFilter(proxy_req, servletResponse);
    }

    private List<String> list = new ArrayList<String>();

}
