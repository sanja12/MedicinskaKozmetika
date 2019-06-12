var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("linijeKozmetikeCtrl", function($scope, $http, $location) {

	$scope.linijeKozmetike = [];

	$scope.linijaKozmetike = {};
	$scope.linijaKozmetike.id = "";
	$scope.linijaKozmetike.naziv = "";
	$scope.linijaKozmetike.datumLansiranja = "";
	$scope.linijaKozmetike.opis = "";
	
	var linijeKozmetikeUrl = "/api/linije-kozmetike";
	
	var getlinijeKozmetike = function() {
		$http.get(linijeKozmetikeUrl).then(function success(res) {
			$scope.linijeKozmetike = res.data;

		}, function error() {
			alert("Couldn't get linijeKozmetike!");
		});
	}

	getlinijeKozmetike();


	$scope.doSearch = function() {
		$scope.pageNum = 0;
		getApoteke();
	}

	
	
	$scope.goToEdit = function(id) {
		$location.path("apoteke/edit/" + id);
	}
	
	$scope.delete = function(id) {

		$http.delete("/api/apoteke/" + id).then(function success() {
			getApoteke();
			
		}, function error() {
			alert("Could not delete a apoteka!");
		});
	}
	
	$scope.deleteLanacApoteka = function(id) {

		$http.delete("/api/lanci-apoteka/" + id).then(function success() {
			getLanciApoteka();
			
		}, function error() {
			alert("Could not delete a lanac apoteka!");
		});
	}	
	
	$scope.goToEditLanacApoteka = function(id) {
		$location.path("lanci-apoteka/edit/" + id);
	}
	
	$scope.listApoteke = function(id) {
		$scope.searchParams.lanac = id;
		getApoteke();

	}
	
	$scope.doAdd = function() {
		$http.post(("/api/knjige"), $scope.newKnjiga).then(function success() {
			getKnjige();
			
			$scope.newKnjiga = {};
			$scope.newKnjiga.id = "";
			$scope.newKnjiga.naziv = "";
			$scope.newKnjiga.glasovi = "0";
			$scope.newKnjiga.pisac = "";
			$scope.newKnjiga.izdavacId = "";
			$scope.newKnjiga.izdavacNaziv = "";
			$scope.newKnjiga.izdanje = "";
			$scope.newKnjiga.isbn = "";
			
		}, function error() {
			alert("Something went wrong.");
		});
	}

	$scope.glasaj = function(id) {
		var url = "/api/knjige/" + id + "/glasaj";

		$http.post(url).then(function success() {
			getKnjige();
			alert("Uspjesno ste glasali! :)")
		}, function error() {
			alert("Neuspjesno glasanje!")
		});
	}
	
	var getNajvise = function() {
		var url = "/api/knjige/najvise";

		$http.get(url).then(function success(res) {
			$scope.knjiga = res.data;
			
		}, function error() {
			alert("Neuspjesno ucitavanje knjige sa najvecim brojem glasova!")
		});
	}
	
	$scope.edit = function(id) {
		var url = "/api/knjige/" + id;

		$http.get(url).then(function success(res) {
			$scope.newKnjiga = res.data;
			getKnjige();

		}, function error() {
			alert("Neuspjesno!")
		});
	}
	

	
});