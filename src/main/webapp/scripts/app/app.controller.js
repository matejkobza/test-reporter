'use strict';

angular.module('app')
    .controller('AppController', function ($scope) {

        $scope.tab = 1;


        $scope.testy = function() {
            $scope.tab = 1;
        };

        $scope.logs = function() {
            $scope.tab = 2;
        };


    });