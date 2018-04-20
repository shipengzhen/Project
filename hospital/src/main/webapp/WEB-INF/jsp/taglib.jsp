<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
String path = request.getContextPath();//相对路径
session.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";//绝对路径
session.setAttribute("basePath",basePath);
String images=path+"/statics/images";
session.setAttribute("images",images);
String css=path+"/statics/Css";
session.setAttribute("Css",css);
String js=path+"/statics/Js";
session.setAttribute("Js",js);
%>

