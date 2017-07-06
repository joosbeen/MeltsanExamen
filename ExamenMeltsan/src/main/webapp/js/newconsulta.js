angular.module('webappApp').controller('newconsultaCtrl',
		[ '$scope', '$http', '$location', function($scope, $http, $location) {

			console.log(" cargando pacientes..");
			$scope.parametros ={
					nombre : '',
					clave : '',
					ciudad : '',
					municipio : '',
					colonia : '',
					
				}

			// $scope.tablas.paciente = [];
			// $http(
			// {
			// method : "POST",
			// url :
			// "http://localhost:8080/testSpringItc/services/login/listaPacientes"
			// }).success(function(data) {
			//				
			// $scope.tablas.paciente = data;
			// console.log(".: datos ROLES :.");
			// console.log(data);
			//
			// });

			$scope.agregarAgregarConsulta = function() {
				console.log("insertando new consulta...");
			}
			
		} ]);