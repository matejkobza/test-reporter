'use strict';

angular.module('app')
    .controller('NewSettingController', function ($scope) {

        var vp = this;
        $scope.onlyNumbers = /^[0-9]+$/;

        vm.settings = {
            driverType: undefined,
            serverName: undefined,
            portNumber: undefined,
            databaseName: undefined,
            user: undefined,
            password: undefined

        };

        vp.send = send;



    });