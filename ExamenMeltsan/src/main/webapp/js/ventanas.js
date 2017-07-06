var app = angular.module('webappApp',
		[ 'ngRoute', 'ngTable', 'ngResource', 'ngRoute', 'ngSanitize'

		]).config(function($routeProvider) {
			
	$routeProvider.when('/', {
		templateUrl : 'pacientes.html',
		controller : 'pacienteCtrl'
	}).when('/medico', {
		templateUrl : 'medico.html',
		controller : 'medicoCtrl'
	}).when('/consulta', {
		templateUrl : 'consultas.html',
		controller : 'consultaCtrl'
	}).when('/newconsulta', {
		templateUrl : 'newconsulta.html',
		controller : 'newconsultaCtrl'
	}).when('/medicamentos', {
		templateUrl : 'medicamentos.html',
		controller : 'medicamentosCtrl'
	}).when('/nosivos', {
		templateUrl : 'nosivos.html',
		controller : 'nosivosCtrl'
	}).otherwise({
		redirectTo : '/'
	});
}

);
