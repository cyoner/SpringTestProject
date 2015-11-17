<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-messages.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angular_material/0.11.2/angular-material.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/angular-material-icons/0.6.0/angular-material-icons.min.js"></script>
	
	<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/angular_material/0.11.2/angular-material.min.css">
	<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css"></style> 
	<title>Login</title>
	
	 
</head>
<body>
	<div ng-app="restFulTest">
		<div ng-controller="UserCtrl" layout="row" ng-cloak id="popupContainer">
			<div flex="20">
				<md-toolbar class="md-tall" md-scroll-shrink id="toolbarMain">
					<div class="md-body-2 layout-padding">
						Back : Java(Spring)<br>
						Front : AngularJs<br>
						Design : Angular Mamerial Design
				    </div>
				</md-toolbar>
				<md-list-item ng-repeat="menu in menus | orderBy:'idx'" ng-click="movePage(menu.link)">
				  <p> {{ menu.name }}</p>
				</md-list-item>
			</div>
			<div flex="80">
				<div ng-view></div>
			</div>
		</div>
	</div>
</body>
</html>