<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/loginsingup.css" />
<title>Admin Login</title>
<style>
	@import 'loginsingup.css';
</style>
</head>
<body>
	<nav class="option-login">
		<ul class="opt-item">
			<li class="opt"><a href="dangnhap.jsp">Người dùng</a></li>
			<li class="opt"><a href="dangnhapntd.jsp">Nhà tuyển dụng</a></li>
			<li class="opt active1"><a href="dangnhapadmin.jsp">Admin</a></li>
		</ul>
	</nav>
	<h2>Admin</h2>
	<div class="container" id="container">
		<div class="form-container sign-in-container">
			<form action="ktdnadmin">
				<h1>Đăng nhập</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
					<input type="text"
					placeholder="Username" name="txtun"/> <input type="password"
					placeholder="Password" name="txtpass"/> <a href="#">Forgot your password?</a>
				<button>Đăng nhập</button>
			</form>
		</div>
	</div>

	<footer>
		<p>
			Created with <i class="fa fa-heart"></i> by <a target="_blank"
				href="https://florin-pop.com">Florin Pop</a> - Read how I created
			this and how you can join the challenge <a target="_blank"
				href="https://www.florin-pop.com/blog/2019/03/double-slider-sign-in-up-form/">here</a>.
		</p>
	</footer>
	
	<%
	if (request.getParameter("kt") != null) {%>
	<script>alert("Thông tin đăng nhập sai")</script> 
	<%}%>
	
	<script>
	const signUpButton = document.getElementById('signUp');
	const signInButton = document.getElementById('signIn');
	const container = document.getElementById('container');

	signUpButton.addEventListener('click', () => {
		container.classList.add("right-panel-active");
	});

	signInButton.addEventListener('click', () => {
		container.classList.remove("right-panel-active");
	});
	</script>
</body>
</html>