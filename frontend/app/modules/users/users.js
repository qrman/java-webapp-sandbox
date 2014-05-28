'use strict';

angular.module('sandbox-app')
.factory('userRepo', function($http, apiEntrance) {
  return {
    fetchAll: function() {
      return apiEntrance('user').then(function(uri) {
        return $http.get(uri);
      });
    },
    add: function(user) {
      return apiEntrance('user').then(function(uri) {
        return $http.post(uri, user);
      });
    }
  };
})
.controller('UsersCtrl', function($scope, userRepo) {
  $scope.users = [];
  $scope.user = {};

  userRepo.fetchAll().then(function(response) {
    $scope.users = response.data;
  });


  $scope.addUser = function() {
    userRepo.add($scope.user).then(function() {
      $scope.user = {};
    });
  };
});
