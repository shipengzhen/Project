/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-06 05:53:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>枣阳市第二人民医院信息管理系统</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"../statics/assets/css/dpl-min.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"../statics/assets/css/bui.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"../statics/assets/css/main.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction back() {\r\n");
      out.write("\t\tif (confirm(\"确认退出\")) {\r\n");
      out.write("\t\t\twindow.location.href = \"/HMS/doTu\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!--<div class=\"header\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"dl-title\">\r\n");
      out.write("        <img src=\"/chinapost/Public/assets/img/top.png\">\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"dl-log\">欢迎您，<span class=\"dl-log-user\">张三</span><a href=\"/chinapost/index.php?m=Public&a=logout\" title=\"退出系统\" class=\"dl-log-quit\">[退出]</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>-->\r\n");
      out.write("\t<div class=\"content\">\r\n");
      out.write("\t\t<div class=\"dl-main-nav\">\r\n");
      out.write("\t\t\t<div class=\"dl-inform\">\r\n");
      out.write("\t\t\t\t<div class=\"dl-inform-title\">\r\n");
      out.write("\t\t\t\t\t<s class=\"dl-inform-icon dl-up\"></s>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<ul id=\"J_Nav\" class=\"nav-list ks-clear\" style=\"float:left\">\r\n");
      out.write("\t\t\t\t<!--<li class=\"nav-item dl-selected\"><div class=\"nav-item-inner nav-home\">信息采编系统</div></li>-->\r\n");
      out.write("\t\t\t\t<li\r\n");
      out.write("\t\t\t\t\tstyle=\" color: #000;font-size: 25px;margin-top: 17px;margin-left: 20px;\">山东省第二人民医院管理平台</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div\r\n");
      out.write("\t\t\t\tstyle=\"float: right;color: #F15D0C;margin-top: 22px;margin-right: 21px;font-size: 18px;font-weight: 800;\">\r\n");
      out.write("\t\t\t\t欢迎您，<span class=\"dl-log-user\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${User.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span><a\r\n");
      out.write("\t\t\t\t\thref=\"javascript:void(0)\" onclick=\"back()\" id=\"out\" title=\"退出系统\"\r\n");
      out.write("\t\t\t\t\tclass=\"dl-log-quit\">[退出]</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<ul id=\"J_NavContent\" class=\"dl-tab-conten\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../statics/assets/js/jquery-1.6.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../statics/assets/js/bui.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"../statics/assets/js/common/main-min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../statics/assets/js/config-min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("    BUI.use('common/main',function(){\r\n");
      out.write("    \t//参数1\r\n");
      out.write("        var config = [\r\n");
      out.write("\t\t{id:'1',menu:[\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t{text:'快速通道',items:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" [\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t{'id':'2','text':'挂号信息管理','href':'goReIdex'},\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t{id:'5',text:'住院办理',href:'gohospitalIndex'},\r\n");
      out.write("\t\t{id:'8',text:'住院结算',href:'goAccount'},\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t{id:'7',text:'在院发药',href:'goDispensingIndex'},\r\n");
      out.write("\t\t{id:'4',text:'药品管理',href:'goMeIndex'},\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t{id:'16',text:'检查收费项目登记',href:'gocharge2'},\r\n");
      out.write("\t\t{id:'6',text:'收费项目管理',href:'gocharge'},\t\t\t\t\r\n");
      out.write("\t\t{id:'3',text:'门诊医生管理',href:'goDoctIndex'},\r\n");
      out.write("\t\t{id:'11',text:'用户管理',href:'goUserIndx'},\r\n");
      out.write("\t\t{id:'12',text:'角色管理',href:'goRoleIndex'},\r\n");
      out.write("\t\t{id:'13',text:'资源管理',href:'goResourceIndex'}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t]}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t]}\r\n");
      out.write("\t\t];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//参数2\r\n");
      out.write("        new PageUtil.MainPage({\r\n");
      out.write("            modulesConfig : config\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
