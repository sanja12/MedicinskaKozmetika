var medicinskaKozmetika = angular.module("medicinskaKozmetika");
medicinskaKozmetika.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/components/home/home.html',
			controller: 'homeCtrl'
		})
		.when('/apoteke', {
			templateUrl : '/app/components/apoteke/apoteke.html'
		})
		.when('/apoteke/edit/:id', {
			templateUrl : '/app/components/edit-apoteka/edit-apoteka.html'
		})
		.when('/lanci-apoteka/edit/:id', {
			templateUrl : '/app/components/edit-lanacApoteka/edit-lanacApoteka.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);