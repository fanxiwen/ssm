package priv.general.utils.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import priv.general.utils.GlobalStatic;
import priv.general.utils.log.Logger;

public class ServerExcptionResolve extends Logger implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			HttpServletResponse response, Object obj, Exception e) {
		response.getStatus();
//		设置返回数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", GlobalStatic.STATUS_FAILED);
		if(e instanceof ServerException) {
			map.put("msg", e.getMessage());
		} else {
			map.put("msg", "未知错误！");
		}
//		判断是否为Ajax请求
		if(!(request.getHeader("accept").indexOf("application/json") > -1 || 
				(request.getHeader("X-Requested-With") != null && request
				.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
//		否
			logger.error(e.getStackTrace().toString());
			return new ModelAndView("/server/error", map);
		} else {
//			是
			response.setContentType("application/json;charset=UTF-8");
			try {
				PrintWriter writer = response.getWriter();
//				写入返回数据
				writer.write("{\"msg\" : a Json Object}");
				writer.flush();
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

}
