angular.module('app')
    .factory('service', function ($http) {
        return {
            'loadTests': function() {
                return $http.get("/api/load").then(function(response) {
                    return response;
                });
            }
        }
    });