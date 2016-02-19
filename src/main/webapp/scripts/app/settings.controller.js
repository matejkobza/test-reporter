'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service) {
        var vp = this;


        service.saveSettings().then(function (response) {
            vp.settings = response.data;
        });
    });