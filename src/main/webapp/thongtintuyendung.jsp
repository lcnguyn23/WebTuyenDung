<%@page import="bean.applybean"%>
<%@page import="bo.applybo"%>
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
<title>Tuyển dụng</title>
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
					
				<%if(session.getAttribute("ntd") != null) { %>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href=""><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");%><%=ntd.getTenntd() %></h3></a>
					
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
			<li class="link-item"><a href="tuyendungController" class="link">Tin tuyển dụng</a></li>
			<li class="link-item"><a href="dangtdController" class="link">Đăng tuyển dụng</a></li>
			<li class="link-item"><a href="quanlytdController" class="link">Quản lý tuyển dụng</a></li>
		</ul>
	</nav>
	
	<div class="main-container">
		<div class="main-content">
			<div class="job-content">
				<div class="list-heading-job">
					<div class="layer-heading">
						<ul class="list-ht-job">
							<li class="list-item all active"><a href="">Thông tin tuyển dụng</a></li>
						</ul>
					</div>
					
				</div>
				<div class="content-container">
				<%
				vieclambean vl = (vieclambean) request.getAttribute("viec");
				nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");
				ArrayList<linhvucbean> dslv = (ArrayList<linhvucbean>) request.getAttribute("dslv");
				ArrayList<hinhthucbean> dsht = (ArrayList<hinhthucbean>) request.getAttribute("dsht");
				ArrayList<nguoidungbean> dsndapply = (ArrayList<nguoidungbean>) request.getAttribute("dsndapply");
				
				%>
				  <div class="row-content">
						<a class="job-link" href="#">
							<div class="logo-job">
								<img class="logo-ntd" src="${pageContext.request.contextPath}/images/<%=ntd.getAnh() %>" alt="">
							</div>
							<div class="job-des">
								<p class="job-title"><%=vl.getTenviec() %></p>
								<p class="name"><%=ntd.getTenntd() %></p>
								<p class="destination"><i class="fa-solid fa-location-dot"></i><span><%=vl.getDiadiem() %> </span></p>
								<p class="salary"><i class="fa-solid fa-dollar-sign"></i><span><%=vl.getNgansachtt() %>VND - <%=vl.getNgansachtd() %>VND</span></p>
								<p class="skill"><i class="fa-solid fa-book"></i><span><%=vl.getKynang() %> </span></p>
								<p class="kn"><i class="fa-solid fa-briefcase"></i><span><%=vl.getKinhnghiem() %></span></p>
								<p class="mota"><i class="fa-solid fa-file"></i><span><%=vl.getMota() %></span></p>
								<p class="handk"><i class="fa-solid fa-calendar"></i><span><%=vl.getHandk()%></span></p>
							</div>
							
						</a>
					</div>
					<div class="apply-title"><h4>Số apply: <%=dsndapply.size() %></h4></div>
					
						<%for(nguoidungbean nd: dsndapply){ 
						applybo abo = new applybo();
					    applybean ap = new applybean();
					    ap = abo.duocnhan(nd.getMand(), vl.getMav());
					    %>
					<div class="row-content-2">
						
						<div class="user-info">
							<img class="anh" src="${pageContext.request.contextPath}/images/<%=nd.getAnh()%>"/>
							<div class="info-us">
								<span class="mand">ID: <%=nd.getMand() %></span>
								<span class="ten">Họ tên: <%=nd.getHoten() %></span>
								<span class="sodt">Số điện thoại: <%=nd.getSodt() %></span>
								<span class="dd">Địa chỉ: <%=nd.getDiachi() %></span>
								<span class="email">Email: <%=nd.getEmail() %></span>
								
							</div>
							<div class="apply-form-1">
								<%if(ap.getDuocnhan()==1){ %>
								<a class="h-apply-btn deact" href="">Đã xác nhận</a>
								<%} else {%>
								<a class="h-apply-btn" href="xacnhan?mnd=<%=nd.getMand()%>&mv=<%=vl.getMav()%>">Xác nhận</a>
								<%} %>
								<a class="tt-apply-btn" href="huyapplyntdController?huymv=<%=vl.getMav()%>&mand=<%=nd.getMand()%>">Hủy</a>
							</div>
						</div>
						
					</div>
				<%} %>
					
		
				</div>
			</div>
		</div>
	</div>
</body>
</html>