<%@page import="bean.adminbean"%>
<%@page import="bean.vieclamchitietbean"%>
<%@page import="bean.hinhthucbean"%>
<%@page import="bean.nhatdbean"%>
<%@page import="bean.linhvucbean"%>
<%@page import="bo.vieclambo"%>
<%@page import="dao.vieclamdao"%>
<%@page import="bean.vieclambean"%>
<%@page import="bean.nguoidungbean"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/job.css" />
<script src="https://kit.fontawesome.com/b0941620fd.js"
	crossorigin="anonymous"></script>
<title>vietjobs</title>
<style>
	@import 'job.css';
</style>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar">
		<div class="nav">
			<img class="logopage" src="${pageContext.request.contextPath}/img/logopage.png" alt="" />
			<div class="nav-items">
				<div class="user">
				<div class="user">
					
				<%if(session.getAttribute("ad") != null) { %>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href=""><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%adminbean ad = (adminbean) session.getAttribute("ad");%>Admin: <%=ad.getTendn() %></h3></a>
					
				<%} else {%>
					<a href="dangnhap.jsp"><button class="login-btn">Đăng nhập</button></a>
					<a href="dangnhap.jsp"><button class="signup-btn">Đăng ký</button></a>
				<%} %>	
				</div>
				</div>
			</div>
		</div>
		<ul class="links-container">
			<li class="link-item"><a href="adminController" class="link">Quản lý tin tuyển dụng</a></li>
			<li class="link-item"><a href="dsntd" class="link">Danh sách nhà tuyển dụng</a></li>
			<li class="link-item"><a href="dsnd" class="link">Danh sách người dùng</a></li>
		</ul>
	</nav>
	<%ArrayList<nguoidungbean> dsnd = (ArrayList<nguoidungbean>) request.getAttribute("dsnd"); %>
	<div class="main-container">
		
		<div class="main-content">
			<div class="job-content">
				<div class="list-heading-job">
					<div class="layer-heading">
						<ul class="list-ht-job">
							<li class="list-item all active"><a href="dsnd">Danh sách người dùng (<%=dsnd.size() %>)</a></li>
						</ul>
					</div>
					
					
				</div>
				<div class="content-container">
				<%
				for(nguoidungbean nd: dsnd) { %>
				  <div class="row-content-2">
						
						<div class="user-info">
							<img class="anh" src="${pageContext.request.contextPath}/images/<%=nd.getAnh()%>"/>
							<div class="info-us">
								<span class="mand mb">ID: <%=nd.getMand() %></span>
								<span class="ten mb">Họ tên: <%=nd.getHoten() %></span>
								<span class="sodt mb">Số điện thoại: <%=nd.getSodt() %></span>
								<span class="dd mb">Địa chỉ: <%=nd.getDiachi() %></span>
								<span class="email mb">Email: <%=nd.getEmail() %></span>
								
							</div>
							
						</div>
						
					</div>
				<% 
				}
				%>
					
		
				</div>
			</div>
		</div>
	</div>
</body>
</html>