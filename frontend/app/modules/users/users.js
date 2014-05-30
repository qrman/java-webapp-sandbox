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

.factory('changeNotifier', function(apiEntrance) {
  var ws, onMessage = {};
  apiEntrance('user-notify').then(function(wsResource) {
    ws = new WebSocket(wsResource);
    ws.onmessage = function(evt) {
      onMessage();
    };
  });

  return {
    notify: function() {
      ws.send('message:new-user');
    },
    onChange: function(onChangeHander) {
      onMessage = onChangeHander;
    }
  };
})

.controller('UsersCtrl', function($scope, userRepo, changeNotifier) {
  $scope.users = [];
  $scope.user = {};
  $scope.newUsers = 0;

  changeNotifier.onChange(function() {
    $scope.newUsers++;
    $scope.$apply();
  });

  $scope.addUser = function() {
    userRepo.add($scope.user).then(function() {
      $scope.user = {};
      changeNotifier.notify();
      $scope.fetchUsers();
    });
  };

  $scope.fetchUsers = function() {
    userRepo.fetchAll().then(function(response) {
      $scope.users = response.data;
      $scope.newUsers = 0;
    });
  };
  
  $scope.fetchUsers();
});
