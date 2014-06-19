'use strict';

angular.module('sandbox-auth', [])

.controller('AuthCtrl', function($scope, $http, $route, apiEntrance, authService) {
  $scope.displayLoginForm = false;

  $scope.login = function() {
    apiEntrance('login').then(function(resource) {
      $http.post(resource, {username: $scope.username, password: $scope.password})
      .then(function() {
        authService.loginConfirmed();
      });
    });
  };

  $scope.logout = function() {
    apiEntrance('logout').then(function(resource) {
      $http.post(resource)
      .then(function() {
        $route.reload();
      });
    });
  };

  $scope.$on('event:auth-loginRequired', function() {
    console.log('login required');
    $scope.displayLoginForm = true;
  });

  $scope.$on('event:auth-loginConfirmed', function() {
    console.log('login loginConfirmed');
    $scope.displayLoginForm = false;
  });
});

