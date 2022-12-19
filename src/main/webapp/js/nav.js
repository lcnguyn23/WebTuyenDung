/**
 * Navigation
 */
 
 const createNav = () => {
    let nav = document.querySelector('.navbar');

    nav.innerHTML = `
        <div class="nav">
			<a href="#"><img
				src="${pageContext.request.contextPath}/img/logo.jpg"
				class="brand-logo"></a>
			<div class="nav-links">
				<a href="#" class="nav-link">Đăng tuyển dụng</a>
				<a href="#" class="nav-link">Tìm việc</a>
			</div>
			<div class="nav-items">
				<div class="search">
					<input type="text" class="search-box"
						placeholder="search jobs, company,...">
					<button class="search-btn">
						<i class="fa-solid fa-magnifying-glass fa-lg"></i>
					</button>
				</div>
				<a href="#"><i class="fa-solid fa-user fa-xl"></i></a> 
				<a href="#"><i class="fa-solid fa-cart-shopping fa-xl"></i></a>
			</div>
		</div>
		<ul class="links-container">
			<li class="link-item"><a href="#" class="link">Quản lý tin tuyển dụng</a></li>
			<li class="link-item"><a href="#" class="link">Quản lý việc làm</a></li>
		</ul>
    `;
}

createNav();