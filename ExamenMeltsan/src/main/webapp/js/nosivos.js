angular.module('webappApp')
.controller ('nosivosCtrl',['$scope','$http','$location', function ($scope,$http,$location){

			console.log(" cargando sustancias nosivas.."); 
			
//			$scope.tablas.doctores = [];
//			$http(
//					{
//						method : "POST",
//						url : "http://localhost:8080/testSpringItc/services/login/listaMedico"
//					}).success(function(data) {
//				
//				$scope.tablas.doctores = data;
//				console.log(".: datos ROLES :.");
//				console.log(data);
//
//			});
			
			
//			$scope.filters = {myfilter: ''}; 
//			  
//			  
//			$scope.tableParams = new ngTableParams({
//				        page: 1,            // show first page
//				        count: 10,
//				        filter: $scope.filters,
//				        sorting: {	
//				        	     // initial sorting
//
//				        }
//				    }, {
//				     count:[], //here put empty counts
//			         total: $scope.tablas.doctores.length, // length of data
//				      getData: function($defer, params) {
//				         
//				           var filteredData = params.filter() ? $filter('filter')($scope.tablas.pantallas, params.filter().myfilter) : data;
//			               var orderedData = params.sorting() ?  $filter('orderBy')(filteredData, params.orderBy()) :
//			                       data;
//			                    params.total(orderedData.length); // set total for recalc pagination
//				          $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
//				        },
//			       $scope: { $data: {} }
//				   
//				    });
}]);