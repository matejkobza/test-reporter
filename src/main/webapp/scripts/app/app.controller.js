'use strict';

angular.module('app')
    .controller('AppController', function ($scope, service) {
        var vThis = this;
        vThis.selected = [];

        $scope.tab = 1;


        $scope.testy = function () {
            $scope.tab = 1;
        };

        $scope.logs = function () {
            $scope.tab = 2;
        };


        $scope.tabTesty = {
            subjects: service.loadTests()
        };

        $scope.toggleAddSubject = function (subjects) {


            var index = vThis.selected.indexOf(subjects);


            if (index == -1) {
                vThis.selected.push(subjects);
            }
            else {
                vThis.selected.splice(index, 1, subjects);
            }
        }
    });