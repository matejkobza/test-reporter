angular.module('app')
    .factory('service', function ($http) {
        return {
            'loadTests': function () {
                return $http.get("/api/test/load").then(function (response) {
                    return response;
                });
            },
            'save': function (test) {
                return $http.post("/api/test/save", test).then(function (response) {
                    return response;
                });
            },
            'run': function (testId) {
                return $http.post("/api/test/run", testId).then(function (response) {
                    return response;
                });
            },
            'delete': function (testId) {
                return $http.get("/api/test/delete/" + testId).then(function (response) {
                    return response;
                });
            },
            'findTest': function (testId) {
                return $http.get("/api/test/" + testId).then(function (response) {
                    return response;
                })
            },
            'saveSettings': function (settings) {
                return $http.post("/api/settings/save", settings).then(function (response) {
                    return response;
                });
            },
            'loadSettings': function () {
                return $http.get("/api/settings/get").then(function (response) {
                    return response;
                });
            },
            'deleteSettings': function (settings) {
                return $http.post("/api/settings/delete", settings).then(function (response) {
                    return response;
                });
            },
            'updateSettings': function (settings) {
                return $http.post("/api/settings/update", settings).then(function (response) {
                    return response;
                });
            },
            'findOneSettings': function (settingId) {
                return $http.get("/api/settings/" + settingId).then(function (response) {
                    return response;
                });
            }
        };
    });