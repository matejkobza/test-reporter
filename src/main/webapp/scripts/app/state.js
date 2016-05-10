'use strict';

angular.module('app')
    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('tests', {
                url: '/',
                views: {
                    'content': {
                        templateUrl:'html/tests.html',
                        controller: 'TestController as testController'
                    }
                }
            })
            .state('tests.new', {
                parent: 'tests',
                url: 'new/:id',
                views: {
                    'content@': {
                        templateUrl: 'html/tests.new.html',
                        controller: 'NewTestController as newTestController'
                    }
                }
            })
            .state('runs', {
                url: '/runs',
                views: {
                    'content': {
                        templateUrl: 'html/tests.results.html'
                    }
                }
            })
            .state('settings', {
                url: '/settings',
                views: {
                    'content': {
                        templateUrl: 'html/settings.html',
                        controller: 'SettingsController as settingsController'
                    }
                }
            })
            .state('settings.new', {
                parent: 'settings',
                url: '/new',
                views: {
                    'content@': {
                        templateUrl: 'html/settings.new.html',
                        controller: 'NewSettingController as newSettingController'
                    }
                }
            })
            .state('settings.update', {
                parent: 'settings',
                url: '/update/:id',
                views: {
                    'content@': {
                        templateUrl: 'html/settings.new.html',
                        controller: 'UpdateSettingController as updateSettingController'
                    }
                }
            });
    });