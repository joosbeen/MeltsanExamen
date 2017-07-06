var app = angular.module('myApp',
		[ 'ngRoute', 'ngTable', 'ngResource', 'ngRoute', 'ngSanitize'

		]).config(function($routeProvider) {
	$routeProvider.when('/pacientes', {
		templateUrl : 'pacientes.html',
		controller : 'pacienteCtrl'
	}).when('/welcome', {
		templateUrl : 'welcome.html',
		controller : 'WelcomeCtrl'
	}).when('/interfazUsuario', {
		templateUrl : 'paginasUsuario/interfazUsuario.html',
		controller : 'interfazUsuarioCtrl'
	}).when('/insertUsuario', {
		templateUrl : 'paginasUsuario/insertUsuario.html',
		controller : 'insertUsuarioCtrl'
	}).when('/parametros', {
		templateUrl : 'parametros.html',
		controller : 'ParametrosCtrl'
	}).otherwise({
		redirectTo : '/'
	});
}

);
