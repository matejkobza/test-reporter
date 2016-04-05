'use strict';

angular.module('app')
    .controller('UpdateSettingController', function ($scope, service, $state, $stateParams) {

        var vm = this;
        $scope.onlyNumbers = /^[0-9]+$/;
        var settingId = $stateParams.id;

        vm.setting = {
            driverClassName: undefined,
            serverName: undefined,
            portNumber: undefined,
            databaseName: undefined,
            user: undefined,
            password: undefined
        };
        vm.update = update;


        function update() {
            service.updateSettings(vm.setting).then(function (response) {
                $state.go('settings');
            });
        }

        function init() {
            service.findOneSettings(settingId).then(function (response) {
                vm.setting = response.data;
            });
        }

        init();

        return vm;
    });