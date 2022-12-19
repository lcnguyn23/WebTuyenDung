<%@page import="bean.vieclamchitietbean"%>
<%@page import="bean.hinhthucbean"%>
<%@page import="bean.nhatdbean"%>
<%@page import="bean.linhvucbean"%>
<%@page import="bo.vieclambo"%>
<%@page import="dao.vieclamdao"%>
<%@page import="bean.vieclambean"%>
<%@page import="bean.nguoidungbean"%>
<%@page import="bean.soapplybean"%>
<%@page import="dao.soapplydao"%>

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
					
				<%if(session.getAttribute("ntd") != null) { %>
					<a href="logout"><i class="fa-solid fa-right-from-bracket fa-xl"></i></a>
					<a href="thongtinuserController"><i class="fa-solid fa-user fa-xl"></i><h3 class="user-name"><%nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");%><%=ntd.getTenntd() %></h3></a>
					
				<%} else {%>
					<a href="dangnhap.jsp"><button class="login-btn">Đăng nhập</button></a>
					<a href="dangnhap.jsp"><button class="signup-btn">Đăng ký</button></a>
				<%} %>	
				</div>
				
			</div>
		</div>
		<ul class="links-container">
			<li class="link-item"><a href="trangchuController" class="link">Trang chủ</a></li>
			<li class="link-item"><a href="tuyendungController" class="link">Tin tuyển dụng</a></li>
			<li class="link-item"><a href="dangtdController" class="link">Đăng tuyển dụng</a></li>
			<li class="link-item"><a href="quanlytdController" class="link">Quản lý tin tuyển dụng</a></li>
		</ul>
	</nav>
	<%ArrayList<vieclamchitietbean> dsvlct = new ArrayList<>();
	dsvlct = (ArrayList<vieclamchitietbean>) request.getAttribute("dsvlct"); %>
	<div class="main-container">
	
		<div class="main-content">
			<div class="job-content">
				<div class="list-heading-job">
					<div class="layer-heading">
						<ul class="list-ht-job">
							<li class="list-item all active"><a href="">Tất cả tin tuyển dụng (<%=dsvlct.size() %>)</a></li>
						</ul>
					</div>
					
				</div>
				<div class="content-container">
				<%
				ArrayList<soapplybean> dsapply = (ArrayList<soapplybean>) request.getAttribute("dsapply");
				soapplydao sodao = new soapplydao();
				
				int i=0;
				for(vieclamchitietbean vl: dsvlct) { i++;%>
				  <div class="row-content">
						<a class="job-link" href="thongtintdController?mv=<%=vl.getMav()%>">
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
							<div class="c-apply-form">
							<%
							soapplybean so = sodao.getso(vl.getMav());
							if(vl.getMav() == so.getMav()) %>
								<a class="apply" href="thongtintdController?mv=<%=vl.getMav()%>">Số apply: <%=so.getSoapply() %></a>
							<% %>
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