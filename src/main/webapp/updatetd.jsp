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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

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
			<li class="link-item"><a href="quanlytdController" class="link">Quản lý tin tuyển dụng</a></li>
		</ul>
	</nav>
	
	<div class="main-container">
		<div class="main-content">
			<div class="job-content">
				<div class="list-heading-job">
					<div class="layer-heading">
						<ul class="list-ht-job">
							<li class="list-item all active"><a href="">Quản lý tin tuyển dụng</a></li>
						</ul>
					</div>
					
				</div>
				<div class="content-container">
				<%
				vieclambean vl = (vieclambean) request.getAttribute("viec");
				nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");
				ArrayList<linhvucbean> dslv = (ArrayList<linhvucbean>) request.getAttribute("dslv");
				ArrayList<hinhthucbean> dsht = (ArrayList<hinhthucbean>) request.getAttribute("dsht");
				
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
					
					<div class="row-content-1">
						<form class="f-update" action="sua?mv=<%=vl.getMav() %>&ntd=<%=ntd.getMantd() %>" method="post">
							<label>Tên việc</label>
							<input type="text" name="tenv" placeholder="<%=vl.getTenviec()%>">
							<label>Địa điểm</label>
							<input type="text" name="dd" placeholder="<%=vl.getDiadiem()%>">
							<label>Ngân sách tối thiểu</label>
							<input type="text" name="nstt" placeholder="<%=vl.getNgansachtt()%>">
							<label>Ngân sách tối đa</label>
							<input type="text" name="nstd" placeholder="<%=vl.getNgansachtd()%>">
							<label>Kỹ năng</label>
							<input type="text" name="skill" placeholder="<%=vl.getKynang()%>">
							<label>Kinh nghiệm</label>
							<input type="text" name="kn" placeholder="<%=vl.getKinhnghiem()%>">
							<label>Mô tả</label>
							<input type="text" name="mota" placeholder="<%=vl.getMota()%>">
							<label>Hình thức làm việc</label>
							<select name="ht">
								<%for(hinhthucbean ht: dsht){ %>
								<option value="<%=ht.getMaht()%>"><%=ht.getTenht() %></option>
								<%} %>
							</select>
							<label>Lĩnh vực</label>
							<select name="lv">
								<%for(linhvucbean lv: dslv){ %>
								<option value="<%=lv.getMalv()%>"><%=lv.getTenlv() %></option>
								<%} %>
							</select>
							<label>Hạn đăng ký</label>
							<input type="date" name="handk">
							<button>Sửa</button>
						</form>
					</div>
				
					
		
				</div>
			</div>
		</div>
	</div>
</body>
</html>