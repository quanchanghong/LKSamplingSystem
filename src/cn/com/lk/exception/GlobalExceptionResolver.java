package cn.com.lk.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统全局异常处理器
 * @author 1500000367-3
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (e instanceof UnauthorizedException){
			modelAndView.setViewName("unauthorized");
		}
		else{
			e.printStackTrace();
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}


}
