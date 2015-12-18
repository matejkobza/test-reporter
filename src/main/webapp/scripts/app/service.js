angular.module('app')
    .factory('service', function ($http) {
        return {
            'loadTests': function() {
                return $http.get("/loadTests").then(function(response) {
                    return response;
                });
            }
        }
    });