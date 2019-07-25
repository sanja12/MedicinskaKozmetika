var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("promocijeCtrl", function($scope, $http, $location) {

	$scope.promocije = [];

	$scope.promocija = {};
	$scope.promocija.id = "";
	$scope.promocija.apotekaDTO = "";
	$scope.promocija.datum = "";
	$scope.promocija.vrijeme = "";
	$scope.promocija.tipPromocije = "";
	$scope.promocija.dodatniOpisPromocije = "";

	var promocijeUrl = "/api/promocije";
	
	$scope.searchParams = {};
	$scope.searchParams.naziv = "";
	$scope.searchParams.grad = "";
	$scope.searchParams.lanac = "";

	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	var getPromocije = function() {

	        var config = {params: {}};

	        config.params.pageNum = $scope.pageNum;

	        if($scope.searchParams.naziv != ""){
	            config.params.naziv = $scope.searchParams.naziv;
	        }

	        if($scope.searchParams.grad != ""){
	            config.params.grad = $scope.searchParams.grad;
	        }
	        
	        if($scope.searchParams.lanac != ""){
	            config.params.lanac = $scope.searchParams.lanac;
	        }
	        	        
	        $http.get(promocijeUrl, config)
            .then(function success(data){
                $scope.promocije = data.data;
  
                $scope.totalPages = data.headers('totalPages');
  
            });
	    };
	    
	    getPromocije();

	$scope.changePage = function(direction) {
		$scope.pageNum = $scope.pageNum + direction;
		getPromocije();
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