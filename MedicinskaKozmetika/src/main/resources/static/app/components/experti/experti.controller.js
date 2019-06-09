var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("expertiCtrl", function($scope, $http, $location) {

	$scope.experti = [];

	$scope.expert = {};
	$scope.expert.id = "";
	$scope.expert.ime = "";
	$scope.expert.prezime = "";
	$scope.expert.zvanje = "";
	$scope.expert.email = "";
	$scope.expert.telefon = "";
	$scope.expert.opis = "";
	$scope.expert.slika = "";
	
	var expertiUrl = "/api/eksperti";
	
	var getExperti = function() {
		$http.get(expertiUrl).then(function success(res) {
			$scope.experti = res.data;

		}, function error() {
			alert("Couldn't get experti!");
		});
	}

	getExperti();
	
	$scope.sendMessage = function(id) {
		$location.path("experti/send-message/" + id);
	}	
	
});