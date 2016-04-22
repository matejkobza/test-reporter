'use strict';

angular.module('app')
    .controller('NewSettingController', function ($scope, service, $state) {

        var vm = this;
        $scope.onlyNumbers = /^[0-9]+$/;

        vm.setting = {
            id: undefined,
            driverClassName: undefined,
            serverName: undefined,
            portNumber: undefined,
            databaseName: undefined,
            user: undefined,
            password: undefined
        };
        vm.saveOrUpdate = saveOrUpdate;

        // sends data to server
        function saveOrUpdate() {
            service.saveSettings(vm.setting).then(function (response) {
                $state.go('settings');
            });
        }

        return vm;

    });