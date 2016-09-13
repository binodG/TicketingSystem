
  var app=angular.module('myApp', []);
  app.controller('myCtrl',function($scope) {

     
    $scope.type1 = function() {
     $scope.type = 1;
    }

     
    $scope.type2 = function() {
     $scope.type = 2;
    }


});
