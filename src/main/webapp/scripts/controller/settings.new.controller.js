'use strict';

angular.module('app')
    .controller('NewSettingController', function ($scope, service, $state, $stateParams) {

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

        if ($stateParams.id) {
            init();
        }

        // sends data to server
        function saveOrUpdate() {
            service.saveSettings(vm.setting).then(function (response) {
                $state.go('settings');
            });
        }

        function init() {
            service.findOneSettings($stateParams.id).then(function (response) {
                vm.setting = response.data;
            });
        }

        return vm;

    });