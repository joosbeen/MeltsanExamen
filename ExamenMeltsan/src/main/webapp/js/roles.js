angular
		.module('webappApp')
		.controller( 'RolesCtrl', ['$scope', '$http', 'ngTableParams', '$filter', function($scope, $http, ngTableParams, $filter) {

							console.log("Obtener Lista");

							$scope.listas = {};
							$scope.tablas = {};
							$scope.tablas.roles = [];
							

							$scope.mensaje = {};
							$scope.mensaje = {
									info : ''
							}
							

							$scope.parametros = {};
							$scope.parametros = {
									roldi: '',
									rol : '',
								vigencia : '',
								actualizado_por : '',
								dsrol : '',
								swanalista : ''
							}
							$scope.datos = {};
							$scope.datos={
									ROL : '',
									VIGENCIA:'',
									DS_ROL:'',
									SW_ANALISTA:''
							       
							}
							
							$http({
								method: "POST",
								url:"http://localhost:8080/testSpringItc/services/login/roles"
							}).success(function(data){
								 $scope.listas.roles = data;
								 $scope.listas.selectRolesValue = $scope.listas.roles[0];
								 
								console.log("roles..");
								console.log($scope.listas);
							
							   });

							$http(
									{
										method : "POST",
										url : "http://localhost:8080/testSpringItc/services/login/listaRoles"
									}).success(function(data) {
								
								$scope.tablas.roles = data;
								console.log(".: datos ROLES :.");
								console.log(data);

							});

							$scope.filters = {
								myfilter : ''
							};

							$scope.tableParams = new ngTableParams(
									{
										page : 1, // show first page
										count : 10,
										filter : $scope.filters,
										sorting : {
										// initial sorting

										}
									},
									{
										count : [], // here put empty counts
										total : $scope.tablas.roles.length, // length
										// of
										// data
										getData : function($defer, params) {

											var filteredData = params.filter() ? $filter(
													'filter')(
													$scope.tablas.roles,
													params.filter().myfilter)
													: data;
											var orderedData = params.sorting() ? $filter(
													'orderBy')(filteredData,
													params.orderBy())
													: data;
											params.total(orderedData.length); // set
											// total
											// for
											// recalc
											// pagination
											$defer.resolve(orderedData.slice(
													(params.page() - 1)
															* params.count(),
													params.page()
															* params.count()));
										},
										$scope : {
											$data : {}
										}

									});

							$scope.$watch("tablas.roles", function() {
								$scope.tableParams.reload();
								console.log($scope.tablas.roles);
							})

							
							
//							MOSTRAR
//							MODALES DE
//							ROLES
							$scope.obtenerCreador = function(){
								$scope.parametros.actualizado_por =$scope.listas.selectRolesValue.dsRol;
								
								console.log("creado por: " + $scope.parametros.actualizado_por);
							}
							
							$scope.ventanaAgregar = function() {
								$scope.parametros.rol = '';
								$scope.parametros.vigencia  = '';
								$scope.parametros.dsrol = '';
								$scope.parametros.swanalista = '';
								$("#myModal").modal("show");

							}
							
							$scope.ventanaActualizar = function(registro) {							

								
//								$scope.parametros.roldi = registro.roldi;
//								$scope.parametros.vigencia = registro.vigencia;
//								$scope.parametros.swanalista = registro.sw_analista;
//								$scope.parametros.dsrol = registro.dsrol;
								$scope.parametros.roldi = '1';
								$scope.parametros.vigencia = 'qwert';
								$scope.parametros.swanalista = 's';
								$scope.parametros.dsrol = 'qwert';
							
								console.log("ventanaActualizar");
								console.log($scope.parametros);
								
								$("#myModalAtulizar").modal("show");
							}

							$scope.eliminarUsuario = function(registro){
								console.log("registro.roldi = " + registro.roldi);
								console.log("registro.rol = " + registro.rol);
								$scope.parametros.roldi = registro.roldi;
								$scope.parametros.rol = registro.rol;
							
								

								$("#myModalEliminar").modal("show");
								
							}
							
							
							$scope.InsertarDatosRoles = function() {

								console.log("DATOS InsertarDatosRoles!!..**");
								console.log($scope.parametros);
								
								
								$http(
										{
											method : "POST",
											data : $scope.parametros,
											url : "http://localhost:8080/testSpringItc/services/login/NewUser"
										}).success(function(data) {

									if (data.success) {
										console.log("InsertaDo datos");
									} else {
										$scope.mensaje.info = data.Mensaje;
										alert(data.errorMensaje);
										console.log(data.errorMensaje);

									}

								});

							}
							
							$scope.EliminarDatosRoles = function() {

								if (confirm("¿Está seguro?")){
									
									console.log("EliminarDatosRoles!!..**.");
									console.log($scope.parametros);

									$http(
											{
												method : "POST",
												data : $scope.parametros,
												url : "http://localhost:8080/testSpringItc/services/login/deleteUser"
											}).success(function(data) {

										if (data.success) {
											console.log("InsertaDo datos");
										} else {
											console.log("ERROR datos");
											alert(data.errorMensaje);
											console.log(data.errorMensaje);

										}

									});
									
								}else{
								alert("CANCELADO");
								}
								

							}
							
							$scope.ActualizarDatosRoles = function(registros) {
								
								$scope.parametros.vigencia = registros.vigencia;
//								$scope.parametros.actualizado_por =$scope.listas.selectRolesValue.dsRol;
								$scope.parametros.actualizado_por = 'admin';
								$scope.parametros.dsrol = registros.dsrol;
								$scope.parametros.swanalista = registros.swanalista;
								$scope.parametros.roldi = registros.roldi;
								
								console.log("ActualizarDatosRoles!!..**.");
								console.log($scope.parametros);

								$http(
										{
											method : "POST",
											data : $scope.parametros,
											url : "http://localhost:8080/testSpringItc/services/login/updateUser"
										}).success(function(data) {
									if (data.success) {
										$scope.mensaje.info = data.mensaje;
										$("#ventanaMensajes").modal("show");
									} else {
										console.log("ERROR datos");
										$scope.mensaje.info = data.errorMensaje;
										$("#ventanaMensajes").modal("show");
									}

								});

							}
							
							
							
						} ]);
