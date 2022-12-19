<%@page import="bo.applybo"%>
<%@page import="bean.vieclamchitietbean"%>
<%@page import="bean.hinhthucbean"%>
<%@page import="bean.nhatdbean"%>
<%@page import="bean.linhvucbean"%>
<%@page import="bo.vieclambo"%>
<%@page import="bo.applybo"%>
<%@page import="bean.applybean"%>

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
<title>Thông tin người dùng</title>
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
					
				<%if(session.getAttribute("nd") != null) { %>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href="thongtinuserController"><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%nguoidungbean nd = (nguoidungbean) session.getAttribute("nd");%><%=nd.getHoten() %></h3></a>
					
				<%} else {%>
					<a href="dangnhap.jsp"><button class="login-btn">Đăng nhập</button></a>
					<a href="dangnhap.jsp"><button class="signup-btn">Đăng ký</button></a>
				<%} %>	
				</div>
				</div>
			</div>
		</div>
		<ul class="links-container">
			<li class="link-item"><a href="trangchuController" class="link">Trang chủ</a></li>
			<li class="link-item"><a href="vieclamController" class="link">Việc làm</a></li>
			<li class="link-item"><a href="thongtinviecController" class="link">Quản lý việc làm</a></li>
		</ul>
	</nav>
	
	<div class="main-container">
		<div class="main-content">
			<div class="job-content">
				<div class="list-heading-job">
					<div class="layer-heading">
						<ul class="list-ht-job">
							<li class="list-item all active"><a href="">Thông tin tài khoản</a></li>
						</ul>
					</div>
					
				</div>
				<div class="content-container">
				<%
				nguoidungbean nd = (nguoidungbean) session.getAttribute("nd");
					    %>
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
				<div class="row-content-1">
						<form class="f-update" action="sua?mnd=<%=nd.getMand() %>" method="post">
							<label>Họ tên</label>
							<input type="text" name="ht" placeholder="">
							<label>Số điện thoại</label>
							<input type="text" name="dt" placeholder="">
							<label>Địa chỉ</label>
							<input type="text" name="dc" placeholder="">
							<label>Email</label>
							<input type="email" name="em" placeholder="">
							
							<button>Sửa</button>
						</form>
					</div>
					
		
				</div>
			</div>
		</div>
	</div>
</body>
</html>