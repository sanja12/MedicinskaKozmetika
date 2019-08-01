var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.controller("apotekeCtrl", function($scope, $http, $location) {

	$scope.apoteke = [];
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
	
	$scope.lanacApoteka = {};
	$scope.lanacApoteka.id = "";
	$scope.lanacApoteka.naziv = "";
	$scope.lanacApoteka.kontaktOsoba = "";
	$scope.lanacApoteka.email = "";
	$scope.lanacApoteka.telefon = "";
	
	var apotekeUrl = "/api/apoteke";
	var lanciApotekaUrl = "/api/lanci-apoteka";
	
	var getLanciApoteka = function() {
		$http.get(lanciApotekaUrl).then(function success(res) {
			$scope.lanciApoteka = res.data;

		}, function error() {
			alert("Couldn't get lanceApoteka!");
		});
	}

	getLanciApoteka();

	$scope.searchParams = {};
	$scope.searchParams.naziv = "";
	$scope.searchParams.grad = "";
	$scope.searchParams.lanac = "";

	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	var getApoteke = function() {

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
	        	        
	        $http.get(apotekeUrl, config)
            .then(function success(data){
                $scope.apoteke = data.data;
  
                $scope.totalPages = data.headers('totalPages');
  
            });
	    };
	    
	    getApoteke();

	$scope.doSearch = function() {
		$scope.pageNum = 0;
		getApoteke();
	}

	$scope.changePage = function(direction) {
		$scope.pageNum = $scope.pageNum + direction;
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
		
	};
	
	(function ($) {
		$.fn.countTo = function (options) {
			options = options || {};
			
			return $(this).each(function () {

				var settings = $.extend({}, $.fn.countTo.defaults, {
					from:            $(this).data('from'),
					to:              $(this).data('to'),
					speed:           $(this).data('speed'),
					refreshInterval: $(this).data('refresh-interval'),
					decimals:        $(this).data('decimals')
				}, options);
				
				var loops = Math.ceil(settings.speed / settings.refreshInterval),
					increment = (settings.to - settings.from) / loops;
				
				var self = this,
					$self = $(this),
					loopCount = 0,
					value = settings.from,
					data = $self.data('countTo') || {};
				
				$self.data('countTo', data);
				
				// if an existing interval can be found, clear it first
				if (data.interval) {
					clearInterval(data.interval);
				}
				data.interval = setInterval(updateTimer, settings.refreshInterval);
				
				// initialize the element with the starting value
				render(value);
				
				function updateTimer() {
					value += increment;
					loopCount++;
					
					render(value);
					
					if (typeof(settings.onUpdate) == 'function') {
						settings.onUpdate.call(self, value);
					}
					
					if (loopCount >= loops) {
						// remove the interval
						$self.removeData('countTo');
						clearInterval(data.interval);
						value = settings.to;
						
						if (typeof(settings.onComplete) == 'function') {
							settings.onComplete.call(self, value);
						}
					}
				}
				
				function render(value) {
					var formattedValue = settings.formatter.call(self, value, settings);
					$self.html(formattedValue);
				}
			});
		};
		
		$.fn.countTo.defaults = {
			from: 0,               // the number the element should start at
			to: 0,                 // the number the element should end at
			speed: 1000,           // how long it should take to count between the target numbers
			refreshInterval: 100,  // how often the element should be updated
			decimals: 0,           // the number of decimal places to show
			formatter: formatter,  // handler for formatting the value before rendering
			onUpdate: null,        // callback method for every time the element is updated
			onComplete: null       // callback method for when the element finishes updating
		};
		
		function formatter(value, settings) {
			return value.toFixed(settings.decimals);
		}
	}(jQuery));

	jQuery(function ($) {
	  // custom formatting example
	  $('.count-number').data('countToOptions', {
		formatter: function (value, options) {
		  return value.toFixed(options.decimals).replace(/\B(?=(?:\d{3})+(?!\d))/g, ',');
		}
	  });
	  
	  // start all the timers
	  $('.timer').each(count);  
	  
	  function count(options) {
		var $this = $(this);
		options = $.extend({}, options || {}, $this.data('countToOptions') || {});
		$this.countTo(options);
	  }
	});
	
});