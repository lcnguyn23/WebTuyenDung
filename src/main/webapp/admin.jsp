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
<title>vietjobs Admin</title>
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
	
	<div class="main-container">
		<div class="layer-navigation">
			<div class="control-group"> <!-- Lĩnh vực -->
				<div class="category">
					<h3 class="category-heading">Lĩnh vực</h3>
					<div class="subcategory">
						<ul class="list-subcategory">
							<li class="sub-item"><a href="adminController">Tất cả</a></li>
						<%ArrayList<linhvucbean> dslv = new ArrayList<>(); 
						 dslv = (ArrayList<linhvucbean>) request.getAttribute("dslv");
						 for(linhvucbean lv: dslv) { %> 
						 	<li class="sub-item"><a href="adminController?search-input=<%=lv.getMalv()%>"><%=lv.getTenlv() %></a></li>
						<%   
						 }
						%>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="control-group"> <!-- Nhà tuyển dụng -->
				<div class="category">
					<h3 class="category-heading">Nhà tuyển dụng</h3>
					<div class="subcategory">
						<ul class="list-subcategory">
							<li class="sub-item"><a href="adminController">Tất cả</a></li>
						<%ArrayList<nhatdbean> dsntd = new ArrayList<>();
						dsntd = (ArrayList<nhatdbean>) request.getAttribute("dsntd");
						ArrayList<vieclamchitietbean> dsvlct = new ArrayList<>();
						dsvlct = (ArrayList<vieclamchitietbean>) request.getAttribute("dsvlct");
						for(nhatdbean ntd: dsntd) { %> 
					 		<li class="sub-item"><a href="adminController?search-input=<%=ntd.getTenntd()%>"><%=ntd.getTenntd() %></a></li>
						<%   
						 }
						%>
						</ul>
					</div>
				</div>
			</div>
			
			
		</div>
		<div class="main-content">
			<div class="job-content">
				<div class="list-heading-job">
					<div class="layer-heading">
						<ul class="list-ht-job">
							<li class="list-item all active"><a href="adminController">Quản lý tin tuyển dụng (<%=dsvlct.size() %>)</a></li>
						</ul>
					</div>
					
					<form class="search-box-job" method="post" action="adminController">
						<input type="text" class="search-input" name="search-input" placeholder="search jobs, company,...">
						<input class="search-place" type="submit" value="Tìm kiếm"></input>
					</form>
					
				</div>
				<div class="content-container">
				<%
				for(vieclamchitietbean vl: dsvlct) { %>
				  <div class="row-content">
						<a class="job-link" href="#">
							<div class="logo-job">
								<img class="logo-ntd" src="${pageContext.request.contextPath}/images/<%=vl.getAnhntd() %>" alt="">
							</div>
							<div class="job-des">
								<p class="job-title"><%=vl.getTenviec() %></p>
								<p class="name"><%=vl.getTenntd() %></p>
								<p class="destination"><i class="fa-solid fa-location-dot"></i><span><%=vl.getDiadiem() %> (<%=vl.getTenht() %>)</span></p>
								<p class="salary"><i class="fa-solid fa-dollar-sign"></i><span><%=vl.getNgansachtt() %>VND - <%=vl.getNgansachtd() %>VND</span></p>
								<p class="skill"><i class="fa-solid fa-book"></i><span><%=vl.getKynang() %> (<%=vl.getTenlv() %>)</span></p>
								<p class="kn"><i class="fa-solid fa-briefcase"></i><span><%=vl.getKinhnghiem() %></span></p>
								<p class="mota"><i class="fa-solid fa-file"></i><span><%=vl.getMota() %></span></p>
								<p class="handk"><i class="fa-solid fa-calendar"></i><span><%=vl.getHandk()%></span></p>
							</div>
							<div class="apply-form">
								
									<a class="apply-btn" href="xoatin?xoa=<%=vl.getMav()%>">Xóa</a>
								
							</div>
						</a>
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