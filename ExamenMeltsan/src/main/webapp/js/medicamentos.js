angular.module('webappApp').controller('medicamentosCtrl',
		[ '$scope', '$http', '$location', function($scope, $http, $location) {

			console.log(" cargando medicamentosCtrl..");
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

			$scope.ventanaAgregar = function() {
				console.log("cargando ventana \" myAgregarPaciente \"");
				$("#myModal").modal("show");
			}
			$scope.ventanaActualizar = function(datos) {

				$("#myModalEditar").modal("show");
			}
			
			
			$scope.InsertarDatosRoles = function() {
				
			}
			
		} ]);