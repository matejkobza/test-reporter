'use strict';

angular.module('app')
    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('tests', {
                url: '/',
                templateUrl: 'html/tests.html',
                controller: 'TestController as testController'
            })
            .state('new', {
                //parent: 'tests',
                url: '/new',
                templateUrl: 'html/tests.new.html',
                controller: 'NewTestController as newTestController'
            });
    });