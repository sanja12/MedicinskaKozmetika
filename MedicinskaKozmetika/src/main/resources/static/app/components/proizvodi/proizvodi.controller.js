var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("proizvodiCtrl", function($scope, $http, $routeParams, $location) {

	$scope.proizvodi = [];

	$scope.proizvod = {};
	$scope.proizvod.id = "";
	$scope.proizvod.naziv = "";
	$scope.proizvod.kolicina = "";
	$scope.proizvod.linijaKozmetikeDTO = "";
	$scope.proizvod.opis = "";
	$scope.proizvod.tipProizvoda = "";
	$scope.proizvod.tipoviKoze = "";
	$scope.proizvod.problemiKoze = "";
	$scope.proizvod.mjestaPrimjene = "";
	
	$scope.searchParams = {};
	$scope.searchParams.id = $routeParams.id;

	$scope.pageNum = 0;
	$scope.totalPages = 1;
		
	var getProizvodi = function() {

	        var config = {params: {}};

	        config.params.pageNum = $scope.pageNum;

	        if($scope.searchParams.id != ""){
	            config.params.id = $scope.searchParams.id;
	        }
	        	        
	        $http.get("/api/linije-kozmetike/" + $routeParams.id + "/proizvodi", config)
            .then(function success(data){
                $scope.proizvodi = data.data;
  
                $scope.totalPages = data.headers('totalPages');
  
            });
	    };
	    
	getProizvodi();
	
	   
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