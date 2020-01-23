<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<!--
	Ethereal by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>LEGGO</title>
<meta charset="euc-kr" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?
	appkey=be626cc1f959d4787a1d8381c33922e7&libraries=services,clusterer,drawing"></script>
<style type="text/css">
#text {
	font-family: ����ǹ��� ������ü TTF; /* ����ǹ��� ����; */
	text-transform: uppercase;
	background: linear-gradient(to right, #30CFD0 0%, #330867 100%);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}

#header {
	text-align: center;
}

#content1 {
	height: 450px;
	/* background-color: red;
					opacity: 0.2; */
	margin: 0 auto;
	text-align: center;
	width: 100%;
	margin-top: -20px;
	padding: 3.5rem 3.5rem 2rem 3.5rem;
}

.menuImg {
	width: 170px;
	height: 170px;
}

.menuBtn {
	width: 200px;
	display: inline-block;
	margin: 20px;
}
/************�ؼ� CSS ����****************/
#back {
	background-color: #ffffff;
	width: 80%;
	height: 52%;
	padding: 5px;
}

#road {
	font-size: 50px;
	font: bold;
	color: white;
	margin-bottom: 10px;
}

#search {
	background-color: #2f5597;
	width: 80%;
}

#home {
	padding-left: 6%;
}

.button_gr {
	background-color: #5b9bd5;
	width: 70%;
	height: 25%;
	margin: 10px;
	color: black;
	font-size: 50pt;
	font: bold;
	font-family: HY�߰��;
}

#input {
	background-color: gray;
	padding-top: 12px;
}

input::-webkit-input-placeholder {
	color: white;
	font-style: italic;
}

input::-ms-input-placeholder {
	color: white;
	font-style: italic;
}

#favorite {
	color: #fee599;
}
/************�ؼ� CSS �������****************/
</style>
</head>
<body class="is-preload">
	<div id="page-wrapper">
		<div id="wrapper">

			<section class="panel banner right">
				<div class="content color1 span-6">
					<div id="outer">
						<!-- --------------ù ������ �Դϴ�-------------- -->
						<div id="header">
							<a href="#second" id="logo"> <img
								src="../LEGGO/images/leggo/MainLogo.png" width=10% height=10%>
							</a>
							<h1 id="text">What makes you connected?</h1>

						</div>
					</div>
				</div>
			</section>
<!-- ���� html ���� !!!!!-->
			
			<!-- --------------�� ��° ������ �Դϴ�-------------- -->
			<section class="panel banner left" id="second">
				<div class="content span-2" style="background-color: #2f5597;">
					<div align="center">
						<!-- --------------�ΰ�-------------- -->
						<div id="road">
							<img src="./images/mark.jpg" alt="��ũ" width="50" height="50" />
							�� ã��
						</div>
						<div id="search">
							<form action="" method="get">
								<!-- <div id="input">  -->
								<input type="text" name="search" placeholder="�˻��ϼ���"
									style="width: 80%;" /><br />
								<!-- </div>  -->
								<input type="submit" class="button primary color2"
									style="font-size: 20px;" value="�˻�"> <input
									type="reset" class="button primary color2"
									style="font-size: 20px;" value="�ٽ��Է�">
							</form>
						</div>
						<div id="back">
							<div id="menu">
								<input type="image" name="home" id="home"
									src="./images/LeggoLogo.png" style="width: 85px; height: 55px;"
									onclick="location.href='https://www.google.com'" /><br />
								<!-- --------------�޴�4�� ������-------------- -->
								<div>


									<a href="road_map.html" class="button primary color2"
										style="width: 70%; margin: 10px; font-size: 20px;">��ã��</a><br />
									<a href="road_map.html" class="button primary color2"
										style="width: 70%; margin: 10px; font-size: 20px;">��</a><br />
									<a href="road_map.html" class="button primary color2"
										style="width: 70%; margin: 10px; font-size: 20px;">P</a><br />
									<a href="road_map.html" class="button primary color2"
										style="width: 70%; margin: 10px; font-size: 20px;">Last
										Miles</a><br />
								</div>
							</div>
						</div>
						<br />
						<div>
							<a href="#third"
								class="button primary color1 circle icon solid fa-angle-right">Next</a>
						</div>
					</div>
				</div>
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
				
				<div class="content color1 span-4" id="map" style="height: 100%;">
					<script>
						var container = document.getElementById('map');
						//������ ���� ������ DOM ���۷���
						var options = {//������ ������ �� �ʿ��� �⺻ �ɼ�
							/* center: new kakao.maps.LatLng(37.38611, 126.570667),//������ �߽���ǥ */
							center : new kakao.maps.LatLng(37.4871, 127.0529),//������ �߽���ǥ
							level : 3
						// ������ ����(Ȯ��, ��� ����)
						};

						var map = new kakao.maps.Map(container, options);
						//���� ���� �� ��ü ����

						// ��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
						if(navigator.geolocation) {
							navigator.geolocation.getCurrentPosition(function(position) {
								var lat = position.coords.latitude; //����
								var	lng = position.coords.longitude; //�浵
								
								var locPosition = new kakao.maps.LatLng(lat, lng), //��Ŀ�� ǥ�õ� ��ġ
									message = '<div style="padding:5px;">���⿡ ��Ű���?</div>';
								//��Ŀ�� ���������츦 ǥ���Ѵ�.
								displayMarker(locPosition,message);
							
							});
						} else {
							
						}
						
							//������ ��Ŀ�� ���������츦 ǥ���ϴ� �Լ��̴�.
							function displayMarker(locPosition, message){
												
							// ��Ŀ�� �����մϴ�
							var marker = new kakao.maps.Marker({
								map: map,
								position : locPosition
							});

							// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
							//marker.setMap(map);
						
							//���������쿡 ǥ���� ����
							var iwContent = message,
								iwRemoveable = true;
							//���������츦 �����Ѵ�.
							var infowindow = new kakao.maps.InfoWindow({
								content : iwContent,
								removable : iwRemoveable
							});
						
						
							//���������츦 ��Ŀ���� ǥ���Ѵ�.
							infowindow.open(map,marker);
							//���� �߽���ǥ�� ������ġ�� �����Ѵ�.
							map.setCenter(locPosition);
						}	
						// ��Ŀ�� �巡�� �����ϵ��� �����մϴ� 
						//marker.setDraggable(true);
					</script>
				</div>

			</section>
<!-- ���� html �ڵ� ��!!!!! -->
			<!-- Panel (Spotlight) -->
			<section class="panel spotlight medium right" id="third">
				<div class="content span-7">
					<h2 class="major">Sed etiam aenean</h2>
					<p>Mauris et ligula arcu. Proin dapibus convallis accumsan.
						Lorem maximus hendrerit orci, sit amet elementum massa hendrerit
						sed. Donec et ullamcorper ligula. Suspendisse amet potenti. Ut
						pretium libero eleifend euismod sed tristique. Quisque dictum
						magna risus, id ultricies justo sagittis vitae. Sed id odio
						tempor, porttitor elit amet, gravida hendrerit fringilla lorem
						ipsum dolor.</p>
				</div>
				<div class="image filtered tinted" data-position="top left">
					<img src="images/pic02.jpg" alt="" />
				</div>
			</section>

			<!-- Panel -->
			<section class="panel color1">
				<div class="intro joined">
					<h2 class="major">Amet lorem</h2>
					<p>Sed vel nibh libero. Mauris et lorem pharetra massa lorem
						turpis congue pulvinar. Vivamus sed feugiat finibus. Duis amet
						bibendum amet sed. Duis mauris ex, dapibus sed ligula tempus
						volutpat magna etiam.</p>
				</div>
				<div class="inner">
					<ul class="grid-icons three connected">
						<li><span class="icon fa-gem"><span class="label">Lorem</span></span></li>
						<li><span class="icon solid fa-camera-retro"><span
								class="label">Ipsum</span></span></li>
						<li><span class="icon solid fa-cog"><span
								class="label">Dolor</span></span></li>
						<li><span class="icon solid fa-paper-plane"><span
								class="label">Sit</span></span></li>
						<li><span class="icon solid fa-chart-bar"><span
								class="label">Amet</span></span></li>
						<li><span class="icon solid fa-code"><span
								class="label">Nullam</span></span></li>
					</ul>
				</div>
			</section>

			<!-- Panel (Spotlight) -->
			<section class="panel spotlight large left">
				<div class="content span-5">
					<h2 class="major">Magna amet tempus</h2>
					<p>Mauris a cursus velit. Nunc lacinia sollicitudin egestas
						bibendum, magna dui bibendum ex, sagittis commodo enim risus sed
						magna nulla. Vestibulum ut consequat velit. Curabitur vitae libero
						lorem. Quisque iaculis porttitor blandit. Nullam quis sagittis
						maximus. Sed vel nibh libero. Mauris et lorem pharetra massa lorem
						turpis congue pulvinar.</p>
				</div>
				<div class="image filtered tinted" data-position="top right">
					<img src="images/pic03.jpg" alt="" />
				</div>
			</section>

			<!-- Panel -->
			<section class="panel">
				<div class="intro color2">
					<h2 class="major">Elit integer</h2>
					<p>Sed vel nibh libero. Mauris et lorem pharetra massa lorem
						turpis congue pulvinar. Vivamus sed feugiat finibus. Duis amet
						bibendum amet sed. Duis mauris ex, dapibus sed ligula tempus
						volutpat magna etiam.</p>
				</div>
				<div class="gallery">
					<div class="group span-3">
						<a href="images/gallery/fulls/01.jpg"
							class="image filtered span-3" data-position="bottom"><img
							src="images/gallery/thumbs/01.jpg" alt="" /></a> <a
							href="images/gallery/fulls/02.jpg"
							class="image filtered span-1-5" data-position="center"><img
							src="images/gallery/thumbs/02.jpg" alt="" /></a> <a
							href="images/gallery/fulls/03.jpg"
							class="image filtered span-1-5" data-position="bottom"><img
							src="images/gallery/thumbs/03.jpg" alt="" /></a>
					</div>
					<a href="images/gallery/fulls/04.jpg"
						class="image filtered span-2-5" data-position="top"><img
						src="images/gallery/thumbs/04.jpg" alt="" /></a>
					<div class="group span-4-5">
						<a href="images/gallery/fulls/05.jpg"
							class="image filtered span-3" data-position="top"><img
							src="images/gallery/thumbs/05.jpg" alt="" /></a> <a
							href="images/gallery/fulls/06.jpg"
							class="image filtered span-1-5" data-position="center"><img
							src="images/gallery/thumbs/06.jpg" alt="" /></a> <a
							href="images/gallery/fulls/07.jpg"
							class="image filtered span-1-5" data-position="bottom"><img
							src="images/gallery/thumbs/07.jpg" alt="" /></a> <a
							href="images/gallery/fulls/08.jpg" class="image filtered span-3"
							data-position="top"><img src="images/gallery/thumbs/08.jpg"
							alt="" /></a>
					</div>
					<a href="images/gallery/fulls/09.jpg"
						class="image filtered span-2-5" data-position="right"><img
						src="images/gallery/thumbs/09.jpg" alt="" /></a>
				</div>
			</section>

			<!-- Panel -->
			<section class="panel color4-alt">
				<div class="intro color4">
					<h2 class="major">Contact</h2>
					<p>Sed vel nibh libero. Mauris et lorem pharetra massa lorem
						turpis congue pulvinar. Vivamus sed feugiat finibus. Duis amet
						bibendum amet sed. Duis mauris ex, dapibus sed ligula tempus
						volutpat magna etiam.</p>
				</div>
				<div class="inner columns divided">
					<div class="span-3-25">
						<form method="post" action="#">
							<div class="fields">
								<div class="field half">
									<label for="name">Name</label> <input type="text" name="name"
										id="name" />
								</div>
								<div class="field half">
									<label for="email">Email</label> <input type="email"
										name="email" id="email" />
								</div>
								<div class="field">
									<label for="message">Message</label>
									<textarea name="message" id="message" rows="4"></textarea>
								</div>
							</div>
							<ul class="actions">
								<li><input type="submit" value="Send Message"
									class="button primary" /></li>
							</ul>
						</form>
					</div>
					<div class="span-1-5">
						<ul class="contact-icons color1">
							<li class="icon brands fa-twitter"><a href="#">@untitled-tld</a></li>
							<li class="icon brands fa-facebook-f"><a href="#">facebook.com/untitled</a></li>
							<li class="icon brands fa-snapchat-ghost"><a href="#">@untitled-tld</a></li>
							<li class="icon brands fa-instagram"><a href="#">@untitled-tld</a></li>
							<li class="icon brands fa-medium-m"><a href="#">medium.com/untitled</a></li>
						</ul>
					</div>
				</div>
			</section>

			<!-- Panel -->
			<section class="panel color2-alt">
				<div class="intro color2">
					<h2 class="major">Elements</h2>
					<p>Sed vel nibh libero. Mauris et lorem pharetra massa lorem
						turpis congue pulvinar. Vivamus sed feugiat finibus. Duis amet
						bibendum amet sed. Duis mauris ex, dapibus sed ligula tempus
						volutpat magna etiam.</p>
				</div>
				<div class="inner columns aligned">
					<div class="span-2-75">

						<h3 class="major">Text</h3>
						<p>
							This is <b>bold</b> and this is <strong>strong</strong>. This is
							<i>italic</i> and this is <em>emphasized</em>. This is <sup>superscript</sup>
							text and this is <sub>subscript</sub> text. This is <u>underlined</u>
							and this is code:
							<code>for (;;) { ... }</code>
							. Finally, <a href="#">this is a link</a>.
						</p>

						<h1>Heading Level 1</h1>
						<h2>Heading Level 2</h2>
						<h3>Heading Level 3</h3>
						<h4>Heading Level 4</h4>
						<h5>Heading Level 5</h5>
						<h6>Heading Level 6</h6>

					</div>
					<div class="span-3">

						<h4>Blockquote</h4>
						<blockquote>Lorem ipsum dolor sit amet. Felis
							sagittis eget tempus euismod. Vestibulum ante ipsum primis in
							vestibulum. Blandit adipiscing eu iaculis volutpat ac adipiscing
							volutpat ac adipiscing faucibus.</blockquote>

						<h4>Preformatted</h4>
						<pre>
							<code>i = 0;

while (!deck.isInOrder()) {
    print 'Iteration ' + (i++);
    deck.shuffle();
}

print 'It took ' + i + ' iterations to sort the deck.';</code>
						</pre>

					</div>
					<div class="span-1-25">

						<h3 class="major">Lists</h3>

						<h4>Unordered</h4>
						<ul>
							<li>Lorem ipsum dolor sit.</li>
							<li>Dolor pulvinar etiam.</li>
							<li>Etiam vel felis viverra.</li>
						</ul>

						<h4>Alternate</h4>
						<ul class="alt">
							<li>Lorem ipsum dolor sit.</li>
							<li>Dolor pulvinar etiam.</li>
							<li>Etiam vel felis viverra.</li>
							<li>Felis enim feugiat.</li>
						</ul>

					</div>
					<div class="span-1-5">

						<h4>Ordered</h4>
						<ol>
							<li>Lorem ipsum dolor sit.</li>
							<li>Dolor pulvinar etiam.</li>
							<li>Etiam vel felis viverra.</li>
							<li>Felis enim feugiat.</li>
							<li>Etiam vel felis lorem.</li>
						</ol>

						<h4>Actions</h4>
						<ul class="actions">
							<li><a href="#" class="button primary color2">Default</a></li>
							<li><a href="#" class="button">Default</a></li>
						</ul>
						<ul class="actions stacked">
							<li><a href="#" class="button primary color2">Default</a></li>
							<li><a href="#" class="button">Default</a></li>
						</ul>

					</div>
					<div class="span-1-25">

						<h4>Icons</h4>
						<ul class="icons">
							<li><a href="#" class="icon brands fa-twitter"><span
									class="label">Twitter</span></a></li>
							<li><a href="#" class="icon brands fa-facebook-f"><span
									class="label">Facebook</span></a></li>
							<li><a href="#" class="icon brands fa-instagram"><span
									class="label">Instagram</span></a></li>
							<li><a href="#" class="icon brands fa-github"><span
									class="label">GitHub</span></a></li>
							<li><a href="#" class="icon brands fa-medium-m"><span
									class="label">Medium</span></a></li>
						</ul>

						<h4>Contact Icons</h4>
						<ul class="contact-icons color2">
							<li class="icon brands fa-twitter"><a href="#">Twitter</a></li>
							<li class="icon brands fa-facebook-f"><a href="#">Facebook</a></li>
							<li class="icon brands fa-instagram"><a href="#">Instagram</a></li>
							<li class="icon brands fa-github"><a href="#">GitHub</a></li>
							<li class="icon brands fa-medium-m"><a href="#">Medium</a></li>
						</ul>

					</div>
					<div class="span-3">
						<h3 class="major">Table</h3>
						<h4>Default</h4>
						<div class="table-wrapper">
							<table>
								<thead>
									<tr>
										<th>Name</th>
										<th>Description</th>
										<th>Price</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Item One</td>
										<td>Ante turpis integer aliquet porttitor.</td>
										<td>29.99</td>
									</tr>
									<tr>
										<td>Item Two</td>
										<td>Vis ac commodo adipiscing arcu aliquet.</td>
										<td>19.99</td>
									</tr>
									<tr>
										<td>Item Three</td>
										<td>Morbi faucibus arcu accumsan lorem.</td>
										<td>29.99</td>
									</tr>
									<tr>
										<td>Item Four</td>
										<td>Vitae integer tempus condimentum.</td>
										<td>19.99</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="2"></td>
										<td>100.00</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<div class="span-3">
						<h4>Alternate</h4>
						<div class="table-wrapper">
							<table class="alt">
								<thead>
									<tr>
										<th>Name</th>
										<th>Description</th>
										<th>Price</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Item One</td>
										<td>Ante turpis integer aliquet porttitor.</td>
										<td>29.99</td>
									</tr>
									<tr>
										<td>Item Two</td>
										<td>Vis ac commodo adipiscing arcu aliquet.</td>
										<td>19.99</td>
									</tr>
									<tr>
										<td>Item Three</td>
										<td>Morbi faucibus arcu accumsan lorem.</td>
										<td>29.99</td>
									</tr>
									<tr>
										<td>Item Four</td>
										<td>Vitae integer tempus condimentum.</td>
										<td>19.99</td>
									</tr>
									<tr>
										<td>Item Five</td>
										<td>Ante turpis integer aliquet porttitor.</td>
										<td>29.99</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="2"></td>
										<td>100.00</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<div class="span-2-25">
						<h3 class="major">Buttons</h3>
						<ul class="actions">
							<li><a href="#" class="button primary color2">Primary</a></li>
							<li><a href="#" class="button">Default</a></li>
						</ul>
						<ul class="actions">
							<li><a href="#" class="button">Default</a></li>
							<li><a href="#" class="button large">Large</a></li>
							<li><a href="#" class="button small">Small</a></li>
						</ul>
						<ul class="actions">
							<li><a href="#"
								class="button primary color2 icon solid fa-cog">Icon</a></li>
							<li><a href="#" class="button icon fa-gem">Icon</a></li>
						</ul>
						<ul class="actions">
							<li><span class="button primary color2 disabled">Disabled</span></li>
							<li><span class="button disabled">Disabled</span></li>
						</ul>
						<ul class="actions">
							<li><a href="#"
								class="button primary color2 circle icon solid fa-cog">Icon</a></li>
							<li><a href="#" class="button circle icon fa-gem">Icon</a></li>
						</ul>
					</div>
					<div class="span-4-5">
						<h3 class="major">Form</h3>
						<form method="post" action="#">
							<div class="fields">
								<div class="field third">
									<label for="demo-name">Name</label> <input type="text"
										name="demo-name" id="demo-name" value=""
										placeholder="Jane Doe" />
								</div>
								<div class="field third">
									<label for="demo-email">Email</label> <input type="email"
										name="demo-email" id="demo-email" value=""
										placeholder="jane@untitled.tld" />
								</div>
								<div class="field third">
									<label for="demo-category">Category</label>
									<div class="select-wrapper">
										<select name="demo-category" id="demo-category">
											<option value="">-</option>
											<option value="1">Manufacturing</option>
											<option value="1">Shipping</option>
											<option value="1">Administration</option>
											<option value="1">Human Resources</option>
										</select>
									</div>
								</div>
								<div class="field quarter">
									<input type="radio" id="demo-priority-low" name="demo-priority"
										class="color2" checked /> <label for="demo-priority-low">Low
										Priority</label>
								</div>
								<div class="field quarter">
									<input type="radio" id="demo-priority-high"
										name="demo-priority" class="color2" /> <label
										for="demo-priority-high">High Priority</label>
								</div>
								<div class="field quarter">
									<input type="checkbox" id="demo-copy" name="demo-copy"
										class="color2" /> <label for="demo-copy">Email a copy</label>
								</div>
								<div class="field quarter">
									<input type="checkbox" id="demo-human" name="demo-human"
										class="color2" checked /> <label for="demo-human">Not
										a robot</label>
								</div>
								<div class="field">
									<label for="demo-message">Message</label>
									<textarea name="demo-message" id="demo-message"
										placeholder="Enter your message" rows="2"></textarea>
								</div>
							</div>
							<ul class="actions">
								<li><input type="submit" value="Send Message"
									class="primary color2" /></li>
								<li><input type="reset" value="Reset" /></li>
							</ul>
						</form>
					</div>
				</div>
			</section>

			<!-- Copyright -->
			<div class="copyright">
				&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.
			</div>

		</div>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>
