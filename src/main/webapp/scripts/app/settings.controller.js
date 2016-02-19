'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service) {
        var vp = this;


        service.loadTests().then(function (response) {
            vp.settings = response.data;
        });
    });