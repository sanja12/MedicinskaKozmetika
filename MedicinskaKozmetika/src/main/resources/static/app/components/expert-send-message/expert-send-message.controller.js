var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("expertSendMessageCtrl", function($scope, $http,
		$routeParams, $location) {

	$scope.upitKorisnika = {};
	$scope.upitKorisnika.id = "";
	$scope.upitKorisnika.expertId = $routeParams.id;
	$scope.upitKorisnika.email = "";
	$scope.upitKorisnika.lozinka = "";
	$scope.upitKorisnika.text = "";

	var expertUrl = "/api/eksperti/send-message/" + $routeParams.id;

	$scope.send = function() {

		$http.put(expertUrl, $scope.upitKorisnika).then(function success() {
			$location.path("/experti");
		}, function error() {
			alert("Something went wrong.");
		});
	}

});