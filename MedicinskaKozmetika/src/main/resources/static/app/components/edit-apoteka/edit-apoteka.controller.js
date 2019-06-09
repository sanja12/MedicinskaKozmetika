var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("editCtrl", function($scope, $http, $routeParams,
		$location) {

	$scope.lanciApoteka = [];

	$scope.newApoteka = {};
	$scope.newApoteka.id = "";
	$scope.newApoteka.naziv = "";
	$scope.newApoteka.adresa = "";
	$scope.newApoteka.grad = "";
	$scope.newApoteka.telefon = "";
	$scope.newApoteka.email = "";
	$scope.newApoteka.lanacApotekaId = "";
	$scope.newApoteka.lanacApotekaNaziv = "";

	var apotekaUrl = "/api/apoteke/" + $routeParams.id;
	var lanciApotekaUrl = "/api/lanci-apoteka";

	var getlanciApoteka = function() {
		$http.get(lanciApotekaUrl).then(function success(res) {
			$scope.lanciApoteka = res.data;
			getApoteka();
		}, function error() {
			alert("Something went wrong.");
		});
	}

	getlanciApoteka();

	var getApoteka = function() {

		$http.get(apotekaUrl).then(function success(res) {
			$scope.newApoteka = res.data;
		}, function error() {
			alert("Something went wrong.");
		});
	};
	
	
	$scope.removeLanac = function() {
		$scope.newApoteka.lanacApotekaId = "null";
		getApoteka();
	}

	$scope.doEdit = function() {

		$http.put(apotekaUrl, $scope.newApoteka).then(function success() {
			$location.path("/apoteke");
		}, function error() {
			alert("Something went wrong.");
		});
	}
});