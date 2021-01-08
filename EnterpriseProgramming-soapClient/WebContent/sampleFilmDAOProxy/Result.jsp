<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleFilmDAOProxyid" scope="session" class="Model.FilmDAOProxy" />
<%
	if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleFilmDAOProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
	String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleFilmDAOProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp%>
<%
	}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
%>
        <%=tempResultreturnp3%>
        <%
        	}
        break;
        case 5:
                gotMethod = true;
                String endpoint_0id=  request.getParameter("endpoint8");
                    java.lang.String endpoint_0idTemp = null;
                if(!endpoint_0id.equals("")){
                 endpoint_0idTemp  = endpoint_0id;
                }
                sampleFilmDAOProxyid.setEndpoint(endpoint_0idTemp);
        break;
        case 10:
                gotMethod = true;
                Model.FilmDAO getFilmDAO10mtemp = sampleFilmDAOProxyid.getFilmDAO();
        if(getFilmDAO10mtemp == null){
        %>
<%=getFilmDAO10mtemp%>
<%
	}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
	}
break;
case 15:
        gotMethod = true;
        String filmID_2id=  request.getParameter("filmID20");
        int filmID_2idTemp  = Integer.parseInt(filmID_2id);
        String filmReview_3id=  request.getParameter("filmReview22");
            java.lang.String filmReview_3idTemp = null;
        if(!filmReview_3id.equals("")){
         filmReview_3idTemp  = filmReview_3id;
        }
        String filmName_4id=  request.getParameter("filmName24");
            java.lang.String filmName_4idTemp = null;
        if(!filmName_4id.equals("")){
         filmName_4idTemp  = filmName_4id;
        }
        String filmCredits_5id=  request.getParameter("filmCredits26");
            java.lang.String filmCredits_5idTemp = null;
        if(!filmCredits_5id.equals("")){
         filmCredits_5idTemp  = filmCredits_5id;
        }
        String filmYear_6id=  request.getParameter("filmYear28");
        int filmYear_6idTemp  = Integer.parseInt(filmYear_6id);
        String filmDuration_7id=  request.getParameter("filmDuration30");
            java.lang.String filmDuration_7idTemp = null;
        if(!filmDuration_7id.equals("")){
         filmDuration_7idTemp  = filmDuration_7id;
        }
%>
        <jsp:useBean id="Model1Film_1id" scope="session" class="Model.Film" />
        <%
        	Model1Film_1id.setFilmID(filmID_2idTemp);
                Model1Film_1id.setFilmReview(filmReview_3idTemp);
                Model1Film_1id.setFilmName(filmName_4idTemp);
                Model1Film_1id.setFilmCredits(filmCredits_5idTemp);
                Model1Film_1id.setFilmYear(filmYear_6idTemp);
                Model1Film_1id.setFilmDuration(filmDuration_7idTemp);
                boolean updateFilm15mtemp = sampleFilmDAOProxyid.updateFilm(Model1Film_1id);
                String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateFilm15mtemp));
        %>
        <%=tempResultreturnp16%>
        <%
        	break;
        case 32:
                gotMethod = true;
                String filmID_9id=  request.getParameter("filmID37");
                int filmID_9idTemp  = Integer.parseInt(filmID_9id);
                String filmReview_10id=  request.getParameter("filmReview39");
                    java.lang.String filmReview_10idTemp = null;
                if(!filmReview_10id.equals("")){
                 filmReview_10idTemp  = filmReview_10id;
                }
                String filmName_11id=  request.getParameter("filmName41");
                    java.lang.String filmName_11idTemp = null;
                if(!filmName_11id.equals("")){
                 filmName_11idTemp  = filmName_11id;
                }
                String filmCredits_12id=  request.getParameter("filmCredits43");
                    java.lang.String filmCredits_12idTemp = null;
                if(!filmCredits_12id.equals("")){
                 filmCredits_12idTemp  = filmCredits_12id;
                }
                String filmYear_13id=  request.getParameter("filmYear45");
                int filmYear_13idTemp  = Integer.parseInt(filmYear_13id);
                String filmDuration_14id=  request.getParameter("filmDuration47");
                    java.lang.String filmDuration_14idTemp = null;
                if(!filmDuration_14id.equals("")){
                 filmDuration_14idTemp  = filmDuration_14id;
                }
        %>
        <jsp:useBean id="Model1Film_8id" scope="session" class="Model.Film" />
        <%
        	Model1Film_8id.setFilmID(filmID_9idTemp);
                Model1Film_8id.setFilmReview(filmReview_10idTemp);
                Model1Film_8id.setFilmName(filmName_11idTemp);
                Model1Film_8id.setFilmCredits(filmCredits_12idTemp);
                Model1Film_8id.setFilmYear(filmYear_13idTemp);
                Model1Film_8id.setFilmDuration(filmDuration_14idTemp);
                boolean insertFilm32mtemp = sampleFilmDAOProxyid.insertFilm(Model1Film_8id);
                String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertFilm32mtemp));
        %>
        <%=tempResultreturnp33%>
        <%
        	break;
        case 49:
                gotMethod = true;
                String filmName_15id=  request.getParameter("filmName64");
                    java.lang.String filmName_15idTemp = null;
                if(!filmName_15id.equals("")){
                 filmName_15idTemp  = filmName_15id;
                }
                Model.Film getFilmByName49mtemp = sampleFilmDAOProxyid.getFilmByName(filmName_15idTemp);
        if(getFilmByName49mtemp == null){
        %>
<%=getFilmByName49mtemp%>
<%
	}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmID:</TD>
<TD>
<%
	if(getFilmByName49mtemp != null){
%>
<%=getFilmByName49mtemp.getFilmID()%><%
	}
%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmReview:</TD>
<TD>
<%
	if(getFilmByName49mtemp != null){
java.lang.String typefilmReview54 = getFilmByName49mtemp.getFilmReview();
        String tempResultfilmReview54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmReview54));
%>
        <%=tempResultfilmReview54%>
        <%
        	}
        %>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmName:</TD>
<TD>
<%
	if(getFilmByName49mtemp != null){
java.lang.String typefilmName56 = getFilmByName49mtemp.getFilmName();
        String tempResultfilmName56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmName56));
%>
        <%=tempResultfilmName56%>
        <%
        	}
        %>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmCredits:</TD>
<TD>
<%
	if(getFilmByName49mtemp != null){
java.lang.String typefilmCredits58 = getFilmByName49mtemp.getFilmCredits();
        String tempResultfilmCredits58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmCredits58));
%>
        <%=tempResultfilmCredits58%>
        <%
        	}
        %>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmYear:</TD>
<TD>
<%
	if(getFilmByName49mtemp != null){
%>
<%=getFilmByName49mtemp.getFilmYear()%><%
	}
%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmDuration:</TD>
<TD>
<%
	if(getFilmByName49mtemp != null){
java.lang.String typefilmDuration62 = getFilmByName49mtemp.getFilmDuration();
        String tempResultfilmDuration62 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmDuration62));
%>
        <%=tempResultfilmDuration62%>
        <%
        	}
        %>
</TD>
</TABLE>
<%
	}
break;
case 66:
        gotMethod = true;
        String filmId_16id=  request.getParameter("filmId81");
        int filmId_16idTemp  = Integer.parseInt(filmId_16id);
        Model.Film getFilmById66mtemp = sampleFilmDAOProxyid.getFilmById(filmId_16idTemp);
if(getFilmById66mtemp == null){
%>
<%=getFilmById66mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmID:</TD>
<TD>
<%
if(getFilmById66mtemp != null){
%>
<%=getFilmById66mtemp.getFilmID()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmReview:</TD>
<TD>
<%
if(getFilmById66mtemp != null){
java.lang.String typefilmReview71 = getFilmById66mtemp.getFilmReview();
        String tempResultfilmReview71 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmReview71));
        %>
        <%= tempResultfilmReview71 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmName:</TD>
<TD>
<%
if(getFilmById66mtemp != null){
java.lang.String typefilmName73 = getFilmById66mtemp.getFilmName();
        String tempResultfilmName73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmName73));
        %>
        <%= tempResultfilmName73 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmCredits:</TD>
<TD>
<%
if(getFilmById66mtemp != null){
java.lang.String typefilmCredits75 = getFilmById66mtemp.getFilmCredits();
        String tempResultfilmCredits75 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmCredits75));
        %>
        <%= tempResultfilmCredits75 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmYear:</TD>
<TD>
<%
if(getFilmById66mtemp != null){
%>
<%=getFilmById66mtemp.getFilmYear()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">filmDuration:</TD>
<TD>
<%
if(getFilmById66mtemp != null){
java.lang.String typefilmDuration79 = getFilmById66mtemp.getFilmDuration();
        String tempResultfilmDuration79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefilmDuration79));
        %>
        <%= tempResultfilmDuration79 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 83:
        gotMethod = true;
        String filmId_17id=  request.getParameter("filmId86");
        int filmId_17idTemp  = Integer.parseInt(filmId_17id);
        boolean deleteFilm83mtemp = sampleFilmDAOProxyid.deleteFilm(filmId_17idTemp);
        String tempResultreturnp84 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteFilm83mtemp));
        %>
        <%= tempResultreturnp84 %>
        <%
break;
case 88:
        gotMethod = true;
        java.lang.String getAllFilms88mtemp = sampleFilmDAOProxyid.getAllFilms();
if(getAllFilms88mtemp == null){
%>
<%=getAllFilms88mtemp %>
<%
}else{
        String tempResultreturnp89 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAllFilms88mtemp));
        %>
        <%= tempResultreturnp89 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>