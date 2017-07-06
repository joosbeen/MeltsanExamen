angular.module('webappApp').controller('pacienteCtrl',
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

			$scope.agregarPaciente = function() {
				console.log("cargando ventana \" myAgregarPaciente \"");
				$("#myAgregarPaciente").modal("show");
			}
			$scope.ventanaActualizar = function(datos) {

				$("#myEditarPaciente").modal("show");
			}
		} ]);