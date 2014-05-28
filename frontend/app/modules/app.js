'use strict';

angular.module('sandbox-app', [
  'ngRoute'
])
.config(function($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'modules/main/main.html',
    controller: 'MainCtrl'
  })
  .otherwise({
    redirectTo: '/'
  });
});
