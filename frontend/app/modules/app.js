'use strict';

angular.module('sandbox-app', [
  'ngRoute',
  'sandbox-api-entrance'

])
.constant('apiURI', 'sandbox/api')
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
