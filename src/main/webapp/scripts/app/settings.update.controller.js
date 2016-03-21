'use strict';

angular.module('app')
    .controller('UpdateSettingController', function ($scope, service, $state) {

        var vm = this;
        $scope.onlyNumbers = /^[0-9]+$/;

        vm.setting = {
            driverClassName: undefined,
            serverName: undefined,
            portNumber: undefined,
            databaseName: undefined,
            user: undefined,
            password: undefined
        };
        vm.send = send;



        // sends data to server
        function send() {
            service.saveSettings(vm.setting).then(function (response) {
                $state.go('settings');
            });
        }



        return vm;

    });