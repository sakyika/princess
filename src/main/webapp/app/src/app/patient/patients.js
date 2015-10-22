angular.module('princess.patients', [ 'ui.router', 'plusOne', 'angular-hal' ])

		.config(
				function config($stateProvider) {
					$stateProvider
							.state(
									'app.patients',
									{
										url : '/patients',
										views : {
											"main" : {
												controller : 'PatientsCtrl',
												templateUrl : 'patient/list-patients.tpl.html'
											}
										},
										ncyBreadcrumb : {
											label : 'Patients',
											description : 'Patients List'
										},
										resolve : {
											deps : [
													'$ocLazyLoad',
													function($ocLazyLoad) {
														return $ocLazyLoad
																.load(
																		[ 'ngGrid' ])
																.then(
																		function() {
																			return $ocLazyLoad
																					.load({
																						serie : true,
																						files : [
																								'assets/lib/jquery/datatable/dataTables.bootstrap.css',
																								'assets/lib/jquery/datatable/jquery.dataTables.min.js',
																								'assets/lib/jquery/datatable/ZeroClipboard.js',
																								'assets/lib/jquery/datatable/dataTables.tableTools.min.js',
																								'assets/lib/jquery/datatable/dataTables.bootstrap.min.js' ]
																					});
																		});

													} ]
										}, 
										data : {
											pageTitle : 'All Patients'
										}
						
							})
							
							.state('app.patient-add', {
								url : '/patient-add/{patientNumber}',
								views : {
									"main" : {
										controller : 'PatientsAddCtrl',
										templateUrl : 'patient/add-patient.tpl.html'
									}
								}, 
								ncyBreadcrumb : {
									label : 'Patient',
									description : 'Add New Patient'
								},
								data : {
									pageTitle : 'Add Patient'
								}
							})
							
							.state('app.patient-edit', {
								url : '/patient-edit/{patientNumber}',
								views : {
									"main" : {
										templateUrl : 'patient/edit-patient.tpl.html'
									}
								}, 
								ncyBreadcrumb : {
									label : 'Edit Patient {{patientNumber}}',
									description : ''
								},
								data : {
									pageTitle : 'Edit Patient'
								}
							})
									
							.state(
									'app.patients-chiropractic',
									{
										url : '/patients-chiropractic',
										views : {
											"main" : {
												controller : 'PatientsChiropracticCtrl',
												templateUrl : 'patient/list-patients-chiropractic.tpl.html'
											}
										},
										ncyBreadcrumb : {
											label : 'Chiropractic Patients',
											description : ''
										},
										data : {
											pageTitle : 'Chiropractic Patients'
										}

									})
							.state(
									'app.patients-massage',
									{
										url : '/patients-massage',
										views : {
											"main" : {
												controller : 'PatientsMassageCtrl',
												templateUrl : 'patient/list-patients-massage.tpl.html'
											}
										},
										ncyBreadcrumb : {
											label : 'Massage Patients',
											description : ''
										},
										data : {
											pageTitle : 'Massage Patients'
										}

									})
							.state(
									'app.patients-acupuncture',
									{
										url : '/patients-acupuncture',
										views : {
											"main" : {
												controller : 'PatientsAcupunctureCtrl',
												templateUrl : 'patient/list-patients-acupuncture.tpl.html'
											}
										},
										ncyBreadcrumb : {
											label : 'Acupuncture Patients',
											description : ''
										},
										data : {
											pageTitle : 'Acupuncture Patients'
										}

									});
				})
 /* sample */ 
		.service('patientService', function(halClient, $q) {
		
			var deferred = $q.defer();
			
			halClient.$get("/rest/patients").then(function (data){
				deferred.resolve(data);
			});
			
			this.getPatients = function(){
				return deferred.promise;
			};

		})

		.controller(
				'PatientsCtrl',
				function PatientsCtrl($scope, $rootScope, $state, patientService) {

				var promise = patientService.getPatients();
				promise.then(function(data){
					$scope.customers = data.patientListResource;
				});
					
					//Datatable Initiating
		
						$scope.simpleTableOptions = {
										"aLengthMenu" : [
												[ 5, 15, 20, 100, -1 ],
												[ 5, 15, 20, 100, "All" ] ],
										"iDisplayLength" : 5,
										"sPaginationType" : "bootstrap",
										"sDom" : "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>",
										"oTableTools" : {
											"aButtons" : [
													"copy",
													"print" ],
											"sSwfPath" : "assets/swf/copy_csv_xls_pdf.swf"
										},
										"language" : {
											"search" : "",
											"sLengthMenu" : "_MENU_",
											"oPaginate" : {
												"sPrevious" : "Prev",
												"sNext" : "Next"
											}
										},
										"aoColumns" : [ null, null, null, null, {
											"bSortable" : false
										} ]
									};
						
						
						$("tfoot input").keyup(function() {
							/* Filter on the column (the index) of this element */
							oTable.fnFilter(this.value, $("tfoot input").index(this));
						});
					
		})
		
		.controller('PatientsAddCtrl', function PatientsAddCtrl($scope){
			$scope.today = function () {
				$scope.dt = new Date();
			};
			$scope.today();

			$scope.clear = function () {
				$scope.dt = null;
			};

			// Disable weekend selection
			$scope.disabled = function (date, mode) {
				return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6));
			};

			$scope.toggleMin = function () {
				$scope.minDate = $scope.minDate ? null : new Date();
			};
			$scope.toggleMin();

			$scope.open = function ($event) {
				$event.preventDefault();
				$event.stopPropagation();

				$scope.opened = true;
			};

			$scope.dateOptions = {
					formatYear: 'yy',
					startingDay: 1
			};

			$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
			$scope.format = $scope.formats[0];
		})
				
		.directive('repeatDone', function(){
			return function(scope, element, attrs){
				if(scope.$last){
					scope.$eval(attrs.repeatDone);
				}
			};
		})

		.controller(
				'PatientsChiropracticCtrl',
				function PatientsChiropracticCtrl($scope, $rootScope, $state,
						$http) {

					

					$scope.filterOptions = {
						filterText : "",
						useExternalFilter : true
					};
					$scope.totalServerItems = 0;
					$scope.pagingOptions = {
						pageSizes : [ 250, 500, 1000 ],
						pageSize : 250,
						currentPage : 1
					};
					$scope.setPagingData = function(data, page, pageSize) {
						var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
						$scope.myData = pagedData;
						$scope.totalServerItems = data.length;
						if (!$scope.$$phase) {
							$scope.$apply();
						}
					};
					$scope.getPagedDataAsync = function(pageSize, page,searchText) {
						setTimeout(
								function() {
									var data;
									if (searchText) {
										var ft = searchText.toLowerCase();
										$http.get('assets/lib/modules/ng-grid/data.json')
											.success(function(largeLoad) {
												data = largeLoad.filter(function(item) {
													return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
												});
												$scope.setPagingData(data, page,pageSize);
											});
									} else {
										$http.get('assets/lib/modules/ng-grid/data.json')
											.success(function(largeLoad) {
												$scope.setPagingData(largeLoad, page, pageSize);
											});
									}
								}, 100);
					};

					$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
							$scope.pagingOptions.currentPage);

					$scope.$watch('pagingOptions', function(newVal, oldVal) {
						if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);
					$scope.$watch('filterOptions', function(newVal, oldVal) {
						if (newVal !== oldVal) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);

					$scope.gridOptions = {
						data : 'myData',
						enablePaging : true,
						showFooter : true,
						totalServerItems : 'totalServerItems',
						pagingOptions : $scope.pagingOptions,
						filterOptions : $scope.filterOptions
					};

				})

		.controller(
				'PatientsMassageCtrl',
				function PatientsMassageCtrl($scope, $rootScope, $state, $http) {

					

					$scope.filterOptions = {
						filterText : "",
						useExternalFilter : true
					};
					$scope.totalServerItems = 0;
					$scope.pagingOptions = {
						pageSizes : [ 250, 500, 1000 ],
						pageSize : 250,
						currentPage : 1
					};
					$scope.setPagingData = function(data, page, pageSize) {
						var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
						$scope.myData = pagedData;
						$scope.totalServerItems = data.length;
						if (!$scope.$$phase) {
							$scope.$apply();
						}
					};
					$scope.getPagedDataAsync = function(pageSize, page,
							searchText) {
						setTimeout(
								function() {
									var data;
									if (searchText) {
										var ft = searchText.toLowerCase();
										$http
												.get(
														'assets/lib/modules/ng-grid/data.json')
												.success(
														function(largeLoad) {
															data = largeLoad
																	.filter(function(
																			item) {
																		return JSON
																				.stringify(
																						item)
																				.toLowerCase()
																				.indexOf(
																						ft) != -1;
																	});
															$scope
																	.setPagingData(
																			data,
																			page,
																			pageSize);
														});
									} else {
										$http
												.get(
														'assets/lib/modules/ng-grid/data.json')
												.success(
														function(largeLoad) {
															$scope
																	.setPagingData(
																			largeLoad,
																			page,
																			pageSize);
														});
									}
								}, 100);
					};

					$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
							$scope.pagingOptions.currentPage);

					$scope.$watch('pagingOptions', function(newVal, oldVal) {
						if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);
					$scope.$watch('filterOptions', function(newVal, oldVal) {
						if (newVal !== oldVal) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);

					$scope.gridOptions = {
						data : 'myData',
						enablePaging : true,
						showFooter : true,
						totalServerItems : 'totalServerItems',
						pagingOptions : $scope.pagingOptions,
						filterOptions : $scope.filterOptions
					};

				})

		.controller(
				'PatientsAcupunctureCtrl',
				function PatientsAcupunctureCtrl($scope, $rootScope, $state,
						$http) {

					if (!$rootScope.authenticated) {
						$state.go("app.login");
					}

					$scope.filterOptions = {
						filterText : "",
						useExternalFilter : true
					};
					$scope.totalServerItems = 0;
					$scope.pagingOptions = {
						pageSizes : [ 250, 500, 1000 ],
						pageSize : 250,
						currentPage : 1
					};
					$scope.setPagingData = function(data, page, pageSize) {
						var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
						$scope.myData = pagedData;
						$scope.totalServerItems = data.length;
						if (!$scope.$$phase) {
							$scope.$apply();
						}
					};
					$scope.getPagedDataAsync = function(pageSize, page,
							searchText) {
						setTimeout(
								function() {
									var data;
									if (searchText) {
										var ft = searchText.toLowerCase();
										$http
												.get(
														'assets/lib/modules/ng-grid/data.json')
												.success(
														function(largeLoad) {
															data = largeLoad
																	.filter(function(
																			item) {
																		return JSON
																				.stringify(
																						item)
																				.toLowerCase()
																				.indexOf(
																						ft) != -1;
																	});
															$scope
																	.setPagingData(
																			data,
																			page,
																			pageSize);
														});
									} else {
										$http
												.get(
														'assets/lib/modules/ng-grid/data.json')
												.success(
														function(largeLoad) {
															$scope
																	.setPagingData(
																			largeLoad,
																			page,
																			pageSize);
														});
									}
								}, 100);
					};

					$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
							$scope.pagingOptions.currentPage);

					$scope.$watch('pagingOptions', function(newVal, oldVal) {
						if (newVal !== oldVal&& newVal.currentPage !== oldVal.currentPage) {
							$scope.getPagedDataAsync( 
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);
					$scope.$watch('filterOptions', function(newVal, oldVal) {
						if (newVal !== oldVal) {
							$scope.getPagedDataAsync(
									$scope.pagingOptions.pageSize,
									$scope.pagingOptions.currentPage,
									$scope.filterOptions.filterText);
						}
					}, true);

					$scope.gridOptions = {
						data : 'myData',
						enablePaging : true,
						showFooter : true,
						totalServerItems : 'totalServerItems',
						pagingOptions : $scope.pagingOptions,
						filterOptions : $scope.filterOptions
					};

				});
