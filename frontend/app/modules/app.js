'use strict';

angular.module('sandbox-app', [
  'ngRoute',
  'http-auth-interceptor',
  'sandbox-api-entrance',
  'sandbox-auth'

])
.constant('apiURI', 'sandbox/api')
.config(function($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'modules/users/users.html',
    controller: 'UsersCtrl'
  })
  .otherwise({
    redirectTo: '/'
  });
});


angular.module('sandbox-api-entrance', [])
.factory('apiEntrance', function($http, $q, apiURI) {
  var resourcesUri = undefined;
  return function(resource) {
    var deferred = $q.defer();
    if (resourcesUri) {
      deferred.resolve(resourcesUri[resource]);
    } else {
      $http.get(apiURI).then(function(response) {
        resourcesUri = response.data;
        deferred.resolve(resourcesUri[resource]);
      });
    }
    return deferred.promise;
  };
});
