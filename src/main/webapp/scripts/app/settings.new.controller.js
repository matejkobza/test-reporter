'use strict';

angular.module('app')
    .controller('NewSettingController', function ($scope, service, $state) {

        var vp = this;
        $scope.onlyNumbers = /^[0-9]+$/;

        vp.settings = {
            driverType: undefined,
            serverName: undefined,
            portNumber: undefined,
            databaseName: undefined,
            user: undefined,
            password: undefined

        };

        vp.send = send;

        function send() {

                service.save(vp.settings).then(function (response) {
                    $state.go('settings');
                });

        }

    });