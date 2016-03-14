'use strict';

angular.module('app')
    .controller('SettingsController', function ($scope, service) {
        var vp = this;


        service.loadSettings().then(function (response) {
            console.debug(response.data);
            vp.settings = response.data;
        });
    });