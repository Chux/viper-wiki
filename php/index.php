<!DOCTYPE html>
<html>
	<!-- Frontend for Viper Wiki 1.1 -->
	<head>
		<meta charset="UTF-8">
		<title>Artikelnamn | Viper Wiki instans</title>
		<link rel="stylesheet" type="text/css" href="layout.css">
		<script type="text/javascript" src="js/setup.js" ></script>
		<script type="text/javascript" src="js/lib/jquery-1.4.3.min.js" ></script>
		<script type="text/javascript" src="js/Model.js" ></script>
		<script type="text/javascript" src="js/ArticleModel.js" ></script>
		<script type="text/javascript" src="js/ApiConnection.js" ></script>
		<script type="text/javascript" src="js/UserModel.js" ></script>
		<script type="text/javascript" src="js/AuthModel.js" ></script>
		<script type="text/javascript" src="js/ajaxtest.js" ></script>
	</head>
	<body>
		<header>
			<a href="#" title="Home">
				<img id="logo" alt="Viper Wiki logo" src="logo.png">
			</a>
			<menu>
				<li><a href="#">Menyval1</a></li>
				<li><a href="#">Menyval2</a></li>
				<li><a href="#">Menyval3</a></li>
			</menu>
			<div id="login"><a href="" id="loginLink">Logga In </a>
			</div>
			<form id="search" method="post" action="#">
				<input type="text" name="search_text" id="search_text">
				<input type="submit" name="search_submit" id="search_submit" value="Search">
			</form>
		</header>
		<div id="errormessages"></div>
		<article id="article">
		</article>
		<footer>
			Här kan man ju skriva någonslags copyleft notice 2010
		</footer>
	</body>
</html>
