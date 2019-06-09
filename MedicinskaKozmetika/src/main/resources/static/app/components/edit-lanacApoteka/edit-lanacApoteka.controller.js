var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("editLanciApotekaCtrl", function($scope, $http, $routeParams,
		$location) {

	$scope.apoteke = [];
	$scope.lanciApoteka = [];

	$scope.apoteka = {};
	$scope.apoteka.id = "";
	$scope.apoteka.naziv = "";
	$scope.apoteka.adresa = "";
	$scope.apoteka.grad = "";
	$scope.apoteka.telefon = "";
	$scope.apoteka.email = "";
	$scope.apoteka.lanacApotekaId = "";
	$scope.apoteka.lanacApotekaNaziv = "";
	
	$scope.lanacApoteka = {};
	$scope.lanacApoteka.id = "";
	$scope.lanacApoteka.naziv = "";
	$scope.lanacApoteka.kontaktOsoba = "";
	$scope.lanacApoteka.email = "";
	$scope.lanacApoteka.telefon = "";

	var apotekeUrl = "/api/apoteke";
	var lanacApotekaUrl = "/api/lanci-apoteka/" + $routeParams.id;

	var getApoteke = function() {
		$http.get(apotekeUrl).then(function success(res) {
			$scope.apoteke = res.data;
			getLanacApoteka();
		}, function error() {
			alert("Something went wrong.");
		});
	}

	getApoteke();

	var getLanacApoteka = function() {

		$http.get(lanacApotekaUrl).then(function success(res) {
			$scope.lanacApoteka = res.data;
		}, function error() {
			alert("Something went wrong with lanci apoteka.");
		});
	};

	$scope.doEdit = function() {

		$http.put(lanacApotekaUrl, $scope.lanacApoteka).then(function success() {
			$location.path("/apoteke");
		}, function error() {
			alert("Something went wrong.");
		});
	}
});