package test.action.context;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * @author zhangyx-v
 */
public class TestActionContext {

    public String execute(){

        //0.获取actionContext对象
        ActionContext actionContext=ActionContext.getContext();
        //1.ActionContext是Action的上下文，类似于springMVC中的ApplicationContext,可以从中获取Action需要的一切信息
        //获取HttpServletRequest 对应的map
        Map<String,Object>applicationMap=actionContext.getApplication();
        //向map中存入一属性 这个过程就相当于request.setAttribute(key,val)
        applicationMap.put("applicationKey","applicationValqqq");
        //获取属性request.getAttribute(key,val)
        Object date=applicationMap.get("date");
        System.out.println("date:"+date);

        //2.session
        Map<String,Object> sessionMap=actionContext.getSession();
        sessionMap.put("sessionKey","sessionValue");

        //3.request

        //4.获取请求参数对应的Map,并获取指定的参数值


        return "success";
    }
}
