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
		.when('/experti', {
			templateUrl : '/app/components/experti/experti.html'
		})
		.when('/experti/send-message/:id', {
			templateUrl : '/app/components/expert-send-message/expert-send-message.html'
		})
		.when('/promocije', {
			templateUrl : '/app/components/promocije/promocije.html'
		})
		.when('/linije-kozmetike', {
			templateUrl : '/app/components/linije-kozmetike/linije-kozmetike.html'
		})
		.when('/linije-kozmetike/:id/proizvodi', {
			templateUrl : '/app/components/proizvodi/proizvodi.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);