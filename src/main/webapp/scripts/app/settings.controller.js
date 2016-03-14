'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service) {
        var vp = this;


        service.loadSettings().then(function (response) {
            vp.settings = response.data;
        });
    });