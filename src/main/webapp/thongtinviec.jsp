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
<title>Việc làm</title>
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
		<div class="layer-navigation">
			<div class="control-group"> <!-- Lĩnh vực -->
				<div class="category">
					<h3 class="category-heading">Lĩnh vực</h3>
					<div class="subcategory">
						<ul class="list-subcategory">
							<li class="sub-item"><a href="thongtinviecController">Tất cả</a></li>
						<%ArrayList<linhvucbean> dslv = new ArrayList<>(); 
						 dslv = (ArrayList<linhvucbean>) request.getAttribute("dslv");
						 for(linhvucbean lv: dslv) { %> 
						 	<li class="sub-item"><a href="thongtinviecController?search-input=<%=lv.getMalv()%>"><%=lv.getTenlv() %></a></li>
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
							<li class="sub-item"><a href="thongtinviecController">Tất cả</a></li>
						<%ArrayList<nhatdbean> dsntd = new ArrayList<>();
						dsntd = (ArrayList<nhatdbean>) request.getAttribute("dsntd");
						ArrayList<vieclamchitietbean> dsvlct = new ArrayList<>();
						dsvlct = (ArrayList<vieclamchitietbean>) request.getAttribute("dsvlct");
						nguoidungbean nd = (nguoidungbean) session.getAttribute("nd");
						for(nhatdbean ntd: dsntd) { %> 
					 		<li class="sub-item"><a href="thongtinviecController?search-input=<%=ntd.getTenntd()%>"><%=ntd.getTenntd() %></a></li>
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
							<li class="list-item all active"><a href="">Các công việc đã apply (<%=dsvlct.size() %>)</a></li>
						</ul>
					</div>
					
					<form class="search-box-job" method="post" action="thongtinviecController">
						<input type="text" class="search-input" name="search-input" placeholder="search jobs, company,...">
						<input class="search-place" type="submit" value="Tìm kiếm"></input>
					</form>
					
				</div>
				<div class="content-container">
				<%
				for(vieclamchitietbean vl: dsvlct) { 
				  applybo abo = new applybo();
				    applybean ap = new applybean();
				    ap = abo.duocnhan(nd.getMand(), vl.getMav());
				%>
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
								<%if(ap.getDuocnhan()==1){ %>
								<a class="h-apply-btn deact" href="">Apply thành công</a>
								<%} else {%>
								<a class="h-apply-btn" href="">Chờ xác nhận</a>
								<%} %>	
								<a class="tt-apply-btn" href="huyapplyController?huymv=<%=vl.getMav()%>">Hủy Apply</a>	
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