angular.module('app')
    .factory('service', function ($http) {
        return {
            'loadTests': function() {
                return $http.get("/api/load").then(function(response) {
                    return response;
                });
            },
            'save': function(test) {
                return $http.post("/api/save", test).then(function(response) {
                    return response;
                });
            },
            'loadSettings': function(settings) {
                return $http.get("/api/load", settings).then(function (response) {
                    return response;
                });
            }
        }
    });