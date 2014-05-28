'use strict';

angular.module('sandbox-app')
.factory('userRepo', function($http, apiEntrance) {
  return {
    fetchAll: function() {
      return apiEntrance('user').then(function(uri) {
        return $http.get(uri);
      });
    }
  };
})
.controller('MainCtrl', function($scope, userRepo) {
  $scope.users = [];

  userRepo.fetchAll().then(function(response) {
    $scope.users = response.data;
  });


  $scope.awesomeThings = [
    'HTML5 Boilerplate',
    'AngularJS',
    'Karma',
    'Java',
    'Vert.x'
  ];
});
