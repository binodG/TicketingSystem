      var myApp = angular.module('programApp', []);
            myApp.controller('programCtrl', function ($scope, $http) {
                $http({
                    method: 'GET',
                    url: 'GetAllProgram'
                }).then(function success(response) {
                    $scope.programmes = response.data;
                }, function error(response) {
                });
         $scope.limits=5;
        $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
                
            });
            
      