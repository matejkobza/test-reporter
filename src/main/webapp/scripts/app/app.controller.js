'use strict';

var sampleApp = angular.module('app')
    .controller('AppController', function ($scope, service) {
        var vThis = this;
        vThis.selected = [];

        $scope.tab = 1;


        $scope.testy = function() {
            $scope.tab = 1;
        };

        $scope.logs = function() {
            $scope.tab = 2;
        };


        $scope.tabTesty = {
            subjects: service.loadTests()
        }

        console.debug(service.loadTests());

        $scope.toggleAddSubject = function(subjects) {


            var index = vThis.selected.indexOf(subjects);


            if( index == -1 )
            {
                vThis.selected.push(subjects);
            }
            else
            {
                vThis.selected.splice(index, 1, subjects);
            }
        }

        sampleApp.config(['$routeProvider',
            function($routeProvider) {
                $routeProvider.
                when('/AddNewTest', {
                    templateUrl: 'templates/add_order.html',
                    controller: 'AddNewTestController'
                }).
                when('/Back', {
                    templateUrl: 'templates/show_orders.html',
                    controller: 'BackController'
                }).
                otherwise({
                    redirectTo: '/AddNewTest'
                });
            }]);


        sampleApp.controller('AddNewTestController', function($scope) {

            $scope.message = 'This is Add new order screen';

        });


        sampleApp.controller('BackController', function($scope) {

            $scope.message = 'This is Show orders screen';

        });


    });