      var myApp = angular.module('facultyApp', []);
            myApp.controller('facultyCtrl', function ($scope, $http) {
                $http({
                    method: 'GET',
                    url: 'GetAllFaculty'
                }).then(function success(response) {
                    $scope.faculties = response.data;
                }, function error(response) {
                });
         $scope.limits=5;
        $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
                
            });
            
      