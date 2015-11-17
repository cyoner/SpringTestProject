var myApp = 
	angular.module('restFulTest', [ 'ngMaterial', 'ngMessages', 'ngRoute', 'ngMdIcons' ])
	.config( [ '$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		$routeProvider.when('/login', {
			templateUrl : 'login',
			controller : 'UserCtrl'
		}).when('/getUserListPage', {
			templateUrl : 'getUserListPage',
			controller : 'UserCtrl'
		}).when('/signUp', {
			templateUrl : 'signUp',
			controller : 'UserCtrl'
		}).when('/UpdateUser', {
			templateUrl : 'UpdateUser',
			controller : 'UserCtrl'
		}).when('/welcome', {
			templateUrl : 'welcome',
			controller : 'UserCtrl'
		}).when('/leaveUser', {
			templateUrl : 'leaveUser',
			controller : 'UserCtrl'
		}).otherwise({
			redirectTo : '/login',
			controller : 'UserCtrl'
		});
	}])
	.controller( 'UserCtrl',[ '$scope', '$http', '$mdToast', 
	                          '$location', '$mdSidenav', '$mdDialog',
	function($scope, $http, $mdToast, $location,$mdSidenav,$mdDialog) {
			
		// 변수 선언 및 초기화
		$scope.menus = 
			[ { "name" : "Sign In",			"link" : "/login"			},
			  {	"name" : "Sign Up",			"link" : "/signUp"			},
			  {	"name" : "Member Update",	"link" : "/UpdateUser" 		},
			  { "name" : "Member List",		"link" : "/getUserListPage"	},
			  {	"name" : "Member Leave",	"link" : "/leaveUser"		} ];
		$scope.user = null;
		$scope.passwd2="";
		$scope.chkIdMsg = null;
		$scope.chkPwMsg = null;
		// 유저 초기화
		$scope.userInit = function () {
			$scope.user = 
				{	"id" : "",	"passwd" : "",	"first_name" : "",	
					"last_name" : "",	"grade" : 1	};	
		};
		
		// 함수 선언
		$scope.simpleToast = function(string) {
			$mdToast.show($mdToast.simple().content(string).hideDelay(1000));
		};
		$scope.movePage = function(url) {
			$location.path(url);
		};
		
		$scope.userInit();
		
		// 유저 정보 확인을 위한 다이어로그 불러오는 함수
		$scope.showUserDetail = function(user, ev) {
			var str = 
			  "<p> user Name : "		+ user.first_name +  user.last_name + "</p>"+
			  "<p> user grade : "		+ user.grade 						+ "</p>"+
			  "<p> user id : "			+ user.id 							+ "</p>"+
			  "<p> user password : "	+ user.passwd 						+ "</p>"+
			  "<p> user loginState : "	+ user.loginState 					+ "</p>"+
			  "<p> user verification : "+ user.verification 				+ "</p>"
			$mdDialog.show(
			   $mdDialog.alert()
			    		.parent(angular.element
			    					(document.querySelector('#popupContainer')))
			    		.clickOutsideToClose(true)
			    		.title('User Detail Info')
			    		.content(str)
			    		.ariaLabel('Alert Dialog Demo')
			    		.ok('OK!')
			    		.targetEvent(ev) );
		};

		$scope.checkUseableId = function() {
			var msg = null; 
			var id = $scope.user.id;
			if (id=="") { msg="아이디를 입력하지 않았습니다."; 
			} else if (id.indexOf(" ")>=0) {
				msg = "아이디에 공백을 사용할 수 없습니다.";
			} else if (id.length<6 || id.length>12) {
				msg = "아이디를 6~12자까지 입력해주세요.";
			} else {
				for (var i=0; i < id.length; i++ ) {
					ch=id.charAt(i);
					if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z')) {
						msg = "아이디는 소문자, 숫자만 입력가능합니다.";
					}
				}
			}
			if ( msg == null ) {
				$http.post('checkUser', $scope.user).success(function(data) {
						var msg = ""; 
					if (data) { msg = '이미 존재하는 아이디입니다';
					} else { msg = '사용 가능한 아이디입니다'; }
					$scope.chkIdMsg = msg;
				});
			} else {
				$scope.chkIdMsg = msg;
			}
		};

		$scope.checkPassword = function () {
			var msg = null;
			if ($scope.user.passwd=="") {
				msg = ""; 
			} else if ($scope.user.passwd.length<4 || $scope.passwd2.length>8) {
				msg = "비밀번호를 4~8자까지 입력해주세요.";
			} else if ($scope.user.passwd !=$scope.passwd2) {
				msg = "비밀번호가 일치하지 않습니다";
			} else {
				msg = "사용 가능한 비밀번호 입니다.";
			}
			$scope.chkPwMsg = msg;
		};
		
		// RestFul API 불러오기
		$scope.getUserList = function () {
			$http.post('getUserList').success(function(data) {
				$scope.userList = data.result_list;
			});
		};
		
		$scope.signIn = function() {
			$http.post('checkSignIn', $scope.user).success(function(data) {
				var msg = null;
				switch (data) {
				case 1: msg = "아이디가 등록되어 있지 않습니다."; break;
				case 2: msg = "비밀번호가 맞지 않습니다. "; 	break;
				case 3: msg = "정상적으로 로그인 되었습니다.";	break;
				}
				$scope.simpleToast(msg);
				if (data == 3) { $scope.movePage('/welcome'); }
			});
		};

		$scope.addUser = function() {
			$http.post('addUser', $scope.user).success(function(data) {
				$scope.userInit();
				$scope.simpleToast('회원 가입이 완료되었습니다.');
				$scope.movePage('/login');
			}).error(function(data, status, headers, config) {
				$scope.simpleToast('회원 가입에 실패하였습니다.');
				$scope.movePage('/login');
			});
		};
		
		$scope.updateUserInfo = function() {
			$http.post('updateUserInfo', $scope.user).success(function() {
				$scope.simpleToast('회원 정보가 변경되었습니다.');
				$scope.movePage('/login');
			});
		};



		$scope.dropUser = function() {
			var msg ="";
			$http.post('dropUser', $scope.user.id).success(function(data) {
				if (data == 1)
					msg = $scope.user.id + "이(가) 성공적으로 삭제되었습니다.";
				else {
					msg = $scope.user.id + "이(가) 존재하지 않는 유저이거나 이미 삭제 되었습니다. ";
				}
				$scope.simpleToast(msg);
			});
		};

		$scope.getUser = function() {
			$http.post('getUser', $scope.user).success(function(data) {
				$scope.user = data;
			});
		}

		$scope.checkUser = function() {
			$http.post('checkUser', $scope.user).success(function(data) {
				var msg = ""; 
				if (data) { msg = '사용 할 수 없는 아이디입니다';
				} else { msg = '사용 가능한 아이디입니다'; }
				$scope.simpleToast(msg);
			});
		};
}]);
