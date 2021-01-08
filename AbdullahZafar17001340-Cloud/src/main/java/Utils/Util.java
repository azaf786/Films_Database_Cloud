package Utils;

import javax.servlet.http.HttpServletResponse;

public class Util {

	public static String formatType(HttpServletResponse response, String format)
	{
		String outputPage;
		
		if("xml".equals(format))
		{
			response.setContentType("text/xml");
			 outputPage = "/WEB-INF/results/filmsXml.jsp";
		}
		else if("json".equals(format))
		{
			response.setContentType("text/json");
			 outputPage = "/WEB-INF/results/filmsJson.jsp";
		}
		else
		{
			response.setContentType("text/html");
			 outputPage = "/WEB-INF/results/filmsText.jsp";
		}
		return outputPage;
	}


}
