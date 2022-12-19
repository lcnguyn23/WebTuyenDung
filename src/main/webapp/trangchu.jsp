<%@page import="bean.adminbean"%>
<%@page import="bean.nhatdbean"%>
<%@page import="bean.topctybean"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="bean.vieclambean" %>
<%@ page import="bean.nguoidungbean" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/home.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Be+Vietnam+Pro:wght@100;300;400;700;900&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/b0941620fd.js"
	crossorigin="anonymous"></script>
<title>vietjobs</title>
<style>
	@import 'home.css'; 
</style>

</head>
<body>

	<!-- Navigation -->
	<nav class="navbar">
		<div class="nav">
			<img class="logopage" src="${pageContext.request.contextPath}/img/logopage.png" alt="" />
			
			<div class="nav-items">
				<%if(session.getAttribute("nd")!=null){ %>
				<div class="nav-item-link"><a href="vieclamController" class="nav-link">Tìm việc</a></div>
				<%} else if (session.getAttribute("ntd") != null) {%>
				<div class="nav-item-link"><a href="tuyendungController" class="nav-link">Tuyển dụng</a></div>
				<%} else if (session.getAttribute("ad") != null) { %>
				<div class="nav-item-link"><a href="tuyendungController" class="nav-link">Tuyển dụng</a></div>
				<div class="nav-item-link"><a href="vieclamController" class="nav-link">Tìm việc</a></div>
				<%} else { %>
				<div class="nav-item-link"><a href="tuyendungController" class="nav-link">Tuyển dụng</a></div>
				<div class="nav-item-link"><a href="vieclamController" class="nav-link">Tìm việc</a></div>
				<%} %>
				<div class="search">
					<input type="text" class="search-box"
						placeholder="search jobs, company,...">
					<button class="search-btn">
						<i class="fa-solid fa-magnifying-glass fa-lg"></i>
					</button>
				</div>
				<div class="user">
					
				<%if(session.getAttribute("nd") != null) { %>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href="userinfo.jsp"><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%nguoidungbean nd = (nguoidungbean) session.getAttribute("nd");%><%=nd.getHoten() %></h3></a>
				
				
				<%} else if (session.getAttribute("ntd") != null) {%>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href=""><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");%><%=ntd.getTenntd() %></h3></a>
				
				<%} else if (session.getAttribute("ad") != null) {%>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href=""><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%adminbean ad = (adminbean) session.getAttribute("ad");%>Admin: <%=ad.getTendn() %></h3></a>
						
				<%} else {%>
					<a href="dangnhap.jsp"><button class="login-btn">Đăng nhập</button></a>
					<a href="dangnhap.jsp"><button class="signup-btn">Đăng ký</button></a>
				<%} %>	
				</div>
			</div>
		</div>
		<ul class="links-container">
			<li class="link-item"><a href="trangchuController" class="link">Trang chủ</a></li>
			<%if(session.getAttribute("nd") != null) { %>
			<li class="link-item"><a href="vieclamController" class="link">Việc làm</a></li>
			<li class="link-item"><a href="thongtinviecController" class="link">Quản lý việc làm</a></li>
			<%} else if (session.getAttribute("ntd") != null) {%>
			<li class="link-item"><a href="tuyendungController" class="link">Tin tuyển dụng</a></li>
			<li class="link-item"><a href="dangtdController" class="link">Đăng tuyển dụng</a></li>
			<li class="link-item"><a href="quanlytdController" class="link">Quản lý tuyển dụng</a></li>
			<%} else if (session.getAttribute("ad") != null) {%>
			<li class="link-item"><a href="adminController" class="link">Quản lý tin tuyển dụng</a></li>
			<li class="link-item"><a href="#" class="link">Danh sách nhà tuyển dụng</a></li>
			<li class="link-item"><a href="#" class="link">Danh sách người dùng</a></li>
			<%} else {%>
			
			<%} %>
		</ul>
	</nav>

	<!-- Hero-section -->
	<section class="hero section-1">
		<div class="container">
			<div class="info">
				<h1>Cơ Hội Việc Làm & Tăng Thu Nhập</h1>
				<p>Tham gia tìm kiếm cơ hội việc làm hấp dẫn & Tăng thu nhập từ việc giới thiệu ứng viên</p>
				<a class="hero-btn" href="vieclamController">Tìm việc</a>
			</div>
		</div>
	</section>
	<section class="hero section-2">
		<div class="container">
			<div class="info">
				<h1>Tuyển Nhân Sự Chất Lượng Cao - Mọi Lĩnh Vực</h1>
				<p>Đáp ứng mọi nhu cầu tuyển dụng nhân sự Fulltime & Freelancer.<br>
					Kết nối nhanh chóng - Đúng người, đúng việc</p>
				<a class="hero-btn" href="tuyendungController">Tuyển dụng</a>
			</div>
		</div>
	</section>

	<!-- Top NTD -->
	<section class="top-company">
		<h2 class="banner-top">Top nhà tuyển dụng</h2>
	
	<div class="ntd-container">
	<%
	ArrayList<topctybean> dstop = new ArrayList<>();
	dstop = (ArrayList<topctybean>) request.getAttribute("dstop");
	for(topctybean ds: dstop) { %>
		 <div class="ntd-card">
            <img src="${pageContext.request.contextPath}/images/<%=ds.getAnh() %>" class="ntd-logo" alt="">
        	<div class="ntd-info">
	            <h2 class="ntd-name"><%=ds.getTenntd() %></h2>
	            <span class="ntd-jobs">Số tin tuyển dụng: <a href="vieclamController?search-input=<%=ds.getTenntd()%>"><%=ds.getSoviec() %></a></span>
        	</div>
    </div>
	<% 
	}
	%>
	</div>
	</section>
	
	
	
	
	
	<!-- ======================================================================================================= -->
	<!-- Footer -->
    <section class="section-footer">
		<footer class="footer">
		  <div class="footer__addr">
		    <h1 class="footer__logo">vietjobs</h1>
		        
		    <h2>Contact</h2>
		    
		    <address>
		      Hue. Thua Thien - Hue<br>
		          
		      <a class="footer__btn" href="mailto:example@gmail.com">Email Us</a>
		    </address>
		  </div>
		  
		  <ul class="footer__nav">
		    <li class="nav__item">
		      <h2 class="nav__title">Tuyển dụng</h2>
		
		      <ul class="nav__ul">
		        <li>
		          <a href="#">Đăng tin tuyển dụng</a>
		        </li>
		
		        <li>
		          <a href="#">Quản lý tin tuyển dụng</a>
		        </li>
		       
		      </ul>
		    </li>
		    
		    <li class="nav__item nav__item--extra">
		      <h2 class="nav__title">Tìm việc</h2>
		      
		      <ul class="nav__ul nav__ul--extra">
		        <li>
		          <a href="#">Danh sách việc làm</a>
		        </li>
		        
		        <li>
		          <a href="#">Quản lý việc làm</a>
		        </li>
		        
		        <li>
		          <a href="#">Top nhà tuyển dụng</a>
		        </li>
		        
		        <li>
		          <a href="#">Automation</a>
		        </li>
		        
		        <li>
		          <a href="#">Artificial Intelligence</a>
		        </li>
		        
		        <li>
		          <a href="#">IoT</a>
		        </li>
		      </ul>
		    </li>
		    
		    <li class="nav__item">
		      <h2 class="nav__title">Legal</h2>
		      
		      <ul class="nav__ul">
		        <li>
		          <a href="#">Privacy Policy</a>
		        </li>
		        
		        <li>
		          <a href="#">Terms of Use</a>
		        </li>
		        
		        <li>
		          <a href="#">Sitemap</a>
		        </li>
		      </ul>
		    </li>
		  </ul>
		  
		  <div class="legal">
		    <p>&copy; 2022 Hue. All rights reserved.</p>
		    
		    <div class="legal__links">
		      <span>Made with <span class="heart">♥</span> remotely from Anywhere</span>
		    </div>
		  </div>
		</footer>
	</section>

	<script src="${pageContext.request.contextPath}/js/nav.js"></script>
</body>
</html>