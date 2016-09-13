      var myApp = angular.module('courseApp', []);
            myApp.controller('courseCtrl', function ($scope, $http) {
                $http({
                    method: 'GET',
                    url: 'GetAllCourse'
                }).then(function success(response) {
                    $scope.courses = response.data;
                }, function error(response) {
                });
         $scope.limits=5;
        $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
                
            });
            
      