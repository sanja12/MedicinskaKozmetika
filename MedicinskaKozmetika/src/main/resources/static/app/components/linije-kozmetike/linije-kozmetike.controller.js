var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("linijeKozmetikeCtrl", function($scope, $http, $location) {

	$scope.linijeKozmetike = [];

	$scope.linijaKozmetike = {};
	$scope.linijaKozmetike.id = "";
	$scope.linijaKozmetike.naziv = "";
	$scope.linijaKozmetike.datumLansiranja = "";
	$scope.linijaKozmetike.opis = "";
	
	$scope.newLinijaKozmetike = {};
	$scope.newLinijaKozmetike.id = "";
	$scope.newLinijaKozmetike.naziv = "";
	$scope.newLinijaKozmetike.datumLansiranja = "";
	$scope.newLinijaKozmetike.opis = "";
	
	var linijeKozmetikeUrl = "/api/linije-kozmetike";
	
	var getLinijeKozmetike = function() {
		$http.get(linijeKozmetikeUrl).then(function success(res) {
			$scope.linijeKozmetike = res.data;

		}, function error() {
			alert("Couldn't get linijeKozmetike!");
		});
	}

	getLinijeKozmetike();

	$scope.goToProizvodi = function(id) {
		$location.path("linije-kozmetike/" + id + "/proizvodi");
	}
	
	$scope.visible = false;
	
	$scope.show = function() {
		if($scope.visible) {
			$scope.visible = false;
			return;
		}
		
		$scope.visible = true;
	}
	
	$scope.doAdd = function() {
		$http.post(("/api/linije-kozmetike"), $scope.newLinijaKozmetike).then(function success() {
			getLinijeKozmetike();
			
			$scope.newLinijaKozmetike = {};
			$scope.newLinijaKozmetike.id = "";
			$scope.newLinijaKozmetike.naziv = "";
			$scope.newLinijaKozmetike.datumLansiranja = "";
			$scope.newLinijaKozmetike.opis = "";
			
			$scope.visible = false;
			
		}, function error() {
			alert("Something went wrong.");
		});
	}
	
	$scope.delete = function(id) {

		$http.delete("/api/linije-kozmetike/" + id).then(function success() {
			getLinijeKozmetike();
			
		}, function error() {
			alert("Could not delete a linija kozmetike!");
		});
	}
	
	$scope.visible2 = false;
	
	$scope.goToEdit = function(id) {
		$http.get("/api/linije-kozmetike/" + id).then(function success(res) {
			$scope.linijaKozmetike = res.data;

		}, function error() {
			alert("Could not get a linija kozmetike!")
		});
		
		if($scope.visible2) {
			$scope.visible2 = false;
			return;
		}
		
		$scope.visible2 = true;
	}
	

	$scope.doEdit = function(id) {
		var url = "/api/linije-kozmetike/" + id;

		$http.put(url, $scope.linijaKozmetike).then(function success(res) {
			$scope.visible2 = false;
			getLinijeKozmetike();

		}, function error() {
			alert("Could not edit a linija kozmetike!")
		});
	}
	
});