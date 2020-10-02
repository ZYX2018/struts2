package filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@WebFilter(filterName = "InputActionFilter")
public class InputActionFilter implements Filter {
    @Override
    public void destroy() {
    }

    /**
     *  拦截并处理action请求
     * @param req httpRequest
     * @param resp httpResponse
     * @param chain  FilterChain
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取http请求地址
        HttpServletRequest request= (HttpServletRequest) req;
        String servletPath=request.getServletPath();
       if(servletPath.equals("/save.action")){
           //获取参数
           Map<String, String[]> paramMap=request.getParameterMap();
           //由反射实例化PO并返回结果VO
           Class peopleClass = null;
           Object obj=null;
           String resultName=null;
           try {
               peopleClass = Class.forName("po.People");
               obj= peopleClass.newInstance();
               //获得所有属性
               Field[] fields=peopleClass.getDeclaredFields();
               for (Field field:fields){
                   String filedName=field.getName();
                   String[] targetVal=paramMap.get(filedName);
                   //长度为1 是key为sting value为string形式
                   if(targetVal.length==1){
                       //直接赋值
                       field.setAccessible(true);
                       String filedType= field.getType().getSimpleName();
                       //匹配属性类型
                       if(filedType.equals("String")){
                           field.set(obj,targetVal[0]);
                       }
                       //其他类型
                   }
               }
                //调用action中的指定方法
               Method[] methods=obj.getClass().getDeclaredMethods();
              for (Method method:methods){
                  if(method.getName().equals("save")){
                      resultName= (String) method.invoke(obj);
                  }
              }
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InstantiationException e) {
               e.printStackTrace();
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           }

           //将VO加入request域
           request.setAttribute(resultName,obj);
           //返回结果到前端
           request.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(req,resp);
       }else if(servletPath.equals("/input.action")) {
           System.out.println("拦截 input.action");
           request.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(req,resp);
       }
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
